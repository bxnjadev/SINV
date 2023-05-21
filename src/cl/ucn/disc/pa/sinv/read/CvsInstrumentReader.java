package cl.ucn.disc.pa.sinv.read;

import cl.ucn.disc.pa.sinv.model.Instrument;
import cl.ucn.disc.pa.sinv.utils.InstrumentSerializerHelper;
import ucn.ArchivoEntrada;

import java.io.IOException;

/**
 * This class provide a way for read instrument using cvs files
 */

public class CvsInstrumentReader implements InstrumentReader {

    private final String fileName;
    private ArchivoEntrada fileManager;

    /**
     * The constructor
     * @param fileName the cvs name file
     * @throws IOException
     */

    public CvsInstrumentReader(String fileName) throws IOException {
        this.fileName = fileName;

        open();
    }

    /**
     * Open the read for the file
     * @throws IOException
     */

    private void open() throws IOException {
        fileManager = new ArchivoEntrada(fileName);
    }

    /**
     * Read the next element
     * @return the next element as Instrument
     * @throws IOException
     */

    @Override
    public Instrument next() throws IOException {
        //Use the InstrumentSerializerHelper for create a new instance based a "Registro"

        return InstrumentSerializerHelper.constructInstrument(
                fileManager.getRegistro()
        );
    }

    /**
     * Check if it has a new element
     * @return return true if it has a new element
     */

    @Override
    public boolean hasNext() {
        return !fileManager.isEndFile();
    }

    /**
     * Close the read the file
     * @throws Exception
     */

    @Override
    public void close() throws Exception {
        fileManager.close();
    }

}
