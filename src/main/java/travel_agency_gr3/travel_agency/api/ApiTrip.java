package travel_agency_gr3.travel_agency.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import travel_agency_gr3.travel_agency.entity.Trip;
import travel_agency_gr3.travel_agency.repository.TripRepo;

import java.util.List;

@RestController
@RequestMapping("/add")
public class ApiTrip {
    private TripRepo tripRepo;

    @Autowired
    public ApiTrip(TripRepo tripRepo){
        this.tripRepo=tripRepo;
    }

    @GetMapping
    public List<Trip> getTrip(){
        return tripRepo.findAll();
    }

    @PostMapping
    public void addTrip(@RequestBody Trip trip){
        tripRepo.save(trip);
    }
}
