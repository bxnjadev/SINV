package cl.ucn.disc.pa.sinv.model;

import ucn.StdOut;

public abstract class Instrument implements Showable {

    protected final String SEPARATOR = ",";

    private final String code;
    private int stockAvailable;
    private final int price;
    private final String type;
    private final String name;
    private final String material;

    /**
     * The main constructor for the Instrument
     * @param code the code class
     * @param stockAvailable the stock available
     * @param price the price the instrument
     * @param type the type instrument
     * @param name the name instrument
     * @param material the material that was created
     */

    public Instrument(String code, int stockAvailable, int price, String type, String name,
                      String material) {
        this.code = code;
        this.stockAvailable = stockAvailable;
        this.price = price;
        this.type = type;
        this.name = name;
        this.material = material;
    }

    /**
     * Check if it has stock
     * @return true if it has stock, false if it no has stock
     */

    public boolean hasStock() {
        return stockAvailable > 0;
    }

    /**
     * Remove the stock, this quantity is one
     */

    public void removeStock() {
        setStock(getStock() - 1);
    }

    /**
     * Get stock available
     * @return the stock available
     */

    public int getStock() {
        return stockAvailable;
    }

    /**
     * Set the stock
     * @param stockAvailable the stock available
     */

    private void setStock(int stockAvailable) {
        this.stockAvailable = stockAvailable;

        if (stockAvailable < 0) {
            this.stockAvailable = 0;
        }

    }

    /**
     * Get code
     * @return the code
     */

    public String getCode() {
        return this.code;
    }

    /**
     * Get the type
     * @return the type
     */

    public String getType() {
        return this.type;
    }

    /**
     * Get price
     * @return the price
     */

    public int getPrice() {
        return this.price;
    }

    /**
     * Get name
     * @return the name
     */

    public String getName() {
        return this.name;
    }

    /**
     * Get the material
     * @return the material
     */

    public String getMaterial() {
        return this.material;
    }

    /**
     * Show the component and date the instrument
     */

    @Override
    public void show() {
        StdOut.println("Code: " + code + " Stock " + stockAvailable + " Price " + price + " Name " + name);
    }

    @Override
    public String toString() {
        return type + SEPARATOR + code + SEPARATOR + stockAvailable + SEPARATOR + price;
    }
}
