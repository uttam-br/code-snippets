import decorators.FileStorage;

public class Main {

    public static void main(String[] args) {
        
        FileStorage fileStorage = new RawFileStorage();

        fileStorage.storeFile("File Name", null);
        fileStorage.getFile("File Name");

    }

}
