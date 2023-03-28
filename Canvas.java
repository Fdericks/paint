package groupProject.paint.main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Canvas extends JPanel { // specialized JPanel
			
		private int width;
		private int height;
		
		
	private ArrayList<Shape> shapes = new ArrayList<Shape>();

	public Canvas(int width,int height) {
		this.width = width;
		this.height = height;
		
		Rectangle r;
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
		shapes.add(c3);
		
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(Color.LIGHT_GRAY);
		g.drawRect(0, 0, width, height);
		
		g.setColor(Color.BLACK);
		for (Shape shape : shapes) {
			shape.draw(g);
		}

	}
}
