package myapp.web;

import java.util.Map;
import myapp.domain.RegistrationCommand;
import myapp.service.RegistrationService;
import myapp.validator.RegistrationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({"/registration"})
public class RegistrationController {
   @Autowired
   private RegistrationService registrationService;
   @Autowired
   private RegistrationValidator registrationValidator;

   @RequestMapping(
      method = {RequestMethod.GET},
      value = {"/{i}"}
   )
   public String showRegistration3(@PathVariable("i") Integer i, Map model) {
      model.put("registrationCommand", this.registrationService.getRegistrationCommand());
      if(i.intValue() == 3 && this.registrationService.getRegistrationCommand().getPhoto() != null) {
         model.put("filename", this.registrationService.getRegistrationCommand().getPhoto().getOriginalFilename());
      }

      return "registration/" + i;
   }

   @RequestMapping(
      method = {RequestMethod.POST},
      value = {"/1"}
   )
   public String processRegistration1(@ModelAttribute RegistrationCommand command, BindingResult result) {
      if(command.getDirection().equals("Next")) {
         command.setStep(Integer.valueOf(0));
         this.registrationValidator.validate(command, result);
         if(result.hasErrors()) {
            return "registration/1";
         } else {
            this.registrationService.getRegistrationCommand().setStep(Integer.valueOf(0));
            this.registrationService.getRegistrationCommand().setEmail(command.getEmail());
            this.registrationService.getRegistrationCommand().setPassword(command.getPassword());
            this.registrationService.getRegistrationCommand().setConfurmpassword(command.getConfurmpassword());
            return "redirect:/registration/2";
         }
      } else {
         return "redirect:/users";
      }
   }

   @RequestMapping(
      method = {RequestMethod.POST},
      value = {"/2"}
   )
   public String processRegistration2(@ModelAttribute RegistrationCommand command, BindingResult result) {
      command.setStep(Integer.valueOf(1));
      if(this.registrationService.getRegistrationCommand().getStep().intValue() < 0) {
         return "redirect:1";
      } else {
         this.registrationValidator.validate(command, result);
         if(result.hasErrors()) {
            return "registration/2";
         } else {
            if(this.registrationService.getRegistrationCommand().getStep().intValue() < 1) {
               this.registrationService.getRegistrationCommand().setStep(Integer.valueOf(1));
            }

            this.registrationService.getRegistrationCommand().setFname(command.getFname());
            this.registrationService.getRegistrationCommand().setLname(command.getLname());
            this.registrationService.getRegistrationCommand().setGender(command.getGender());
            this.registrationService.getRegistrationCommand().setBirthDay(command.getBirthDay());
            this.registrationService.getRegistrationCommand().setBirthMonth(command.getBirthMonth());
            this.registrationService.getRegistrationCommand().setBirthYear(command.getBirthYear());
            return command.getDirection().equals("Next")?"redirect:/registration/3":"redirect:/registration/1";
         }
      }
   }

   @RequestMapping(
      method = {RequestMethod.POST},
      value = {"/3"}
   )
   public String processRegistration3(@ModelAttribute RegistrationCommand command, BindingResult result, Map model) {
      if(this.registrationService.getRegistrationCommand().getStep().intValue() < 1) {
         return "redirect:1";
      } else {
         command.setStep(Integer.valueOf(2));
         this.registrationValidator.validate(command, result);
         if(result.hasErrors()) {
            return "registration/3";
         } else {
            this.registrationService.getRegistrationCommand().setStep(Integer.valueOf(2));
            this.registrationService.getRegistrationCommand().setLanguages(command.getLanguages());
            this.registrationService.getRegistrationCommand().setAboutYou(command.getAboutYou());
            this.registrationService.getRegistrationCommand().setHobby(command.getHobby());
            if(command.getDirection().equals("Create an Account")) {
               this.registrationService.addUser();
               model.put("reg", Integer.valueOf(1));
               this.registrationService.setRegistrationCommand(new RegistrationCommand());
               return "registration/3";
            } else if(command.getDirection().equals("Load")) {
               this.registrationService.getRegistrationCommand().setPhoto(command.getPhoto());
               return "redirect:/registration/3";
            } else {
               return "redirect:/registration/2";
            }
         }
      }
   }
}
