
class Queue 
{

    #queue;
    #size;
    #quantity = 0;
    #first = 0;
    #last = 0;

    constructor (size)
    {
        this.#size = size;
        this.#queue = new Array(this.#size);
    }

    isEmpty()
    {
        return this.#quantity === 0;
    }

    isFull()
    {
        return this.#quantity === this.#size;
    }

    increase()
    {
        this.#quantity++;
        this.#last = ++this.#last % this.#size;
    }

    decrease()
    {
        this.#quantity--;
        this.#first = ++this.#first % this.#size;
    }

    enqueue(item)
    {
        if(this.isFull())
            return Number.MIN_VALUE;
        this.#queue[this.#last] = item;
        this.increase();
        return item;
    }

    dequeue()
    {
        if(this.isEmpty())
            return Number.MIN_VALUE;
        var item = this.#queue[this.#first];
        this.#queue[this.#first] = 0;
        this.decrease();
        return item;
    }

    printQueue()
    {
        if(this.isEmpty())
            return Number.MIN_VALUE;
        var sb = "";
        this.#queue.forEach(element => {
            sb += ` ${element}`;
        });
        console.log(sb);
    }

};


function main()
{
    size = 8;
    q = new Queue(8);
    for (let i = 1; i <= size; i++)
        q.enqueue(i*10);
    q.printQueue();
    for (let j = 1; j <= size + (size / 2); j++)
        if(j <= size)
            q.dequeue();
        else 
            q.enqueue(j * 11);
    q.printQueue();
}

main();