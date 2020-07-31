package datastructures.trees;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by tareqmy on 10/7/20.
 */
public class BinarySearchTree {

    enum SearchType {
        IN_ORDER,
        PRE_ORDER,
        POST_ORDER
    }

    private BinaryNode root;

    public void insert(int value) {
        if (root == null) {
            root = new BinaryNode(value);
        } else {
            BinaryNode current = root;
            while (true) {
                if (current.getValue() == value) {
                    return; //it already exists
                }

                if (current.getValue() > value) {
                    if (current.getLeft() == null) {
                        current.setLeft(new BinaryNode(value));
                        return;
                    }
                    current = current.getLeft();
                } else {
                    if (current.getRight() == null) {
                        current.setRight(new BinaryNode(value));
                        return;
                    }
                    current = current.getRight();
                }
            }
        }
    }

    public BinaryNode search(int value) {
        BinaryNode current = root;
        while (current != null) {
            if (current.getValue() > value) {
                current = current.getLeft();
            } else if (current.getValue() < value) {
                current = current.getRight();
            } else {
                return current;
            }

        }
        return null;
    }

    //NOTE: failed miserbly for long because didnt understand the requirement fully
    //copied from the solution and found edgecase missing and improved it.
    public void remove(int value) {
        if (root == null) {
            return;
        }

        BinaryNode nodeToRemove = root;
        BinaryNode parentNode = null;
        while (nodeToRemove != null && nodeToRemove.getValue() != value) { //Searching for the node to remove and it's parent
            parentNode = nodeToRemove;
            if (value < nodeToRemove.getValue()) {
                nodeToRemove = nodeToRemove.getLeft();
            } else if (value > nodeToRemove.getValue()) {
                nodeToRemove = nodeToRemove.getRight();
            }
        }
        //could not find
        if (nodeToRemove == null || nodeToRemove.getValue() != value) {
            return;
        }

        BinaryNode replacementNode = null;
        if (nodeToRemove.getLeft() != null && nodeToRemove.getRight() != null) {

            replacementNode = nodeToRemove.getRight();
            if (replacementNode.getLeft() == null) { //replacement node doesnt have left child
                replacementNode.setLeft(nodeToRemove.getLeft());
                //no need to put right of node to remove because it is the right child
            } else {
                //find the left most child starting from initial replacement child.
                BinaryNode replacementParentNode = nodeToRemove;
                while (replacementNode.getLeft() != null) {
                    replacementParentNode = replacementNode;
                    replacementNode = replacementNode.getLeft();
                }

                replacementParentNode.setLeft(replacementNode.getRight());
                replacementNode.setLeft(nodeToRemove.getLeft());
                replacementNode.setRight(nodeToRemove.getRight());
            }

        } else if (nodeToRemove.getLeft() != null) { //only left child
            replacementNode = nodeToRemove.getLeft();
        } else if (nodeToRemove.getRight() != null) { //only right child
            replacementNode = nodeToRemove.getRight();
        }

        if (parentNode == null) {
            root = replacementNode;
        } else if (parentNode.getLeft() == nodeToRemove) { //We are a left child
            parentNode.setLeft(replacementNode);
        } else { //We are a right child
            parentNode.setRight(replacementNode);
        }
    }

    public List<Integer> breathFirstSearch() {
        List<Integer> bfs = new ArrayList<>();
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);

        while (queue.size() > 0) {
            BinaryNode currentNode = queue.poll();
            bfs.add(currentNode.getValue());
            if (currentNode.getLeft() != null) {
                queue.offer(currentNode.getLeft());
            }
            if (currentNode.getRight() != null) {
                queue.offer(currentNode.getRight());
            }
        }

        System.out.println("bfs = " + bfs);
        return bfs;
    }

    public List<Integer> depthFirstSearch(SearchType searchType) {
        List<Integer> dfs = new ArrayList<>();
        depthFirstSearch(root, dfs, searchType);
        System.out.println("dfs = " + dfs);
        return dfs;
    }

    public void depthFirstSearch(BinaryNode node, List<Integer> dfs, SearchType searchType) {
        if (searchType.equals(SearchType.PRE_ORDER)) {
            dfs.add(node.getValue());
        }
        if (node.getLeft() != null) {
            depthFirstSearch(node.getLeft(), dfs, searchType);
        }
        if (searchType.equals(SearchType.IN_ORDER)) {
            dfs.add(node.getValue());
        }
        if (node.getRight() != null) {
            depthFirstSearch(node.getRight(), dfs, searchType);
        }
        if (searchType.equals(SearchType.POST_ORDER)) {
            dfs.add(node.getValue());
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(9);
        tree.insert(4);
        tree.insert(6);
        tree.insert(20);
        tree.insert(37);
        tree.insert(15);
        tree.insert(1);
        tree.insert(18);
        tree.insert(25);
        tree.insert(30);
        tree.insert(16);
        tree.printTree();
//        tree.remove(9);
//        tree.printTree();
        tree.breathFirstSearch();
        tree.depthFirstSearch(SearchType.IN_ORDER);
        tree.depthFirstSearch(SearchType.PRE_ORDER);
        tree.depthFirstSearch(SearchType.POST_ORDER);
    }

    public void printTree() {
        printTree(root, 0);
    }

    //note: using depth first on right node... with InOrder
    private void printTree(BinaryNode node, int level) {
        int nextLevel = level + 1;
        if (node.getRight() != null) {
            printTree(node.getRight(), nextLevel);
        }
        for (int i = 0; i < level; i++) {
            System.out.print("    ");
        }
        System.out.println(node.getValue());
        if (node.getLeft() != null) {
            printTree(node.getLeft(), nextLevel);
        }
    }
}
