package cl.ucn.disc.pa.sinv;

import cl.ucn.disc.pa.sinv.model.Instrument;
import cl.ucn.disc.pa.sinv.utils.PaginatorInstrument;
import ucn.StdIn;
import ucn.StdOut;

public class Main {

    private static final String SEPARATOR = "<------------------------------->";
    private static final String PREFIX = "[BeatTheRhythm] > ";

    public static void main(String[] args) {
        StdOut.print(PREFIX + " Bienvenido, ¿Qué deseas hacer?");

        showOptions("Agregar instrumento",
                "Vender instrumento",
                "Consultar instrumento",
                "Salir");

        int opcion = StdIn.readInt();
        while (true) {

            if (opcion == 1) {
                continue;
            }

            if (opcion == 2) {
                continue;
            }

            StdOut.println(PREFIX + " Ingresa una opción valida");
        }

    }

    private static void showMenuSellInstrument() {



    }

    private static void showMenuQueryInstrument() {

    }

    private static void showOptions(String... options) {
        for (int i = 0; i < options.length; i++) {
            StdOut.println(i + ". " + options[i]);
        }
    }

    private static void showInstruments(Instrument[] instruments, int page) {

        PaginatorInstrument paginatorInstrument = new PaginatorInstrument(instruments, 10);

        for (Instrument instrument : instruments) {
            StdOut.println(SEPARATOR);
            instrument.show();
            StdOut.println(SEPARATOR);
        }

    }

}
