package cl.ucn.disc.pa.sinv.model;

import ucn.StdOut;

public class StringInstrument extends Instrument {

    private String instrument;
    private String typeString;
    private String material;
    private String instrumentClass;
    private int numberString;

    public StringInstrument(String code, int stockAvailable, int price, String type,
                            String instrument, String  typeString, String material, String instrumentClass, int numberString) {
        super(code, stockAvailable, price, type);
    }

    public String getInstrument(){
        return this.instrument;
    }
    public String getTypeString(){
        return this.typeString;
    }
    public String getMaterial(){
        return this.material;
    }
    public String getInstrumentClass(){
        return this.instrumentClass;
    }
    public int getNumberString(){
        return this.numberString;
    }

    public void setTypeString(String typeString){
        this.typeString = typeString;
    }
    public void setMaterial(String material){
        this.material = material;
    }

    @Override
    public void show() {
        StdOut.println("Type String: " + typeString);
        StdOut.println("Type Material: " + material);
        StdOut.println("Instrument Class: " + instrumentClass);
        StdOut.println("");

    }

}
