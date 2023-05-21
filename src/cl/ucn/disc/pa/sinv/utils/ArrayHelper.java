package cl.ucn.disc.pa.sinv.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayHelper {

    /**
     * Simple method for add a element a array
     * @param theStaticArray the static array
     * @param theObject the object for added
     * @param <T> the generic element
     * @return the array updated
     */

    public static <T> T[] append(T[] theStaticArray, T theObject) {
        // new arraylist
        List<T> theList = new ArrayList<>();
        // copy all the items from [] to the list
        Collections.addAll(theList, theStaticArray);
        // add the object
        theList.add(theObject);
        // return the static array
        return theList.toArray(theStaticArray);
    }

}
