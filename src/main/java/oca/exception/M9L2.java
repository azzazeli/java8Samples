package oca.exception;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketException;

public class M9L2 {
    public static void main(String[] args) {
        try {
            brokenOne(3);
        } catch (SocketException e) {
            System.out.println("Opps, that broke");
        }
        System.out.println("=============================");
        try {
            brokenTwo();
        } catch (IOException e) {
            System.out.println("Opps, that broke");
        }
    }


    public static void brokenOne(int mode) throws SocketException {
        System.out.println("Starting");
        try {
            System.out.println("In try");
            if (mode == 1) {
                System.out.println("Throwing EOFException");
                throw new EOFException();
            }
            System.out.println("Survived one");
            if (mode == 2) {
                System.out.println("Throwing FileNotFoundException");
                throw new FileNotFoundException();
            }
            System.out.println("Survived two");
            if (mode == 3) {
                System.out.println("Throwing SocketException");
                throw new SocketException();
            }

        } catch (EOFException e) {
            System.out.println("In catch for EOFException");
        } catch (FileNotFoundException e) {
            System.out.println("In catch for FileNotFoundException");
        } finally {
            System.out.println("In finally");
        }
        System.out.println("Method completing");
    }

    public static void brokenTwo() throws IOException {
        System.out.println("Starting");
        boolean success = false;
        int retriesLeft = 2;
        while (!success) {
            try {
                System.out.println("In try");
                if (Math.random() > 0.5) {
                    System.out.println("Throwing FileNotFoundException");
                    throw new FileNotFoundException();
                }
                success = true;
                System.out.println("Survived two");
            } catch (FileNotFoundException e) {
                System.out.println("In catch for FileNotFoundException");
                if (0 == retriesLeft--) {
                    System.out.println("Too many retires, giving up");
                    throw new IOException("Too many retries", e);
                }
            } finally {
                System.out.println("In finaly");
            }
        }
        System.out.println("Method completing");
    }
}
