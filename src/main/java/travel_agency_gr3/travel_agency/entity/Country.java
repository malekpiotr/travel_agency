package travel_agency_gr3.travel_agency.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Country extends BaseEntity{
    private String name;
    @ManyToOne
    private Continent continent;
}
