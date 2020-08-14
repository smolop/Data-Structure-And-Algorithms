import random

def get_cndtn(arr):
    upper_bound = len(arr) - 1
    r = random.randint(0, upper_bound)
    m = (len(arr) - 1) // 2
    l = [0, m] 
    b = r not in l
    print(f"Random number: {r}")
    return not arr.is_empty or b, r