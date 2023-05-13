package cl.ucn.disc.pa.sinv.model;

public abstract class Instrument implements Showable {

    private String code;
    private int stockAvailable;
    private int price;
    private String type;
    private String name;

    public Instrument(String code, int stockAvailable, int price, String type) {
        this.code = code;
        this.stockAvailable = stockAvailable;
        this.price = price;
        this.type = type;
        this.name = name;
    }


    public boolean hasStock() {
        return stockAvailable > 0;
    }

    public void removeStock() {
        setStock(getStock() - 1);
    }

    public int getStock() {
        return stockAvailable;
    }

    private void setStock(int stockAvailable) {
        this.stockAvailable = stockAvailable;

        if (stockAvailable < 0) {
            this.stockAvailable = 0;
        }

    }

    public String getCode() {
        return this.code;
    }

    public String getType() {
        return this.type;
    }

    public int getPrice() {
        return this.price;
    }

    public String getName() {
        return this.name;
    }

}
