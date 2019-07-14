package travel_agency_gr3.travel_agency.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import travel_agency_gr3.travel_agency.DTO.TripDTO;
import travel_agency_gr3.travel_agency.Service.CityService;
import travel_agency_gr3.travel_agency.Service.TripService;
import travel_agency_gr3.travel_agency.entity.FoodType;


import javax.validation.Valid;
import java.time.LocalDate;


@RequestMapping("/admin")
@Controller
public class AdminContoller {
    @Autowired
    TripService tripService;

    @Autowired
    CityService cityService;

    @GetMapping(value = "/addtrip")
    public String addTripForm(Model model) {
        model.addAttribute("tripFormData", new TripDTO());
        model.addAttribute("foodtypes", FoodType.values());
        model.addAttribute("cities",cityService.findAllCity());
        return "addTripForm";
    }

    @PostMapping(value = "/addtrip")
    public String addTrip(@ModelAttribute(name = "tripFormData") @Valid TripDTO trip, Model model, BindingResult bindingResult) {
        LocalDate start = LocalDate.parse(trip.getDateOfDeparture());
        LocalDate rtn = LocalDate.parse(trip.getDateOfReturn());
        trip.setNumberOfDays(rtn.getDayOfYear() - start.getDayOfYear());

        if (bindingResult.hasErrors()) {
            model.addAttribute("foodtypes",  FoodType.values());
            return "addTripForm";
        }
        tripService.updateTrip(trip);
        model.addAttribute("addTripData", trip.getName());
        return "addTripEffect";
    }
}
