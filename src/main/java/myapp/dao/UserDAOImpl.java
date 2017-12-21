package myapp.dao;

import java.util.List;
import myapp.dao.UserDAO;
import myapp.domain.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {
   @Autowired
   private SessionFactory sessionFactory;

   public void addUser(User user) {
      this.sessionFactory.getCurrentSession().save(user);
   }

   public List listUser() {
      return this.sessionFactory.getCurrentSession().createQuery("from User").list();
   }

   public void removeUser(Integer id) {
      User user = (User)this.sessionFactory.getCurrentSession().load(User.class, id);
      if(null != user) {
         this.sessionFactory.getCurrentSession().delete(user);
      }

   }
}
