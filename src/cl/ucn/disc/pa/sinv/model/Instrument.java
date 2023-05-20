package cl.ucn.disc.pa.sinv.model;

import ucn.StdOut;

public abstract class Instrument implements Showable {

    private final String code;
    private int stockAvailable;
    private final int price;
    private final String type;
    private final String name;
    private final String material;

    public Instrument(String code, int stockAvailable, int price, String type, String name,
                      String material) {
        this.code = code;
        this.stockAvailable = stockAvailable;
        this.price = price;
        this.type = type;
        this.name = name;
        this.material = material;
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

    public String getMaterial() {
        return this.material;
    }

    @Override
    public void show() {
        StdOut.println("Code: " + code + " Stock " + stockAvailable + " Price " + price + " Name " + name);
    }

}
