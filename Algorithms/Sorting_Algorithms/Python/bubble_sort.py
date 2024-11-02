import time

def bubble_sort(array=[]):
	"""

	:type array: int[]
	"""
	flag = False
	while not flag:
		flag = True
		for i in range(0, len(array ) -1):
			if array[i] > array[i + 1]:
				array[i], array[ i +1] = array[ i +1], array[i]
				flag = False
	print(array)


def main():
	start = time.time()
	array = [29, 20, 40, 50, 80, 60]
	bubble_sort(array)
	end = time.time()
	dif1 = (end - start)

	start = time.time()
	array = [10, 20, 40, 50, 80, 60]
	bubble_sort(array)
	end = time.time()
	dif2 = (end - start)

	print(dif1 - dif2)


if __name__ == '__main__':
	main()
