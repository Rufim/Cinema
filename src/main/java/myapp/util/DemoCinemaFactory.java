package myapp.util;

import myapp.domain.Cinema;
import myapp.domain.Hall;
import myapp.domain.Seat;

import java.time.LocalDateTime;
import java.util.Random;

/**
 * Created by Dmitry on 03.12.2015.
 */
public class DemoCinemaFactory {

    public static Cinema generateCinema(String cinemaTitle, String hallTitle, int rows, int seats) {
        Cinema cinema = new Cinema();
        cinema.setTitle(cinemaTitle);
        LocalDateTime dateTime = LocalDateTime.now().plusDays(1);
        cinema.setStartDate(dateTime);
        cinema.setEndDate(dateTime.plusHours(2));
        Hall hall = new Hall();
        hall.setTitle(hallTitle);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seats;) {
                Seat seat = new Seat();
                seat.setNumber(j += 1);
                seat.setRow(Integer.toHexString(i));
                seat.setPrice(231, 1223);
                hall.addSeat(seat);
            }
        }
        cinema.setHall(hall);
        return cinema;
    }

    ;

}
