package cl.ucn.disc.pa.sinv.services;

import cl.ucn.disc.pa.sinv.model.Instrument;
import cl.ucn.disc.pa.sinv.model.Ticket;
import cl.ucn.disc.pa.sinv.read.InstrumentReader;
import cl.ucn.disc.pa.sinv.utils.ArrayHelper;
import cl.ucn.disc.pa.sinv.utils.InstrumentSerializerHelper;
import cl.ucn.disc.pa.sinv.write.CvsInstrumentWriter;
import cl.ucn.disc.pa.sinv.write.InstrumentWriter;
import ucn.ArchivoSalida;

import java.io.IOException;

/**
 * This is main implementation the interface
 */

public class DefaultSystemSINV implements SystemSINV {

    private final InstrumentReader instrumentReader;
    private Instrument[] instruments = new Instrument[0];

    /**
     * The constructor
     * @param instrumentReader the way form the read instrument
     */

    public DefaultSystemSINV(InstrumentReader instrumentReader) {
        this.instrumentReader = instrumentReader;
    }

    /**
     * This method load the instrument based a file
     * @param fileName name file
     * @throws IOException
     */

    @Override
    public void fill(String fileName) throws IOException {

        while (instrumentReader.hasNext()) {
            instruments = ArrayHelper.append(
                    instruments, instrumentReader.next()
            );

        }

    }

    /**
     * This method save the instrument based a file
     * @param fileName the fileName
     * @throws Exception
     */

    @Override
    public void save(String fileName) throws Exception {

        InstrumentWriter instrumentWriter = new CvsInstrumentWriter(fileName);

        for (Instrument instrument : instruments) {
            instrumentWriter.save(instrument);
        }

        instrumentWriter.close();

    }

    /**
     * This method sell a instrument
     * @param code the instrument code
     * @return the Ticket generate in the buy
     */

    @Override
    public Ticket sellInstrument(String code) {
        Instrument instrumentSearched = searchInstrumentByCode(code);

        if (instrumentSearched == null) {
            throw new IllegalArgumentException("The instrument is not registered!");
        }

        if (!instrumentSearched.hasStock()) {
            throw new IllegalArgumentException("The instrument have not stock");
        }

        instrumentSearched.removeStock();

        return new Ticket(
                instrumentSearched.getName(),
                instrumentSearched.getPrice()
        );
    }

    /**
     * Search a instrument by code
     * @param code the instrument code
     * @return the instrument searched
     */

    @Override
    public Instrument searchInstrumentByCode(String code) {
        Instrument instrumentSearched = null;

        for (Instrument instrument : instruments) {

            if (instrument.getCode().equals(code)) {
                return instrument;
            }

        }
        return instrumentSearched;
    }

    /**
     * Search a instrument by her type
     * @param type the instrument type
     * @return the instrument searched
     */

    @Override
    public Instrument[] searchInstrumentByType(String type) {

        Instrument[] instrumentsSearched = new Instrument[0];

        for (Instrument instrument : instruments) {
            if (instrument.getType().equals(type)) {
                instrumentsSearched = ArrayHelper.append(
                        instrumentsSearched, instrument
                );
            }
        }

        return instrumentsSearched;
    }

    /**
     * Search a instrument by her name
     * @param name t
     * @return
     */

    @Override
    public Instrument[] searchByName(String name) {
        Instrument[] instrumentsSearched = new Instrument[0];

        for (Instrument instrument : instruments) {
            if (instrument.getName().equals(name)) {
                instrumentsSearched = ArrayHelper.append(
                        instrumentsSearched, instrument
                );
            }
        }

        return instrumentsSearched;
    }

    /**
     * Get all instruments
     * @return all instruments
     */

    @Override
    public Instrument[] getInstruments() {
        return instruments;
    }

}
