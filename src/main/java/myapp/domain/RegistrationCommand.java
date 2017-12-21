package myapp.domain;

import biz.source_code.base64Coder.Base64Coder;
import lombok.Data;
import myapp.domain.User;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Component
@Data
public class RegistrationCommand {
   @NotEmpty(
      message = "notEmpty"
   )
   @Email(
      message = "incorrect"
   )
   private String email;
   @Length(
      min = 5,
      message = "length"
   )
   private String password;
   private String confurmpassword;
   @Length(
      min = 3,
      message = "length"
   )
   private String fname;
   @Length(
      min = 3,
      message = "length"
   )
   private String lname;
   @NotEmpty(
      message = "notEmpty"
   )
   private String gender;
   private String birthDay;
   private String birthMonth;
   private String birthYear;
   private String[] languages;
   private String[] hobby;
   @Length(
      min = 0,
      max = 255,
      message = "length"
   )
   private String aboutYou;
   private CommonsMultipartFile photo;
   private Integer step = Integer.valueOf(-1);
   private String direction;
   private String photoBase64;
   private byte[] photoByte;

   public CommonsMultipartFile getPhoto() {
      return this.photo != null?this.photo:null;
   }

   public void setPhoto(CommonsMultipartFile photo) {
      this.photoByte = photo.getBytes();
      this.photoBase64 = new String(Base64Coder.encode(this.photoByte));
      this.photo = photo;
   }

   public String getPhotoBase64() {
      return this.photoBase64;
   }

   public void setPhotoBase64(String bt) {
      this.photoBase64 = bt;
   }

   public User toUser() {
      User obj = new User();
      obj.setEmail(this.email);
      obj.setPassword(this.password);
      obj.setFname(this.fname);
      obj.setLname(this.lname);
      obj.setGender(this.gender.charAt(0));
      obj.setBirthDay(Integer.valueOf(this.birthDay.equals("0")?1:Integer.valueOf(this.birthDay).intValue()));
      obj.setBirthMonth(Integer.valueOf(this.birthDay.equals("0")?1:Integer.valueOf(this.birthMonth).intValue()));
      obj.setBirthYear(Integer.valueOf(this.birthYear).intValue());
      String str = "";
      String[] arr$ = this.languages;
      int len$ = arr$.length;

      int i$;
      String i;
      for(i$ = 0; i$ < len$; ++i$) {
         i = arr$[i$];
         str = str + i + " ";
      }

      obj.setLanguages(str);
      obj.setAboutYou(this.aboutYou);
      str = "";
      arr$ = this.hobby;
      len$ = arr$.length;

      for(i$ = 0; i$ < len$; ++i$) {
         i = arr$[i$];
         str = str + i + " ";
      }

      obj.setHobby(str);
      obj.setPhoto(this.photoByte);
      return obj;
   }
}
