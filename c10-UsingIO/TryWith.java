/*
 * This version of the ShowFile program uses a try-with-resources
 * statement to automatically close a file when it is no longer needed.
 */

import java.io.*;

class TryWith {
    public static void main(String[] args) {
        int i;

        if (args.length != 1) {
            System.out.println("Usage: ShowFile filename");
            return;
        }
        try (FileInputStream fin = new FileInputStream(args[0])) {
            while ((i = fin.read()) != -1) // When equals -1, the end of the file has been reached
                System.out.print((char) i);
        } catch (IOException exc) {
            System.out.println("I/O Error: " + exc);
        }

    }
}