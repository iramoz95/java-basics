/*In Java, characters are not 8-bit quantities like they are in many other computer languages.
Instead, Java uses Unicode. In Java, char is an unsigned 16-bit type having a
range of 0 to 65,535 */
public class Characters {
    public static void main(String[] args){
        char ch;

        ch = 'X';
        System.out.println("ch contains " + ch);
        ch++;
        System.out.println("ch is now " + ch);
        ch = 90;
        System.out.println("ch is now " + ch);
    }
}
