#include <stdio.h>
#include <stdlib.h>

typedef struct MinHeap{
  int * arr;
  int size;
  int capacity;
} MinHeap;

MinHeap * CreateHeap(int capacity) {
  MinHeap * heap = (MinHeap * )malloc(sizeof(MinHeap));

  if (heap == NULL) {
    exit(1);
  }

  heap -> arr = (int *)calloc(capacity + 1, sizeof(int));
  heap -> size = 0;
  heap -> capacity = capacity;

  return heap;
}

void SwapElement(int * a, int * b) {
  int temp = *a;
  *a = *b;
  *b = temp;
}

void MinHeapIfyUp(MinHeap * heap, int idx) {
  while(idx > 1 && heap -> arr[idx] < heap -> arr[idx/2]) {
    SwapElement(&heap -> arr[idx], &heap -> arr[idx/2]);
    idx = idx / 2;
  }
}

void MinHeapIfyDown(MinHeap * heap, int idx) {
  int smallest = idx;
  int left_child_idx = 2 * idx;
  int right_child_idx = 2 * idx + 1;

  if (left_child_idx <= heap -> size && heap -> arr[left_child_idx] < heap -> arr[smallest]) {
    smallest = left_child_idx;
  }

  if (right_child_idx <= heap -> size && heap -> arr[right_child_idx] < heap -> arr[smallest]) {
    smallest = right_child_idx;
  }

  if (smallest != idx) {
    SwapElement(&heap->arr[idx], &heap->arr[smallest]);
    MinHeapIfyDown(heap, smallest);
  }
}

void Insert(MinHeap * heap, int key) {
	if (heap -> size == heap -> capacity)
    	return;

 	heap -> size ++;
  heap -> arr[heap -> size] = key;

  MinHeapIfyUp(heap, heap->size);
}

int getMinHeap(MinHeap * heap) {
	int root = heap -> arr[1];

  if (heap -> size == 1) {
    heap -> size --;
    return root;
  }

  heap -> arr[1] = heap -> arr[heap->size];
  heap -> size--;

  if (heap -> size > 0)
    MinHeapIfyDown(heap, 1);

  return root;
}

void FreeHeap(MinHeap * heap) {
  free(heap -> arr);
  free(heap);
}

int main() {
  int n;
  scanf("%d", &n);

  MinHeap * heap = CreateHeap(n);
  for (int i = 0; i< n; i++) {
    int element;
    scanf("%d", &element);

    if (element == 0) {
      if (heap -> size > 0) {
        printf("%d\n", getMinHeap(heap));
      }
      else {
        printf("0\n");
      }
    }
    else if (element > 0) {
      Insert(heap, element);
    }
  }

  FreeHeap(heap);
  return 0;
}

