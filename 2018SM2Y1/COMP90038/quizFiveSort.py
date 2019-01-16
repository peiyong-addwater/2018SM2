def insertionSort(arr):
    assignment = 0
    # Traverse through 1 to len(arr)
    for i in range(1, len(arr)):
 
        key = arr[i]
        assignment = assignment +1
 
        # Move elements of arr[0..i-1], that are
        # greater than key, to one position ahead
        # of their current position
        j = i-1
        while j >=0 and key < arr[j] :
                arr[j+1] = arr[j]
                assignment = assignment+1
                j -= 1
        arr[j+1] = key
        assignment = assignment +1
    
    print(arr, assignment)

def shellSort(arr):
 
    # Start with a big gap, then reduce the gap
    n = len(arr)
    gap = n/2
 
    # Do a gapped insertion sort for this gap size.
    # The first gap elements a[0..gap-1] are already in gapped 
    # order keep adding one more element until the entire array
    # is gap sorted
    while gap > 0:
 
        for i in range(gap,n):
 
            # add a[i] to the elements that have been gap sorted
            # save a[i] in temp and make a hole at position i
            temp = arr[i]
 
            # shift earlier gap-sorted elements up until the correct
            # location for a[i] is found
            j = i
            while  j >= gap and arr[j-gap] >temp:
                arr[j] = arr[j-gap]
                j -= gap
 
            # put temp (the original a[i]) in its correct location
            arr[j] = temp
        gap /= 2


array = [9, 8, 7, 6, 5, 4, 3, 2, 1, 0]
insertionSort(array)

import math
print(math.log2(3355431+1))

# Python program to implement interpolation search

# If x is present in arr[0..n-1], then returns
# index of it, else returns -1
'''def interpolationSearch(arr, n, x):
    # Find indexs of two corners
    lo = 0
    hi = (n - 1)
 
    # Since array is sorted, an element present
    # in array must be in range defined by corner
    while lo <= hi and x >= arr[lo] and x <= arr[hi]:
        # Probing the position with keeping
        # uniform distribution in mind.
        pos  = lo + int(((float(hi - lo) / 
            ( arr[hi] - arr[lo])) * ( x - arr[lo])))

        # Condition of target found
        if arr[pos] == x:
            return pos
 
        # If x is larger, x is in upper part
        if arr[pos] < x:
            lo = pos + 1;
 
        # If x is smaller, x is in lower part
        else:
            hi = pos - 1;
    
    return -1

# Driver Code
# Array of items oin which search will be conducted
arr = [10, 10, 10, 10, 11, 10, 10, 10, \
                22, 23, 24, 33, 35, 42, 10]
n = len(arr)

x = 18 # Element to be searched
index = interpolationSearch(arr, n, x)

if index != -1:
    print "Element found at index",index
else:
    print "Element not found"

# This code is contributed by Harshit Agrawal'''
