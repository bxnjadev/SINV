package cl.ucn.disc.pa.sinv.utils;

import cl.ucn.disc.pa.sinv.model.Instrument;
import ucn.StdOut;

/**
 * This class generate a paginator with Instrument elements
 */

public class PaginatorInstrument {

    private final Instrument[] elements;
    private final int maxInPage;

    /**
     * The main constructor for create a PaginatorInstrument
     * @param elements the array elements
     * @param maxInPage the max elements per page
     */

    public PaginatorInstrument(Instrument[] elements, int maxInPage) {
        this.elements = elements;
        this.maxInPage = maxInPage;
    }

    /**
     * Generate array with the instrument in those page
     * @param page
     * @return
     */

    public Instrument[] search(int page) {

        Instrument[] objects = new Instrument[0];
        int positionFirstElement = (page - 1) * maxInPage;

        for (int i = positionFirstElement; i < (positionFirstElement + maxInPage); i++) {

            if (i >= elements.length) {
                break;
            }

            objects = ArrayHelper.append(objects, elements[i]);
        }

        System.out.println(objects.length);
        return objects;
    }

}

