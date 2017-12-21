package myapp.web;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import myapp.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionController implements HandlerExceptionResolver {
   @Autowired
   private ReloadableResourceBundleMessageSource messageSource;
   @Autowired
   private RegistrationService registrationService;

   public void setRegistrationService(RegistrationService registrationService) {
      this.registrationService = registrationService;
   }

   public void setMessageSource(ReloadableResourceBundleMessageSource messageSource) {
      this.messageSource = messageSource;
   }

   public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object obj, Exception exception) {
      HashMap model = new HashMap();
      String error;
      if(exception instanceof MaxUploadSizeExceededException) {
         error = this.messageSource.getMessage("photo.error", (Object[])null, request.getLocale());
         String[] part = error.split("_");
         model.put("errors", part[0] + ((MaxUploadSizeExceededException)exception).getMaxUploadSize() / 1024L + part[1]);
         model.put("registrationCommand", this.registrationService.getRegistrationCommand());
         return new ModelAndView("/userRegistration/3", model);
      } else if(exception instanceof CannotCreateTransactionException) {
         error = this.messageSource.getMessage("connection.error", (Object[])null, request.getLocale());
         model.put("errors", error);
         return new ModelAndView("/index", model);
      } else {
         model.put("errors", exception.getMessage());
         System.out.println("Unexpected error: " + exception.getMessage());
         return new ModelAndView("/index", model);
      }
   }
}
