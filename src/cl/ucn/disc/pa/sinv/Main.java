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

/**
 * Taller N°3 Programación Avanzada
 * Rut: 21.288.569-K - Roberto Díaz Araya
 * Rut: 21.544.970-K - Benjamín Miranda Ovalle
 */

public class Main {

    private static final String FILE_INSTRUMENT = "instruments.cvs";

    private static final String SEPARATOR = "<------------------------------->";
    private static final String PREFIX = "[BeatTheRhythm] > ";

    private static SystemSINV systemSINV = null;

    public static void main(String[] args) throws Exception {

        //Create a class InstrumentReader as implementation CvsInstrumentReader
        InstrumentReader instrumentReader = new CvsInstrumentReader(FILE_INSTRUMENT);

        //Create the class SystemSINV

        systemSINV = new DefaultSystemSINV(
                instrumentReader
        );

        StdOut.println(PREFIX + " Bienvenido, ¿Qué deseas hacer?");
        StdOut.println(PREFIX + " Primero antes de hacer cualquier cosa debe cargar los instrumentos");
        StdOut.println(PREFIX + " Sino podría obtener más de un error");

        //The main menu

        while (true) {

            //Show the main options

            showOptions("Cargar instrumentos",
                    "Guardar instrumentos",
                    "Vender instrumento",
                    "Consultar instrumento",
                    "Salir");

            //Wait a int
            int option = StdIn.readInt();

            if (option == 1) {

                //Load all instruments
                systemSINV.fill(FILE_INSTRUMENT);
                System.out.println("Has cargado el archivo");
            } else if (option == 2) {

                //Saves all instrument
                systemSINV.save(FILE_INSTRUMENT);
                System.out.println("Has guardado el archivo");
            } else if (option == 3) {
                showMenuSellInstrument();
            } else if (option == 4) {
                showMenuQueryInstrument();
            } else if (option == 5) {
                StdOut.println("Has salido");

                if (systemSINV.getInstruments().length != 0) {
                    systemSINV.save(FILE_INSTRUMENT);
                }

                break;
            } else {
                StdOut.println("Ingresa una opción valida");
            }

        }

    }

    /**
     * Open the menu for sale instruments
     */

    private static void showMenuSellInstrument() {

        //Wait a code and sell a instrument

        StdOut.println(PREFIX + " Ingresa el código del instrumento que quieres vender: ");
        String code = StdIn.readString();

        Ticket ticket = systemSINV.sellInstrument(code);

        //If the purchase is realized the system create a ticket and show it

        if (ticket != null) {
            StdOut.println(PREFIX + "Instrumento vendido " + code);
            ticket.show();
        }
    }

    /**
     * Open menu for make query in instrument
     */

    private static void showMenuQueryInstrument() {

        //Shot it the main options

        StdOut.println("Ingrese el tipo de busqueda: ");

        showOptions("Mostrar todos",
                "Buscar por tipo",
                "Buscar por código",
                "Buscar por nombre (guitarra, saxofon... etc)",
                "Ir para atras");

        //Wait a int for screen

        int option = StdIn.readInt();

        if (option == 1) {

            //Get all instrument and show it

            Instrument[] instruments = systemSINV.getInstruments();

            if (instruments == null || instruments.length == 0) {
                StdOut.println("No hay ningún instrumento de este tipo");
                return;
            }

            showMenuPagination(instruments);
        }

        if (option == 2) {

            //Search all instrument by type and show it

            String type = StdIn.readString();
            Instrument[] instruments = systemSINV.searchInstrumentByType(type);

            if (instruments == null || instruments.length == 0) {
                StdOut.println("No hay ningún instrumento de este tipo");
                return;
            }

            showMenuPagination(instruments);
        }

        if (option == 3) {

            //This method wait a String

            String code = StdIn.readString();

            //Search a instrument by code

            Instrument instrument =
                    systemSINV.searchInstrumentByCode(code);

            if (instrument == null) {
                //If the instrument is null is warned
                StdOut.println("Lo siento, instrumento no encontrado");
                return;
            }

            //show the instrument
            instrument.show();
        }

        if (option == 4) {

            StdOut.println("Ingrese el nombre por el quiere buscar: ");
            //This method wait a String
            String name = StdIn.readString();

            //Search a instruments by name

            Instrument[] instruments =
                    systemSINV.searchByName(name);

            if (instruments == null || instruments.length == 0) {
                StdOut.println("No hay ningún instrumento de este tipo");
                return;
            }

            //Show elements
            showMenuPagination(instruments);
        }

    }

    /**
     * Show the options menu
     *
     * @param options the array options
     */

    private static void showOptions(String... options) {
        //Show the options
        for (int i = 0; i < options.length; i++) {
            StdOut.println((i + 1) + ". " + options[i]);
        }
    }

    /**
     * Open pagination menu
     *
     * @param instruments the instrument array
     */

    private static void showMenuPagination(Instrument[] instruments) {

        while (true) {

            //First ask it if want search

            StdOut.println("¿Quieres seguir buscando? (Si/No):");

            //This method wait her reply

            String reply = StdIn.readString();

            //Reply now be in lower
            reply = reply.toLowerCase(Locale.ROOT);

            //Check the reply is equal to "si"

            if (reply.equals("si")) {

                //This method wait the page entered
                StdOut.println("Ingresa la página: ");
                int page = StdIn.readInt();

                //Show the instrument based an page
                showInstruments(instruments, page);

            } else {
                break;
            }

        }

    }

    /**
     * Show instruments based a page
     *
     * @param instruments the instrument array
     * @param page        the page, this can be major that 0
     */

    private static void showInstruments(Instrument[] instruments, int page) {

        //Check if page is minor that 0, if it is true throw exception

        if (page <= 0) {
            throw new IllegalArgumentException("The page should be major that 0");
        }

        //Create the pagination and search

        PaginatorInstrument paginatorInstrument = new PaginatorInstrument(instruments, 10);
        Instrument[] instrumentsSearched = paginatorInstrument.search(page);

        //Search if the instruments are null and warned if it true

        if (instrumentsSearched == null) {
            StdOut.println("En está pagina no hay items :(");
            return;
        }

        //Iterate about the instrument and call the show function

        for (Instrument instrument : instrumentsSearched) {
            StdOut.println(SEPARATOR);
            instrument.show();
            StdOut.println(SEPARATOR);
        }

    }

}
