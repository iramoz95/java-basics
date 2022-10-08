//This class implements a "fail-soft" array which prevents runtime errors
class FailSoftArray{
    private int[] a;
    private int errval;
    public int length;

    public FailSoftArray(int size, int errv){
        a = new int[size];
        errval = errv;
        length = size;
    }

    public int get(int index){        
        if(indexOK(index)) return a[index];        
        return errval;
    }

    public boolean put(int index, int val){
        if(indexOK(index)){
            a[index] = val;
            return true;
        }
        return false;
    }

    private boolean indexOK(int index){
        return index >= 0 && index < length ? true : false;       
    }
}

//Demonstrate the fail-soft array array
class FSDemo{
    public static void main(String[] args){
        FailSoftArray fs = new FailSoftArray(5,-1);
        int x;

        //Show quite failures
        System.out.println("Fail quietly.");
        for(int i=0; i < (fs.length * 2); i++)
            fs.put(i, i*10);            
        
        for(int i=0; i < (fs.length * 2); i++){
            x = fs.get(i);
            if(x != -1)  System.out.print(x + " ");
        }
        System.out.println();

        //now handle failures
        System.out.println("\nFail with error reports.");
        for(int i=0; i < (fs.length * 2); i++)
            if(!fs.put(i, i*10))
                System.out.println("Index " + i + " out-of-bounds");
        
        for(int i=0; i < (fs.length * 2); i++){
            x = fs.get(i);
            if(x != -1) System.out.print(x + " ");
            else System.out.println("Index " + i + " out-of-bounds");
        }

        System.out.println("\nFinal array:");
        for(int i=0; i<fs.length * 5; i++)
            System.out.print(fs.get(i) + " ");
    }
}
