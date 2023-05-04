package cl.ucn.disc.pa.sinv.model;

public class Instrument {

    private int stockAvailable;

    public boolean hasStock() {
        return stockAvailable > 0;
    }

    public void removeStock(int quantityStock) {
        setStock(getStock() - quantityStock);
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

}
