public class Stack {

    private final Object[] MAS;
    private int size = 0;

    public Stack() {
        MAS = new Object[255];
    }

    public void push(Object element) {
        if (size < MAS.length) {
            MAS[size] = element;
            size++;
        }
    }
    public Object pop() {
        if(size>0) {
            size--;
            return MAS[size];
        }
        return null;
    }
    public int getSize() { return size; }
}