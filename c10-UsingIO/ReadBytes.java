
//Read an array of bytes from the keyboard
import java.io.*;

class ReadBytes {
    public static void main(String[] args) throws IOException {
        byte[] data = new byte[100];
        System.out.println("Enter some characters.");
        System.in.read(data);// Read an array of bytes from the keyuboard
        System.out.println("You entered: ");
        for (int i = 0; i < data.length; i++)
            System.out.print((char) data[i]);
    }
}