
public class TOH {

    //create stacks
    Stack startStack;
    Stack auxStack;
    Stack endStack;
    //count of number of elements (or "books")
    private int size = 10;
    //array containing stacks
    private Stack[] stacks = new Stack[3];

    public TOH() {
        startStack = new Stack(size);
        auxStack = new Stack(size);
        endStack = new Stack(size);
        stacks[0] = startStack;
        stacks[1] = auxStack;
        stacks[2] = endStack;

        //push on numbers 0-9, these will be the elements that will be moved
        for (int n = size-1; n >= 0; n--) {
            startStack.push(n);
        }
        printOutAllStacks();
    }
        //---------------------------------------------
    public void printOutAllStacks() {
        System.out.println("//////////////////////////////////////");
        System.out.println("--STACK 0--");
        startStack.printStack();
        System.out.println("--STACK 1--");
        auxStack.printStack();
        System.out.println("--STACK 2--");
        endStack.printStack();
        System.out.println("//////////////////////////////////////");

    }
    public void moveBlock() {

        int i =0;
        //keeps track of moves made
        int moveCount = 0;
        int valueOnTopOfPopper;
            while(!checkIfDone()) {
                //modulo three to loop. (ie. since there's three stacks using modulo three would loop through this array
                //more efficiently than restarting it every time
                Stack stackToPop = stacks[i % 3];
                Stack stackToPush;
                if ((valueOnTopOfPopper = stackToPop.peek()) < (stacks[(i+1) % 3].peek())) {
                    stackToPush = stacks[(i+1)%3];
                    stackToPop.pop();
                    stackToPush.push(valueOnTopOfPopper);
                    printOutAllStacks();
                    i++;
                    moveCount++;
                } else if (valueOnTopOfPopper < (stacks[(i+2) % 3].peek())) {
                    stackToPush = stacks[(i+2)%3];
                    stackToPop.pop();
                    stackToPush.push(valueOnTopOfPopper);
                    printOutAllStacks();
                    i+=2;
                    moveCount++;
                }
                else {

                }
                i++;
            }
        System.out.println("Moves taken: " + moveCount);
    }

    //method to keep track of when to stop the loop
    public boolean checkIfDone() {
        if ((startStack.isEmpty())  && (auxStack.isEmpty() || endStack.isEmpty())) {
            return true;
        }
        else return false;


    }
}

