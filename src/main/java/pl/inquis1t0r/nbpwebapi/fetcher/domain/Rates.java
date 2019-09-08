package pl.inquis1t0r.nbpwebapi.fetcher.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Rates {
    @JsonProperty("rates")
    private List<Rates> ratesList;
    private BigDecimal bid;
    private BigDecimal ask;
    private String no;

    MathContext mc = new MathContext(4);

    public BigDecimal getDifference() {
        return bid.subtract(ask, mc).abs();
    }

    public void setDifference(BigDecimal difference) {
        this.difference = bid.subtract(ask, mc).abs();
    }

    private BigDecimal difference;

    public List<Rates> getRatesList() {
        return ratesList;
    }

    public void setRatesList(List<Rates> ratesList) {
        this.ratesList = ratesList;
    }

    public BigDecimal getBid() {
        return bid;
    }

    public void setBid(BigDecimal bid) {
        this.bid = bid;
    }

    public BigDecimal getAsk() {
        return ask;
    }

    public void setAsk(BigDecimal ask) {
        this.ask = ask;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

}
