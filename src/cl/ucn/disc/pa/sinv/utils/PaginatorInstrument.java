package cl.ucn.disc.pa.sinv.utils;

import cl.ucn.disc.pa.sinv.model.Instrument;
import ucn.StdOut;

public class PaginatorInstrument {

    private final Instrument[] elements;
    private final int maxInPage;

    public PaginatorInstrument(Instrument[] elements, int maxInPage) {
        this.elements = elements;
        this.maxInPage = maxInPage;
    }

    public Instrument[] search(int page) {

        Instrument[] objects = new Instrument[0];
        int positionFirstElement = (page - 1) * maxInPage;

        for (int i = positionFirstElement; i < (positionFirstElement + maxInPage) - 1; i++) {

            if (i >= elements.length) {
                break;
            }

            objects = ArrayHelper.append(objects, elements[i]);
        }

        System.out.println(objects.length);
        return objects;
    }

}

