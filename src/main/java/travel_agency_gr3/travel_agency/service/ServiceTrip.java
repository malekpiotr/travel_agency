package travel_agency_gr3.travel_agency.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import travel_agency_gr3.travel_agency.entity.Trip;
import travel_agency_gr3.travel_agency.repository.TripRepo;

import java.util.List;
import java.util.Optional;

@RequestMapping("/add")
public class ServiceTrip {
    private TripRepo tripRepo;

    @Autowired
    public ServiceTrip(TripRepo tripRepo){
        this.tripRepo=tripRepo;
    }

    @GetMapping
    public Iterable<Trip>getTrip(){
        return tripRepo.findAll();
    }

    @PostMapping
    public void addTrip(@RequestBody Trip trip){
        tripRepo.save(trip);
    }
}
