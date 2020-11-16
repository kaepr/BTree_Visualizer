package sample;

import btree.Operations;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import btree.Node;

import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;


public class TreeArea extends Pane {
    private Operations<Integer> btree = new Operations<>();
    private double startX, startY;
    private double nodeWidth = 35;

    public TreeArea(Operations<Integer> btree, double startX, double startY) {
        this.btree = btree;
        this.startX = startX;
        this.startY = startY;
    }

    private void drawNode(int num, double posX, double posY) {
        String s = Integer.toString(num);
        Rectangle node = new Rectangle(posX, posY, nodeWidth, nodeWidth);
        node.setFill(Color.rgb(24, 71, 102));
        node.setArcWidth(20);
        node.setArcHeight(20);
        Text nodeValue = new Text(posX + 10 - s.length(), posY + 10, s);
        nodeValue.setStyle("-fx-font-weight: bold; -fx-text-fill: white; -fx-font-size: 14");
        this.getChildren().addAll(node, nodeValue);
    }

    private void drawTree(Node root, double posX, double posY) {

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
                ArrayList<Node> children = new ArrayList<>();
                if (root.getLeftNode() != null) {
                    children.add(root.getLeftNode());
                }
                if (root.getMidNode() != null) {
                    children.add(root.getMidNode());
                }
                if (root.getRightNode() != null) {
                    children.add(root.getRightNode());
                }

                if (root.isLeaf()) {
                    //Its a leaf node, so no children, hence no more things need to be rendered
                } else {
                    double updatedY = posY + 30;
                    for (int i = 0; i < children.size(); i++) {

                    }
                }

            }
        } catch (NullPointerException e) {
            System.out.println("Null pointer error occured");
        }


    }


}
