package cl.ucn.disc.pa.sinv.utils;

import cl.ucn.disc.pa.sinv.model.Instrument;

public class PaginatorInstrument {

    private final Instrument[] elements;
    private final int maxInPage;

    public PaginatorInstrument(Instrument[] elements, int maxInPage) {
        this.elements = elements;
        this.maxInPage = maxInPage;
    }

    public Instrument[] search(int page) {

        Instrument[] objects = new Instrument[0];
        int positionFirstElement = page * maxInPage;

        if (!(elements.length >= positionFirstElement)) {
            return null;
        }

        for (int i = 0; i < (page + maxInPage); i++) {
            objects = ArrayHelper.append(objects, elements[i]);
        }

        return objects;
    }

}

