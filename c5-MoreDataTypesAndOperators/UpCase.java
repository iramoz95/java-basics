//Uppercase letters with bitwise operators
class UpCase {
    public static void main(String[] args){
        char ch;

        for(int i=0; i<26; i++){
            ch = (char) ('a' + i);
            System.out.print(ch);
            //This statement turns off the 6th bit.
            ch = (char) ((int) ch & 65503); // ch now is uppercase
            System.out.print(ch + " ");
        
        }
    }
}
