package es.upm.grise.profundizacion.file;

public class InvalidContentException extends Exception {

    private static final long serialVersionUID = 1L;

    public InvalidContentException() {
        super("El contenido proporcionado es inválido (null).");
    }
}
