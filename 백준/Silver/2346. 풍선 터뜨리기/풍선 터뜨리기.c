#include <stdio.h>
#include <stdlib.h>
typedef struct Node {
    int number;
    int value;
    struct Node * next;
    struct Node * prev;
} Node;

int main() {
    int n;
    scanf("%d", &n);

    Node * head = NULL;
    Node * tail = NULL;

    for (int i=0; i<n; i++) {
        int number;
        scanf("%d", &number);

        Node * new_node = (Node*)malloc(sizeof(Node));

        new_node -> number = i+1;
        new_node -> value = number;
        if (head == NULL) {
            new_node -> next = new_node;
            new_node -> prev = new_node;
            head = new_node;
            tail = new_node;
        } else {
            new_node -> next = head;
            new_node -> prev = tail;
            head -> prev = new_node;
            tail -> next = new_node;
            tail = new_node;
        }
    }

    Node * current = head;
    // pop ballon
    for (int i=0; i<n; i++) {
        // print
        printf("%d ", current -> number);
        if (i == n-1)
            break;

        Node * next_node = current->next;
        Node * prev_node = current -> prev;
        // store next move_step & remove node from list
        int move_step = current -> value;
        next_node -> prev = prev_node;
        prev_node -> next = next_node;

        // search node
        Node * dele = current;
        if (move_step > 0) {
            for (int j=0; j<move_step; j++) {
                current = current -> next;
            }
        } else {
            for (int j=0; j<-move_step; j++) {
                current = current -> prev;
            }
        }
        free(dele);
    }

    return 0;
}