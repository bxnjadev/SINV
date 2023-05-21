package cl.ucn.disc.pa.sinv.write;

import cl.ucn.disc.pa.sinv.model.Instrument;
import cl.ucn.disc.pa.sinv.utils.InstrumentSerializerHelper;
import ucn.ArchivoSalida;
import ucn.Out;
import ucn.Registro;

import java.io.IOException;

/**
 * This class represent a way for write Instrument, using cvs files
 */

public class CvsInstrumentWriter implements InstrumentWriter {

    private final Out out;
    private final String fileName;

    /**
     * The constructor
     * @param fileName the file name csv file
     * @throws IOException
     */

    public CvsInstrumentWriter(String fileName) throws IOException {
        this.fileName = fileName;
        out = new Out(fileName);
    }

    /**
     * Save a element
     * @param instrument the instrument
     */

    @Override
    public void save(Instrument instrument) {
        out.println(instrument.toString());
    }

    /**
     * Close the writer
     * @throws Exception
     */

    @Override
    public void close() throws Exception {
        out.close();
    }

}
