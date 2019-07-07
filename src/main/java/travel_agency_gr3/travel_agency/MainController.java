package travel_agency_gr3.travel_agency;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.servlet.ModelAndView;
import travel_agency_gr3.travel_agency.entity.Trip;
import travel_agency_gr3.travel_agency.repository.TripRepo;
import travel_agency_gr3.travel_agency.api.ApiTrip;

@Controller

public class MainController {
    private TripRepo tripRepo;
    private ApiTrip apiTrip = new ApiTrip(tripRepo);
    private String someText = "Aktualne oferty";

    private Trip trip = new Trip("Jakas wycieczka");



    @GetMapping("/")
    public ModelAndView getMain() {
        ModelAndView m = new ModelAndView();
        m.setViewName("index");
        m.addObject("someText", someText);

        initTrip();
        //viewTrip();
        m.addObject("trips", apiTrip.getTrip());

        return m;
    }


    public void initTrip() {
       apiTrip.addTrip(trip);
    }

//    public void viewTrip(){
//        tripSet=apiTrip.getTrip();
//        for (Trip t:tripSet) {
//            t.getName();
//        }
//    }
}