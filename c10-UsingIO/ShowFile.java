
/*
 * Display a text file.
 * To use this program, specify the name
 * of the file that you want to see.
 * For example, to see a file called input.txt,
 * use the following command line.
 * java ShowFile input.txt
 */
import java.io.*;

class ShowFile {
    public static void main(String[] args) {
        int i;
        FileInputStream fin = null;

        if (args.length != 1) {
            System.out.println("Usage: ShowFile File");
            return;
        }

        try {
            fin = new FileInputStream(args[0]);
            while ((i = fin.read()) != -1) // When equals -1, the end of the file has been reached
                System.out.print((char) i);
        } catch (IOException exc) {
            System.out.println("I/O Error: " + exc);
        } finally {
            try {
                if (fin != null)
                    fin.close();
            } catch (IOException exc) {
                System.out.println("Error closing file");
            }
        }
    }
}