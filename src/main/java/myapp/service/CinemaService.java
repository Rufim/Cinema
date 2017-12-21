package myapp.service;

import myapp.domain.Cinema;
import myapp.domain.Seat;
import myapp.domain.User;

/**
 * Created by 0shad on 05.12.2015.
 */
public interface CinemaService {

    Cinema getCinema();

    void reserveSeat(Seat seat, User user) throws Exception;

}
