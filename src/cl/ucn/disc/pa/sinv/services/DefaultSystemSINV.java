package cl.ucn.disc.pa.sinv.services;

import cl.ucn.disc.pa.sinv.model.Instrument;
import cl.ucn.disc.pa.sinv.model.Ticket;
import cl.ucn.disc.pa.sinv.read.InstrumentReader;
import cl.ucn.disc.pa.sinv.utils.ArrayHelper;
import cl.ucn.disc.pa.sinv.utils.InstrumentSerializerHelper;
import cl.ucn.disc.pa.sinv.write.CvsInstrumentWriter;
import cl.ucn.disc.pa.sinv.write.InstrumentWriter;
import ucn.ArchivoSalida;
import ucn.StdOut;

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

        //Load the instruments using instrum read
        //This while be will executed until finish the read

        while (instrumentReader.hasNext()) {
            //The instruments are added at the array
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

        //Create a new instance InstrumentWriter
        InstrumentWriter instrumentWriter = new CvsInstrumentWriter(fileName);

        //Iterate about all instruments and save it using InstrumentWriter
        for (Instrument instrument : instruments) {
            instrumentWriter.save(instrument);
        }

        //Close the file
        instrumentWriter.close();

    }

    /**
     * This method sell instrument
     * @param code the instrument code
     * @return the Ticket generate in the buy
     */

    @Override
    public Ticket sellInstrument(String code) {
        //Search the instrument by her su code
        Instrument instrumentSearched = searchInstrumentByCode(code);

        //Check if the instrument is null and this case throw a new exception

        if (instrumentSearched == null) {
            StdOut.println("El instrumento no está registrado.");
            return null;
        }

        //Check if the instrument has stock and this case throw a new exception

        if (!instrumentSearched.hasStock()) {
            StdOut.println("El instrumento no tiene stock.");
            return null;
        }

        //Remove stock the instrument

        instrumentSearched.removeStock();

        //Generate a new ticket

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

        //Iterate about all instrument and check if the code is the same in this case return it
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

        //Create the new array elements

        Instrument[] instrumentsSearched = new Instrument[0];

        //Iterate about all instrument and check if the type is the same in this
        // case add it in this new array

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

        //Create the new array elements
        Instrument[] instrumentsSearched = new Instrument[0];

        //Iterate about all instrument and check if the name is the same in this
        // case add it in this new array

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
