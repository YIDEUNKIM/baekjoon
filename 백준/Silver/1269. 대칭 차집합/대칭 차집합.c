#include <stdio.h>
#include <stdlib.h>

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
  return (key%capacity + capacity) % capacity;
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

void Insert(HashTable * table, int key) {
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

  if ((double)table -> size / table -> capacity > kLoadFactorThreshold) {
    ResizeHashTable(table);
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
      Insert(b_table, element);
      b_element++;
    }
  }

  int a_b = a_element - both_number;
  int b_a = b_element;

  printf("%d", a_b + b_a);

  return 0;
}