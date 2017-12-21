package myapp.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by Dmitry on 03.12.2015.
 */
@Data
@Component
public class Cinema {
    private Hall hall;
    private String title;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
