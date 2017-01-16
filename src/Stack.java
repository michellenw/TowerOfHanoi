
public class Stack {

    //instance variables
    private int[] stack = new int[10];
    private int count = 0;
    private int size;

    //fills stack with -1 which represents an empty space
    public Stack(int size) {
        this.size = size;
        for (int i = 0; i < size; i++) {
            stack[i] = -1;
        }
    }

    //takes off the top integer in a stack
    public int pop() {
        int i = stack[count-1];
        stack[count-1] = -1;
        count--;
        return i;
    }

    //takes the integer that was popped and "pushes"/puts it on a new stack
    //integer will be the integer being added to the array
    public void push(int integer) {
        //so initial pushing doesn't affect count
        stack[count] = integer;
        count++;
    }

    //peeks stack (looks at top element but does not remove it)
    public int peek() {
        //if there are no elements in a stack, return 99 (bc no value will be higher than this in this case)
        //which would allow ANY size integer to be placed in the stack returning this
        if (count == 0) {
            return 99;
        }
        //otherwise return the value of the top integer to see if a certain integer may be placed on top
        else {
            int i = stack[count-1];
            return i;
        }
    }
    //checks if a certain "stack" is empty or not
    public boolean isEmpty() {
        if (count == 0) {
            return true;
        }
        else return false;
    }

    //prints stack in stack order :D
    public void printStack() {
        System.out.println("==========");
        for (int n = size-1; n >= 0; n--) {
            if (stack[n] == -1) {
                System.out.println("\t_");
            }
                else{
                System.out.println("\t" + stack[n]);
            }
        }
        System.out.println("==========");
    }
}
