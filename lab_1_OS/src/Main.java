public class Main {
    public static void main(String[] args) {
         Stack stack = new Stack();
         SystemCore Core = new SystemCore(stack);
        Core.print_Calls();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        Core.perform_Calls(0);

        stack.push(1.2);
        stack.push(5);
        stack.push("");
        Core.perform_Calls(1);

        stack.push("int");
        stack.push("string");
        Core.perform_Calls(2);

        stack.push(3);
        stack.push(5);
        Core.perform_Calls(3);

        stack.push('R');
        stack.push(1);
        stack.push(1.2);
        Core.perform_Calls(4);

        stack.push(5);
        Core.perform_Calls(5);

        stack.push("string");
        Core.perform_Calls(6);
    }
}