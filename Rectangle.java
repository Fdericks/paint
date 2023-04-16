package groupProject.paint.main;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Rectangle class is responsible for drawing a solid rectangle to the canvas
 * based on the user's press and release of the mouse.
 * Rectangle inherits from Shape. 
 * 
 * @author Derick Flores
 * @author Bridget Brigadoi
 * @author Taylor Holdridge
 *
 */
public class Rectangle extends Shape {

	/**
	 * Creates a new solid rectangle 
	 */
	public Rectangle() {
	}

	/**
	 * Creates new solid rectangle with initial and final (x,y) points based on
	 * the user's press and release of the mouse. 
	 * @param initialX - the x point based on the press of the user's mouse
	 * @param initialY - the y point based on the press of the user's mouse
	 * @param finalX - the x point based on the release of the user's mouse
	 * @param finalY - the y point based on the release of the user's mouse
	 * @param color - color the user chooses 
	 */
	public Rectangle(int initialX, int initialY, int finalX, int finalY, Color color) {
		super(initialX, initialY, finalX, finalY, color);

	}

	@Override
	public void draw(Graphics g) {
		g.fillRect(getX(), getY(), getWidth(), getHeight());
	}
}
