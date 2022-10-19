
/*
 * A version of CopyFile that uses try-with-resources.
 * It demonstrates two resources (in this case files) being
 * managed by a single try statement.
 */
import java.io.*;

class CopyFile2 {
    public static void main(String[] args) {
        int i;
        if (args.length != 2) {
            System.out.println("Usage: CopyFile from to");
            return;
        }
        try (FileInputStream fin = new FileInputStream(args[0]);
                FileOutputStream fout = new FileOutputStream(args[1])) {
            while ((i = fin.read()) != -1)
                fout.write(i);
        } catch (IOException exc) {
            System.out.println("I/O Error: " + exc);
        }
    }
}