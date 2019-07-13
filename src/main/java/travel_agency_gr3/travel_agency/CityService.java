package travel_agency_gr3.travel_agency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import travel_agency_gr3.travel_agency.entity.City;
import travel_agency_gr3.travel_agency.entity.Country;
import travel_agency_gr3.travel_agency.repository.CityRepo;
import travel_agency_gr3.travel_agency.repository.TripRepo;

@Service
public class CityService {
    @Autowired
    private CityDTOBuilder cityDTOBuilder;

    @Autowired
    private CityRepo<City> cityRepo;

    public void createNewCity(Country country,
                              String name
    ) {
        City city = new City();
        city.setCountry(country);
        city.setName(name);
        cityRepo.save(city);
    }
    public void updateCity(CityDTO cityDTO){
        City c = cityDTOBuilder.buildCityEntity(cityDTO);
        cityRepo.save(c);
    }
    public void deleteCity(Long id){
        cityRepo.deleteById(id);
    }


}
