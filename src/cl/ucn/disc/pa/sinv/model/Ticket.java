package cl.ucn.disc.pa.sinv.model;

import ucn.StdOut;

public class Ticket implements Showable {

    private final String sellInstrument;
    private final int price;

    public Ticket(String sellInstrument, int price) {
        this.sellInstrument = sellInstrument;
        this.price = price;
    }

    public String getSellInstrument() {
        return sellInstrument;
    }

    @Override
    public String toString() {
        return "Instrumento vendido: " + sellInstrument + " Precio " + price;
    }

    @Override
    public void show() {
        StdOut.println("Instrumento vendido: " + sellInstrument);
        StdOut.println("Precio: " + price);
    }

}
