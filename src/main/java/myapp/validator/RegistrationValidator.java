package myapp.validator;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import myapp.domain.RegistrationCommand;
import myapp.domain.User;
import myapp.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component("registrationValidator")
public class RegistrationValidator {
   @Autowired
   private RegistrationService registrationService;

   public boolean supports(Class clazz) {
      return RegistrationCommand.class.isAssignableFrom(clazz);
   }

   public void validate(Object target, Errors errors) {
      RegistrationCommand command = (RegistrationCommand)target;
      ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
      Validator validator = vf.getValidator();
      Set cvs = validator.validate(command, new Class[0]);
      Iterator users = cvs.iterator();

      while(users.hasNext()) {
         ConstraintViolation s = (ConstraintViolation)users.next();
         String in = s.getPropertyPath().toString();
         String msg = s.getMessage();
         switch(command.getStep().intValue()) {
         case 0:
            if(!in.equals("email") && !in.equals("password") && !in.equals("confurmpassword")) {
               break;
            }
            errors.rejectValue(in, in + "." + s.getMessage());
            return;
         case 1:
            if(!in.equals("fname") && !in.equals("lname") && !in.equals("gender") && !in.equals("birthYear")) {
               break;
            }
            errors.rejectValue(in, in + "." + s.getMessage());
            return;
         case 2:
            if(in.equals("aboutYou")) {
               errors.rejectValue(in, in + "." + s.getMessage());
               return;
            }
         }
      }

      List users1 = this.registrationService.listUser();
      Iterator s1 = users1.iterator();

      User in1;
      do {
         if(!s1.hasNext()) {
            switch(command.getStep().intValue()) {
            case 0:
               if(!command.getPassword().equals(command.getConfurmpassword())) {
                  errors.rejectValue("confurmpassword", "confurmpassword.confurm");
               }
               break;
            case 1:
               if(!command.getBirthDay().equals("0")) {
                  try {
                     SimpleDateFormat s3 = new SimpleDateFormat("dd.MM.yyyy");
                     s3.setLenient(false);
                     s3.parse(command.getBirthDay() + "." + command.getBirthMonth() + "." + command.getBirthYear());
                  } catch (Exception var11) {
                     errors.rejectValue("birthYear", "birthYear.incorrect");
                  }
               }
               break;
            case 2:
               if(command.getPhoto().getSize() != 0L) {
                  String s2 = command.getPhoto().getContentType();
                  if(!s2.startsWith("image")) {
                     errors.rejectValue("photo", "photo.mbimg");
                  }
               }
            }

            return;
         }

         in1 = (User)s1.next();
      } while(!in1.getEmail().equals(command.getEmail()));

      errors.rejectValue("email", "email.exist");
   }
}
