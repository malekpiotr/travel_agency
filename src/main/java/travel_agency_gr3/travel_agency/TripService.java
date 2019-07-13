package travel_agency_gr3.travel_agency;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import travel_agency_gr3.travel_agency.datatables.DataTablesOrder;
import travel_agency_gr3.travel_agency.datatables.DataTablesResponse;
import travel_agency_gr3.travel_agency.entity.FoodType;
import travel_agency_gr3.travel_agency.entity.QTrip;
import travel_agency_gr3.travel_agency.entity.Trip;
import travel_agency_gr3.travel_agency.repository.TripRepo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class TripService {
    @Autowired
    private TripDTOBuilder tripDTOBuilder;

    @Autowired
    private TripRepo<Trip> tripRepo;

    public void createNewTrip(String destinationName,
                              LocalDateTime dateOfDeparture,
                              LocalDateTime dateOfReturn,
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

    public void updateTrip(TripDTO tripDTO){
        Trip t = tripDTOBuilder.buildEntity(tripDTO);
        tripRepo.save(t);
    }

    public Optional<Trip> findTrip(Long id){
        return tripRepo.findById(id);
    }

    public List<Trip> findPromotionTrips(){
        return tripRepo.findPromotionTrip();
    }


    public List<Trip> findTripToEdit(String query, String foodType){
        return findTripQuery(query, foodType);
    }

    private List<Trip> findTripQuery(String query, String productType) {
        if (StringUtils.isBlank(query) && StringUtils.isBlank(productType)) {
            return tripRepo.findAll();
        }
        if (StringUtils.isBlank(query)) {
            return tripRepo.findTripByFoodType(FoodType.valueOf(productType));
        }
        if (StringUtils.isBlank(productType)) {
            return tripRepo.findTripByName(query);
        }
        return tripRepo.findByNameAndFoodType(query, FoodType.valueOf(productType));
    }

    public List<TripDTO> findTripsForCustomer(String query, String foodType) {
        return findTripQuery(query, foodType)
                .stream()
                .filter(e -> ObjectUtils.defaultIfNull(e.getAddultPrice(), 0d) > 0d)
                .map(tripDTOBuilder::buildDto)
                .collect(Collectors.toList());
    }

    public Optional<TripDTO> findTriptById(Long id) {
        return tripRepo.findById(id).map(tripDTOBuilder::buildDto);
    }

    public DataTablesResponse<TripDTO> getTripDataTable(Integer start, Integer length, String sortColumn, String sortOrder, String searchText) {
        DataTablesResponse<TripDTO> dtResponse = new DataTablesResponse<>();
        Page<Trip> tripByName = findTripByName(searchText, start == 0 ? 0 : (start / length), length, getSort(sortColumn, sortOrder));
        dtResponse.setData(tripByName.getContent()
                .stream()
                .map(tripDTOBuilder::buildDto)
                .collect(Collectors.toList()));
        dtResponse.setRecordsTotal((int) tripByName.getTotalElements());
        dtResponse.setRecordsFiltered((int) tripByName.getTotalElements());
        return dtResponse;
    }
    private Sort getSort(String name, String direction) {
        return direction.equalsIgnoreCase(DataTablesOrder.Direction.asc.name()) ? Sort.by(name).ascending() : Sort.by(name).descending();
    }
    private Page<Trip> findTripByName(String query, int page, int size, Sort sort) {
        Function<String, Page<Trip>> supplierForNotBlankQuery = (q) -> tripRepo.findAll(QTrip.trip.name.likeIgnoreCase("%" + q + "%").and(QTrip.trip.numberAdultPlaces.goe(1)), PageRequest.of(page, size, sort));
        Function<String, Page<Trip>> supplierForBlankQuery = (q) -> tripRepo.findAll(QTrip.trip.numberAdultPlaces.goe(1), PageRequest.of(page, size, sort));
        return StringUtils.isBlank(query) ? supplierForBlankQuery.apply(query) : supplierForNotBlankQuery.apply(query);
    }
    private void mockTrip(String name,
                             String destinationName,
                             LocalDateTime dateOfDeparture,
                             LocalDateTime dateOfReturn,
                             int numberOfDays,
                             FoodType foodType,
                             double addultPrice,
                             double childPrice,
                             int numberAdultPlaces,
                             int numberChildPlaces,
                             boolean promotion)

    {
        Trip trip = new Trip();
        trip.setAddultPrice(addultPrice);
        trip.setChildPrice(childPrice);
        trip.setDateOfDeparture(dateOfDeparture);
        trip.setDateOfReturn(dateOfReturn);
        trip.setFoodType(foodType);
        trip.setDestinationName(destinationName);
        trip.setName(name);
        trip.setNumberAdultPlaces(numberAdultPlaces);
        trip.setNumberChildPlaces(numberChildPlaces);
        trip.setNumberOfDays(numberOfDays);
        trip.isPromotion();
        tripRepo.save(trip);
    }



}
