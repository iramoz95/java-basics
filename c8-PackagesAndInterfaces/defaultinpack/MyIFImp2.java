package defaultinpack;

class MyIFImp2 implements MyIF {
    // Here, implements for both getUserId()
    // and getAdminId() are provided
    public int getUserID() {
        return 100;
    }

    public int getAdminID() {
        return 42;
    }
}