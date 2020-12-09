public class SystemCall {
    private int ID;
    private Object [] Data;

    SystemCall(int id, Object[] data) {
        Data= data;
        ID= id;
    }
    public Object[] getdata() { return Data; }

    public int getid() { return ID; }
}
