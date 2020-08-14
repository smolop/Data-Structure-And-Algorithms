public class Queue<T> {

	private final T MIN_VALUE = (T) Integer.valueOf("-214748364");
	
	private int size, quantity = 0, head = 0, tail = -1;
	private Object[] queue = {};
	
	public <T> Queue(int size) {
		this.size = size;
		this.queue = (T[]) new Object[this.size];
	}

	private void decrease() {
		this.quantity--;
		this.head = ++this.head % this.size;
		System.out.printf("Quantity: %d \n", this.quantity);
		System.out.printf("Head: %d \n", this.head);
	}

	private void increase() {
		this.quantity++;
		this.tail = ++this.tail % this.size;
		System.out.printf("Quantity: %d \n", this.quantity);
		System.out.printf("Tail: %d \n", this.tail);
	}

	public boolean isEmpty() {
		return this.quantity == 0;
	}

	public boolean isFull() {
		return this.quantity == this.size;
	}
	
	public T enqueue(T item) {
		if (this.isFull())
			return MIN_VALUE;
		this.increase();
		this.queue[this.tail] = item;
		return item;
	}

	public T dequeued() {
	if (this.isEmpty())
		return MIN_VALUE;
	T item = (T) this.queue[this.head]; 
	this.queue[this.head] = null;
	this.decrease();
	return item;
	}

	public T head() {
		if (this.isEmpty())
			return MIN_VALUE;
		return (T) this.queue[this.head];
	}

	public T tail() {
		if (this.isEmpty())
			return MIN_VALUE;
		return (T) this.queue[this.tail];
	}

	public void printQueue() {
		for (int i = 0; i < queue.length; i++)
			System.out.printf("%s %d %s", i == 0 ? "[" : "," ,queue[i], i == queue.length - 1 ? "]\n" : "" );
	}
	
	public static void main(String[] args) {
	int limit = 20;
	Queue<Integer> queue = new Queue<Integer>(limit);
		for (int i = 1; i <= limit; i++) 
			System.out.printf("Enqueued: %d \n", queue.enqueue(i*10));
		queue.printQueue();
		System.out.printf("Current head: %d \n", queue.head());
		System.out.printf("Current tail: %d \n", queue.tail());
		int range = limit + 1;     
		int to = (int)(Math.random() * range);
		int from = 0;
		if (to > 0) {
			for (; from < to; from++)
				System.out.printf("Dequeued: %d \n",queue.dequeued());
			queue.printQueue();
			System.out.printf("Current head: %d \n", queue.head());
			System.out.printf("Current tail: %d \n", queue.tail());
			to = from;
			range = from + 1; 
			from = (int)(Math.random() * range);
			if (from < to) {
				while (from++ < to)
					System.out.printf("Enqueued: %d \n",queue.enqueue(from*11));
				queue.printQueue();
				System.out.printf("Current head: %d \n", queue.head());
				System.out.printf("Current tail: %d \n", queue.tail());
			}
		}
		
	}

}
