package es.upm.grise.profundizacion.file;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class FileTest {

    /*
     * Verifica que la clase File puede instanciarse correctamente
     */
    @Test
    public void Instalacion() {
        File file = new File();
        assertNotNull(file);
        assertNotNull(file.getContent());
        assertTrue(file.getContent().isEmpty());
    }

    /*
     * Test: añadir propiedad válida a un archivo PROPERTY
     */
    @Test
    public void añadirContenidoValido() throws Exception {
        File file = new File();
        file.setType(FileType.PROPERTY);

        char[] content = { 'A', '=', '1' };
        file.addProperty(content);

        assertEquals(3, file.getContent().size());
        assertEquals('A', file.getContent().get(0));
        assertEquals('=', file.getContent().get(1));
        assertEquals('1', file.getContent().get(2));
    }

    /*
     * Test: añadir contenido null debe lanzar InvalidContentException
     */
    @Test
    public void addPropertyNullContent() {
        File file = new File();
        file.setType(FileType.PROPERTY);

        assertThrows(
            InvalidContentException.class,
            () -> file.addProperty(null)
        );
    }

    /*
     * Test: añadir propiedad a un archivo IMAGE debe lanzar WrongFileTypeException
     */
    @Test
    public void addPropertyWrongFileType() {
        File file = new File();
        file.setType(FileType.IMAGE);

        char[] content = { 'A', '=', '1' };

        assertThrows(
            WrongFileTypeException.class,
            () -> file.addProperty(content)
        );
    }

    /*
     * Test: CRC32 de un archivo vacío debe ser 0
     */
    @Test
    public void getCRC32EmptyContent() {
        File file = new File();
        assertEquals(0L, file.getCRC32());
    }

    /*
     * Test: CRC32 con contenido no vacío
     */
    @Test
    public void getCRC32WithContent() throws Exception {
        File file = new File();
        file.setType(FileType.PROPERTY);

        char[] content = { 'A', '=', '1' };
        file.addProperty(content);

        long crc = file.getCRC32();
        assertNotEquals(0L, crc);
    }
}
