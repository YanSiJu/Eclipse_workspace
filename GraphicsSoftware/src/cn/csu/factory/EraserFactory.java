package cn.csu.factory;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.JFrame;

public class EraserFactory extends ShapeFactory {

	public EraserFactory(int x1, int y1, int x2, int y2, Color color, BasicStroke s) {
		super(x1, y1, x2, y2, color, s);

	}

	@Override
	public void draw(Graphics2D g) {
		g.setStroke(new BasicStroke(20));// ��Ƥ��С
		JFrame frame = new JFrame();
		g.setColor(frame.getBackground());
		g.drawLine(getX1(), getY1(), getX2(), getY2());

	}

}
