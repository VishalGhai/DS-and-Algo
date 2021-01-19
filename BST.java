import java.util.*;

public class BST {
    
    static node root;  //ROOT NODE
    int height=0;  //TO FIND HEIGHT OF THE TREE

    static class node{
        int data;
        node left,right;
        node(int n){
            data=n;
            left=right=null;
        }
    }

    //ADD NODE METHOD

    static void addNode(int k,node p){
        node n=new node(k);
        if(p==null){
            root=n;
        }else if(p.left==null||p.right==null){
            if(k<p.data&&p.left==null)
                p.left=n;
            else if(k<p.data&&p.left!=null)
                addNode(k,p.left);
            else if(k>p.data&&p.right==null)
                p.right=n;
            else if(k>p.data&&p.right!=null)
                addNode(k,p.right);
        }else{
            if(k<p.data)
                addNode(k,p.left);
            else
                addNode(k,p.right);
        }

    }

    //DELETE NODE METHOD

    static void deleteNode(int k,node p){
        if(p==null){
            System.out.println("node doesn't exist");
            return;
        }
        if(p.left!=null&&p.left.left==null)
            if(p.left.data==k){
            p.left=null;
            return;
        }
        if(p.right!=null&&p.right.left==null)
            if(p.right.data==k){
            p.right=p.right.right;
            return;
        }
        if(k<p.data)
            deleteNode(k,p.left);
        else if(k>p.data)
            deleteNode(k,p.right);
        else if(k==p.data){
            node traverse = p;
            if(traverse.left.right==null){
                traverse.data=traverse.left.data;
                traverse.left=traverse.left.left;
                return;
            }
            traverse=traverse.left;
            while(traverse.right.right!=null){
                traverse=traverse.right;
            }
            p.data=traverse.right.data;
            traverse.right=traverse.right.right;
        
        }
        }
        
    //FIND NODE METHOD

    static void findNode(int n,node p){
        if(p==null){
            System.out.println("node doesn't exist");
            return;
        }
        if(n<p.data)
            findNode(n,p.left);
        else if(n>p.data)
            findNode(n,p.right);
        else if(n==p.data)
            System.out.println("node exists");
        
    }

    //METHOD TO FIND HEIGHT

    static int height(node p){
        if(p==null){
            return 0;
        }
        if(height(p.left)>height(p.right))
        return height(p.left)+1;
        else
        return height(p.right)+1;
    }

    //PRE-ORDER TRAVERSAL

    static void preOrder(node n){
        if(n==null)
            return;
        System.out.println(n.data);
        preOrder(n.left);
        preOrder(n.right);
    }

    //POST-ORDER TRAVERSAL

    static void postOrder(node n){
        if(n==null)
            return;
        postOrder(n.left);
        postOrder(n.right);
        System.out.println(n.data);
    }

    //IN-ORDER TRAVERSAL

    static void inOrder(node n){
        if(n==null)
            return;
        inOrder(n.left);
        System.out.println(n.data);
        inOrder(n.right);
    }

    //LEVEL ORDER TRAVERSAL

    static void levelOrder(node n,int i){
        if(n==null)
        return;
        else if(i==0)
        System.out.println(n.data);
        else if(i>0){
        levelOrder(n.left,i-1);
        levelOrder(n.right,i-1);
        }

    }

    //LEVEL ORDER TRAVERSAL USING QUEUE

    static void levelOrderQueue(node n){
        Queue<node> q = new LinkedList<node>();
        q.add(n);
        while(!q.isEmpty()){
            node temp=q.poll();
            System.out.println(temp.data);
            if(temp.left!=null)
            q.add(temp.left);
            if(temp.right!=null)
            q.add(temp.right);
        }

    }

    public static void main(String[] args) {
        addNode(50,root);
        addNode(60,root);
        addNode(40,root);
        addNode(30,root);
        addNode(33,root);
        addNode(20,root);
        addNode(45,root);
        addNode(43,root);
        addNode(48,root);
        addNode(55,root);
        addNode(53,root);
        addNode(57,root);
        addNode(65,root);
        addNode(70,root);
        addNode(63,root);
        inOrder(root);
    }
}