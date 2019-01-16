import math
def transheap(H):
        n = len(H)
        for i in range(math.floor((n-1)/2), -1,-1):
                k = i
                v = H[k]
                heap = False
                while heap is False and 2*k <= n-1:
                        j = 2*k
                        if j<n-1:
                                if H[j]>=H[j+1]:
                                        j = j+1
                        if v<=H[j]:
                                heap = True
                        else:
                                H[k] = H[j]
                                k = j
                H[k] = v
        print(H)




b = [89,19,49,45,65,71,76,28,68,66]
a = [1,1,2,1,3]
b.sort()
transheap(b)