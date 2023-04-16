package groupProject.paint.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * Canvas creates shapes and drawings based on user's choice.
 * Canvas saves the start and end points based on the user's pressing and releasing of mouse.
 * Canvas will draw using the brush tool if no shape is selected.
 * 
 * @author Derick Flores
 * @author Bridget Brigadoi
 * @author Taylor Holdridge
 *
 */
public class Canvas extends JPanel { // specialized JPanel

	private int initialX;
	private int initialY;

	private Shape currentShape;
	private Color currentColor = Color.BLACK; //default to black.
	private Brush currentBrush;
	private float currentBrushWidth = 1f; // 1 is default

	private ArrayList<Point> points = new ArrayList<Point>();
	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	
	private Shape temporaryShape = new Rectangle(); // Rectangle as default to avoid crashes from paint component.

	public Canvas() {

		addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				int currentX = e.getX();
				int currentY = e.getY();
				try {
					if (currentShape instanceof Rectangle) {
						createRectangle(currentX, currentY);
					} else if (currentShape instanceof EmptyRectangle) {
						createEmptyRectangle(currentX, currentY);
					} else if (currentShape instanceof Triangle) {
						createTriangle(currentX, currentY);
					} else if (currentShape instanceof EmptyTriangle) {
						createEmptyTriangle(currentX, currentY);
					} else if (currentShape instanceof Circle) {
						createCircle(currentX, currentY);
					} else if (currentShape instanceof EmptyCircle) {
						createEmptyCircle(currentX, currentY);
					} else if (currentShape instanceof Line) {
						createLine(currentX, currentY);
					} else {
						throw new RuntimeException("Shape not selected");
					}
				} catch (Exception error) {
					// Shape not selected means that the brush was being used, a new brush is
					// started once the mouse is released so the points are reset to default.
					points = new ArrayList<Point>();
				}
				temporaryShape = new Rectangle(); // temporary shape is set back to default once actual shape is
												  // created.
				repaint(); // calls paint component again
			}

			@Override
			public void mousePressed(MouseEvent e) {
				//create brush if no shape is selected.
				if (currentShape == null) {
					points.add(e.getPoint());
					createBrush(points);
					repaint();
					
				} else { //shape is selected
					initialX = e.getX();
					initialY = e.getY();
				}

			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent e) {
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				int currentX = e.getX();
				int currentY = e.getY();
				// brush add points to array
				if (currentShape == null) {
					points.add(e.getPoint());
					useBrush(points);
				}

				// shapes create shadow before creating the shape itself.
				if (currentShape instanceof Rectangle) {
					temporaryShape = new Rectangle(initialX, initialY, currentX, currentY, currentColor);
				} else if (currentShape instanceof EmptyRectangle) {
					temporaryShape = new EmptyRectangle(initialX, initialY, currentX, currentY, currentColor);
				} else if (currentShape instanceof Triangle) {
					temporaryShape = new Triangle(initialX, initialY, currentX, currentY, currentColor);
				} else if (currentShape instanceof EmptyTriangle) {
					temporaryShape = new EmptyTriangle(initialX, initialY, currentX, currentY, currentColor);
				} else if (currentShape instanceof Circle) {
					temporaryShape = new Circle(initialX, initialY, currentX, currentY, currentColor);
				} else if (currentShape instanceof EmptyCircle) {
					temporaryShape = new EmptyCircle(initialX, initialY, currentX, currentY, currentColor);
				} else if (currentShape instanceof Line) {
					temporaryShape = new Line(initialX, initialY, currentX, currentY, currentColor);
				}
				repaint();
			}
		});

	}

	public void setColor(Color newColor) {
		currentColor = newColor;
	}

	public Color getColor() {
		return currentColor;
	}

	public void setCurrentShape(Shape newShape) {
		currentShape = newShape;
	}

	public void setBrushWidth(float width) {
		currentBrushWidth = width;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		repaint();
		for (Shape shape : shapes) {
			g.setColor(shape.getShapeColor());
			shape.draw(g);
		}
		g.setColor(temporaryShape.getShapeColor());
		temporaryShape.draw(g);

	}
	
	//the following methods instantiate a shape and add it into the shapes array that paintComponent uses.
	private void createRectangle(int newX, int newY) {

		Rectangle rect = new Rectangle(initialX, initialY, newX, newY, currentColor);
		shapes.add(rect);
	}

	private void createEmptyRectangle(int newX, int newY) {

		EmptyRectangle empRect = new EmptyRectangle(initialX, initialY, newX, newY, currentColor);
		shapes.add(empRect);
	}

	private void createTriangle(int newX, int newY) {

		Triangle triangle = new Triangle(initialX, initialY, newX, newY, currentColor);
		shapes.add(triangle);
	}

	private void createEmptyTriangle(int newX, int newY) {

		EmptyTriangle empTriangle = new EmptyTriangle(initialX, initialY, newX, newY, currentColor);
		shapes.add(empTriangle);
	}

	private void createCircle(int newX, int newY) {
		Circle circ = new Circle(initialX, initialY, newX, newY, currentColor);

		shapes.add(circ);
	}

	private void createEmptyCircle(int newX, int newY) {

		EmptyCircle empCirc = new EmptyCircle(initialX, initialY, newX, newY, currentColor);
		shapes.add(empCirc);
	}

	private void createLine(int newX, int newY) {
		Line line;
		line = new Line(initialX, initialY, newX, newY, currentColor);
		shapes.add(line);

	}
   
	private void createBrush(ArrayList<Point> points) {
		Brush brush = new Brush(points, currentColor, currentBrushWidth);
		shapes.add(brush);
		currentBrush = brush;
	}
	// to avoid creating a new shape at every point, useBrush adds points to the currently working brush.
	private void useBrush(ArrayList<Point> points) {
		currentBrush.setPoints(points);
	}

}
