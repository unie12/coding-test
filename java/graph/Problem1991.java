package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Problem1991 {
    static class Node {
        char data;
        Node left;
        Node right;

        Node(char data) {
            this.data = data;
        }
    }

    static Node[] tree = new Node[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String val = br.readLine();
            char data = val.charAt(0);
            char left = val.charAt(2);
            char right = val.charAt(4);

            if (tree[data - 'A'] == null) {
                tree[data - 'A'] = new Node(data);
            }

            if (left != '.') {
                tree[data - 'A'].left = new Node(left);
                tree[left - 'A'] = tree[data - 'A'].left;
            }

            if (right != '.') {
                tree[data - 'A'].right = new Node(right);
                tree[right - 'A'] = tree[data - 'A'].right;
            }
        }

        preorder(tree[0]);
        System.out.println();
        inorder(tree[0]);
        System.out.println();
        postorder(tree[0]);
    }
    
    static void preorder(Node node) {
        if (node == null) return; 

        System.out.print(node.data);
        preorder(node.left);
        preorder(node.right);
    }

    static void inorder(Node node) {
        if (node == null) return; 

        inorder(node.left);
        System.out.print(node.data);
        inorder(node.right);
    }

    static void postorder(Node node) {
        if (node == null) return; 

        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data);
        
    }
}
