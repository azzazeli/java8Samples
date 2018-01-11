package oca.exception.retries;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        try {
            broken();
        } catch (AskForNewFilenameException e) {
            System.out.println("Called method failed completely, caught an " + e.getClass().getName());
        }
    }

    public static void broken() throws AskForNewFilenameException {
        System.out.println("Starting");
        boolean success = false;
        int retriesLeft = 2;
        while (!success) {
            try{
                System.out.println("In try");
                if (Math.random() > 0.5) {
                    System.out.println("Failed attempt: Throwing FileNotFoundException");
                    throw new FileNotFoundException();
                }
                success = true;
                System.out.println("Succeeded!");
            } catch (FileNotFoundException e) {
                System.out.println("In catch for FileNotFoundException");
                if (0 == retriesLeft--) {
                    System.out.println("Too many retries, giving up");
                    throw new AskForNewFilenameException();
                }
            }
            finally {
                System.out.println("In finally");
            }
        }
        System.out.println("Method completing normally");
    }

}
