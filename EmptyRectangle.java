package groupProject.paint.main;

import java.awt.Color;
import java.awt.Graphics;

/**
 * EmptyRectangle class is responsible for drawing a hollow rectangle to the canvas
 * based on the user's press and release of the mouse.
 * EmptyRectangle inherits from Shape. 
 * @author Derick Flores
 * @author Bridget Brigadoi
 * @author Taylor Holdridge
 *
 */
public class EmptyRectangle extends Shape {

	/**
	 * Creates a new hollow rectangle
	 */
	public EmptyRectangle() {
	}

	/**
	 * Creates new hollow rectangle with initial and final (x,y) points based on
	 * the user's press and release of the mouse. 
	 * @param initialX - the x point based on the press of the user's mouse
	 * @param initialY - the y point based on the press of the user's mouse
	 * @param finalX - the x point based on the release of the user's mouse
	 * @param finalY - the y point based on the release of the user's mouse
	 * @param color - color the user chooses 
	 */
	public EmptyRectangle(int initialX, int initialY, int finalX, int finalY, Color color) {
		super(initialX, initialY, finalX, finalY, color);
	}

	@Override
	public void draw(Graphics g) {
		g.drawRect(getX(), getY(), getWidth(), getHeight());

	}
}
