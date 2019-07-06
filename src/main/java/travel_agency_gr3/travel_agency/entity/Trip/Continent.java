package travel_agency_gr3.travel_agency.entity.Trip;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
public class Continent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "continent")
    private Set<Country> countryList = new HashSet<>();

    public Continent() {
    }

}
