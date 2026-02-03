package es.upm.grise.profundizacion.file;

public class WrongFileTypeException extends Exception {

    private static final long serialVersionUID = 1L;

    public WrongFileTypeException() {
        super("Operación no permitida para el tipo de archivo IMAGE.");
    }
}
