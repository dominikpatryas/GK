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
			g2.translate(0,0);  // Moves (0,0) to the center of the display.
			int whichTransform = transformSelect.getSelectedIndex(); /////
			AffineTransform transform = new AffineTransform();
			AffineTransform at = new AffineTransform();
			
			
			switch(whichTransform)
			{
			case 1:
			{
				int x = 150; int xpoczatkowe = x;
				int y = 200;
				int[] xValues1 =    {x,x, x += 20, x += 20, x += 20, x += 20, x += 20, x += 20, x += 20, x += 20, x += 20, x += 20,
						x += 20, x += 20, x += 20, x += 20, x += 20, x += 20, x, xpoczatkowe};
				
				 int[] yValues1 = {y, y, y+20, y,y+20, y,y+20, y,y+20, y,y+20, y,y+20, y,y+20, y,y+20, y,y+120,y+120};
					
				
				   Polygon polygon1 = new Polygon(xValues1, yValues1, 20);
				   g2.drawPolygon(polygon1);
				   g2.fill(polygon1);
				   
			        
			        
				   break;
			}
			case 2:
			{
				int x = 150; int xpoczatkowe = x;
				int y = -20;
				int[] xValues1 =    {x,x, x += 20, x += 20, x += 20, x += 20, x += 20, x += 20, x += 20, x += 20, x += 20, x += 20,
						x += 20, x += 20, x += 20, x += 20, x += 20, x += 20, x, xpoczatkowe};
				
				 int[] yValues1 = {y, y, y+20, y,y+20, y,y+20, y,y+20, y,y+20, y,y+20, y,y+20, y,y+20, y,y+120,y+120};
					
				
				   Polygon polygon1 = new Polygon(xValues1, yValues1, 20);
				   g2.translate(20, -50);
			        g2.rotate(Math.PI/4);
			      
				   g2.scale(1.5, 1.5);
				   g2.drawPolygon(polygon1);
				   g2.fill(polygon1);
				   
				   break;
				   
				   
				   
				   
				   
			}
			
			case 3:
			{
				int x = 150; int xpoczatkowe = x;
				int y = 400;
				int[] xValues1 =    {x,x, x += 20, x += 20, x += 20, x += 20, x += 20, x += 20, x += 20, x += 20, x += 20, x += 20,
						x += 20, x += 20, x += 20, x += 20, x += 20, x += 20, x, xpoczatkowe};
				
				 int[] yValues1 = {y, y, y+20, y,y+20, y,y+20, y,y+20, y,y+20, y,y+20, y,y+20, y,y+20, y,y+120,y+120};
					
				
				 Polygon polygon1 = new Polygon(xValues1, yValues1, 20);
				 
			     g2.scale(1, 2);
				 g2.rotate(Math.toRadians(180),300,300);
				 g2.drawPolygon(polygon1);
				 g2.fill(polygon1);
				   
				   break;
				
			}
			case 4:
			{
				int x = 150; int xpoczatkowe = x;
				int y = 200;
				int[] xValues1 =    {x,x, x += 20, x += 20, x += 20, x += 20, x += 20, x += 20, x += 20, x += 20, x += 20, x += 20,
						x += 20, x += 20, x += 20, x += 20, x += 20, x += 20, x, xpoczatkowe};
				
				 int[] yValues1 = {y, y, y+20, y,y+20, y,y+20, y,y+20, y,y+20, y,y+20, y,y+20, y,y+20, y,y+120,y+120};
					
				
				 Polygon polygon1 = new Polygon(xValues1, yValues1, 20);
				 
			      
				 AffineTransform tx2 = new AffineTransform();
				 	tx2.translate(50, -100);
			        tx2.shear(0, 0.5);

			        g2.setTransform(tx2);
			
				 g2.drawPolygon(polygon1);
				 g2.fill(polygon1);
				   
				   break;
				
			}
			case 5:
			{
				int x = 150; int xpoczatkowe = x;
				int y = 0;
				int[] xValues1 =    {x,x, x += 20, x += 20, x += 20, x += 20, x += 20, x += 20, x += 20, x += 20, x += 20, x += 20,
						x += 20, x += 20, x += 20, x += 20, x += 20, x += 20, x, xpoczatkowe};
				
				 int[] yValues1 = {y, y, y+20, y,y+20, y,y+20, y,y+20, y,y+20, y,y+20, y,y+20, y,y+20, y,y+120,y+120};
					
				
				   Polygon polygon1 = new Polygon(xValues1, yValues1, 20);
				   g2.drawPolygon(polygon1);
				   g2.fill(polygon1);
				   
			        			        
				   break;
				
			}
			case 6:
			{
				
				
			}
			}
			
				
			
			// TODO Apply transforms here, depending on the value of whichTransform!

			//g2.drawImage(pic, -200, -150, null); // Draw image with center at (0,0).
			
			
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
		window.setLocation( (screen.width - window.getWidth())/2, (screen.height - window.getHeight())/2 );
		window.setVisible(true);
	}

}