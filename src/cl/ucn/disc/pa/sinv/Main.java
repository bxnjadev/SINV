package cl.ucn.disc.pa.sinv;

import cl.ucn.disc.pa.sinv.model.Instrument;
import cl.ucn.disc.pa.sinv.model.Ticket;
import cl.ucn.disc.pa.sinv.services.SystemSINV;
import cl.ucn.disc.pa.sinv.utils.PaginatorInstrument;
import ucn.StdIn;
import ucn.StdOut;

import java.util.Locale;

public class Main {

    private static final String SEPARATOR = "<------------------------------->";
    private static final String PREFIX = "[BeatTheRhythm] > ";

    private static final SystemSINV systemSINV = null;

    public static void main(String[] args) {
        StdOut.print(PREFIX + " Bienvenido, ¿Qué deseas hacer?");

        showOptions("Agregar instrumento",
                "Vender instrumento",
                "Consultar instrumento",
                "Salir");

        int option = StdIn.readInt();
        while (true) {

            if (option == 1) {
                showMenuSellInstrument();
                break;
            }

            if (option == 2) {
                showMenuQueryInstrument();
                break;
            }

            StdOut.println(PREFIX + " Ingresa una opción valida");
        }

    }

    private static void showMenuSellInstrument() {

        StdOut.println(PREFIX + " Ingresa el código del instrumento que quieres vender: ");
        String code = StdIn.readString();

        Ticket ticket = systemSINV.sellInstrument(code);

        ticket.show();
    }

    private static void showMenuQueryInstrument() {

        StdOut.println("Ingrese el tipo de busqueda: ");
        showOptions("Buscar por tipo", "Buscar por código");

        int option = StdIn.readInt();

        if (option == 1) {

            String type = StdIn.readString();
            Instrument[] instruments = systemSINV.searchInstrumentByType(type);

            showMenuPagination(instruments);
        }

        if (option == 2) {

            String code = StdIn.readString();

            Instrument instrument =
                    systemSINV.searchInstrumentByCode(code);

            instrument.show();
        }

    }

    private static void showOptions(String... options) {
        for (int i = 0; i < options.length; i++) {
            StdOut.println(i + ". " + options[i]);
        }
    }

    private static void showMenuPagination(Instrument[] instruments) {

        while (true) {

            StdOut.println("¿Quieres seguir buscando? (Si/No):");
            String reply = StdIn.readString();
            reply = reply.toLowerCase(Locale.ROOT);

            if (reply.equals("si")) {

                int page = StdIn.readInt();
                showInstruments(instruments, page);

            }  else {
                break;
            }

        }

    }

    private static void showInstruments(Instrument[] instruments, int page) {

        PaginatorInstrument paginatorInstrument = new PaginatorInstrument(instruments, 10);
        Instrument[] instrumentsSearched = paginatorInstrument.search(page);

        for (Instrument instrument : instrumentsSearched) {
            StdOut.println(SEPARATOR);
            instrument.show();
            StdOut.println(SEPARATOR);
        }

    }

}
