package myapp.dao;

import java.util.List;
import myapp.domain.User;

public interface UserDAO {
   void addUser(User var1);

   List listUser();

   void removeUser(Integer var1);
}
