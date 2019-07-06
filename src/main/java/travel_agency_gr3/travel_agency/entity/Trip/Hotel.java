package travel_agency_gr3.travel_agency.entity.Trip;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private HotelStandard hotelStandard;
    private String description;

    @OneToOne
    private City city;
    public Hotel() {
    }
}
