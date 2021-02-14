import java.util.*;

public class BinaryTree {
    static node head = null;
    static class node{
        int data;
        node parent=null;
        ArrayList<node> children=new ArrayList<node>();
        node(int d){
            data=d;
        }
    }

    static void addChild(int child,int parent){
        node n=new node(child);
        if(head==null)
            head=n;
        else{
            node p=findChild(parent,head,0);
            p.children.add(n);
            n.parent=p;
        }
    }

    static node findChild(int n,node child,int index){
        
        if(child.data==n) return child;
        if(child.children.size()>index)
        return findChild(n,child.children.get(index),0);
        return findChild(n,child.parent,index+1);
    }
    static void inOrder(node n){
        if(n==null) return;
        System.out.println(n.data);
        for(int i=0;i<n.children.size();i++){
            inOrder(n.children.get(i));
        }
    }


    public static void main(String[] args) {
        addChild(1,1);
        addChild(2,1);
        addChild(3,2);
        addChild(4,2);
        addChild(5,4);
        addChild(6,4);
        addChild(7,4);
        addChild(8,3);
        addChild(9,1);
        inOrder(head);
    }
}
