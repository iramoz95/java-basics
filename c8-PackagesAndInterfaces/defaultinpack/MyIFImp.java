package defaultinpack;

//Implement MyIf
class MyIFImp implements MyIF {
    // Only getUserID() defined by MyIF needs to be implementd
    // getAdminID() can be allowed to default
    public int getUserID() {
        return 100;
    }
}