package cl.ucn.disc.pa.sinv.model;

import ucn.StdOut;

public class WindInstrument extends Instrument {

    private String instrument;
    private String material;

    public WindInstrument(String code, int stockAvailable, int price, String type, String name,
                          String  material) {
        super(code, stockAvailable, price, type);
        this.material = material;

    }

    public String getInstrument(){
        return this.instrument;
    }
    public String getMaterial(){
        return this.material;
    }

    public void setMaterial(String material){
        this.material = material;
    }

    @Override
    public void show() {

        super.show();
        StdOut.println("Material: " + material);

    }

}
