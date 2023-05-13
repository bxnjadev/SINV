package cl.ucn.disc.pa.sinv.model;

public class PercussionInstrument extends Instrument{
    private String instrument;
    private String typePerseccussion;
    private String material;
    private String altitude;

    public PercussionInstrument(String code, int stockAvailable, int price, String type) {
        super(code, stockAvailable, price, type);

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
}
