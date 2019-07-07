package travel_agency_gr3.travel_agency;

import java.util.HashSet;

import java.util.Set;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.servlet.ModelAndView;
import travel_agency_gr3.travel_agency.entity.Trip.Trip;

@Controller

public class MainController {
    Set<Trip>tripSet=new HashSet<>();

    String someText = "Promowane oferty";

    @EventListener(ApplicationReadyEvent.class)
    public void addTrip(){
        Trip trip = new Trip();
        trip.setNumberOfDays(8);
        trip.setAddultPrice(2000);
        trip.setDestinationName("Italy");
        trip.setName("Wycieczka do Włoch");
        tripSet.add(trip);
        Trip trip2 = new Trip();
        trip2.setNumberOfDays(8);
        trip2.setAddultPrice(2000);
        trip2.setDestinationName("Majorka");
        trip2.setName("Wycieczka na Majorrrę");
        tripSet.add(trip2);
        Trip trip3 = new Trip();
        trip3.setNumberOfDays(8);
        trip3.setAddultPrice(2000);
        trip3.setDestinationName("Greece");
        trip3.setName("Wycieczka do Grecji");
        tripSet.add(trip3);
    }

    @GetMapping("/trips")

    public ModelAndView getMain() {

        ModelAndView m = new ModelAndView();

        m.setViewName("trips");

        m.addObject("someText", someText);


        initTrip();

        m.addObject("trips", tripSet);

        return m;

    }



    public void initTrip() {

        for (Trip trip : tripSet) {
            trip.getAddultPrice();
            trip.getNumberOfDays();
            trip.getDestinationName();
        }

    }
}