package groupProject.paint.main;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape {

	public Line() {
	}

	public Line(int x1, int y1, int x2, int y2, Color color) {
		super(x1, y1, x2, y2, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawLine(getInitialX(), getInitialY(), getNewX(), getNewY());
	}

}
