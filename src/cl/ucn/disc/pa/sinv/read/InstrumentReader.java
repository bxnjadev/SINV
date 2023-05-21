package cl.ucn.disc.pa.sinv.read;

import cl.ucn.disc.pa.sinv.model.Instrument;

import java.io.IOException;

/**
 * This class provide a form for read instrument
 */

public interface InstrumentReader extends AutoCloseable {

    /**
     * Read the next instrument
     * @return the next instrument
     * @throws IOException
     */

    Instrument next() throws IOException;

    /**
     * Check if has the next instrument
     * @return return true if has new Instrument
     */

    boolean hasNext();

}
