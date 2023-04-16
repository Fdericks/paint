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

	public Rectangle() {
	}

	public Rectangle(int initialX, int initialY, int finalX, int finalY, Color color) {
		super(initialX, initialY, finalX, finalY, color);

	}

	@Override
	public void draw(Graphics g) {
		g.fillRect(getX(), getY(), getWidth(), getHeight());
	}
}
