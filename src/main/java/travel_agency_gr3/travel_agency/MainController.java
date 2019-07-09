package travel_agency_gr3.travel_agency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.servlet.ModelAndView;
import travel_agency_gr3.travel_agency.entity.Trip;

@Controller
public class MainController {
    @Autowired
    TripService tripService;

    String someText = "Promowane oferty";

//    @EventListener(ApplicationReadyEvent.class)
//    public void addTrip(){
//        TripDTO trip = new TripDTO();
//        trip.setNumberOfDays(8);
//        trip.setAddultPrice(2000d);
//        trip.setDestinationName("Italy");
//        trip.setName("Wycieczka do Włoch");
//        trip.setPromotion(true);
//        tripService.updateTrip(trip);
//
//        TripDTO trip2 = new TripDTO();
//        trip2.setNumberOfDays(8);
//        trip2.setAddultPrice(2000d);
//        trip2.setDestinationName("Majorka");
//        trip2.setName("Wycieczka na Majorrrę");
//        trip2.setPromotion(true);
//        tripService.updateTrip(trip2);
//
//        TripDTO trip3 = new TripDTO();
//        trip3.setNumberOfDays(8);
//        trip3.setAddultPrice(2000d);
//        trip3.setDestinationName("Greece");
//        trip3.setName("Wycieczka do Grecji");
//        trip3.setPromotion(true);
//        tripService.updateTrip(trip3);
//    }

    @GetMapping("/trips")
    public ModelAndView getMain() {

        ModelAndView m = new ModelAndView();

        m.setViewName("trips");

        m.addObject("someText", someText);

        m.addObject("trips",tripService.findPromotionTrips());

        return m;

    }
}