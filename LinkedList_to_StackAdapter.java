//Points to be noted :
//1. You have 2 options : either push/pop from start of linked list (head-side) with time complexity O(1)
//   or push/pop from end of the linked list (tail-side) with time complexity O(n).
//2. Clearly, we'll select O(1) complexity over O(n).
//3. The above explanation is valid when you've made a class linked list yourself but in case of Java's LinkedList
//   both head-side and tail-side case has O(1) time complexity. So, it doesn't matter that you are using which side.

import java.util.LinkedList;

class Stack{
    LinkedList<Integer> list ; //can use either combination : first (head) or last (tail)
    //Here, I'm using first's combination.

    Stack(){ //Constructor
        list = new LinkedList<>();
    }

    int Size(){
        return list.size();
    }

    void Push(int element){
        list.addFirst(element);
    }

    int Pop(){
        if (list.size()==0){
            System.out.println("Stack Underflow");
            return -1;
        }
        else return list.removeFirst();
    }

    int Top(){
        if (list.size()==0){
            System.out.println("Stack Underflow");
            return -1;
        }
        else return list.getFirst();
    }
}

public class LinkedList_to_StackAdapter {
    public static void main(String[] args) {
        Stack stack = new Stack();
        System.out.println(stack.Size());
        stack.Push(10);
        System.out.println(stack.Top());
        System.out.println(stack.Pop());

        stack.Push(5);
        stack.Push(1);
        System.out.println(stack.Pop());

        System.out.println(stack.Pop());
        System.out.println(stack.Top());
        System.out.println(stack.Pop());
    }
}

// Output :

// 0
// 10
// 10
// 1
// 5
// Stack Underflow
// -1
// Stack Underflow
// -1
