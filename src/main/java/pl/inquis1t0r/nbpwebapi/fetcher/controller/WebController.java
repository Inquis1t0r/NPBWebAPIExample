package pl.inquis1t0r.nbpwebapi.fetcher.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import pl.inquis1t0r.nbpwebapi.fetcher.domain.StartTime;
import pl.inquis1t0r.nbpwebapi.fetcher.domain.Rates;

import java.util.List;



@Controller
public class WebController {
    RestTemplate restTemplate = new RestTemplate();

    private String format = "/?format=json";
    private String url = "http://api.nbp.pl/api/exchangerates/rates/c/usd/";
    private String dateToday = "2019-09-09";

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("message", new StartTime());
        return "form";
    }

    @PostMapping("/showResult")
    public String index(@ModelAttribute(value = "messageBody") String messageBody, BindingResult bindingResult, Model model) {
        System.out.println("messageBody: " + messageBody);
        //List<Rates> ratesList = restTemplate
            //    .getForObject(url+messageBody+"/"+dateToday+format, Rates.class)
              //  .getRatesList();
        List<Rates> ratesList = restTemplate
                .getForObject("http://api.nbp.pl/api/exchangerates/rates/c/usd/2012-09-01/2013-01-31/?format=json", Rates.class)
                .getRatesList();

        model.addAttribute("ratesList",  ratesList);
        return "result";
    }


}
