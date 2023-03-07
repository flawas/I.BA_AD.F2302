/*
 * Copyright Flavio Waser (c) 2023.
 */

package ch.hslu.ad.sw03;

public class Tree implements TreeInterface{

    TreeNode root = null;

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public TreeNode getLastNodeLeft(){
        TreeNode node = this.root;
        while(node.getChildNodeLeft() ! = null){
            node = node.getChildNodeLeft();
        }
        return node;
    }

    public TreeNode getLastNodeRight(){
        TreeNode node = this.root;
        while(node.getChildNodeRight() ! = null){
            node = node.getChildNodeRight();
        }
        return node;
    }

    @Override
    public void addNode(TreeNode node) {
        if(this.root == null){
            setRoot(node);
            return;
        }




    }

    @Override
    public TreeNode searchNode(TreeNode node) {
        return null;
    }

    @Override
    public void deleteNode(TreeNode node) {

    }
}
