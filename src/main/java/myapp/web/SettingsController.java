package myapp.web;

import java.sql.SQLException;
import java.util.Map;
import myapp.domain.Settings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({"/settings"})
public class SettingsController {
   @Autowired
   private DriverManagerDataSource dataSource;

   @RequestMapping(
      method = {RequestMethod.GET}
   )
   public String init(Map model) {
      model.put("settings", new Settings());
      return "settings";
   }

   @RequestMapping(
      method = {RequestMethod.POST}
   )
   public String tryConnect(@ModelAttribute("settings") Settings settings, BindingResult result, Map model) {
      this.dataSource.setUsername(settings.getUname());
      this.dataSource.setPassword(settings.getPassword());
      this.dataSource.setDriverClassName("com.mysql.jdbc.Driver");
      this.dataSource.setUrl("jdbc:mysql://" + settings.getHostName() + ":" + settings.getPort() + "/mydb");

      try {
         boolean e = this.dataSource.getConnection().isClosed();
      } catch (SQLException var5) {
         var5.printStackTrace();
         model.put("err", Integer.valueOf(1));
         return "settings";
      }

      model.put("err", Integer.valueOf(0));
      return "settings";
   }
}
