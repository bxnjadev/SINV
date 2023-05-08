package cl.ucn.disc.pa.sinv.model;

import org.omg.CORBA.WStringSeqHelper;

public class StringInstrument extends Instrument {

    private String instrument;
    private String typeString;
    private String material;
    private String instrumentclass;
    private int numberString;

    public StringInstrument(String code, int stockAvailable, int price, String type) {
        super(code, stockAvailable, price, type);
    }

    //----------------------------------------------FUNCIONES GET-------------------------------------------------------
    public String getInstrument(){
        return this.instrument;
    }
    public String getTypeString(){
        return this.typeString;
    }
    public String getMaterial(){
        return this.material;
    }
    public String getInstrumentclass(){
        return this.instrumentclass;
    }
    public int getNumberString(){
        return this.numberString;
    }

    //-----------------------------------------------FUNCIONES SET------------------------------------------------------
    public void setTypeString(String typeString){
        this.typeString = typeString;
    }
    public void setMaterial(String material){
        this.material = material;
    }
}