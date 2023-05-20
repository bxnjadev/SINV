package cl.ucn.disc.pa.sinv.utils;

import ucn.Registro;

public class RegistroBuilder {

    private final Registro registro;

    public RegistroBuilder(int fields) {
        registro = new Registro(fields);
    }

    public RegistroBuilder addField(String value) {
        registro.agregarCampo(value);
        return self();
    }

    public RegistroBuilder addField(int value) {
        registro.agregarCampo(value);
        return self();
    }

    public RegistroBuilder self() {
        return this;
    }

    public static RegistroBuilder newBuilder(int fields) {
        return new RegistroBuilder(fields);
    }

}
