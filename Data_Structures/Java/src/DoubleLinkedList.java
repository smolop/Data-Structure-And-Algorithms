/**
 * DoubleLinkedList
 * 
 * @param <T>
 */
public class DoubleLinkedList<T> {
   private Node<T> first;
   private Node<T> last;

    class Node<T> {
        T item;
        Node<T> next = null;
        Node<T> prev = null;
        
        public Node(final T item)
        {
            this.item = item;
        }
    }

    boolean isEmpty()
    {
        return first == null;
    }

    T enqueue(T item){
        
        if (isEmpty()){
            first = new Node<T>(item);
            last = first;
        } else {
            Node <T> newNode = new Node<T>(item);
            newNode.prev = last;
            last.next = newNode;
            last = newNode;
        }
        return item;
    }

    T dequeue(){
        if (isEmpty())
            return (T) String.valueOf(Integer.MIN_VALUE);
        T item = first.item;
        first = first.next;
        return item;
    }

    void printDoubleLinkedList(){
        Node<T> current = first;
        StringBuilder sb = new StringBuilder();
        while (current != null){
            sb.append(current.item + " ");
            current = current.next;
        }
        System.out.println(sb);
    }

    public static void main(final String[] args) {
        System.out.println("DoubleLinkedList"); 
        DoubleLinkedList<Integer> ll = new DoubleLinkedList<Integer>(); 
        for (int i = 1; i <= 20; i++){
            ll.enqueue(i*10);
            ll.printDoubleLinkedList();}
        for (int i = 1; i <= 20; i++){
            ll.dequeue();
            ll.printDoubleLinkedList();}
    }
}