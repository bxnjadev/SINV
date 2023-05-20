package cl.ucn.disc.pa.sinv.model;

import ucn.StdOut;

public class StringInstrument extends Instrument {

    private String typeString;
    private final String typeStringInstrument;
    private final int numberString;

    public StringInstrument(String code, int stockAvailable, int price, String type,
                            String typeString, String name, String material,
                            int numberString, String typeStringInstrument) {
        super(code, stockAvailable, price, type, name, material);
        this.typeString = typeString;
        this.typeStringInstrument = typeStringInstrument;
        this.numberString = numberString;
    }

    public String getTypeString() {
        return this.typeString;
    }

    public String getTypeStringInstrument() {
        return this.typeStringInstrument;
    }

    public int getNumberString() {
        return this.numberString;
    }

    public void setTypeString(String typeString) {
        this.typeString = typeString;
    }

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
