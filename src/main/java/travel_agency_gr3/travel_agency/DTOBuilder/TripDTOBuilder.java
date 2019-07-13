package travel_agency_gr3.travel_agency.DTOBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import travel_agency_gr3.travel_agency.DTO.TripDTO;
import travel_agency_gr3.travel_agency.entity.Trip;
import travel_agency_gr3.travel_agency.repository.TripRepo;

@Service
public class TripDTOBuilder {
    @Autowired
    private TripRepo<Trip> tripRepo;

    public TripDTO buildDto(Trip trip) {
        return TripDTO.builder()
                .id(trip.getId())
                .addultPrice(trip.getAddultPrice())
                .childPrice(trip.getChildPrice())
                .dateOfDeparture(trip.getDateOfDeparture())
                .dateOfReturn(trip.getDateOfReturn())
                .foodType(trip.getFoodType())
                .destinationName(trip.getDestinationName())
                .name(trip.getName())
                .numberAdultPlaces(trip.getNumberAdultPlaces())
                .numberChildPlaces(trip.getNumberChildPlaces())
                .numberOfDays(trip.getNumberOfDays())
                .promotion(trip.isPromotion())
                .build();
    }

    public Trip buildEntity(TripDTO dto) {
        Trip trip;
        if (dto.getId() == null) {
            trip = new Trip();
        } else {
            trip = tripRepo.getOne(dto.getId());
        }

        trip.setAddultPrice(dto.getAddultPrice());
        trip.setChildPrice(dto.getChildPrice());
        trip.setDateOfDeparture(dto.getDateOfDeparture());
        trip.setDateOfReturn(dto.getDateOfReturn());
        trip.setFoodType(dto.getFoodType());
        trip.setDestinationName(dto.getDestinationName());
        trip.setName(dto.getName());
        trip.setNumberAdultPlaces(dto.getNumberAdultPlaces());
        trip.setNumberChildPlaces(dto.getNumberChildPlaces());
        trip.setNumberOfDays(dto.getNumberOfDays());
        trip.setPromotion(dto.isPromotion());
        return trip;
    }
}
