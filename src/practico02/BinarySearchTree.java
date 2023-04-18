package practico02;

import practico01.Node;

import java.util.ArrayList;

/* TODO: List getLongestBranch()
* */
public class BinarySearchTree {
    private TreeNode root;

    public BinarySearchTree(){
        this.root = null;
    }
    public int getRoot(){
        return this.root.getValue();
    }
    public boolean isEmpty(){
        return this.root == null;
    }
    public void insert(int value) {
        if (this.root == null)
            this.root = new TreeNode(value);
        else
            this.insert(this.root,value);
    }
    private void insert(TreeNode node,int value){
        if (node.getValue() > value){
            if (node.getLeft() == null){
                TreeNode tmp = new TreeNode(value);
                node.setLeft(tmp);
            } else {
                insert(node.getLeft(),value);
            }
        } else if (node.getValue() < value){
            if (node.getRight() == null){
                TreeNode tmp = new TreeNode(value);
                node.setRight(tmp);
            }else {
                insert(node.getRight(),value);
            }
        }
    }
    public ArrayList<Integer> getFrontera() {
        ArrayList<Integer> result = new ArrayList<>();
        getFrontera(this.root,result);
        return result;
    }
    private void getFrontera(TreeNode node,ArrayList<Integer> result){
        if (node == null){
            return;
        }
        if (node.getLeft() == null && node.getRight() == null){
            result.add(node.getValue());
        }else {
            getFrontera(node.getLeft(),result);
            getFrontera(node.getRight(),result);
        }
    }
    public int getHeight(){
        return maxDeepth(this.root) - 1;
    }
    private int maxDeepth(TreeNode node){
        if (node == null){
            return 0;
        }
        int leftDepth = maxDeepth(node.getLeft());
        int rigthDepth = maxDeepth(node.getRight());

        if (leftDepth > rigthDepth){
            return leftDepth + 1;
        }
        return rigthDepth + 1;
    }
    public void printPreOrder(){
        this.printPreOrder(this.root);
    }
    private void printPreOrder(TreeNode root){
        if (root == null){
            return;
        }
        System.out.println(root.getValue());
        printPreOrder(root.getLeft());
        printPreOrder(root.getRight());
    }
    public void printPosOrder(){
        this.printPosOrder(this.root);
    }
    private void printPosOrder(TreeNode node){
        if (node == null){
            return;
        }
        printPosOrder(node.getLeft());
        printPosOrder(node.getRight());
        System.out.println(node.getValue());
    }
    public void printInOrder(){
        this.printInOrder(this.root);
    }
    private void printInOrder(TreeNode node){
        if (node == null){
            return;
        }
        printInOrder(node.getLeft());
        System.out.println(node.getValue());
        printInOrder(node.getRight());
    }
    public int getMaxElem(){
        TreeNode current = this.root;
        while (current.getRight() != null){
            current = current.getRight();
        }
        return current.getValue();
    }
    public boolean hasElem(int value){
        return this.hasElem(this.root,value);
    }
    private boolean hasElem(TreeNode node,int value){
        if (node == null){
            return false;
        }
        if (node.getValue() == value){
            return true;
        }
        if (node.getValue() > value){
            return hasElem(node.getRight(),value);
        }else {
            return hasElem(node.getLeft(),value);
        }
    }
    public ArrayList<Integer> getElemAtLevel(int level) {
        ArrayList<Integer> result = new ArrayList<>();
        getElemAtLevel(this.root,level,0,result);
        return result;
    }
    private  void getElemAtLevel(TreeNode node,int level,int currentLevel,ArrayList<Integer> result){
        if (node == null){
            return;
        }
        if (currentLevel == level){
            result.add(node.getValue());
        }else {
            getElemAtLevel(node.getLeft(),level,currentLevel+1,result);
            getElemAtLevel(node.getRight(),level,currentLevel+1,result);
        }
    }
    /*
    * Ejercicio 2
    Dado un árbol binario de búsquedas que almacena números enteros, implementar un algoritmo
    que retorne la suma de todos los nodos internos del árbol.
    * */
    public int getSuma(){
        return getSuma(this.root);
    }
    private int getSuma(TreeNode node) {
        if (node == null){
            return 0;
        }
        if (node.getLeft() == null && root.getRight() == null) {
            return 0;
        }
        return node.getValue() + getSuma(node.getLeft()) + getSuma(node.getRight());
    }
    /*
    * Ejercicio 3
    Dado un árbol binario de búsqueda que almacena
    números enteros y un valor de entrada K, implementar un
    algoritmo que permita obtener un listado con los valores
    de todas las hojas cuyo valor supere K.
    * */
    public ArrayList<Integer> getGreaterThan(int value){
        ArrayList<Integer> result = new ArrayList<>();
        getGreaterThan(this.root,value,result);
        return result;
    }
    private void getGreaterThan(TreeNode node,int value,ArrayList<Integer> result){
        if (node == null){
            return;
        }
        if (node.getValue() > value){
            result.add(node.getValue());
        }
        getGreaterThan(node.getLeft(),value,result);
        getGreaterThan(node.getRight(),value,result);
    }

    public boolean delete(int value){
        TreeNode result = delete(this.root,value);
        if (result == null){
            return false;
        }
        return true;
    }
    private TreeNode delete(TreeNode node, int value){
        if (node == null){
            return null;
        }
        if (value > node.getValue()){
            node.setRight(delete(node.getRight(),value));
        }else if (value < node.getValue()){
            node.setLeft(delete(node.getLeft(),value));
        }else {
            if (node.getLeft() == null && node.getRight() == null) {
                node = null;
            }else if (node.getLeft() == null){
                node = node.getRight();
            }else if (node.getRight() == null){
                node = node.getLeft();
            }else {
                node.setValue(successor(node));
                node.setRight(delete(node.getRight(),node.getValue()));
            }
        }
        return node;
    }
    private int successor(TreeNode node){
        node = node.getRight();
        while(node.getLeft() != null){
            node = node.getLeft();
        }
        return node.getValue();
    }
}
