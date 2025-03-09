tree={}
str1 = []
str2 = []
str3 = []

class Node:
    def __init__(self, item, left, right):
        self.item=item
        self.left=left
        self.right=right

def preorder(node):
    if node.item!='.': str1.append(node.item)
    if node.left != '.': preorder(tree[node.left])
    if node.right != '.': preorder(tree[node.right])

def inorder(node):
    if node.left != '.': inorder(tree[node.left])
    if node.item!='.': str2.append(node.item)
    if node.right != '.': inorder(tree[node.right])

def postorder(node):
    if node.left != '.': postorder(tree[node.left])
    if node.right != '.': postorder(tree[node.right])
    if node.item!='.': str3.append(node.item)

n=int(input())
for i in range(n):
    p , l, r = map(str, input().split())
    tree[p]=Node(p, l, r)

preorder(tree['A'])
inorder(tree['A'])
postorder(tree['A'])

for i in str1:
    print(i, end='')
print()
for i in str2:
    print(i, end='')
print()
for i in str3:
    print(i, end='')