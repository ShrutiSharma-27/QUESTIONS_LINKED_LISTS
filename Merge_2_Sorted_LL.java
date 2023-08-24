//You are required to make a mergeSort function. The function is static and  is passed the head and tail of
//an unsorted list. The function is expected to return a new sorted list. The original list must not change.

class Node{
    int data;
    Node next;
}

class LinkedList{
    Node head;
    Node tail;
    int size;

    void addLast(int value){
        Node temp=new Node();
        temp.data=value;
        temp.next=null;
        if (size==0){
            head = tail = temp;
        }
        else{
            tail.next=temp ;
            tail=temp;
        }
        size++;
    }

    void displayLinkedList(){
        if (size==0) System.out.println("List is empty");
        else{
            Node temp = head;
            while (temp != null){
                System.out.println(temp.data);
                temp=temp.next;
            }
        }
    }

    int getSize(){
        return size;
    }

    void removeFirst(){
        if(size==0) System.out.println("Linked list is empty");
        else if (size==1) {
            head=null;
            tail=null;
        }
        else{
            head=head.next;
            size--;
        }
    }

    int getFirst(){
        if(size==0) {
            System.out.println("Linked List is empty.");
            return -1;
        }
        return head.data;
    }

    int getLast(){
        if(size==0) {
            System.out.println("Linked List is empty.");
            return -1;
        }
        return tail.data;
    }

    int getAt(int index){
        if(size==0) {
            System.out.println("Linked List is empty.");
        }
        else if(index>size-1 || index<0){
            System.out.println("Invalid Arguments !");
        }
        else{
            Node temp = head; //for 0th index
            for(int i=0 ; i<index ; i++){ //so run it 1 less than the desired index as you've covered that 1 outside this loop.
                temp=temp.next;
            }
            return temp.data;
        }
        return -1;
    }

    void addFirst(int value){
        Node temp = new Node();
        temp.data=value;
        temp.next=head;
        head=temp;
        size++;
    }

    void addIndex(int index, int value){
        if (index<0 || index>size){ //index==size is not included because you can add at last so, in that case index=size
            System.out.println("Invalid Arguments");
        }
        else if(index==size) addLast(value);
        else if(index==0) addFirst(value);
        else {
            //Node to be added in linked list
            Node temp = new Node();
            temp.data = value;

            Node before_node = new Node();
            before_node=head; //0th index is assigned already so, we'll start our loop from i=1

            for(int i=1 ; i<index ; i++) {//I want to stop at node with index 1 less than the given
                before_node = before_node.next;
            }

            temp.next=before_node.next;
            before_node.next = temp;

            size++;
        }
    }

    void removeLast(){
        if(size == 0){
            System.out.println("List is empty");
        }
        else if (size == 1){
            head=tail=null;
            size--;
        }
        else{
            Node temp = new Node();
            temp=head;
            for (int i=1 ; i<size-1 ; i++){
                temp=temp.next;
            }
            temp.next=null;
            tail=temp; //tail will point to new last
            size--;
        }
    }

    void reverse(){
        if (size == 0){
            ; //acts like pass in python : empty statement
        }
        else if (size==1){
            ;
        }
        else{
            Node previous_node = null;
            Node current_node = head;
            while (current_node != null){
                Node hold_currentNext = current_node.next;

                current_node.next = previous_node;
                previous_node=current_node;
                current_node=hold_currentNext;
            }
            //Swap head and tail
            Node temp = head;
            head = tail;
            tail = temp;
        }
    }

    void removeByIndex(int index){
        if (index>=size || index<0) System.out.println("Invalid Arguments !");
        else if(index==size-1){ //means last element of linked list
            removeLast();
        }
        else if (index==0){
            removeFirst();
        }
        else {
            Node newBefore = head;
            for (int i=1 ; i<index ; i++){
                newBefore = newBefore.next;
            }
            Node nodeToRemove = newBefore.next;
            newBefore.next = nodeToRemove.next;
            nodeToRemove.next = null; //it is also completely fine if you don't do this : in that case only the above line will get execute (also you can only use 1 node variable and just type newBefore.next = newBefore.next.next ;)
            size--;
        }
    }

    int kthFromLast(int k){
        if(k>=size || k<0){
            System.out.println("Invalid Arguments");
        }

        else{
            Node slow = head;
            Node fast = head;
            for (int i = 0 ; i<k ; i++){
                fast=fast.next;
            }
            //Now, slow and fast both will have same gap of k
            while (fast != tail){ //when fast will reach tail then slow must be present at its correct position.
                slow = slow.next;
                fast = fast.next;
            }
            return slow.data;
        }
        return -1;
    }

    int getMid(){
        if(size==0) return -1;
        Node slow = head;
        Node fast = head;
        while(fast.next != null && fast.next.next != null){ // for EVEN case : fast.next.next != null, other wise we'll get start of 2nd half
            slow = slow.next; //will move 1 step forward
            fast = fast.next.next; //will move 2 step forward
            //So, by the end fast will cover entire linked list while slow will only cover half of it
        }
        return slow.data;
    }
}

public class Merge_2_Sorted_LL {
    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.addLast(2); list1.addLast(7); list1.addLast(15); list1.addLast(90); list1.addLast(101); list1.addLast(200);
        LinkedList list2 = new LinkedList();
        list2.addLast(1); list2.addLast(3); list2.addLast(22); list2.addLast(30); list2.addLast(50);

        LinkedList sortedLL = mergeSort(list1, list2);
        sortedLL.displayLinkedList();
    }

    // HERE is the mentioned function :
    static LinkedList mergeSort(LinkedList list1, LinkedList list2){
        LinkedList sortedList = new LinkedList();
        Node pointer1 = list1.head;
        Node pointer2 = list2.head;
        while(pointer1 != null && pointer2 != null){ //because if any of them finishes then there would be nothing to compare with
            if(pointer1.data<=pointer2.data){
                sortedList.addLast(pointer1.data);
                pointer1=pointer1.next;
            }
            else{
                sortedList.addLast(pointer2.data);
                pointer2=pointer2.next;
            }
        }

        //if something left in any of the linked list
        while (pointer1 != null){
            sortedList.addLast(pointer1.data);
            pointer1=pointer1.next;
        }
        while (pointer2 != null){
            sortedList.addLast(pointer1.data);
            pointer1=pointer1.next;
        }
        return sortedList;
    }
}

//Output :

// 1
// 2
// 3
// 7
// 15
// 22
// 30
// 50
// 90
// 101
// 200
