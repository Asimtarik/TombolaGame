/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package component;

import core.AsimTarikKutluerNumberOnBoard;
import core.AsimTarikKutluerTombolaLinkedList;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
public class AsimTarikKutluerBoard extends JPanel {

    private Color darkRed = new Color(139, 0, 0);
    private Color circleEdgeColor = Color.LIGHT_GRAY;
    private Color rectangleEdgeColor = Color.BLACK;
    private Color circleColor = new Color(0, 0, 153);
     Color numberedCircleColor;

    AsimTarikKutluerTombolaLinkedList<AsimTarikKutluerNumberOnBoard> tombolaLinkedList;

    public AsimTarikKutluerBoard(AsimTarikKutluerTombolaLinkedList<AsimTarikKutluerNumberOnBoard> tombolaLinkedList) {
        this.tombolaLinkedList = tombolaLinkedList;
    }
    public void updateBoard(AsimTarikKutluerTombolaLinkedList<AsimTarikKutluerNumberOnBoard> updatedList) {
        this.tombolaLinkedList = updatedList;
        repaint(); // Repaint the board with the updated list
    }
    
    

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        int rectangleWidth = 325;
        int rectangleHeight = 115;

        int circleDiameter = 25;
        int spacing = 10;

        // Draw rectangle
        g2d.setColor(darkRed);
        g2d.fillRect((getWidth() - rectangleWidth) / 2, (getHeight() - rectangleHeight) / 2,
                rectangleWidth, rectangleHeight);
        g2d.setColor(rectangleEdgeColor);
        g2d.drawRect((getWidth() - rectangleWidth) / 2, (getHeight() - rectangleHeight) / 2,
                rectangleWidth, rectangleHeight);

        // Draw circles
        int circlesPerRow = 9;
        int index = 0;
        AsimTarikKutluerNumberOnBoard value;
        for (int i = 0; i < 27; i++) {
            
            value = tombolaLinkedList.getFromChild(index);
            int column = value.getNumber() / 10;
            int row = i / circlesPerRow;
            int col = i % circlesPerRow;

            int circleX = spacing + (getWidth() - rectangleWidth) / 2 + col * (circleDiameter + spacing);
            int circleY = spacing + (getHeight() - rectangleHeight) / 2 + row * (circleDiameter + spacing);
            if (i % 9 == column) {
                
               
                if(value.isChecked()){
                    numberedCircleColor = new Color(0, 255, 0);
                }
                else{
                    numberedCircleColor = new Color(255, 0, 0);
                }
                Color circleEdgeColor = Color.BLACK; // Circle edge color

                // Draw circle
                g2d.setColor(numberedCircleColor);
                g2d.fillOval(circleX, circleY, circleDiameter, circleDiameter);

                // Draw circle edge
                g2d.setColor(circleEdgeColor);
                g2d.drawOval(circleX, circleY, circleDiameter, circleDiameter);

                // Draw number inside the circle
                g2d.setColor(Color.WHITE); // Number color
                Font font = new Font("Arial", Font.BOLD, 12); // Font for the number
                g2d.setFont(font);
                String numberStr = String.valueOf(value.getNumber());
                FontMetrics fm = g2d.getFontMetrics();
                int textWidth = fm.stringWidth(numberStr);
                int textHeight = fm.getHeight();
                int textX = (circleDiameter - textWidth) / 2;
                int textY = (circleDiameter - textHeight) / 2 + fm.getAscent();
                g2d.drawString(numberStr, textX+circleX, textY+circleY);
                if(index<14){
                    index++;
                }

            } else {
                Ellipse2D.Double circle = new Ellipse2D.Double(circleX, circleY, circleDiameter, circleDiameter);

                g2d.setColor(circleColor);
                g2d.fill(circle);

                g2d.setColor(circleEdgeColor);
                g2d.draw(circle);

            }

        }
    }
};
