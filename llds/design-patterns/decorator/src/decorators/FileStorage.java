package decorators;

public interface FileStorage {
    
    void storeFile(String fileName, byte[] bytes);

    byte[] getFile(String fileName);

}
