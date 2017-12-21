package myapp.web;

import java.util.Map;
import myapp.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({"/"})
public class IndexController {
   @Autowired
   private RegistrationService registrationService;

   public void setRegistrationService(RegistrationService registrationService) {
      this.registrationService = registrationService;
   }

   @RequestMapping(method = {RequestMethod.GET})
   public String showMenu(Map model) {
      return "index";
   }

}
