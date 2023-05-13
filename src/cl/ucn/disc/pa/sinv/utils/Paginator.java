package cl.ucn.disc.pa.sinv.utils;

public class Paginator<T> {

    private final T[] elements;
    private final int maxInPage;

    public Paginator(T[] elements, int maxInPage) {
        this.elements = elements;
        this.maxInPage = maxInPage;
    }

    public T[] search(int page) {

        Object[] objects = new Object[0];

        int positionFirstElement = page * maxInPage;

        if (!(elements.length >= positionFirstElement)) {
            return null;
        }

        for (int i = 0; i < (page + maxInPage); i++) {
            objects = ArrayHelper.append(objects, elements[i]);
        }

        return (T[]) objects;
    }

}

