package cl.ucn.disc.pa.sinv.services;

import cl.ucn.disc.pa.sinv.model.Instrument;
import cl.ucn.disc.pa.sinv.model.Ticket;
import cl.ucn.disc.pa.sinv.read.InstrumentReader;
import cl.ucn.disc.pa.sinv.utils.ArrayHelper;

import java.io.IOException;

public class DefaultSystemSINV implements SystemSINV {

    private final InstrumentReader instrumentReader;
    private Instrument[] instruments = new Instrument[0];

    public DefaultSystemSINV(InstrumentReader instrumentReader) {
        this.instrumentReader = instrumentReader;
    }

    @Override
    public void fill(String fileName) throws IOException {

        while (instrumentReader.hasNext()) {
            instruments = ArrayHelper.append(
                    instruments, instrumentReader.next()
            );

        }

    }

    @Override
    public void save(String fileName) throws IOException {

    }

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

    @Override
    public int removeProductInStock(String code) {
        return 0;
    }

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

    @Override
    public Instrument[] getInstruments() {
        return instruments;
    }

}
