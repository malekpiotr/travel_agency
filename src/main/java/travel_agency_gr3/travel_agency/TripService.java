package travel_agency_gr3.travel_agency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import travel_agency_gr3.travel_agency.entity.FoodType;
import travel_agency_gr3.travel_agency.entity.Trip;
import travel_agency_gr3.travel_agency.repository.TripRepo;

import java.util.Date;

@Service
public class TripService {
    @Autowired
    private TripRepo<Trip> tripRepo;

    public void createNewTrip(String destinationName,
                              Date dateOfDeparture,
                              Date dateOfReturn,
                              Integer numberOfDays,
                              FoodType foodType,
                              Double addultPrice,
                              Double childPrice,
                              Integer numberAdultPlaces,
                              Integer numberChildPlaces,
                              boolean promotion) {
        Trip trip = new Trip();
        trip.setAddultPrice(addultPrice);
        trip.setDestinationName(destinationName);
        trip.setName(destinationName);
        trip.setNumberOfDays(numberOfDays);
        trip.setChildPrice(childPrice);
        trip.setDateOfDeparture(dateOfDeparture);
        trip.setFoodType(foodType);
        trip.setDateOfReturn(dateOfReturn);
        trip.setPromotion(promotion);
        tripRepo.save(trip);
    }

}
