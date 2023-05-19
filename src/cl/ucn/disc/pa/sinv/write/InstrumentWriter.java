package cl.ucn.disc.pa.sinv.write;

import cl.ucn.disc.pa.sinv.model.Instrument;

public interface InstrumentWriter extends AutoCloseable {

    void save(Instrument instrument);

}
