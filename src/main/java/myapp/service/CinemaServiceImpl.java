package myapp.service;

import myapp.domain.Cinema;
import myapp.domain.Seat;
import myapp.domain.User;
import myapp.util.DemoCinemaFactory;
import org.springframework.stereotype.Service;

/**
 * Created by 0shad on 05.12.2015.
 */

@Service("cinemaService")
public class CinemaServiceImpl implements CinemaService {


    public Cinema cinema;


    @Override
    public Cinema getCinema() {
        if(cinema == null) {
            cinema = DemoCinemaFactory.generateCinema("Тестовое Кино", "Тестовый Зал", 10, 20);
        }
        return cinema;
    }

    @Override
    public void reserveSeat(Seat seat, User user) {
        seat = cinema.getHall().getSeat(seat.getNumber(), seat.getRow());
        if(seat != null) {
            seat.setReservedBy(user);
        }
    }
}
