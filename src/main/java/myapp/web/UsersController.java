package myapp.web;

import java.util.List;
import java.util.Map;

import myapp.domain.User;
import myapp.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({"users"})
public class UsersController {
   @Autowired
   private RegistrationService registrationService;

   public void setRegistrationService(RegistrationService registrationService) {
      this.registrationService = registrationService;
   }


   @RequestMapping(
      method = {RequestMethod.GET}
   )
   public String showRegistration(Map model) {
      List users = this.registrationService.listUser();
      model.put("users", users);
      return "users";
   }

   @RequestMapping(
           method = {RequestMethod.POST}
   )
   public String placeHolder(@ModelAttribute("users") List<User> users, BindingResult result, Map model) {
      return "showUsers";
   }
}
