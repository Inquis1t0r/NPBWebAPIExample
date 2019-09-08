package pl.inquis1t0r.nbpwebapi.fetcher.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import pl.inquis1t0r.nbpwebapi.fetcher.domain.Rates;


import java.util.List;



@Controller
public class WebController {
    RestTemplate restTemplate = new RestTemplate();



    @GetMapping("/")
    public String index(Model model) {
        List<Rates> ratesList = restTemplate.getForObject("http://api.nbp.pl/api/exchangerates/rates/c/usd/2018-02-03/2019-01-31/?format=json", Rates.class).getRatesList();
        model.addAttribute("ratesList",  ratesList);
        return "index";
    }

}
