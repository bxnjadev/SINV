package cl.ucn.disc.pa.sinv.write;

import cl.ucn.disc.pa.sinv.model.Instrument;
import cl.ucn.disc.pa.sinv.utils.InstrumentSerializerHelper;
import ucn.ArchivoSalida;
import ucn.Out;
import ucn.Registro;

import java.io.IOException;

public class CvsInstrumentWriter implements InstrumentWriter {

    private final Out out;
    private final String fileName;

    public CvsInstrumentWriter(String fileName) throws IOException {
        this.fileName = fileName;
        out = new Out(fileName);
    }

    @Override
    public void save(Instrument instrument) {
        out.println(instrument.toString());
    }

    @Override
    public void close() throws Exception {
        out.close();
    }

}
