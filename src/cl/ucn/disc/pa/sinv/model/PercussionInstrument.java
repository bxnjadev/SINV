package cl.ucn.disc.pa.sinv.model;

import ucn.StdOut;

public class PercussionInstrument extends Instrument {

    private String instrument;
    private String typePerseccussion;
    private String material;
    private String altitude;

    public PercussionInstrument(String code, int stockAvailable, int price, String type,
                                String instrument, String typePerseccussion, String material, String altitude) {
        super(code, stockAvailable, price, type);
        this.instrument = instrument;
        this.typePerseccussion = typePerseccussion;
        this.material = material;
        this.altitude = altitude;

    }

    public String getInstrument(){
        return this.instrument;
    }
    public String getTypePerseccussion(){
        return this.typePerseccussion;
    }
    public String getMaterial(){
        return this.material;
    }
    public String getAltura(){
        return this.altitude;
    }

    public void setTypePerseccussion(String typePerseccussion){
        this.typePerseccussion = typePerseccussion;
    }
    public void setMaterial(String material){
        this.material = material;
    }
    public void setAltitude(String altitude){
        this.altitude = altitude;
    }

    @Override
    public void show() {
        super.show();
        StdOut.println("TypePercussion: " + getTypePerseccussion());
        StdOut.println("Material: " + getMaterial());
        StdOut.println("Altitude: " + getAltura());
    }

}
