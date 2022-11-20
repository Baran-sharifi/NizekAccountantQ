package nizekAccountant;
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package nizekAccountant;
//
///**
// *
// * @author Lenovo
// */
//
//

import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class Diagram extends JPanel {

    public Diagram() {
         setSize(new java.awt.Dimension(453, 444));
        // pack();
    }

    
        private Map<Color, Integer> bars
                = new LinkedHashMap<Color, Integer>();

        public void addBar(Color color, int value) {

            bars.put(color, value);

            repaint();

        }

        @Override

        protected void paintComponent(Graphics g) {

// determine longest bar
            int max = Integer.MIN_VALUE;

            for (Integer value : bars.values()) {

                max = Math.max(max, value);

            }

// paint bars
            int width = (getWidth() / bars.size()) - 2;

            int x = 1;

            for (Color color : bars.keySet()) {

                int value = bars.get(color);

                int height = (int) ((getHeight() - 5) * ((double) value / max));

                g.setColor(color);

                g.fillRect(x, getHeight() - height, width, height);

                g.setColor(Color.black);

                g.drawRect(x, getHeight() - height, width, height);

                x += (width + 2);

            }
        }

        @Override

        public Dimension getPreferredSize() {

            return new Dimension(bars.size() * 10 + 2, 50);

        }

   

}
