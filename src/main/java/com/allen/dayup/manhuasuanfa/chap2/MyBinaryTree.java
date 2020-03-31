package com.allen.dayup.manhuasuanfa.chap2;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Auther: allen
 * @Date: 2020-03-26 16:58
 * @Description:
 */
public class MyBinaryTree {

    public static TreeNode createBinaryTree(LinkedList<Integer> inputList){

        TreeNode node = null;

        if( inputList == null || inputList.isEmpty() ){
            return null;
        }

        Integer data = inputList.removeFirst();

        if( data != null ){
            node = new TreeNode(data);
            node.leftChild = createBinaryTree(inputList);
            node.rightChild = createBinaryTree(inputList);
        }

        return node;
    }

    /**
     * 先序遍历
     * @param node
     */
    public static void preOrderTravel(TreeNode node){
        if( node == null ){
            return;
        }

        System.out.print(node.data + " ");
        preOrderTravel(node.leftChild);
        preOrderTravel(node.rightChild);
    }

    /**
     * 中序遍历
     * @param node
     */
    public static void inOrderTravel(TreeNode node){
        if( node == null ){
            return;
        }

        inOrderTravel(node.leftChild);
        System.out.print(node.data + " ");
        inOrderTravel(node.rightChild);
    }

    public static void postOrderTravel(TreeNode node){
        if( node == null ){
            return;
        }

        postOrderTravel(node.leftChild);
        postOrderTravel(node.rightChild);
        System.out.print(node.data + " ");
    }

    public static void preOrderTraveralWithStack(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;

        while ( treeNode != null || !stack.isEmpty()){
            while ( treeNode != null ){
                System.out.print(treeNode.data + " ");
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }

            //如果节点没有左孩子，则弹出栈顶节点，访问节点的右孩子
            if( !stack.isEmpty() ){
                treeNode = stack.pop();
                treeNode = treeNode.rightChild;
            }
        }
    }

    public static void inOrderTraveralWithStack(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;

        while ( treeNode != null || !stack.isEmpty()){
            while ( treeNode != null ){
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }

            //如果节点没有左孩子，则弹出栈顶节点，访问节点的右孩子
            if( !stack.isEmpty() ){
                treeNode = stack.pop();
                System.out.print(treeNode.data + " ");
                treeNode = treeNode.rightChild;
            }
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<Integer>(
                Arrays.asList(new Integer[]{3,2,9,null,null,10,null,null,8,null,4}));

        TreeNode node = createBinaryTree(inputList);
        System.out.println("前序遍历：");
        preOrderTravel(node);
        System.out.println("");
        System.out.println("中序遍历：");
        inOrderTravel(node);
        System.out.println("");
        System.out.println("后序遍历：");
        postOrderTravel(node);
        System.out.println("");
        System.out.println("非递归前序遍历：");
        preOrderTraveralWithStack(node);
        System.out.println("");
        System.out.println("非递归中序遍历:");
        inOrderTraveralWithStack(node);
    }

    private static class TreeNode {
        private Integer data;
        private TreeNode leftChild;
        private TreeNode rightChild;

        public TreeNode(Integer data) {
            this.data = data;
        }
    }
}
