package groupProject.paint.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Canvas extends JPanel { // specialized JPanel
			
		private int width;
		private int height;
		
		private int initialX;
		private int initialY;
		
		private Color currentColor = Color.BLACK;
		
	
	public void setColor(Color newColor) {
		currentColor = newColor;
	}
		
		
		
	private ArrayList<Shape> shapes = new ArrayList<Shape>();

	public Canvas(int width,int height) {
		this.width = width;
		this.height = height;
		
	/*	Rectangle r;
		Rectangle r1;
		Rectangle r2;
		Rectangle r3;

		r = new Rectangle(10, 10, 50, 50);
		shapes.add(r);

		r1 = new Rectangle(20, 20, 50, 50);
		shapes.add(r1);
		r2 = new Rectangle(10, 50, 40, 70);
		shapes.add(r2);
		r3 = new Rectangle(30, 100, 20, 10);
		shapes.add(r3);

		Circle c1 = new Circle(20, 30, 20, 20);
		Circle c2 = new Circle(200, 200, 30, 30);
		Circle c3 = new Circle(400, 410, 20, 20);
		shapes.add(c1);
		shapes.add(c2);
		shapes.add(c3); */
		
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("Mouse Released: " + e.getX());
				int currentX = e.getX();
				int currentY = e.getY();
				if ((currentX-initialX)>0 && (currentY-initialY)>0) {
					Rectangle rect = new Rectangle(initialX,initialY,Math.abs(initialY-e.getY()),Math.abs(initialX-e.getX()),currentColor);
					shapes.add(rect);
					repaint(); //calls paint component again
				}
//				else if ((currentX-initialX)<0) && (currentY-initialY)>0 {
//					
//				}
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("Mouse Pressed: " + e.getX());
				initialX = e.getX();
				initialY = e.getY();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("Mouse Exited: " + e.getX());
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("Mouse Entered: " + e.getX()); //entering and exiting the frame.
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Mouse Clicked: " + e.getX());
				Circle stroke = new Circle(e.getX(),e.getY(),10,10,currentColor);
				shapes.add(stroke);
				repaint();
			}
		});
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(Color.LIGHT_GRAY);
		g.drawRect(0, 0, width, height);
		
	
		for (Shape shape : shapes) {
			g.setColor(shape.getShapeColor());
			shape.draw(g);
		}

	}
}
