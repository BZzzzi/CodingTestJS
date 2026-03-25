package BeakJoon_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon_5639 {
    static class Node{
        int node;
        Node left, right;

        public Node(int node){
            this.node = node;
        }

        public void insert(int newNode){
            if(newNode < this.node){
                if(this.left == null){
                    this.left = new Node(newNode);
                } else{
                    this.left.insert(newNode);
                }
            } else{
                if(this.right == null){
                    this.right = new Node(newNode);
                } else{
                    this.right.insert(newNode);
                }
            }
        }
    }

    static void result(Node node){
        if(node == null) return;
        result(node.left);
        result(node.right);
        System.out.println(node.node);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line;
        Node root = null;

        while((line = bf.readLine()) != null && !line.isEmpty()){
            int node = Integer.parseInt(line);
            if (root == null){
                root = new Node(node);
            } else{
                root.insert(node);
            }
        }
        result(root);
    }
}



