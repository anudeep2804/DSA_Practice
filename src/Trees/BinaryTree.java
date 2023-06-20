package Trees;

import java.util.Scanner;

public class BinaryTree {

    public static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value){
            this.value=value;
        }
    }

    Node root;

    public void populate(Scanner scanner){
        System.out.println("Enter the value of root node");
        int value= scanner.nextInt();
        root = new Node(value);
        populateChild(scanner , root);
    }

    public void populateChild(Scanner scanner , Node node){
        System.out.println("Do you want to Enter left of "+ node.value);
        boolean left = scanner.nextBoolean();
        if(left){
            System.out.println("Enter the value for left of "+ node.value);
            node.left = new Node(scanner.nextInt());
            populateChild(scanner,node.left);
        }

        System.out.println("Do you want to Enter Right of "+ node.value);
        boolean right = scanner.nextBoolean();
        if(right){
            System.out.println("Enter the value for Right of "+ node.value);
            node.right = new Node(scanner.nextInt());
            populateChild(scanner,node.right);
        }
    }

    public void display(){
        display(this.root,"");
    }

    public  void display(Node node, String indent){
        if(node==null){
            return;
        }
        System.out.println(indent+node.value);
        display(node.left,indent+"\t");
        display(node.right,indent+"\t");
    }

    public void prettyDisplay(){
        prettyDisplay(root,0);
    }

    public void prettyDisplay(Node node , int level){
        if(node == null) return;

        prettyDisplay(node.right, level+1);

        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|------->" + node.value);
        }
        else {
            System.out.println(node.value);
        }

        prettyDisplay(node.left, level+1);
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Scanner scanner = new Scanner(System.in);
        binaryTree.populate(scanner);
        //binaryTree.display();
        binaryTree.prettyDisplay();
    }
}
