package cl.ucn.disc.pa.sinv.read;

import cl.ucn.disc.pa.sinv.model.Instrument;

public class CvsInstrumentReader implements InstrumentReader {

    @Override
    public Instrument next() {
        return null;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public void close() throws Exception {

    }

}
