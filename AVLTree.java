import java.util.Scanner;
//STRUCTURE OF NODE OF THE TREE
class node{
    int data,height;
    node left,right;

    node(int d) {
        data = d;
        left = right = null;
        height = 1;
    }
}

class AVLTree {
    
    //ROOT NODE OF THE TREE
    node root;

    //FUNCTION TO FIND HEIGHT OF THE TREE
    int height(node n) {
        if (n == null)
            return 0;
        return n.height;
    }

    //FIND BALANCE(DIFFERENCE OF HEIGHT) BETWEEN LEFT AND RIGHT SUB-TREES.
    int balance(node n) {
        if (n == null)
            return 0;
        return height(n.left) - height(n.right);
    }

    // ROTATE THE NODES TO THE LEFT
    //         x                   y
    //        /                   / \ 
    //       y         ==>       z   x 
    //      / \                     /
    //     z   a                   a

    node leftRotate(node x) {
        node y = x.right;
        node temp = y.left;
        y.left = x;
        x.right = temp;
        x.height = Math.max(height(x.left), height(x.right))+1;
        y.height = Math.max(height(y.left), height(y.right))+1;
        return y;
    }

    // ROTATE THE NODES TO THE RIGHT
    //         x                     y
    //         \                    / \ 
    //          y         ==>      x   z 
    //        / \                   \
    //       a   z                   a
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
        if (key < n.data)
            n.left = insert(n.left, key);
        else if (key > n.data)
            n.right = insert(n.right, key);
        else
            return n;
        n.height = 1 + Math.max(height(n.left), height(n.right));
        
        //GET BALANCE OF EACH NODE
        int balance=balance(n);
        
        
        //LEFT LEFT CASE
        //        x
        //       /
        //      y 
        //     /  
        //    z   
        if(balance>1&&key<n.left.data){
            return rightRotate(n);
        }

        //RIGHT RIGHT CASE
        //        x
        //         \
        //          y 
        //           \  
        //            z
        if(balance<-1&&key>n.right.data){
            return leftRotate(n);
        }

        //LEFT RIGHT CASE
         //       x
        //       /
        //      y 
        //      \  
        //       z
        if(balance>1&&key>n.left.data){
            n.left = leftRotate(n.left);
            return rightRotate(n);
        }

        //RIGHT LEFT CASE
         //        x
        //          \
        //           y 
        //          /  
        //         z
        if(balance<-1&&key<n.right.data){
            n.right = rightRotate(n.right);
            return leftRotate(n);
        }
        return n;
    }
    //PRINTING IN-ORDER OF THE TREE
    static void inOrder(node root){
        if(root==null) return;
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
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
        System.out.println(tree.root.data);              //30
        System.out.println(tree.root.left.data);         //20
        System.out.println(tree.root.left.left.data);    //10
        System.out.println(tree.root.left.right.data);   //25
        System.out.println(tree.root.right.data);        //40
        System.out.println(tree.root.right.right.data);  //50
        // AFTER ALL OPERATIONS - 
        //           30
        //          / \
        //        20  40
        //       / \   \
        //     10  25  50
    }
}