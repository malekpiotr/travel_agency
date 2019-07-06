package travel_agency_gr3.travel_agency;

import java.util.Collection;
import java.util.HashSet;

import java.util.Set;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.servlet.ModelAndView;
import travel_agency_gr3.travel_agency.entity.Trip;
import travel_agency_gr3.travel_agency.repository.TripRepo;
import travel_agency_gr3.travel_agency.service.ServiceTrip;

@Controller

public class MainController {
    Set<Trip> tripSet = new HashSet<>();
    TripRepo tripRepo;
    ServiceTrip serviceTrip = new ServiceTrip(tripRepo);
    String someText = "Aktualne oferty";


    @GetMapping("/trips")

    public ModelAndView getMain() {

        ModelAndView m = new ModelAndView();

        m.setViewName("index");

        m.addObject("someText", someText);


        m.addObject("trips", serviceTrip.getTrip());

        return m;

    }


    public void initTrip() {
        tripSet.addAll((Collection<? extends Trip>) serviceTrip.getTrip());

    }
}