package cn.csu.factory;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

import cn.csu.Listenerner.DrawListenerner;

public class StringFactory extends ShapeFactory {
	private String str = "��������";

	public StringFactory(int x1, int y1, int x2, int y2, String color, BasicStroke s) {
		super(x1, y1, x2, y2, color, s);

	}

	public StringFactory(DrawListenerner listenerner) {
		super(listenerner);
	}

	@Override
	public void draw(Graphics2D g) {
		// ���ʴ�С
		g.setStroke(new BasicStroke());
		// ���û�����ɫ
		c.setGraphicsColor(g);
		// ����
		g.drawString(str, getX1(), getY1());

	}

}
