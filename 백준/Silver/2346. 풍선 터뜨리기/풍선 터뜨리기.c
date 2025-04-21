#include <stdio.h>
#include <stdlib.h>
typedef struct Node {
    int data;
    int number;
    struct Node * next;
    struct Node * prev;
} Node;

int main(void) {
    int n;

    scanf("%d", &n);

    Node * head = NULL;
    Node * tail = NULL;
    for (int i=0; i<n; i++) {
        int element;
        scanf("%d", &element);

        Node * new_node = (Node *)malloc(sizeof(Node));
        new_node -> data = i+1;
        new_node -> number = element;

        if (head == NULL) {
            new_node -> next = new_node;
            new_node -> prev = new_node;
            head = new_node;
            tail = new_node;
        }
        else {
            new_node -> prev = tail;
            new_node -> next = head;

            head->prev = new_node;
            tail -> next = new_node;
            tail = new_node;
        }
    }

    //pop ballons
    struct Node * current = head;
    for (int i=0; i<n; i++) {
        // print current balloon number
        printf("%d ", current->data);
        if (i == n-1)
            break;
        // store move_steps
        int move_steps = current -> number;
        struct Node *next_node = current->next;
        struct Node *prev_node = current->prev;

        //Remove current node from the list
        next_node -> prev = prev_node;
        prev_node -> next = next_node;


        // Update head if removing the head
        if (current == head) {
            head = next_node;
        }

        Node * deletion = current;
        if (move_steps > 0) {
            for (int i=0; i<move_steps; i++) {
                current = current -> next;
            }
        } else {
            move_steps = -1 * move_steps;
            for (int i=0; i<move_steps; i++) {
                current = current -> prev;
            }
        }
        // delete node
        free(deletion);
    }
    if (head != NULL) {
        free(head);
    }

    return 0;
}