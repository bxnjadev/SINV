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
            case "Persecusion" -> constructPersecussionInstrument(registro);
            case "Cuerda" -> constructStringInstrument(registro);
            default -> constructWindInstrument(registro);
        };

    }

    private static Instrument constructPersecussionInstrument(Registro registro) throws IOException {
        return new PercussionInstrument(registro.getString(), registro.getInt(), registro.getInt(), registro.getString(),
                registro.getString(), registro.getString(), registro.getString(), registro.getString());
    }

    private static Instrument constructWindInstrument(Registro registro) throws IOException {
        return new WindInstrument(registro.getString(), registro.getInt(), registro.getInt()
                , registro.getString(), registro.getString(), registro.getString());
    }

    private static Instrument constructStringInstrument(Registro registro) throws IOException {
        return new StringInstrument(registro.getString(), registro.getInt(), registro.getInt()
                , registro.getString(), registro.getString(), registro.getString(),
                registro.getString(), registro.getString(),
                registro.getInt());
    }

    public static Registro constructRegistro(Instrument instrument) {

    }

}
