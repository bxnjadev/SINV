package cl.ucn.disc.pa.sinv.read;

import cl.ucn.disc.pa.sinv.model.Instrument;

public interface InstrumentReader extends AutoCloseable {

    Instrument next();

    boolean hasNext();

}
