package travel_agency_gr3.travel_agency.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "system_type",
discriminatorType = DiscriminatorType.STRING)
public class Trip {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String destinationName;
    private Date dateOfDeparture;
    private Date dateOfReturn;
    private Integer numberOfDays;
    @Enumerated(EnumType.STRING)
    private FoodType foodType;
    private Double addultPrice;
    private Double childPrice;
    private Integer numberAdultPlaces;
    private Integer numberChildPlaces;
    private boolean promotion;
    private String name;

}
