package myapp.service;

import java.util.List;
import myapp.domain.RegistrationCommand;
import myapp.domain.User;

public interface RegistrationService {
   void setRegistrationCommand(RegistrationCommand var1);

   RegistrationCommand getRegistrationCommand();

   void addUser(User var1);

   void addUser();

   List listUser();

   void removeUser(Integer var1);
}
