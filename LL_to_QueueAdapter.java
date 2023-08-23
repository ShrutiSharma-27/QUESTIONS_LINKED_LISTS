//Points to be noted :
//1. As in this program, we are using Java's LinkedList so addFirst and removeLast methods are okay but when I create
//   LinkedList class myself to implement Queue class then removeLast method will have O(n) time complexity. Therefore, it
//   is better to use removeFirst and addLast methods to implement queues.

import java.util.LinkedList;

class Queue{
    LinkedList<Integer> list ; //can use either combination : first (head) or last (tail)
    //Here, I'm using first's combination.

    Queue(){ //Constructor
        list = new LinkedList<>();
    }

    int Size(){
        return list.size();
    }

    void Add(int element){
        list.addLast(element);
    }

    int Remove(){
        if (list.size()==0){
            System.out.println("Stack Underflow");
            return -1;
        }
        else return list.removeFirst();
    }

    int Peek(){
        if (list.size()==0){
            System.out.println("Stack Underflow");
            return -1;
        }
        else return list.getFirst(); //from where to remove
    }
}

public class LL_to_QueueAdapter {
    public static void main(String[] args) {
        Queue queue = new Queue();

        queue.Add(23);
        queue.Add(223);
        queue.Add(56);
        queue.Add(100);

        System.out.println(queue.Peek());
        System.out.println(queue.Remove());
        System.out.println(queue.Peek());
        System.out.println(queue.Remove());
        System.out.println(queue.Peek());
        System.out.println(queue.Remove());
        System.out.println(queue.Peek());
        System.out.println(queue.Remove());
        System.out.println(queue.Peek());
        System.out.println(queue.Remove());
        System.out.println(queue.Peek());
    }
}

//Output :

// 23
// 23
// 223
// 223
// 56
// 56
// 100
// 100
// Stack Underflow
// -1
// Stack Underflow
// -1
// Stack Underflow
// -1
