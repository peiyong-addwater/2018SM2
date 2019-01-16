import sys
import math
#print(1)
sys.setrecursionlimit(100)
#print(2)
def mystery(numberList, lo, hi):
    if numberList[lo] > lo or numberList[hi] < hi:
        print("numberList[lo]",numberList[lo],"lo",lo, "numberList[hi]",numberList[hi],"hi",hi )
        return -1
    
    
    mid = lo + (hi-lo)//2
    print("mid=",mid)
    print("hi=",hi)
    print('lo = ',lo)
    #print(mid)
    if numberList[mid] == mid:
        print("mid",mid,'=numberList[mid]',numberList[mid])
        return mid
    else:
        if numberList[mid] > mid:
            print("numberList[mid]",numberList[mid],">mid",mid)
            return mystery(numberList,lo,mid-1)
        else:
            print("numberList[mid]",numberList[mid],"<mid",mid)
            return mystery(numberList,mid+1,hi)

#print(3)
a = [1,1,1,2,3,3,5,8,9,10,11]
b = [0,1,2,3,4,5,7,7,7,10,11]
c = [9,9,9,9,9,9,9,9,9,9,11]
d = [1,1,1,1,5]
#print(4)
result = mystery(c, 0, 10)
#print(5)
print(result)