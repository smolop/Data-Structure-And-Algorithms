/**
 * BinarySearchTree
 */
public class BinarySearchTree <T extends java.lang.Comparable<T>> {
    Node <T> root = new Node<T>();

    class Node <T> {
        T item = null;
        Node <T> parent = null;
        Node <T> leftChild = null;
        Node <T> rightChild = null;

        public Node(){}

        public Node(Node<T> parent){
            this.parent = parent;
        }
    }

    private boolean isEmpty(){
        return root.item == null;
    }

    private boolean isEmpty(Node<T> node) {
        return node == null;
    }

    T add(T item){
        if( isEmpty() )
            root.item = item;
        else {
            int cmp = item.compareTo(root.item);
            if(cmp < 0)
                return add(root.leftChild == null? root.leftChild = new Node<T>(root) : root.leftChild, item);
            else
                return add(root.rightChild == null? root.rightChild = new Node<T>(root) : root.rightChild, item);
        }
        return item;
    }

    private T add(BinarySearchTree<T>.Node<T> node, T item) {
        if (node.item == null)
           node.item = item; 
        else{
            int cmp = item.compareTo(node.item);
            if(cmp < 0)
                return add(isEmpty(node.leftChild)? (node.leftChild = new Node<T>(node)) : node.leftChild, item);
            else if (cmp > 0)
                return add(isEmpty(node.rightChild)? (node.rightChild = new Node<T>(node)) : node.rightChild, item);
            else
                System.out.println("The value is already in the BST");
        }
        return item;
    }

    private T findMin(Node<T> node){
        return (!isEmpty(node.leftChild))? findMin(node.leftChild) : node.item;
    }

    T findMin(){
        if(isEmpty())
            return (T) String.valueOf(Integer.MIN_VALUE);
        return (!isEmpty(root.leftChild))? findMin(root.leftChild) : root.item;
    }

    private T findMax(Node<T> node){
        return (!isEmpty(node.rightChild))? findMax(node.rightChild) : node.item;
    }

    T findMax(){
        if(isEmpty())
            return (T) String.valueOf(Integer.MIN_VALUE);
        return (!isEmpty(root.rightChild))? findMax(root.rightChild) : root.item;
    }

    boolean contains(T item){
        return (isEmpty())? false : contains(root, item);
    }

    boolean contains(Node<T> node, T item){
        int cmp = item.compareTo(node.item);
        if (cmp == 0)
            return true;
        if (cmp < 0 & !isEmpty(node.leftChild))
            return contains(node.leftChild,item);
        if (cmp > 0 & !isEmpty(node.rightChild))
            return contains(node.rightChild, item);
        return false;
    }

    void printPreOrder(){
        System.out.println("Print Pre Order.");
        if(!isEmpty()){
            StringBuilder sb = new StringBuilder();
            sb.append(root.item + " ");
            sb.append(printPreOrder(root.leftChild));
            sb.append(printPreOrder(root.rightChild));
            System.out.println(sb);
        }else
            System.out.println("Empty Binary Search Tree");
    }

    private String printPreOrder(Node<T> node){
        StringBuilder sb = new StringBuilder();
        if(!isEmpty(node)){
            sb.append(node.item + " ");
            sb.append(printPreOrder(node.leftChild) + " ");
            sb.append(printPreOrder(node.rightChild) + " ");
        }
        return sb.toString();
    }

    void printInOrder(){
        System.out.println("Print In Order.");
        if(!isEmpty()){
            StringBuilder sb = new StringBuilder();
            sb.append(printInOrder(root.leftChild));
            sb.append(root.item + " ");
            sb.append(printInOrder(root.rightChild));
            System.out.println(sb);
        }else
            System.out.println("Empty Binary Search Tree");
    }

    private String printInOrder(Node<T> node){
        StringBuilder sb = new StringBuilder();
        if(!isEmpty(node)){
            sb.append(printInOrder(node.leftChild) + " ");
            sb.append(node.item + " ");
            sb.append(printInOrder(node.rightChild) + " ");
        }
        return sb.toString();
    }


    void printPostOrder(){
        System.out.println("Print Post Order.");
        if(!isEmpty()){
            StringBuilder sb = new StringBuilder();
            sb.append(printPostOrder(root.leftChild));
            sb.append(printPostOrder(root.rightChild));
            sb.append(root.item + " ");
            System.out.println(sb);
        }else
            System.out.println("Empty Binary Search Tree");
    }

    private String printPostOrder(Node<T> node){
        StringBuilder sb = new StringBuilder();
        if(!isEmpty(node)){
            sb.append(printPostOrder(node.leftChild) + " ");
            sb.append(printPostOrder(node.rightChild) + " ");
            sb.append(node.item + " ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        int[] arr = {50, 40, 60, 45, 55, 30, 70, 35, 65, 20, 80, 25, 75, 10, 90, 15, 85};
        for (int e : arr) 
            bst.add(e);
        System.out.println("I've finished to add elements, I'm going to print'em");
        bst.printPreOrder();
        bst.printInOrder();
        bst.printPostOrder();
        System.out.println(bst.findMin());
        System.out.println(bst.findMax());
        System.out.println(bst.contains(80));
    }

}