class Heap:
    def __init__(self, capacity):
        self.arr = [0] * (capacity + 1)  # 1부터 인덱스 시작
        self.size = 0
        self.capacity = capacity


def swap_element(heap, a_idx, b_idx):
    heap.arr[a_idx], heap.arr[b_idx] = heap.arr[b_idx], heap.arr[a_idx]


def max_heap_up(heap, idx):
    while idx > 1 and heap.arr[idx] > heap.arr[idx // 2]:
        swap_element(heap, idx, idx // 2)
        idx = idx // 2


def insert(heap, element):
    if heap.size == heap.capacity:
        return  # 용량 초과시 종료

    heap.size += 1
    heap.arr[heap.size] = element
    max_heap_up(heap, heap.size)


def create_heap(capacity):
    return Heap(capacity)


def max_heap_down(heap, idx):
    largest = idx
    left_child = 2 * idx
    right_child = 2 * idx + 1

    if left_child <= heap.size and heap.arr[largest] < heap.arr[left_child]:
        largest = left_child
    if right_child <= heap.size and heap.arr[largest] < heap.arr[right_child]:
        largest = right_child

    if largest != idx:
        swap_element(heap, largest, idx)
        max_heap_down(heap, largest)


def extract_max(heap):
    if heap.size == 0:
        return None

    root = heap.arr[1]

    if heap.size == 1:
        heap.size -= 1
        return root

    heap.arr[1] = heap.arr[heap.size]
    heap.size -= 1
    if heap.size > 1:
        max_heap_down(heap, 1)
    return root


def main():
    n = int(input())

    heap = create_heap(n * n)

    for _ in range(n):
        element = list(map(int, input().split()))
        for i in element:
            insert(heap, i)

    max = 0
    for i in range(n):
        max = extract_max(heap)

    print(max)
if __name__ == "__main__":
    main()