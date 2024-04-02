/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package component;

import core.AsimTarikKutluerNumberOnBoard;
import javax.swing.JComponent;
import java.awt.*;
/**
 *
 * @author Lenovo
 */
public class AsimTarikKutluerCircleWithNumber extends JComponent {
    
    
    private AsimTarikKutluerNumberOnBoard number;
   
    
    

    public AsimTarikKutluerCircleWithNumber(AsimTarikKutluerNumberOnBoard number) {
        this.number = number;
        setPreferredSize(new Dimension(25, 25)); 
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        Color circleColor = new Color(255, 0, 0); 

        int circleDiameter = 25; 
        if (number.isChecked()) {
            circleColor = new Color(0, 255, 0); 
        }else{
            circleColor = new Color(255, 0, 0); 
        }
        
        Color circleEdgeColor = Color.BLACK; // Circle edge color

        // Draw circle
        g2d.setColor(circleColor);
        g2d.fillOval(0, 0, circleDiameter, circleDiameter);

        // Draw circle edge
        g2d.setColor(circleEdgeColor);
        g2d.drawOval(0, 0, circleDiameter, circleDiameter);

        // Draw number inside the circle
        g2d.setColor(Color.WHITE); // Number color
        Font font = new Font("Arial", Font.BOLD, 12); // Font for the number
        g2d.setFont(font);
        String numberStr = String.valueOf(number.getNumber());
        FontMetrics fm = g2d.getFontMetrics();
        int textWidth = fm.stringWidth(numberStr);
        int textHeight = fm.getHeight();
        int textX = (circleDiameter - textWidth) / 2;
        int textY = (circleDiameter - textHeight) / 2 + fm.getAscent();
        g2d.drawString(numberStr, textX, textY);
    }
    
}
