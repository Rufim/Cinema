package myapp.service;

import java.util.List;
import myapp.dao.UserDAO;
import myapp.domain.RegistrationCommand;
import myapp.domain.User;
import myapp.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("registrationService")
public class RegistrationServiceImpl implements RegistrationService {
   @Autowired(
      required = false
   )
   RegistrationCommand registrationCommand;

   @Autowired
   private UserDAO userDAO;

   public void setRegistrationCommand(RegistrationCommand registrationCommand) {
      this.registrationCommand = registrationCommand;
   }

   public RegistrationCommand getRegistrationCommand() {
      return this.registrationCommand != null?this.registrationCommand:(this.registrationCommand = new RegistrationCommand());
   }

   @Transactional
   public void addUser(User user) {
      this.userDAO.addUser(user);
   }

   @Transactional
   public void addUser() {
      this.userDAO.addUser(this.registrationCommand.toUser());
   }

   @Transactional
   public List listUser() {
      return this.userDAO.listUser();
   }

   @Transactional
   public void removeUser(Integer id) {
      this.userDAO.removeUser(id);
   }
}
