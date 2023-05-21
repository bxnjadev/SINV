package cl.ucn.disc.pa.sinv.write;

import cl.ucn.disc.pa.sinv.model.Instrument;

/**
 * This class provide a form for write the instrument
 */

public interface InstrumentWriter extends AutoCloseable {

    /**
     * Save a instrument
     * @param instrument the instrument
     */

    void save(Instrument instrument);

}
