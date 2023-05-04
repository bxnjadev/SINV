package cl.ucn.disc.pa.sinv.model;

public class Instrument {

    private int stockAvailable;

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

    }

    public String getType() {

    }

    public String getName() {

    }

    public int getPrice() {

    }

}
