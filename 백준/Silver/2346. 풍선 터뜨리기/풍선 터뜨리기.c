#include <stdio.h>    // 표준 입출력 함수를 사용하기 위한 헤더파일
#include <stdlib.h>   // malloc, free 등 메모리 관리 함수를 사용하기 위한 헤더파일
#include <string.h>   // 문자열 처리 함수를 사용하기 위한 헤더파일 (현재 코드에서는 사용되지 않음)

// 이중 연결 리스트의 노드 구조체 정의
typedef struct Node {
    int number;       // 풍선의 번호 (1부터 N까지)
    int value;        // 풍선 안에 들어있는 값 (이동할 스텝 수)
    struct Node *next; // 다음 노드를 가리키는 포인터
    struct Node *prev; // 이전 노드를 가리키는 포인터 (주석: Ndoe를 Node로 수정)
} Node;

int main() {
    int N;            // 풍선의 개수
    scanf("%d", &N);  // 풍선의 개수 입력받기
    
    // 연결 리스트의 시작과 끝 포인터 초기화
    struct Node *head = NULL;  // 리스트의 시작 노드를 가리키는 포인터
    struct Node *tail = NULL;  // 리스트의 마지막 노드를 가리키는 포인터
    int value;                 // 풍선 안에 들어있는 값을 저장할 변수
    
    // 원형 이중 연결 리스트 구성
    for (int i = 1; i <= N; i++) {
        scanf("%d", &value);   // 각 풍선에 들어있는 값 입력받기
        
        // 새 노드 생성 및 메모리 할당
        struct Node *new_node = (struct Node*)malloc(sizeof(struct Node));
        if (new_node == NULL) {
            printf("Memory allocation faild\n");  // 메모리 할당 실패 시 오류 메시지 출력
            exit(1);                              // 프로그램 종료 (오류 코드 1)
        }
        
        // 새 노드 초기화
        new_node->number = i;     // 풍선 번호 설정 (1부터 N까지)
        new_node->value = value;  // 풍선 안의 값 설정
        
        // 첫 번째 노드인 경우
        if (head == NULL) {
            head = new_node;                // head가 첫 번째 노드를 가리키게 함
            tail = new_node;                // tail도 첫 번째 노드를 가리키게 함
            new_node->next = new_node;      // 자기 자신을 가리키도록 설정 (원형 리스트)
            new_node->prev = new_node;      // 자기 자신을 가리키도록 설정 (원형 리스트)
        } else {
            // 리스트의 끝에 새 노드 추가
            new_node->prev = tail;          // 새 노드의 이전 포인터가 현재 tail을 가리킴
            new_node->next = head;          // 새 노드의 다음 포인터가 head를 가리킴 (원형 리스트)
            tail->next = new_node;          // 현재 tail의 다음 포인터가 새 노드를 가리킴
            head->prev = new_node;          // head의 이전 포인터가 새 노드를 가리킴 (원형 리스트)
            tail = new_node;                // tail 업데이트
        }
    }
    
    // 풍선 터뜨리기 시작
    struct Node *current = head;  // 현재 처리할 노드 포인터 (처음에는 head)
    for (int i = 0; i < N; i++) {
        // 현재 터뜨릴 풍선 번호 출력
        printf("%d ", current->number);
        
        if (i == N-1) {
            // 마지막 풍선인 경우 종료
            break;
        }
        
        // 현재 풍선의 이동 값 저장 및 다음/이전 노드 참조 저장 (노드 제거 전에)
        int move_steps = current->value;              // 이동할 스텝 수
        struct Node *next_node = current->next;       // 다음 노드 포인터
        struct Node *prev_node = current->prev;       // 이전 노드 포인터
        
        // 현재 노드를 리스트에서 제거
        if (current->next == current) {
            // 남은 노드가 하나뿐인 경우
            head = NULL;  // 리스트가 비어있게 됨
        } else {
            // 이전 노드와 다음 노드를 서로 연결하여 현재 노드 제거
            next_node->prev = prev_node;  // 다음 노드의 이전 포인터가 이전 노드를 가리킴
            prev_node->next = next_node;  // 이전 노드의 다음 포인터가 다음 노드를 가리킴
            
            // 현재 노드가 head인 경우 head 업데이트
            if (current == head) {
                head = next_node;
            }
        }
        
        // 메모리 해제를 위해 현재 노드 저장
        struct Node *to_delete = current;
        
        // 다음에 터뜨릴 풍선 찾기
        if (move_steps > 0) {
            // 양수인 경우 시계 방향(다음 노드)으로 이동
            current = next_node;  // 일단 한 칸 이동
            // 추가로 (move_steps - 1)번 더 이동
            for (int j = 1; j < move_steps; j++) {
                current = current->next;
            }
        } else {
            // 음수인 경우 반시계 방향(이전 노드)으로 이동
            current = prev_node;  // 일단 한 칸 이동
            // 추가로 (|move_steps| - 1)번 더 이동
            for (int j = 1; j < -move_steps; j++) {
                current = current->prev;
            }
        }
        
        // 제거된 노드의 메모리 해제
        free(to_delete);
    }
    
    // 프로그램 종료 전 남은 노드 메모리 해제 (마지막 풍선)
    if (head != NULL) {
        free(head);
    }
    
    return 0;  // 프로그램 정상 종료
}
