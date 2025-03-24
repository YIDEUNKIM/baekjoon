def mergeSort(array, left, right):

    if left < right:
        mid  = (left + right) // 2

        mergeSort(array, left, mid)
        mergeSort(array, mid+1, right)

        merge(array, left, right, mid)


def merge(array, left, right, mid):
    leftArray = array[left:mid+1]
    rightArray = array[mid+1:right+1]

    # 왼쪽 배열 인덱스
    i_left = 0
    # 오른쪽 배열 인덱스
    i_right = 0
    # 병합된 배열 인덱스
    k = left
    while i_left< len(leftArray) and i_right < len(rightArray):
        if leftArray[i_left] <= rightArray[i_right]:
            array[k] = leftArray[i_left]
            i_left += 1

        else:
            array[k] = rightArray[i_right]
            i_right += 1
        k += 1

    # 왼쪽 배열에 남은 요소가 있으면 복사
    while i_left< len(leftArray):
        array[k] = leftArray[i_left]
        k+=1
        i_left += 1

    # 오른쪽 배열에 남은 요소가 있으면 복사

    while i_right < len(rightArray):
        array[k] = rightArray[i_right]
        k += 1
        i_right += 1





import sys
input = sys.stdin.readline
t = int(input())

numbers = []
sorted_numbers = []
for i in range(t):
    numbers.append(int(input()))


mergeSort(numbers, 0, len(numbers)-1)

for num in numbers:
    print(num)