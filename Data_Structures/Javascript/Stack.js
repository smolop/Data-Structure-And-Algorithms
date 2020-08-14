

class Stack 
{
    #vector;
    #size;
    #quantity = 0;

    constructor (size) 
    {
        this.#size = size;
        this.#vector = new Array(this.#size);
    }

    isEmpty(){
        return this.#quantity === 0;
    }

    isFull(){
        return this.#quantity === size;
    }

    push(item)
    {
        if (this.isFull())
            return Number.MIN_VALUE;
        this.#vector[this.#quantity++] = item;
        return item;
    }

    pop()
    {
        if (this.isEmpty())
            return Number.MIN_VALUE;
        var item = this.#vector[this.#quantity - 1];
        this.#vector[--this.#quantity] = 0;
        return item;
    }

    print()
    {
        if (this.isEmpty())
            return Number.MIN_VALUE;
        var sb = "";
        this.#vector.forEach(element => {
            sb += ` ${element}`;
        });
        console.log(sb);
    }

};

function main()
{
    size = 8;
    s = new Stack(size);
    for (let index = 1; index <= size; index++) 
        s.push(index * 10);
    s.print();
    for (let j = 1; j <= size; j++)
            s.pop();
    for (let j = 1; j <= (size / 2); j++)
            s.push(j*11);
    s.print();
}

main();