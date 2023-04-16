package groupProject.paint.main;

import java.awt.Color;
import java.awt.Graphics;

/**
 * 
 * EmptyCircle class is responsible for drawing a hollow circle to the canvas 
 * based on user's press and release of the mouse.
 * EmptyCircle inherits from Shape. 
 * @author Derick Flores
 * @author Bridget Brigadoi
 * @author Taylor Holdridge
 *
 */
public class EmptyCircle extends Shape {

	public EmptyCircle() {
	}

	public EmptyCircle(int initialX, int initialY, int finalX, int finalY, Color color) {
		super(initialX, initialY, finalX, finalY, color);

	}

	@Override
	public void draw(Graphics g) {
		g.drawOval(getX(), getY(), getWidth(), getHeight());
	}

}
