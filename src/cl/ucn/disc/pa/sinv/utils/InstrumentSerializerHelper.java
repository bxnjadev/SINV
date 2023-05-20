package cl.ucn.disc.pa.sinv.utils;

import cl.ucn.disc.pa.sinv.model.Instrument;
import cl.ucn.disc.pa.sinv.model.PercussionInstrument;
import cl.ucn.disc.pa.sinv.model.StringInstrument;
import cl.ucn.disc.pa.sinv.model.WindInstrument;
import ucn.Registro;

import java.io.IOException;

public class InstrumentSerializerHelper {

    public static Instrument constructInstrument(Registro registro) throws IOException {
        String type = registro.getString();

        return switch (type) {
            case "Percusión" -> constructPersecussionInstrument(type, registro);
            case "Cuerda" -> constructStringInstrument(type, registro);
            default -> constructWindInstrument(type, registro);
        };

    }

    private static Instrument constructPersecussionInstrument(String  type, Registro registro) throws IOException {
        System.out.println("Construyendo un item ");
        return new PercussionInstrument(registro.getString(), registro.getInt(), registro.getInt(), type,
                registro.getString(), registro.getString(), registro.getString(), registro.getString());
    }

    private static Instrument constructWindInstrument(String type, Registro registro) throws IOException {
        return new WindInstrument(registro.getString(), registro.getInt(), registro.getInt()
                ,type, registro.getString(), registro.getString());
    }

    private static Instrument constructStringInstrument(String type, Registro registro) throws IOException {
        return new StringInstrument(registro.getString(), registro.getInt(), registro.getInt()
                , type, registro.getString(), registro.getString(),
                registro.getString(), registro.getInt(),
                registro.getString());
    }

    public static Registro constructRegistro(Instrument instrument) {
       /* switch (instrument.getType()) {
            case "percussion":
                return RegistroBuilder.newBuilder(9)
                        .addField(instrument.getCode())

        }*/

        return null;
    }


}
