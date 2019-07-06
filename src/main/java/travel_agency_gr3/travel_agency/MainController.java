package travel_agency_gr3.travel_agency;

import java.util.HashSet;

import java.util.Set;import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.servlet.ModelAndView;
import travel_agency_gr3.travel_agency.entity.Trip.Trip;

@Controller

public class MainController {
    Set<Trip>tripSet=new HashSet<>();

    String someText = "Aktualne oferty";

    @GetMapping("/")

    public ModelAndView getMain() {

        ModelAndView m = new ModelAndView();

        m.setViewName("index");

        m.addObject("someText", someText);

        addTrip();

        initTrip();

        m.addObject("trips", tripSet);

        return m;

    }

    public void addTrip(){
        Trip trip = new Trip();
        trip.setNumberOfDays(8);
        trip.setAddultPrice(2000);
        trip.setDestinationName("Italy");
        tripSet.add(trip);
        Trip trip2 = new Trip();
        trip2.setNumberOfDays(8);
        trip2.setAddultPrice(2000);
        trip2.setDestinationName("Majorka");
        tripSet.add(trip2);
        Trip trip3 = new Trip();
        trip3.setNumberOfDays(8);
        trip3.setAddultPrice(2000);
        trip3.setDestinationName("Greece");
        tripSet.add(trip3);
    }

    public void initTrip() {

        for (Trip trip : tripSet) {
            trip.getAddultPrice();
            trip.getNumberOfDays();
            trip.getDestinationName();
        }

    }
}