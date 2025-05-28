#include <stdio.h>
#include <stdlib.h>

#define initialCapacity 100003
#define kLoadFactorThreshold 0.75

typedef struct Node {
    int key;
    struct Node * next;
} Node;

typedef struct HashTable {
    Node ** buckets;
    int size;
    int capacity;
} HashTable;

Node * CreateNode(int key) {
    Node * newNode = (Node *)malloc(sizeof(Node));

    if (newNode == NULL) {
        exit(1);
    }
    newNode -> key = key;
    newNode -> next = NULL;

    return newNode;
}

HashTable * CreateHashTable() {
    HashTable * table = malloc(sizeof(HashTable));

    table -> size = 0;
    table -> capacity = initialCapacity;
    table -> buckets = calloc(table -> capacity, sizeof(Node *));
    return table;
}

int Hash(int key, int capacity) {
    return (key%capacity + capacity)%capacity;
}

void Insert(HashTable * table, int key) {
    int index = Hash(key, table->capacity);

    Node * current = table -> buckets[index];
    while (current != NULL) {
        if (current -> key == key) {
            return;
        }
        current = current -> next;
    }

    Node * newNode = CreateNode(key);
    newNode -> next = table -> buckets[index];
    table -> buckets[index] = newNode;
    table->size++;
}

void ResizeHashTable(HashTable * table) {
    Node ** oldBuckets = table -> buckets;
    int oldCapacity = table -> capacity;
    
    table -> capacity = 2 * oldCapacity;
    table -> buckets = (Node **)calloc(table->capacity, sizeof(Node*));
    
    if (table -> buckets == NULL) {
        table -> buckets = oldBuckets;
        table -> capacity = oldCapacity;
        return;
    }

    for (int i=0; i<oldCapacity; i++) {
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

int Search (HashTable * table, int key) {
    int index = Hash(key, table -> capacity);
    Node * current = table -> buckets[index];

    while (current != NULL) {
        if (current -> key == key) {
            return 1;
        }
        current = current -> next;

    }
    return 0;
}

void FreeHashTable(HashTable * table) {
    for (int i=0; i<table -> capacity; i++) {
        Node * current = table -> buckets[i];
        while (current != NULL) {
            Node * tmp = current;
            current = current -> next;
            free(tmp);
        }
    }
    free(table->buckets);
    free(table);
}

int main() {
    int N, M;

    HashTable * table = CreateHashTable();

    scanf("%d", &N);

    for (int i=0; i<N; i++) {
        int element;
        scanf("%d", &element);
        Insert(table, element);
    }

    scanf("%d", &M);

    for (int i=0; i<M; i++) {
        int element;
        scanf("%d", &element);
        printf("%d\n", Search(table, element));
    }

    FreeHashTable(table);
    return 0;
}