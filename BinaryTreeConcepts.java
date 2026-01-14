public class BinaryTreeConcepts {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
        
    }
    static class BinaryTree {
        static int idx = -1;
        public Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
    }

    public int height(Node root){
        if(root == null){
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public int countNodes(Node root){
        if(root == null){
            return 0;
        }
        int leftCount = countNodes(root.left);
        int rightCount = countNodes(root.right);
        return leftCount + rightCount + 1;
    }

    public int sumNodes(Node root){
        if(root == null){
            return 0;
        }
        int leftSum = sumNodes(root.left);
        int rightSum = sumNodes(root.right);
        return leftSum + rightSum + root.data;
    }

    public int diameter(Node root){
        if(root == null){
            return 0;
        }
        int leftDiameter = diameter(root.left);
        int rightDiameter = diameter(root.right);
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        int selfDiameter = leftHeight + rightHeight + 1;

        return Math.max(selfDiameter, Math.max(leftDiameter, rightDiameter));
    }
    static class Info {
        int diameter;
        int height;

        Info(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
        }
    }
    public Info diameter2(Node root){
        if(root == null){
            return new Info(0, 0);
        }
        Info leftInfo = diameter2(root.left);
        Info rightInfo = diameter2(root.right);

        int selfDiameter = leftInfo.height + rightInfo.height + 1;
        int diameter = Math.max(selfDiameter, Math.max(leftInfo.diameter, rightInfo.diameter));
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;

        return new Info(diameter, height);

    }
    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println("Height of tree: " + new BinaryTreeConcepts().height(root));
        System.out.println("Total number of nodes: " + new BinaryTreeConcepts().countNodes(root));
        System.out.println("Sum of all nodes: " + new BinaryTreeConcepts().sumNodes(root));
        System.out.println("Diameter of tree: " + new BinaryTreeConcepts().diameter(root));
        System.out.println("Diameter of tree (optimized): " + new BinaryTreeConcepts().diameter2(root).diameter);
    }
}
