
import java.awt.Color;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

class PaintTest extends TestCase {

	@Test
	void shapesListTest() {
		
		ArrayList<Shape> shapes = new ArrayList<Shape>();
		Rectangle rect = new Rectangle(10,10,200, 200, Color.black);
		shapes.add(rect);
		Circle circle = new Circle(10, 10, 250, 250, Color.blue);
		shapes.add(circle);
		assertEquals(2, shapes.size());
		
	}
	
	@Test
	void createRectangleTest() {
		Rectangle rect = new Rectangle(10, 30, 460, 320, Color.blue);
		assertTrue(rect.getWidth() == 450);
		assertTrue(rect.getHeight() == 290);
		assertTrue(rect.getX() == 10);
		assertTrue(rect.getY() == 30);
	}
	
	@Test
	void createCircleTest() {
		Circle circle = new Circle(200, 250, 30, 40, Color.red);
		assertTrue(circle.getWidth() == 170);
		assertTrue(circle.getHeight() == 210);
		assertTrue(circle.getX() == 30);
		assertTrue(circle.getY() == 40);
		
	}
	
	void createEmptyRectTest() {
		Rectangle empRect = new Rectangle(50, 65, 400, 20, Color.yellow); 
		assertTrue(empRect.getWidth() == 350);
		assertTrue(empRect.getHeight()== 45);
		assertTrue(empRect.getX() == 50);
		assertTrue(empRect.getY() == 20);
		
	}
	
	@Test
	void createLine() {
		Line line = new Line(300, 220, 45, 80, Color.blue);
		assertTrue(line.getWidth() == 255);
		assertTrue(line.getHeight() == 140);
		assertTrue(line.getX() == 45);
		assertTrue(line.getY() == 80);
	}
}
