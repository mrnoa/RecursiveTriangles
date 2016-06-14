import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

import javax.swing.JFrame;

public class Triangles extends Canvas {
	private JFrame pane;
	private Canvas canvas;
	private int height = 1000;
	private int width = 1000;
	private Polygon polygon;

	public Triangles() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Triangles triangles = new Triangles();
		triangles.setup();
		triangles.drawTriangles();
	}

	public void setup() {
		pane = new JFrame();
		setPreferredSize(new Dimension(width, height));
		setBackground(Color.WHITE);
		pane.add(this);
		pane.pack();
		pane.setVisible(true);

	}

	public void drawTriangles() {
		int[] xPoints = { width / 2, width / 8, width - width / 8 };
		int[] yPoints = { (height / 8), height - height / 8, height - height / 8 };
		System.out.println(xPoints);
		polygon = new Polygon(xPoints, yPoints, 3);
		System.out.println(polygon);
		System.out.println(Math.sqrt((Math.pow(xPoints[0] - xPoints[1], 2) + (Math.pow(yPoints[0] - yPoints[1], 2)))));
		System.out.println(3./4*width);
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(Color.black);

		g.drawPolygon(polygon);
		System.out.println("test");
	}

}
