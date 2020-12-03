import java.util.HashMap;

public class SystemCore {
    private final int Count_sysCalls = 5;
    private HashMap<Integer, SystemCall> Calls = new HashMap<>();
    private Stack stack;

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

    public void perform_Calls(int ID) {
        if (!Calls.containsKey(ID)) {
            System.out.println("No system call with this (ID:"+ID+")");
            return;
        }
        Object[] data = new Object[Calls.get(ID).getdata().length];
        for (int i = 0; i < data.length; i++) {
            data[i] = stack.pop();
            if (data[i] == null) {
                System.out.println("little arguments passed in the call (ID:"+ID+")");
                return;
            }
        }
        SystemCall Call = new SystemCall(ID, data);
        for (int i = 0; i < Calls.get(Call.getid()).getdata().length; i++) {
            if (Call.getdata()[i].getClass() != Calls.get(Call.getid()).getdata()[i].getClass()) {
                System.out.println("System call by (ID:"+ID+") the wrong arguments were passed");
                return;
            }
        }
        System.out.println("system call is called by (ID:"+Call.getid()+")");
    }
}
