
def recursive_insertion_sort(v=[], n=0):
    if n <= 1 :
        return
    
    recursive_insertion_sort(v, n-1)

    last = v[n-1]
    j = n-2

    while j >= 0 and last < v[j]:
        v[j+1] = v[j]
        j -= 1
    v[j+1] = last


def main():
    array = [90, 10, 30, 20, 50, 40, 60, 80, 70]
    length = len(array)
    recursive_insertion_sort(array, length);
    print(array)

if __name__ == '__main__':
    main()
    