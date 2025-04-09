#include <stdio.h>
#include <stdlib.h>
typedef struct BSTNode {
  int key;
  struct BSTNode* left;
  struct BSTNode* right;
} BSTNode;

BSTNode* CreateNode(int key) {
  BSTNode* new_node = (BSTNode*)malloc(sizeof(BSTNode));
  if (new_node == NULL) {
    printf("Memory allocation failed in function CreateNode"); // 메모리 꽉참
    exit(1);
  }

  new_node->key = key;
  new_node->left = NULL;
  new_node->right = NULL;
  return new_node;
}

BSTNode* Insert(BSTNode* root, int key) {
  if (root == NULL)
    return CreateNode(key);

  if (key < root->key) {
    root -> left = Insert(root->left, key);
  }

  else if (key > root->key) {
    root->right =  Insert(root->right, key);
  }
  return root;
}

int Search(BSTNode* root, int key) {
  if (root == NULL)
    return 0;

  if (root->key == key)
    return 1;

  if (key > root->key)
    return Search(root->right, key);

  return Search(root->left, key);
}

int CountNodes(BSTNode* root) {
  if (root == NULL)
    return 0;

  return 1 + CountNodes(root->left) + CountNodes(root->right);
}

void FreeTree(BSTNode* root) {
    if (root == NULL) {
      return;
    }
    FreeTree(root->left);
    FreeTree(root->right);
    free(root);

}


int main() {
    int a_len;
    int b_len;

    BSTNode* set_a = NULL;
    BSTNode* set_b = NULL;

    scanf("%d %d", &a_len, &b_len);

    // 여기에 배열을 사용하는 코드를 추가
    for(int i=0; i<a_len; i++) {
      int a;
      scanf("%d", &a);
      set_a = Insert(set_a, a);
    }

    int in_both_sets = 0; // 공집합 개수

    for (int i = 0; i < b_len; i++) {
        int b; //
        scanf("%d", &b);

        if (Search(set_a, b) == 1) { // set_a의 b의 요소가 있을 때,
          in_both_sets++;
        }
        else{
            set_b = Insert(set_b, b); // B-A 차집합
        }
    }

    int only_in_a = CountNodes(set_a) - in_both_sets; // A-B 차집합
    int only_in_b = CountNodes(set_b); // B-A 차집합

    printf("%d\n", only_in_a+only_in_b); // 결과값 출력

    FreeTree(set_a); // 메모리 없애주기
    FreeTree(set_b);
    return 0;
}