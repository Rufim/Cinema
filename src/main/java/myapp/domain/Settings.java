package myapp.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Settings {
   private String uname;
   private String password;
   private String hostName;
   private String port;
}
