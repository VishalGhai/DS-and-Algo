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
        if(p==null) return 0;
        return 1+Math.max(height(p.left), height(p.right));
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

    static int max_level=0;

    static void leftView(node n){
        Queue<node> q = new LinkedList<node>();
        q.add(n);
        while (!q.isEmpty()) {
            // q.add(n.left);
            int size=q.size();
            for(int i=0;i<size;i++){
                node temp=q.remove();
                if(i==0)
                System.out.println(temp.data);
                if(temp.left!=null)
                q.add(temp.left);
                if(temp.right!=null)
                q.add(temp.right);
            }
        }
    }

    static void leftViewRecursive(node n,int level){
        if(n==null) return;
        if(max_level<level){
            System.out.println(n.data);
            max_level = level;
        }
        leftViewRecursive(n.left,level+1);
        leftViewRecursive(n.right,level+1);

    }

    static void rightView(node n){
        Queue<node> q = new LinkedList<node>();
        q.add(n);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                node temp=q.remove();
                if(i==size-1)
                System.out.println(temp.data);
                if(temp.left!=null)
                q.add(temp.left);
                if(temp.right!=null)
                q.add(temp.right);
            }
        }
    }

    static void rightViewRecursive(node n,int level) {
        if(n==null) return;
        if(max_level<level) {
            System.out.println(n.data);
            max_level=level;
        }
        rightViewRecursive(n.right,level+1);
        rightViewRecursive(n.left,level+1);
    }

    static Map<Integer, Integer> topmap=new TreeMap<Integer, Integer>();
    static void topView(node n,int level){
        if(n==null) return;
        if(!topmap.containsKey(level))
        topmap.put(level,n.data);
        if(n.left!=null&&!(topmap.containsKey(level-1)))
        topmap.put(level-1,n.left.data);
        if(n.right!=null&&!(topmap.containsKey(level+1)))
        topmap.put(level+1,n.right.data);
        topView(n.left,level-1);
        topView(n.right,level+1);
    }

    // Vertical Order View of the Tree
    static void VerticalView(node n){
        Queue<node> q = new LinkedList<node>();
        HashMap<node,Integer> verticalDistances = new HashMap<node,Integer>();
        Map<Integer,ArrayList<node>> m = new TreeMap<Integer,ArrayList<node>>();
        q.add(n);
        verticalDistances.put(n,0);
        m.put(verticalDistances.get(n),new ArrayList<node>());
        m.get(verticalDistances.get(n)).add(n);
        while(!q.isEmpty()){
            node temp=q.poll();
            if(temp.left!=null){
                q.add(temp.left);
                verticalDistances.put(temp.left,verticalDistances.get(temp)-1);
                if(!m.containsKey(verticalDistances.get(temp.left))) m.put(verticalDistances.get(temp.left),new ArrayList<node>());
                m.get(verticalDistances.get(temp.left)).add(temp.left);
            }
            if(temp.right!=null){
                q.add(temp.right);
                verticalDistances.put(temp.right,verticalDistances.get(temp)+1);
                if(!m.containsKey(verticalDistances.get(temp.right))) m.put(verticalDistances.get(temp.right),new ArrayList<node>());
                m.get(verticalDistances.get(temp.right)).add(temp.right);
            }
        }
        for(int key:m.keySet()){
            for(node k:m.get(key)){
                System.out.print(k.data+" ");
            }
            System.out.println();
        }
    }

    static Map<Integer, Integer> bottommap = new TreeMap<Integer, Integer>();
    static void bottomView(node n,int level){
        if(n==null) return;
        bottommap.put(level,n.data);
        if(n.left!=null)
        bottommap.put(level-1,n.left.data);
        if(n.right!=null)
        bottommap.put(level+1,n.right.data);
        bottomView(n.right,level+1);
        bottomView(n.left,level-1);
    }

    static Map<Integer,Integer> inpre= new TreeMap<Integer,Integer>();
    static int pre_ind=0;
    static node treeFromInPre(int[] pre,int start,int end){
        if(start>end) return null;
        node root = new node(pre[pre_ind]);
        int ind=inpre.get(pre[pre_ind]);
        pre_ind++;
        root.left = treeFromInPre(pre,start,ind-1);
        root.right = treeFromInPre(pre,ind+1,end);
        return root;
    }

    static int prepost=0;
    static node treeFromPrePost(int[] pre,int[] post,int l,int h,int size){
        if(prepost>=size||l>h)
        return null;
        node root=new node(pre[prepost]);
        prepost++;
        if(l==h||prepost>=size)
        return root;
        int i;
        for(i=l;i<=h;i++){
            if(post[i]==pre[prepost])
            break;
        }
        if(i<=h){
            root.left=treeFromPrePost(pre,post,l,i,size);
            root.right=treeFromPrePost(pre,post,i+1,h,size);
        }
        return root;
    }

    static Map<Integer, Integer> inpost = new TreeMap<Integer, Integer>();
    static int post_ind = 0;
    static node treeFromInPost(int[] post, int start, int end){
        if(start>end) return null;
        node root = new node(post[post_ind]);
        int ind=inpost.get(post[post_ind]);
        post_ind--;
        root.right = treeFromInPost(post,ind+1,end);
        root.left = treeFromInPost(post,start,ind-1);
        return root;
    }


    //MAXIMUM DIAMETER OF IN THE TREE
    static int max_diameter=Integer.MIN_VALUE;
    static int MaxDiameter(node root){
        if(root==null) return 0;
        int l=MaxDiameter(root.left);
        int r=MaxDiameter(root.right);
        int temp=Math.max(l,r)+1;
        int ans=Math.max(temp,l+r+1);
        max_diameter=Math.max(max_diameter,ans);
        return temp;
    }

    //MAXIMUM SUM PATH IN THE TREE
    static int max_path_sum=Integer.MIN_VALUE;
    static int MaxPathSum(node root){
        if(root==null) return 0;
        int l=MaxPathSum(root.left);
        int r=MaxPathSum(root.right);
        int temp=Math.max(Math.max(l,r)+root.data,root.data);
        int ans=Math.max(temp,l+r+root.data);
        max_path_sum=Math.max(max_path_sum,ans);
        return temp;
    }

    //MAXIMUM SUM PATH OF THE TREE FROM ONE LEAF NODE TO ANOTHER
    static int max_path_sum_from_leaf_to_leaf=Integer.MIN_VALUE;
    static int MaxPathSumFromLeafToLeaf(node root){
        if(root==null) return 0;
        int l=MaxPathSum(root.left);
        int r=MaxPathSum(root.right);
        int temp=Math.max(l,r)+root.data;
        if(root.left==null&&root.right==null) temp=Math.max(temp,root.data);
        int ans=Math.max(temp,l+r+root.data);
        max_path_sum_from_leaf_to_leaf=Math.max(max_path_sum_from_leaf_to_leaf,ans);
        return ans;
    }
    public static void main(String[] args) {
        addNode(-40,root);
        addNode(30,root);
        addNode(20,root);
        addNode(-10,root);
        addNode(50,root);
        addNode(-60,root);

        
        int[] inorder = new int[]{10,20,30,40,50,60};
        int[] preorder = new int[]{40,30,20,10,50,60};
        int[] postorder = new int[]{10,20,30,60,50,40};
        
        for(int i=0;i<inorder.length;i++){
            inpre.put(inorder[i],i);
            inpost.put(inorder[i],i);
        }
        
        post_ind=postorder.length-1;
        
        node treefrominpost=treeFromInPost(postorder,0,postorder.length-1);
        node treefrominpre=treeFromInPre(preorder,0,preorder.length-1);
        node treefromprepost=treeFromPrePost(preorder,postorder,0,preorder.length-1,preorder.length);
        
        // Inorder traversal of the tree
        inOrder(root);

        // Maximum diameter in the tree
        MaxDiameter(root);
        System.out.println(max_diameter);
        
        // maximum sum path in the tree
        MaxPathSum(root);
        System.out.println(max_path_sum);
        
        // max sum path from one leaf to another leaf only.
        MaxPathSumFromLeafToLeaf(root);
        System.out.println(max_path_sum_from_leaf_to_leaf);
        
        // Vertical order view of the tree
        System.out.println("vertical view : ");
        VerticalView(root);
    }
}