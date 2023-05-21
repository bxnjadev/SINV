package cl.ucn.disc.pa.sinv.model;

import ucn.StdOut;

public class Ticket implements Showable {

    private final String sellInstrument;
    private final int price;

    /**
     * The main constructor for the class Ticket
     * @param sellInstrument the instrument sold
     * @param price the price
     */

    public Ticket(String sellInstrument, int price) {
        this.sellInstrument = sellInstrument;
        this.price = price;
    }

    /**
     * Get the instrument sold
     * @return the instrument sold
     */

    public String getSellInstrument() {
        return sellInstrument;
    }

    @Override
    public String toString() {
        return "Instrumento vendido: " + sellInstrument + " Precio " + price;
    }

    /**
     * Show the component class
     */

    @Override
    public void show() {
        StdOut.println("Instrumento vendido: " + sellInstrument);
        StdOut.println("Precio: " + price);
    }

}
