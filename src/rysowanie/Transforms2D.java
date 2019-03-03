package rysowanie;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;

import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Transforms2D extends JPanel {

	private class Display extends JPanel {
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D)g;
			 g2.translate(300, 300);  // Moves (0,0) to the center of the display.
			int whichTransform = transformSelect.getSelectedIndex(); /////
			AffineTransform transform = new AffineTransform();
			AffineTransform at = new AffineTransform();
			
			
			int n=11;       
            double r = 150,
            		t=0,
            		k=(Math.PI*2)/n;     
          
            int[] x1 = new int[n];
            int[] y1 = new int[n];
            
            int[] x2 = new int[n];
            int[] y2 = new int[n];
            
            for (int i=0;i<n;i++)
            {
                x1[i]= (int) (r*Math.sin(t));
                y1[i]= (int) (r*Math.cos(t));
                t+=k;
            }
            
            Polygon p1=new Polygon(x1,y1,n);
            
            for (int i=0;i<n;i++)
            {
            	x2[i] = (int) (r * Math.sin(t));
                y2[i] = (int) (r * Math.cos(t));
                
                if(y2[i]>50)
                    x2[i]+=100;
                
                if(y2[i] < -50)
                    x2[i]-=100;
                
                t+=k;
            }
            
            Polygon p2 = new Polygon(x2,y2,n);
            
            switch (whichTransform) {
                case 0:
                {
                    g2.drawPolygon(p1);   
                    g2.fill(p1);          
                    break;
                }
                case 1:
                {
                    g2.scale(0.5,0.5);  
                    g2.drawPolygon(p1);
                    g2.fill(p1);
                    break;
                }
                case 2:
                {
                    g2.scale(1.5,1.5);
                    g2.rotate(Math.toRadians(45));  
                    g2.drawPolygon(p1);
                    g2.fill(p1);
                    break;
                }
                case 3:
                {
                    g2.rotate(Math.toRadians(180));
                    g2.drawPolygon(p1);
                    g2.fill(p1);
                    break;
                }
                case 4:
                {
                    g2.draw(p2);
                    g2.fill(p2);
                    break;
                }
                case 5:
                {
                    g2.translate(0,-200);
                    g2.scale(1,0.5);
                    g2.draw(p1);
                    g2.fill(p1);
                    break;
                }
                case 6:
                {
                    g2.rotate(Math.toRadians(90));
                    g2.draw(p2);
                    g2.fill(p2);
                    break;
                }
                case 7:
                {
                    g2.rotate(Math.toRadians(180));
                    g2.drawPolygon(p1);
                    g2.fill(p1);
                    break;
                }
                case 8:
                {
                    g2.translate(-100,100);     
                    g2.rotate(Math.toRadians(-45));
                    g2.draw(p1);
                    g2.fill(p1);
                    break;
                }
                case 9:
                {
                    g2.rotate(Math.toRadians(180));
                    g2.draw(p2);
                    g2.fill(p2);
                    break;
                }
            }

            
        }
    }

	private Display display;
	private BufferedImage pic;
	private JComboBox<String> transformSelect;

	public Transforms2D() throws IOException {
					
		
		display = new Display();
		display.setBackground(Color.YELLOW);
		display.setPreferredSize(new Dimension(600,600));
		transformSelect = new JComboBox<String>();
		transformSelect.addItem("None");
		for (int i = 1; i < 10; i++) {
			transformSelect.addItem("No. " + i);
		}
		transformSelect.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display.repaint();
			}
		});
		setLayout(new BorderLayout(3,3));
		setBackground(Color.GRAY);
		setBorder(BorderFactory.createLineBorder(Color.GRAY,10));
		JPanel top = new JPanel();
		top.setLayout(new FlowLayout(FlowLayout.CENTER));
		top.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
		top.add(new JLabel("Transform: "));
		top.add(transformSelect);
		add(display,BorderLayout.CENTER);
		add(top,BorderLayout.NORTH);
	}


	public static void main(String[] args) throws IOException {
		JFrame window = new JFrame("2D Transforms");
		window.setContentPane(new Transforms2D());
		window.pack();
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		window.setLocation( (screen.width - window.getWidth())/2, (screen.height - window.getHeight())/2);
		window.setVisible(true);
	}

}