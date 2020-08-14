/**
 * CircularLinkedList
 */
public class CircularLinkedList<T> {

    Node <T> head = new Node <T>();
    Node <T> tail = new Node <T>();

    public CircularLinkedList(){
        this.head.next = tail;
        this.head.prev = tail;
        this.tail = this.head;
    }

    class Node <T> {
        T item;
        Node <T> next;
        Node <T> prev; 

        public Node (){}

        public Node (T item){
            this.item = item;
        }

        public Node (Node<T> prev, Node <T> next){
            this.prev = prev;
            this.next = next;
        }
    
        public Node (T item, Node<T> prev, Node <T> next){
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    boolean isEmpty(){
        return head.item == null;
    }

    private void flushNode (Node<T> node){
        node.prev = null;
        node.next = null;
        node.item = null;
    }

    private Node<T> unlinkNode (Node<T> current){
        Node <T> nextNode = current.next;
        Node <T> prevNode = current.prev;
        prevNode.next = current.next;
        nextNode.prev = current.prev;
        flushNode(current);
        return nextNode;
    }

    private T addAtTail(T item){
        if (!isEmpty()){
            Node <T> newNode = new Node<T> (item, tail, head);
            if (tail == head){
                head.next = newNode;
            }
            head.prev = newNode;
            tail.next = newNode;
            tail = newNode;
        } else 
            head.item = item;
        return item;
    } 

    T enqueue(T item){
        return addAtTail(item);
    }

    T dequeue(){
        T item = head.item;
        Node<T> nextNode = unlinkNode(head);
        head = nextNode;
        return item;
    }

    T push(T item){
        return addAtTail(item);
    }

    T pop(){
        T item = tail.item;
        Node<T> prevNode = unlinkNode(tail).prev;
        tail = prevNode;
        return item;
    }


    T peek(){
      return this.tail();  
    }

    T head(){
        return head.item;
    }

    T tail(){
        return tail.item;
    }

    void printCircularLinkedList(){
        if (!isEmpty()){
        Node <T> current = head;
        StringBuilder sb = new StringBuilder();
            while ( current.next != head){
                sb.append(current.item + " ");
                current = current.next;
            }
        sb.append(current.item);
        System.out.println(sb);
        }else
            System.out.println("Empty Double Linked List");
    }

    public static void main(String[] args) {
        System.out.println("Double Linked List");
        CircularLinkedList<Integer> cll = new CircularLinkedList<Integer>();
        for (int i = 1; i <= 10; i++)
            cll.enqueue(i);
        cll.printCircularLinkedList();
        for (int i = 11; i <= 20; i++)
            cll.push(i);
        cll.printCircularLinkedList();
        for (int i = 1; i <= 10; i++)
            cll.dequeue();
        cll.printCircularLinkedList();
        System.out.println("Peek: " + cll.peek());
        cll.pop(5);
        cll.pop(4);
        System.out.println("Head: " + cll.head());
        cll.pop(1);
    }

    protected void pop(int quantity){
        for (int i = 1; i <= quantity; i++)
            this.pop();
        this.printCircularLinkedList();
    }

}