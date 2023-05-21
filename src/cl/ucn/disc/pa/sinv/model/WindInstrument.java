package cl.ucn.disc.pa.sinv.model;

import ucn.StdOut;

public class WindInstrument extends Instrument {

    /**
     * The constructor method for create the WindInstrument
     * @param code the code class
     * @param stockAvailable the stock available
     * @param price the price the instrument
     * @param type the type instrument
     * @param name the name instrument
     * @param material the material that was created
     */

    public WindInstrument(String code, int stockAvailable, int price, String type, String name,
                          String  material) {
        super(code, stockAvailable, price, type, name, material);

    }

}
