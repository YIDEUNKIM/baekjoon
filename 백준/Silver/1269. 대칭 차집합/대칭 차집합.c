#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>

#define initialCapacity 100003
#define kLoadFactorThreshold 0.75

typedef struct Node {
  int key;
  struct Node* next;
} Node;

typedef struct HashTable {
  Node ** buckets;
  int capacity;
  int size;
} HashTable;

int Hash(int key, int capacity) {
  uint32_t h = (uint32_t)key;  // 입력 키를 32비트 부호없는 정수로 변환

  // MurmurHash3의 finalizer 부분
  h ^= h >> 16;                // 상위 16비트를 하위 16비트와 XOR하여 비트 혼합
  h *= 0x85ebca6b;            // 곱셈 상수를 이용한 비트 확산 (첫 번째 곱셈)
  h ^= h >> 13;                // 상위 13비트를 하위 19비트와 XOR하여 추가 혼합
  h *= 0xc2b2ae35;            // 곱셈 상수를 이용한 최종 비트 확산 (두 번째 곱셈)
  h ^= h >> 16;                // 최종 상위 16비트와 하위 16비트 XOR로 균등 분산 완성

  return h % capacity;         // 해시 테이블 크기로 모듈러 연산하여 인덱스 반환
}

Node * CreateNode(int key) {
  Node * newNode = (Node *) malloc(sizeof(Node));
  if (newNode == NULL) {  // NULL 체크 추가
    exit(1);
  }
  newNode -> key = key;
  newNode -> next = NULL;
  return newNode;
}

HashTable * CreateHashTable() {
  HashTable * table = (HashTable *) malloc(sizeof(HashTable));

  if (table == NULL) {
    exit(1);
  }

  table -> capacity = initialCapacity;
  table -> size = 0;

  table -> buckets = (Node **) calloc(table -> capacity, sizeof(Node *));

  if (table -> buckets == NULL) {
    free(table);
    exit(1);
  }
  return table;
}

void ResizeHashTable(HashTable* table) {
  int oldCapacity = table -> capacity;
  Node ** oldBuckets = table -> buckets;

  table -> capacity = 2 * oldCapacity;

  table->buckets = (Node**)calloc(table->capacity, sizeof(Node*));

  if (table -> buckets == NULL) {
    table -> buckets = oldBuckets;
    table -> capacity = oldCapacity;
    return;
  }

  for (int i =0; i<oldCapacity; i++) {
    Node * current = oldBuckets[i];
    while (current != NULL) {
      Node * nodeToRehash = current;
      current = current -> next;

      int newIndex = Hash(nodeToRehash -> key, table -> capacity);

      nodeToRehash -> next = table -> buckets[newIndex];
      table -> buckets[newIndex] = nodeToRehash;
    }
  }
  free(oldBuckets);
}

void Insert(HashTable * table, int key) { // O(1)
  int index = Hash(key, table->capacity);

  Node * current = table -> buckets[index];

  // 중복 값 검사
  while(current != NULL) {
    if (current -> key == key) {
      return;
    }
    current = current -> next;
  }

  Node * new_node = CreateNode(key);
  new_node -> next = table -> buckets[index];
  table -> buckets[index] = new_node;
  table -> size++;

  if ((double)table -> size / table -> capacity > kLoadFactorThreshold) { // kLoadFactorThreshold = 0.75
    ResizeHashTable(table); // amortized O(1)
  }
}

int Search(HashTable * table, int key) {
  int index = Hash(key, table->capacity);
  Node * current = table -> buckets[index];

  while(current != NULL) {
    if (current -> key == key) {
      return 1;
    }
    current = current -> next;
  }
  return 0;
}

int main() {
  int N, M;
  scanf("%d %d", &N, &M);

  HashTable * a_table = CreateHashTable();
  HashTable * b_table = CreateHashTable();

  int a_element = 0;
  int b_element = 0;
  int both_number = 0;

  for (int i=0; i<N; i++) {
    int element;
    scanf("%d", &element);
    Insert(a_table, element);
    a_element ++;
  }

  for (int i=0; i<M; i++) {
    int element;
    scanf("%d", &element);

    if (Search(a_table, element) == 1) {
      both_number += 1;
    }
    else{
      b_element++;
    }
  }

  int a_b = a_element - both_number;
  int b_a = b_element;

  printf("%d", a_b + b_a);

  return 0;
}