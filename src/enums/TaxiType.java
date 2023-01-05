package enums;

import java.math.BigDecimal;
import java.time.LocalDate;

public enum TaxiType {
    STANDART(new BigDecimal(10), new BigDecimal(20)),

    COMFORT(new BigDecimal(15), new BigDecimal(30)),

    BUSINESS(new BigDecimal(20), new BigDecimal(40));

    private BigDecimal pricePerKm;

    private BigDecimal priceForLanding;


    TaxiType(BigDecimal pricePerKm, BigDecimal priceForLanding) {

        this.pricePerKm = pricePerKm;

        this.priceForLanding = priceForLanding;

    }


    public BigDecimal getPricePerKm() {

        return pricePerKm;

    }


    public void setPricePerKm(BigDecimal pricePerKm) {

        this.pricePerKm = pricePerKm;

    }


    public BigDecimal getPriceForLanding() {

        return priceForLanding;

    }


    public void setPriceForLanding(BigDecimal priceForLanding) {

        this.priceForLanding = priceForLanding;

    }


    @Override

    public String toString() {

        return "\nTaxiType :" +

                "\npricePerKm :" + pricePerKm +

                "\npriceForLanding :" + priceForLanding;

    }
}
