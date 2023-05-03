package cl.ucn.disc.pa.sinv.read;

import cl.ucn.disc.pa.sinv.model.Instrument;

import java.io.IOException;

public interface InstrumentReader extends AutoCloseable {

    Instrument next() throws IOException;

    boolean hasNext();

}
