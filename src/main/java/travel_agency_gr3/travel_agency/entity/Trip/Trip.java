package travel_agency_gr3.travel_agency.entity.Trip;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@Entity
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String destinationName;
    private Date dateOfDeparture;
    private Date dateOfReturn;
    private int numberOfDays;
    private FoodType foodType;
    private double addultPrice;
    private double childPrice;
    private int numberAdultPlaces;
    private int numberChildPlaces;
    private boolean promotion;

    public Trip() {
    }
}
