package morozov.ru.model;

public class FlightInfo {

    private String fromCity;
    private String toCity;
    private int price;

    public FlightInfo() {
    }

    public FlightInfo(String fromCity, String toCity, int price) {
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.price = price;
    }

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "fromCity : " + fromCity + '\n' +
                "toCity : " + toCity + '\n' +
                "price : " + price;
    }
}