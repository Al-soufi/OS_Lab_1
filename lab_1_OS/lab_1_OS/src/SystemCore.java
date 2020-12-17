import java.util.HashMap;

public class SystemCore {
    private final int Count_sysCalls = 5;
    private HashMap<Integer, SystemCall> Calls = new HashMap<>();
    private Stack stack;
    private SystemCall call;

    public SystemCore(Stack stack) {
        Calls.put(0, new SystemCall(0, new Object[]{1, 2, 3}));
        Calls.put(1, new SystemCall(1, new Object[]{5, "", 1.2}));
        Calls.put(2, new SystemCall(2, new Object[]{"res", "str"}));
        Calls.put(3, new SystemCall(3, new Object[]{"", "", ""}));
        Calls.put(4, new SystemCall(4, new Object[]{'R', 1, 1.2}));
        this.stack = stack;
    }

    public void print_Calls() {
        for (int i = 0; i < Count_sysCalls; i++) {
            String res = "";
            res = "ID:" + i + "  : ";
            System.out.print(res);

            for (int j = 0; j < Calls.get(i).getdata().length; j++) {
                res = Calls.get(i).getdata()[j] + " , ";
                System.out.print(res);
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public void perform_Calls(int Id) {
        try { call = Calls.get(Id); }

        catch (Exception e) { System.out.println("Error :there isn't no system call with this id"); }

        if(stack.getSize()==0){
            System.out.println("The stack is empty");
            return ;
        }
        if (!Calls.containsKey(Id)) {
            System.out.println("No system call with this (ID:"+Id+")");
            return;
        }
        int stackSize = stack.getSize();
        Object[] data = new Object[stackSize];
        for (int i = 0; i < stackSize; i++) {
            data[i] = stack.pop();
        }

        if (data.length != call.getdata().length) {
            System.out.println("little arguments passed in the call (ID:"+Id+")");
            return;
        }
        
        for (int i = 0; i < data.length; i++) {
            if (data[i].getClass() != call.getdata()[i].getClass()) {
                System.out.println("System call by (ID:"+Id+") the wrong arguments were passed");
                return;
            }
        }
        System.out.println("System call is called by (ID:"+Id+")");
    }
}