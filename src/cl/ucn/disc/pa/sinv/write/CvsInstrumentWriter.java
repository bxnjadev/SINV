package cl.ucn.disc.pa.sinv.write;

import cl.ucn.disc.pa.sinv.model.Instrument;
import cl.ucn.disc.pa.sinv.utils.InstrumentSerializerHelper;
import ucn.ArchivoSalida;
import ucn.Registro;

import java.io.IOException;

public class CvsInstrumentWriter implements InstrumentWriter {

    private final ArchivoSalida fileManager;
    private final String fileName;

    public CvsInstrumentWriter(String fileName) throws IOException {
        this.fileName = fileName;
        fileManager = new ArchivoSalida(fileName);
    }

    @Override
    public void save(Instrument instrument) {
        Registro registro = InstrumentSerializerHelper.
                constructRegistro(instrument);

        fileManager.writeRegistro(registro);
    }

    @Override
    public void close() throws Exception {
        fileManager.close();
    }

}
