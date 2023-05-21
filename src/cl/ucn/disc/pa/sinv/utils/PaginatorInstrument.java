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

        //Create empty array

        Instrument[] objects = new Instrument[0];

        //Get the first position based in the page
        int positionFirstElement = (page - 1) * maxInPage;

        //Iterate about the elements in this page

        for (int i = positionFirstElement; i < (positionFirstElement + maxInPage); i++) {

            //If in this part no more elements make break at the for
            if (i >= elements.length) {
                break;
            }

            //Added element at the array
            objects = ArrayHelper.append(objects, elements[i]);
        }

        return objects;
    }

}

