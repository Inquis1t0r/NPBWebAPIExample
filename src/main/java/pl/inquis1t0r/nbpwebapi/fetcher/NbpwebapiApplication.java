package pl.inquis1t0r.nbpwebapi.fetcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class NbpwebapiApplication {

    private static final Logger log=LoggerFactory.getLogger(NbpwebapiApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(NbpwebapiApplication.class, args);

        RestTemplate restTemplate = new RestTemplate();

    }

}
