package myapp.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Dmitry on 03.12.2015.
 */
@Data
@Component
public class Hall {
    private String title;
    private List<Seat> seats;

    public void addSeat(Seat seat) {
        if(seats == null) {
            seats = new ArrayList<>();
        }
        seats.add(seat);
    }

    public Seat getSeat(int number, String row) {
        return seats.stream().filter(s -> s.getNumber().equals(number) && s.getRow().equals(row)).findFirst().orElseGet(null);
    }

}
