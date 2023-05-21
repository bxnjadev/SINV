package cl.ucn.disc.pa.sinv.utils;

import cl.ucn.disc.pa.sinv.model.Instrument;
import cl.ucn.disc.pa.sinv.model.PercussionInstrument;
import cl.ucn.disc.pa.sinv.model.StringInstrument;
import cl.ucn.disc.pa.sinv.model.WindInstrument;
import ucn.ArchivoEntrada;
import ucn.Registro;

import java.io.IOException;

public class InstrumentSerializerHelper {

    /**
     * Create a instrument based in the parameters of the class Registro
     * @param registro the registro read
     * @return a new instrument
     * @throws IOException
     */

    public static Instrument constructInstrument(Registro registro) throws IOException {
        String type = registro.getString();

        return switch (type) {
            case "Percusión" -> constructPersecussionInstrument(type, registro);
            case "Cuerda" -> constructStringInstrument(type, registro);
            default -> constructWindInstrument(type, registro);
        };

    }

    /**
     * Create a instrument of type Persecussion
     * @param type the type instrument
     * @param registro the registro read
     * @return a new instrument of type Persecussion
     * @throws IOException
     */

    private static Instrument constructPersecussionInstrument(String  type, Registro registro) throws IOException {
        return new PercussionInstrument(registro.getString(), registro.getInt(), registro.getInt(), type,
                registro.getString(), registro.getString(), registro.getString(), registro.getString());
    }

    /**
     * Create a instrument of type Wind
     * @param type the type instrument
     * @param registro the registro read
     * @return a new instrument of type Wind
     * @throws IOException
     */

    private static Instrument constructWindInstrument(String type, Registro registro) throws IOException {
        return new WindInstrument(registro.getString(), registro.getInt(), registro.getInt()
                ,type, registro.getString(), registro.getString());
    }

    /**
     * Create a instrument of type String
     * @param type the type instrument
     * @param registro the registro read
     * @return a new instrument of type String
     * @throws IOException
     */

    private static Instrument constructStringInstrument(String type, Registro registro) throws IOException {
        return new StringInstrument(registro.getString(), registro.getInt(), registro.getInt()
                , type, registro.getString(), registro.getString(),
                registro.getString(), registro.getInt(),
                registro.getString());
    }

}
