package cl.ucn.disc.pa.sinv.read;

import cl.ucn.disc.pa.sinv.model.Instrument;
import ucn.ArchivoEntrada;

import java.io.IOException;

public class CvsInstrumentReader implements InstrumentReader {

    private final String fileName;
    private ArchivoEntrada fileManager;

    public CvsInstrumentReader(String fileName) throws IOException {
        this.fileName = fileName;

        open();
    }

    private void open() throws IOException {
        fileManager = new ArchivoEntrada(fileName);
    }

    @Override
    public Instrument next() throws IOException {
        return InstrumentSerializerHelper.constructInstrument(
                fileManager.getRegistro()
        );
    }

    @Override
    public boolean hasNext() {
        return fileManager.isEndFile();
    }

    @Override
    public void close() throws Exception {
        fileManager.close();
    }

}
