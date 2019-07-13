package travel_agency_gr3.travel_agency;

import lombok.*;
import travel_agency_gr3.travel_agency.entity.City;
import travel_agency_gr3.travel_agency.entity.FoodType;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

@Getter
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TripDTO {
    private Long id;
    private City destinationName;
    private LocalDateTime dateOfDeparture;
    private LocalDateTime dateOfReturn;
    private int numberOfDays;
    private FoodType foodType;
    private double addultPrice;
    private double childPrice;
    private int numberAdultPlaces;
    private int numberChildPlaces;
    private boolean promotion;
    private String name;

    public String getFoodTypeString(){
        return Optional.ofNullable(foodType).map(e->e.getType()).orElse("");
    }

}
