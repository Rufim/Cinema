package myapp.web;

import myapp.domain.Cinema;
import myapp.domain.Seat;
import myapp.domain.User;
import myapp.service.CinemaService;
import myapp.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by Dmitry on 01.12.2015.
 */

@Controller
@RequestMapping({"/cinema"})
public class CinemaController {

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private CinemaService cinemaService;

    @RequestMapping(
            method = {RequestMethod.GET}
    )
    public String showCinema(Map model) {
        return "cinema";
    }

    @RequestMapping(
            method = {RequestMethod.GET},
            value = {"/cinema.json"}
    )
    public @ResponseBody Cinema getCinema() {
        return cinemaService.getCinema();
    }


    @RequestMapping(value = "/reserve", method = RequestMethod.POST)
    public @ResponseBody void reserve(@RequestBody Seat seat) {
        try {
            cinemaService.reserveSeat(seat, (User) registrationService.listUser().get(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
