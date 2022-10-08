public class ForEach {
    public static void main (String[] args){
        int[] nums = new int[1000];
        int sum = 0;

        for(int i = 1; i <= 1000; i++)
            nums[i-1] = i;
        for(int x : nums){
            sum += x;
            if(x == 100) break;
        }
        System.out.println("\nSummation: " + sum);
    }
}
