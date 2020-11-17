package sample;

import btree.Operations;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import btree.Node;
import javafx.scene.shape.Line;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class TreeArea extends Pane {
    private Operations<Integer> btree;
    private double startX, startY;
    private double nodeWidth = 35;

    public TreeArea(Operations<Integer> btree, double startX, double startY) {
        //this.setPrefSize(width, 800);
        //System.out.println("going in tree area constructor");
        this.btree = btree;
        this.startX = startX;
        this.startY = startY;
    }

    private void drawNode(int num, double posX, double posY) {
        String s = Integer.toString(num);
        Rectangle node = new Rectangle(posX, posY, nodeWidth, nodeWidth);
        node.setFill(Color.rgb(24, 71, 102));
        node.setArcWidth(15);
        node.setArcHeight(15);
        Text nodeValue = new Text(posX + 13 - s.length(), posY + 20, s);
        nodeValue.setStyle("-fx-font-weight: bold; -fx-text-fill: white; -fx-font-size: 14");
        nodeValue.setFill(Color.WHITE);
        nodeValue.setStrokeWidth(3);
        this.getChildren().addAll(node, nodeValue);
    }

    private void drawTree(Node root, double posX, double posY, double lengthX, double lengthY) {

        //if root is not null, hence tree exists
        try {
            if (root != null || root.getLeftElement() == null) {

                //Left element always exist, so rendering it first
                drawNode((Integer) root.getLeftElement(), posX, posY);

                //If right element exists, then render that
                if (!(root.getRightElement() == null)) {
                    drawNode((Integer) root.getRightElement(), posX + nodeWidth, posY);
                }

                //Going through all the children of the current root
                //ArrayList<Node> children = new ArrayList<>();
                HashMap<Integer, Node> children;
                if (root.getRightElement() == null) {
                    //right exists
                    children = new HashMap<>();
                    if (root.getLeftNode() != null) {
                        System.out.println("Left Node Added");
                        children.put(-1, root.getLeftNode());
                    }

                    if (root.getMidNode() != null) {
                        System.out.println("Middle node added");
                        children.put(1, root.getMidNode());
                    }
//                    if (root.getRightNode() != null) {
//                        System.out.println("Right node added");
//                        children.put(1, root.getRightNode());
//                    }
                } else {
                    children = new HashMap<>();
                    if (root.getLeftNode() != null) {
                        System.out.println("Left Node Added");
                        children.put(-1, root.getLeftNode());
                    }

                    if (root.getMidNode() != null) {
                        System.out.println("Middle node added");
                        children.put(0, root.getMidNode());
                    }

                    if (root.getRightNode() != null) {
                        System.out.println("Right node added");
                        children.put(1, root.getRightNode());
                    }
                }


                if (root.isLeaf()) {
                    //Its a leaf node, so no children, hence no more things need to be rendered
                } else {
                    double updatedY = posY + lengthY;

                    for (int i : children.keySet()) {
                        System.out.println(i);
                        double updatedX = posX + i * lengthX;
                        Line line = new Line(posX, posY + nodeWidth, updatedX, updatedY);
                        line.setStroke(Color.BLACK);
                        line.setStrokeWidth(3);
                        this.getChildren().add(line);
                        drawTree(children.get(i), updatedX, updatedY, 0.65 * lengthX, 1.2 * lengthY);
                    }


                }

            }
        } catch (NullPointerException e) {
            System.out.println("Null pointer error occurred");
        }


    }

    public void makeTree(Operations<Integer> newBTree) {
        this.btree = new Operations<>();
        System.out.println("Inorder from paramaterized makeTree");
        newBTree.inOrder();
        System.out.println("Making a new tree");
        this.btree = newBTree;
        System.out.println("InOrder inside make tree");

        this.btree.inOrder();
        drawTree(btree.getRoot(), startX, startY, 300, 130);
        System.out.println(btree.getRoot());
    }

    public void resetTree() {
        this.btree = new Operations<>();
        this.btree.clear();
        drawTree(btree.getRoot(), startX, startY, 300, 130);
    }


}
