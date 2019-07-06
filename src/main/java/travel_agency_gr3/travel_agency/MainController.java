package travel_agency_gr3.travel_agency;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello user";
    }
}
