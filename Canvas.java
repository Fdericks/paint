package groupProject.paint.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Canvas extends JPanel { // specialized JPanel

	private int initialX;
	private int initialY;

	private Color currentColor = Color.BLACK;

	private Shape currentShape;
	private float currentBrushWidth = 10f; //15 is default

	private ArrayList<Point> points = new ArrayList<Point>();
	private ArrayList<Shape> shapes = new ArrayList<Shape>();

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
//					System.out.println(
//							"Select a shape. Once we add the brush method, this catch should check for the brush size and accordingly paint.");

						points = new ArrayList<Point>();
				}
				repaint(); // calls paint component again
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (currentShape == null) {
					points.add(e.getPoint());
					useBrush(points);
					repaint();
				
				}
				else {
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
				System.out.println("Mouse Clicked: " + e.getPoint());
				Circle stroke = new Circle(e.getX() - 3, e.getY() - 5, e.getX() + 3, e.getY() + 1, currentColor);
				shapes.add(stroke);
				repaint();

			}
		});
		addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent e) {
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				if (currentShape == null) {
					points.add(e.getPoint());
					useBrush(points);
					repaint();
				}

			}
		});

	}

	@Override
	protected void paintComponent(Graphics g) {
		repaint();
		for (Shape shape : shapes) {
			g.setColor(shape.getShapeColor());
			shape.draw(g);
		}
	}

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
	private void useBrush(ArrayList<Point> points) {
		Brush brush = new Brush(points,currentColor,currentBrushWidth);
		shapes.add(brush);
	}

}
