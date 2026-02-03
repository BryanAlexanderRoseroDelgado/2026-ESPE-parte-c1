package es.upm.grise.profundizacion.file;

import java.util.ArrayList;
import java.util.List;

public class File {

    private FileType type;
    private List<Character> content;
	private FileUtils fileUtils = new FileUtils();

    /*
     * Constructor
     */
    public File() {
        // content debe estar vacío pero no ser null
        this.content = new ArrayList<>();
    }

    /*
     * Method to code / test
     */
    public void addProperty(char[] newcontent)
            throws InvalidContentException, WrongFileTypeException {

        if (newcontent == null) {
            throw new InvalidContentException();
        }

        if (this.type == FileType.IMAGE) {
            throw new WrongFileTypeException();
        }

        for (char c : newcontent) {
            content.add(c);
        }
    }

    /*
     * Method to code / test
     */
    public long getCRC32() {

        if (content.isEmpty()) {
            return 0L;
        }

        byte[] bytes = new byte[content.size()];

        for (int i = 0; i < content.size(); i++) {
            // Se usa solo el byte menos significativo
            bytes[i] = (byte) (char) content.get(i);
        }

        return fileUtils.calculateCRC32(bytes);
    }

    /*
     * Setters/getters
     */
    public void setType(FileType type) {
        this.type = type;
    }

    public List<Character> getContent() {
        return content;
    }
}
