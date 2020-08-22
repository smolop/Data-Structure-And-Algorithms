
def insertion_sort(array=[]):
	assert len(array) > 2
	for i in range(1, len(array) - 1):
		key = array[i]
		j = i - 1
		while j >= 0 and key < array[j]:
			array[j + 1] = array[j]
			j -= 1
		array[j + 1] = key
	print(array)


def main(): 
	array = [20, 10, 30, 40, 70]
	insertion_sort(array)


if __name__ == '__main__':
    main()