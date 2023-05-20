package cl.ucn.disc.pa.sinv;

import cl.ucn.disc.pa.sinv.model.Instrument;
import cl.ucn.disc.pa.sinv.model.Ticket;
import cl.ucn.disc.pa.sinv.read.CvsInstrumentReader;
import cl.ucn.disc.pa.sinv.read.InstrumentReader;
import cl.ucn.disc.pa.sinv.services.DefaultSystemSINV;
import cl.ucn.disc.pa.sinv.services.SystemSINV;
import cl.ucn.disc.pa.sinv.utils.PaginatorInstrument;
import ucn.StdIn;
import ucn.StdOut;

import java.io.IOException;
import java.util.Locale;

public class Main {

    private static final String FILE_INSTRUMENT = "instruments.cvs";

    private static final String SEPARATOR = "<------------------------------->";
    private static final String PREFIX = "[BeatTheRhythm] > ";

    private static SystemSINV systemSINV = null;

    public static void main(String[] args) throws Exception {

        InstrumentReader instrumentReader = new CvsInstrumentReader(FILE_INSTRUMENT);

        systemSINV = new DefaultSystemSINV(
                instrumentReader
        );

        StdOut.println(PREFIX + " Bienvenido, ¿Qué deseas hacer?");

        while (true) {

            showOptions("Cargar instrumentos",
                    "Guardar instrumentos",
                    "Vender instrumento",
                    "Consultar instrumento",
                    "Salir");

            int option = StdIn.readInt();

            if (option == 1) {
                systemSINV.fill(FILE_INSTRUMENT);
                System.out.println("Has cargado el archivo");
            } else if (option == 2) {
                systemSINV.save(FILE_INSTRUMENT);
                System.out.println("Has guardado el archivo");
            } else if (option == 3) {
                showMenuSellInstrument();
                continue;
            } else if (option == 4) {
                showMenuQueryInstrument();
                break;

            } else if (option == 5) {
                StdOut.println("Has salido");
                break;
            }

            StdOut.println("Ingresa una opción valida");
        }

    }

    private static void showMenuSellInstrument() {

        StdOut.println(PREFIX + " Ingresa el código del instrumento que quieres vender: ");
        String code = StdIn.readString();

        StdOut.println(PREFIX + "Instrumento vendido " + code);
        Ticket ticket = systemSINV.sellInstrument(code);

        ticket.show();

    }

    private static void showMenuQueryInstrument() {

        StdOut.println("Ingrese el tipo de busqueda: ");

        showOptions("Mostrar todos",
                "Buscar por tipo",
                "Buscar por código",
                "Buscar por nombre (guitarra, saxofon... etc)");

        int option = StdIn.readInt();

        if (option == 1) {

            Instrument[] instruments = systemSINV.getInstruments();

            showMenuPagination(instruments);
        }

        if (option == 2) {

            String type = StdIn.readString();
            Instrument[] instruments = systemSINV.searchInstrumentByType(type);

            showMenuPagination(instruments);
        }

        if (option == 3) {

            String code = StdIn.readString();

            Instrument instrument =
                    systemSINV.searchInstrumentByCode(code);

            if (instrument == null) {
                StdOut.println("Lo siento, instrumento no encontrado");
                return;
            }

            instrument.show();
        }

        if (option == 4) {

            String name = StdIn.readString();

            Instrument[] instruments =
                    systemSINV.searchByName(name);

            showMenuPagination(instruments);
        }

    }

    private static void showOptions(String... options) {
        for (int i = 0; i < options.length; i++) {
            StdOut.println((i + 1) + ". " + options[i]);
        }
    }

    private static void showMenuPagination(Instrument[] instruments) {

        while (true) {

            StdOut.println("¿Quieres seguir buscando? (Si/No):");
            String reply = StdIn.readString();
            reply = reply.toLowerCase(Locale.ROOT);

            if (reply.equals("si")) {

                StdOut.println("Ingresa la página: ");
                int page = StdIn.readInt();
                showInstruments(instruments, page);

            } else {
                break;
            }

        }

    }

    private static void showInstruments(Instrument[] instruments, int page) {

        PaginatorInstrument paginatorInstrument = new PaginatorInstrument(instruments, 10);
        Instrument[] instrumentsSearched = paginatorInstrument.search(page);

        if (instrumentsSearched == null) {
            StdOut.println("En está pagina no hay items :(");
            return;
        }

        for (Instrument instrument : instrumentsSearched) {
            StdOut.println(SEPARATOR);
            instrument.show();
            StdOut.println(SEPARATOR);
        }

    }

}
