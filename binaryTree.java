class Node {
        int data;
        Node left,right;
        public Node(int data){
            this.data = data;
        }
        public int root(){
            return data;
        }
        public void insert(int value){
            if(value <= data){
                if(left == null){
                    left = new Node(value);    
                }
                else{
                    left.insert(value);
                }
                
            }
            else{
                if(right == null){
                    right = new Node(value);    
                }
                else{
                    right.insert(value);
                }
            }
        }
        
        public boolean contains(int value){
            if(value == data){
                return true;
            }
            else if(value <= data) {
                if(left == null){
                    return false;
                }
                return left.contains(value);
            }
            else {
                if(right == null){
                    return false;
                }
                return right.contains(value);
            }
        }
        //Inorder print left,parent,right
        //pre-order print parent,left,right
        //post-order print left,right,parent
        public void printInOrder(){
            if(left != null){
                left.printInOrder();
            }
            System.out.print(data+" ");
            if(right != null){
                right.printInOrder();
            }
        }
        public void printPreOrder(){
            System.out.print(data+" ");
            if(left != null){
                left.printInOrder();
            }
            if(right != null){
                right.printInOrder();
            }
        }
        public void printPostOrder(){
            if(left != null){
                left.printInOrder();
            }
            if(right != null){
                right.printInOrder();
            }
            System.out.print(data+" ");
        }
    }
class binaryTree{
    Node root;
    binaryTree(){
        root = null;
    }
    public void insert(int value){
        if(root == null){
            root = new Node(value);
        }else{
            root.insert(value);    
        }
        
    }
    public Node findNode(Node node,int value){
        if(value == node.data){
            return node;
        }
        else if(value <= node.data){
            if(node.left == null){
                return null;
            }
            return findNode(node.left,node.left.data);
        }
        else if(value > node.data){
            if(node.right == null){
                return null;
            }
            return findNode(node.right,node.right.data);
        }
        else{
            return null;
        }
    }
    public void binaryTreeDelete(int value){
        root = deleteNode(root,value);
    }
    public Node deleteNode(Node node,int value){
        if(node == null){
            return node;
        }
        if (value < node.data){
            node.left = deleteNode(node.left,value);
        }
        else if (value > node.data){
            node.right = deleteNode(node.right,value);
        }
        
        else{
            if(node.left == null){
                return node.right;
            }
            else if (node.right == null){
                return node.left;
            }
        }
        return node;
    }
    private int sumBinaryTree(Node node){
        if(node == null){
            return 0;
        }
        return node.data + sumBinaryTree(node.left) + sumBinaryTree(node.right);
    }
    public void showSum(){
        System.out.println(sumBinaryTree(root));
    }
}

class HelloWorld {
    public static void showNode(Node node){
        node.printInOrder();
        System.out.println();
        node.printPreOrder();
        System.out.println();
        node.printPostOrder();
    }
    public static void main(String[] args) {
        int[] treeArr = {50,0 ,4 ,17 ,28 ,37 ,41 ,45 ,54 ,61 ,67 ,84 ,97};
        System.out.println("Binary Tree Experimental.");
        binaryTree tree = new binaryTree();
        System.out.println();
        for(int i = 0;i<12;i++){
            tree.insert(treeArr[i]);
        }

        Node rootNode = tree.findNode(tree.root,tree.root.data);
        tree.binaryTreeDelete(37);
        showNode(tree.root);
        
        
        tree.showSum();
        
        //tree.deleteNode(0);
        
    }

}
