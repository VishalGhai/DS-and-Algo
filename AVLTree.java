import java.util.Scanner;

class node{
    static int data;
    static int height;
    static node left;
    static node right;

    node(int d) {
        data = d;
        left = null;
        right = null;
        height = 1;
    }
}

class AVLTree {
    node root;

    int height(node n) {
        if (n == null)
            return 0;
        return n.height;
    }

    int balance(node n) {
        if (n == null)
            return 0;
        return height(n.left) - height(n.right);
    }

    node leftRotate(node x) {
        node y = x.right;
        node temp = y.left;
        y.left = x;
        x.right = temp;
        x.height = Math.max(height(x.left), height(x.right))+1;
        y.height = Math.max(height(y.left), height(y.right))+1;
        return y;
    }

    node rightRotate(node x) {
        node y = x.left;
        node temp = y.right;
        y.right = x;
        x.left = temp;
        x.height = Math.max(height(x.left), height(x.right))+1;
        y.height = Math.max(height(y.left), height(y.right))+1;
        return y;
    }

    node insert(node n, int key) {
        if (n == null)
            return (new node(key));
        if (key < node.data)
            node.left = insert(n.left, key);
        else if (key > node.data)
            node.right = insert(n.right, key);
        else
            return n;
        node.height = 1 + Math.max(height(node.left), height(node.right));
        int balance=balance(n);


        //LEFT LEFT CASE
        if(balance>1&&key<node.left.data){
            return rightRotate(n);
        }
        //RIGHT RIGHT CASE
        if(balance<-1&&key>node.right.data){
            return leftRotate(n);
        }
        //LEFT RIGHT CASE
        if(balance>1&&key>node.left.data){
            n.left = leftRotate(n.left);
            return rightRotate(n);
        }
        //RIGHT LEFT CASE
        if(balance<-1&&key>node.right.data){
            node.right = rightRotate(n.right);
            return leftRotate(n);
        }
        return n;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        AVLTree tree=new AVLTree();
        tree.root=tree.insert(tree.root,10);
        tree.root=tree.insert(tree.root,20);
        tree.root=tree.insert(tree.root,30);
        tree.root=tree.insert(tree.root,40);
        tree.root=tree.insert(tree.root,50);
        tree.root=tree.insert(tree.root,25);
        System.out.println(tree.root.data);
        System.out.println(tree.root.left.data);
        System.out.println(tree.root.left.left.data);
        System.out.println(tree.root.right.data);
        System.out.println(tree.root.right.left.data);
        System.out.println(tree.root.right.right.data);
    }
}