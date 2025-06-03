#include <stdio.h>
#include <stdlib.h>

#define initialSize 100002
#define initialFactor 0.75


typedef struct Node{
  int key;
  struct Node * next;
} Node;

typedef struct HashTable{
  Node ** buckets;
  int capacity;
  int size;
} HashTable;

HashTable * CreateHashTable() {
  HashTable * table = (HashTable *)malloc(sizeof(HashTable));

  table -> capacity = initialSize;
  table -> size = 0;
  table -> buckets = (Node **) calloc(table -> capacity, sizeof(Node *));

  return table;
}

Node * CreateNode(int key) {
  Node * newNode = (Node *)malloc(sizeof(Node));
  newNode -> key = key;
  newNode -> next = NULL;
  return newNode;
}

int Hash(int key, int capacity) {
  return (key%capacity + capacity) % capacity;
}

// Capacity를 두 배로 늘리고, 요소들을 재배치
void ResizeHashTable(HashTable * table){
  int oldCapacity = table -> capacity;
  Node ** oldBuckets = table -> buckets;

  table -> capacity = oldCapacity * 2;
  table -> buckets = (Node**)calloc(table -> capacity, sizeof(Node*));

  if (table -> buckets == NULL) {
    table -> buckets = oldBuckets;
    table -> capacity = oldCapacity;
    return;
  }

  for (int i=0; i< oldCapacity; i++) {
    Node * current = oldBuckets[i];
    while (current) {
      Node * nodeReHash = current;
      current = current -> next;
      int newIndex = Hash(nodeReHash->key, table ->capacity);

      nodeReHash -> next = table -> buckets[newIndex];
      table -> buckets[newIndex] = nodeReHash;
    }
  }

  free(oldBuckets);
}

void insert(HashTable * table, int key) {
  int index = Hash(key, table -> capacity);

  Node * current = table -> buckets[index];
  // 중복 검사
  while (current) {
    if (current -> key == key) {
      return;
    }
    current = current -> next;
  }


  Node * newNode = CreateNode(key);
  newNode -> next = table -> buckets[index];
  table -> buckets[index] = newNode;
  table -> size ++;

  if ((double)table->size /table -> capacity >= initialFactor) {
    ResizeHashTable(table);
  }
}

int Search(HashTable * table, int key) {
  int index = Hash(key, table -> capacity);
  Node * current = table -> buckets[index];

  while (current) {
    if (current -> key == key) {
      return 1;
    }
    current = current -> next;
  }

  return 0;
}

int main() {
  int n;
  int m;

  HashTable * a_table = CreateHashTable();

  scanf("%d", &n);
  for (int i=0; i<n; i++) {
    int element;
    scanf("%d", &element);
    insert(a_table, element);
  }

  scanf("%d", &m);
  for (int j=0; j<m; j++) {
    int element;
    scanf("%d", &element);
    if (Search(a_table, element) == 1) {
      printf("1\n");
    }else{
      printf("0\n");
    }
  }

}
