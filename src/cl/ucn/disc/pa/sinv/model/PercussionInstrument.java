package cl.ucn.disc.pa.sinv.model;

import ucn.StdOut;

public class PercussionInstrument extends Instrument {

    private final String typePerseccussion;
    private String altitude;

    public PercussionInstrument(String code, int stockAvailable, int price, String type,
                                String name, String typePerseccussion,  String material, String altitude) {
        super(code, stockAvailable, price, type, name, material);
        this.typePerseccussion = typePerseccussion;
        this.altitude = altitude;

    }

    public String getTypePerseccussion(){
        return this.typePerseccussion;
    }

    public String getAltitude()
    {
        return this.altitude;
    }

    public void setAltitude(String altitude){
        this.altitude = altitude;
    }

    @Override
    public void show() {
        super.show();
        StdOut.println("TypePercussion: " + getTypePerseccussion() + " Material: " + getMaterial() + " Altura " + getAltitude());
    }

    @Override
    public String toString() {
        return super.toString() + SEPARATOR + getName() + SEPARATOR + getTypePerseccussion() +
                SEPARATOR + getMaterial() + SEPARATOR + getAltitude();
    }

}
