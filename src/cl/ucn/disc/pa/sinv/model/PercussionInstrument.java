package cl.ucn.disc.pa.sinv.model;

import ucn.StdOut;

public class PercussionInstrument extends Instrument {

    private final String typePerseccussion;
    private String altitude;

    /**
     *
     * The main constructor for the PercussionInstrument
     * @param code the code class
     * @param stockAvailable the stock available
     * @param price the price the instrument
     * @param type the type instrument
     * @param name the name instrument
     * @param typePerseccussion the type persecussion
     * @param material the material that was created
     * @param altitude the altitutde can be "Definida" or "Indefinida"
     */

    public PercussionInstrument(String code, int stockAvailable, int price, String type,
                                String name, String typePerseccussion,  String material, String altitude) {
        super(code, stockAvailable, price, type, name, material);
        this.typePerseccussion = typePerseccussion;
        this.altitude = altitude;

    }

    /**
     * Get the type persecussion
     * @return the type persecussion
     */

    public String getTypePerseccussion(){
        return this.typePerseccussion;
    }

    /**
     * Get the altitude
     * @return the altitude
     */

    public String getAltitude()
    {
        return this.altitude;
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
