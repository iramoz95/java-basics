
/*
 * Copy a text file.
 * To use this program, specify the name
 * of the source file and the destination file.
 * For example, to copy a file called input.txt
 * to a file called OUTput.txt, use the following
 * command line.
 * java CopyFile input.txt output.txt
 */
import java.io.*;

class CopyFile {
    public static void main(String[] args) throws IOException {
        int i;
        FileInputStream fin = null;
        FileOutputStream fout = null;

        if (args.length != 2) {
            System.out.println("Usage: CopyFile from to");
            return;
        }

        // Copy a file
        try {
            // Attempt to open the files
            fin = new FileInputStream(args[0]);
            fout = new FileOutputStream(args[1]);
            // Read bytes from one file and write them to another
            while ((i = fin.read()) != -1)
                fout.write(i);
        } catch (IOException exc) {
            System.out.println("I/O Error: " + exc);
            ;
        } finally {
            try {
                if (fin != null)
                    fin.close();

            } catch (IOException exc) {
                System.out.println("Error closing input file");
            }
            try {
                if (fout != null)
                    fout.close();
            } catch (IOException exc) {
                System.out.println("Error Closing Outpur File");
            }
        }
    }
}