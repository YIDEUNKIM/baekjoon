#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// linked list Node
typedef struct Node {
    int number; // Ballon number
    int value; // Value inside the ballon
    struct Node * next;
    struct Node * prev; // Ndoe를 Node로 수정
} Node;

int main() {
    int N;
    scanf("%d", &N);
    
    // Create the first node
    struct Node *head = NULL;
    struct Node *tail = NULL;

    int value;
    // build the circulatar doubly linked list
    for (int i = 1; i <= N; i++) {
        scanf("%d", &value);

        //create new node
        struct Node *new_node = (struct Node*)malloc(sizeof(struct Node));
        if (new_node == NULL) {
            printf("Memory allocation faild\n");
            exit(1);
        }

        new_node -> number = i;
        new_node -> value = value;

        // First node case
        if (head == NULL) {
            head = new_node;
            tail = new_node;
            new_node->next = new_node;
            new_node -> prev = new_node;
        } else {
            // addt to end of list
            new_node -> prev = tail;
            new_node -> next = head;
            tail -> next = new_node;
            head -> prev = new_node;
            tail = new_node;
        }
    }

    // pop ballons
    struct Node *current = head;

    for (int i = 0; i < N; i++) {
        // print current ballon number
        printf("%d ", current -> number);

        if (i == N-1) {
            // last ballon
            break;
        }

        // Store move value and get next node references before removing
        int move_steps = current->value;
        struct Node *next_node = current->next;
        struct Node *prev_node = current->prev;
        
        // Remove current node from the list
        if (current->next == current) {
            // Only one node left
            head = NULL;
        } else {
            next_node->prev = prev_node;
            prev_node->next = next_node;
            
            // Update head if removing the head
            if (current == head) {
                head = next_node;
            }
        }
        
        // 변수 선언 위치 수정
        struct Node *to_delete = current;

        // find the next balloon to pop
        if (move_steps > 0) {
            current = next_node;

            // Move forward (move_steps - 1) more times
            for (int j = 1; j < move_steps; j++) {
                current = current -> next;
            }
        } else {
            current = prev_node;
            // Move backward (abs(move_steps) - 1) more times
            for (int j = 1; j < -move_steps; j++) {
                current = current->prev;
            }
        }
        
        free(to_delete);
    }

    if (head != NULL){
        free(head);
    }
    return 0;
}