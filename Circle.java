package groupProject.paint.main;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Circle class is responsible for drawing a filled circle to the canvas 
 * based on user's press and release of the mouse.
 * Circle inherits from Shape. 
 * @author Derick Flores
 * @author Bridget Brigadoi
 * @author Taylor Holdridge
 *
 */
public class Circle extends Shape {

	/**
	 * Creates a new solid circle
	 */
	public Circle() {
	}

	/**
	 * Creates new solid circle with initial and final (x,y) points based on
	 * the user's press and release of the mouse. 
	 * @param initialX - the x point based on the press of the user's mouse
	 * @param initialY - the y point based on the press of the user's mouse
	 * @param finalX - the x point based on the release of the user's mouse
	 * @param finalY - the y point based on the release of the user's mouse
	 * @param color - color the user chooses 
	 */
	public Circle(int initialX, int initialY, int finalX, int finalY, Color color) {
		super(initialX, initialY, finalX, finalY, color);

	}

	@Override
	public void draw(Graphics g) {
		g.fillOval(getX(), getY(), getWidth(), getHeight());
	}
}
