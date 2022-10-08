public class Search {
    public static void main(String[] args){
        int[] nums = {6, 8, 3, 7, 5, 6, 1, 4};
        int val = 6;
        boolean found = false;

        //Use for-each style for to search nums of val
        int index = 0;
        for(int x : nums){
            if(x == val){
                found = true;
                break;
            }
            index++;
        }

        if(found)
            System.out.println("Value found! at position " + index);
    }
}
