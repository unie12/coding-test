package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Problem5639 {
    static class Node {
        int data;
        Node left;
        Node right;
        
        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> preorder = new ArrayList<>();
        String input;

        while ((input = br.readLine()) != null && !input.equals("")) {
            preorder.add(Integer.parseInt(input));
        }

        Node root = buildTree(preorder, 0, preorder.size() - 1);

        postorder(root);
    }

    static Node buildTree(ArrayList<Integer> preorder, int start, int end) {
        if (start > end) return null;

        Node root = new Node(preorder.get(start));

        int i = start + 1;
        while (i <= end && preorder.get(i) < root.data) {
            i++;
        }

        root.left = buildTree(preorder, start + 1, i - 1);
        root.right = buildTree(preorder, i, end);

        return root;
    }

    static void postorder(Node root) {
        if (root == null) return;

        postorder(root.left);
        postorder(root.right);
        System.out.println(root.data);
    }
}
