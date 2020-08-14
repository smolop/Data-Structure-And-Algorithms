public class Stack {
	
	private static final int MAX = 128;
	private static int top = 0;
	private static int stack[] = new int [MAX];
	
	public static int size() {
		return top;
	}
	
	public static boolean isEmpty(){
		return size() == 0;
	}
	
	public static boolean isFull() {
		return size() == MAX;
	}
	
	public static int push(int item){
		return !isFull() ? item = (stack[top++] = item) : Integer.MIN_VALUE;
	}
	
	public static int pop() {
		if (isEmpty())
			return Integer.MIN_VALUE;
		int item = stack[--top];
		stack[top] = 0;
		return item;
	}
	
	public static int peek() {
		if (isEmpty())
			return Integer.MIN_VALUE;
		return stack[top - 1];
	}	
	
	public static void print() {
		for (int i = 0; i < size(); i++) 
			System.out.print((i == 0 ? "[" : "") + stack[i] + (i != size() - 1 ? ", " : "]\n"));
	}
	
	public static void main(String[] args) {
		for (int i = 1; i < 8; i++) 
			push(i * 10);
		print();
		System.out.println("Pop: " + pop());
		System.out.println("Peek: " + peek());
		print();
		
		int range = 8 + 1;     
		int i = (int)(Math.random() * range);
		System.out.println(i);
		while( i != (size()/2) - 1 && i != 0 ) {
			if (i % 2 == 0) 
				System.out.println("Pop: " + pop());
			else 
				System.out.println("Peek: " + peek());
			print();	
			i = (int)(Math.random() * range);
			System.out.println(i);
		}
	}
}
