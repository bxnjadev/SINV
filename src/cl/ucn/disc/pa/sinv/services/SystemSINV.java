package cl.ucn.disc.pa.sinv.services;

import cl.ucn.disc.pa.sinv.model.Instrument;
import cl.ucn.disc.pa.sinv.model.Ticket;

import java.io.IOException;

/**
 * This interface provided the main system of SINV
 */

public interface SystemSINV {

    /**
     * This method fill products in document
     *
     * @param fileName name file
     */

    void fill(String fileName) throws IOException;

    /**
     * Save the data in a fileName
     * @param fileName the fileName
     */

    void save(String fileName) throws  IOException;

    /**
     * Sell a instrument
     *
     * @param code the instrument code
     * @return the sell ticket
     */

    Ticket sellInstrument(String code);

    /**
     * Remove a product in stock
     *
     * @param code the product code
     * @return -1 has no stock, 1 if were deleted
     */

    int removeProductInStock(String code);

    /**
     * Search instrument by code
     *
     * @param code the instrument code
     * @return the instrument, return it if the instrument is null
     */

    Instrument searchInstrumentByCode(String code);

    /**
     * Search instruments by her type
     * @param type the instrument type
     * @return instrument array
     */


    Instrument[] searchInstrumentByType(String  type);

    /**
     * Search by name
     * @param name t
     * @return
     */

    Instrument[] searchByName(String name);

    /**
     * Get all instruments
     * @return get all instruments in the system
     */

    Instrument[] getInstruments();

}
