package defaultinpack;

//Use the default method
class DefaultMethodDemo {
    public static void main(String[] args) {
        MyIFImp obj = new MyIFImp();
        MyIFImp2 obj2 = new MyIFImp2();
        // Can call getUserID(), because it is explicitly
        // implemented by MyIFImp
        System.out.println("User ID is " + obj.getUserID());

        // Can also call getAdminID() because of default implementation
        System.out.println("Administrator ID is " + obj.getAdminID());

        // Can also be overridden 0for a class method
        System.out.println("Administrator ID overridden is " + obj2.getAdminID());

        // Calling interface static method
        System.out.println("Interface static method call : " + MyIF.getUniversalID());
    }
}