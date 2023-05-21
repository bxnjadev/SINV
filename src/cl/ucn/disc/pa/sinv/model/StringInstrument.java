package cl.ucn.disc.pa.sinv.model;

import ucn.StdOut;

public class StringInstrument extends Instrument {

    private String typeString;
    private final String typeStringInstrument;
    private final int numberString;

    /**
     * The main constructor for the StringInstrument class
     * @param code the code instrument
     * @param stockAvailable the stock the instrument
     * @param price the price the instrument
     * @param type the type the instrument
     * @param typeString the Type String instrument
     * @param name the name instrument for example (guitar ... etc)
     * @param material the material that was created
     * @param numberString the number string the instrument
     * @param typeStringInstrument this just accept two values, electric or acoustic
     */

    public StringInstrument(String code, int stockAvailable, int price, String type,
                            String typeString, String name, String material,
                            int numberString, String typeStringInstrument) {
        super(code, stockAvailable, price, type, name, material);
        this.typeString = typeString;
        this.typeStringInstrument = typeStringInstrument;
        this.numberString = numberString;
    }

    /**
     * Get the type string
     * @return the type string
     */

    public String getTypeString() {
        return this.typeString;
    }

    /**
     * Get the type string instrument
     * @return the type string instrument
     */

    public String getTypeStringInstrument() {
        return this.typeStringInstrument;
    }

    /**
     * Get the number string
     * @return the number string
     */

    public int getNumberString() {
        return this.numberString;
    }

    /**
     * Show the data of the class StringInstrument
     */

    @Override
    public void show() {
        super.show();
        StdOut.println("Type String: " + typeString);
    }

    @Override
    public String toString() {
        return super.toString() + SEPARATOR + getTypeString() + SEPARATOR + getName() + SEPARATOR +
                getMaterial() + SEPARATOR + getNumberString() + SEPARATOR + getTypeStringInstrument();
    }

}
