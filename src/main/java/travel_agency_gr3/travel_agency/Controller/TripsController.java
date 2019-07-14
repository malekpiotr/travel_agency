package travel_agency_gr3.travel_agency.Controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import travel_agency_gr3.travel_agency.DTO.TripDTO;
import travel_agency_gr3.travel_agency.Service.TripService;
import travel_agency_gr3.travel_agency.datatables.DataTablesResponse;

import static org.apache.commons.lang3.ObjectUtils.defaultIfNull;

@Controller
@RequestMapping(value = "/trips2")
public class TripsController {
    @Autowired
    private TripService tripService;

    @GetMapping("/list")
    public String tripList(@RequestParam(required = false) String text, Model model) {
        model.addAttribute("trips", tripService.findTripsForCustomer(text, null));
        model.addAttribute("query", StringUtils.defaultIfBlank(text, ""));
        model.addAttribute("cartActive", true);
        return "tripsList";
    }

    @GetMapping("/table")
    public String tripsTable(Model model) {
        model.addAttribute("firstTime", true);
        model.addAttribute("cartActive", true);
        return "tripsTable";
    }


    @RequestMapping(value = "/tableData", method = RequestMethod.GET)
    @ResponseBody
    public DataTablesResponse<TripDTO> find(@RequestParam(required = false) Integer start, @RequestParam(required = false) Integer length, @RequestParam(required = false) String sortColumn, @RequestParam(required = false) String sortOrder, @RequestParam(required = false) String searchText) {
        return tripService.getTripDataTable(defaultIfNull(start, 0), defaultIfNull(length, 5), StringUtils.defaultIfBlank(sortColumn, "id"), StringUtils.defaultIfBlank(sortOrder, "asc"), StringUtils.defaultIfBlank(searchText, ""));

    }

}
