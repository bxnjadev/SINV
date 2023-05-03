package cl.ucn.disc.pa.sinv.model;

public class Ticket {

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

}
