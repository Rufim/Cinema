package myapp.domain;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonValueInstantiator;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Created by Dmitry on 03.12.2015.
 */
@Data
@Component
public class Seat implements Cloneable  {
    private Integer number;
    private String row;
    @JsonIgnore
    private User reservedBy;
    private BigDecimal price;

    public Seat(){};

    public Seat(Seat other) {
        this.number = other.number;
        this.row = other.row;
        this.reservedBy = other.reservedBy;
        this.price = other.price;
    }

    public void setPrice(int notes, int coins) {
        while (coins >= 100) {
            notes ++;
            coins -=100;
        }
        setPrice(new BigDecimal(notes + "." + coins));
    }

    @JsonGetter("reserved")
    public boolean isReserved() {
        return reservedBy != null;
    }

    @Override
    public Seat clone() {
        return new Seat(this);
    }
}
