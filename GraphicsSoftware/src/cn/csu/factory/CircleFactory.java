package cn.csu.factory;

import java.awt.Graphics2D;

import cn.csu.Listenerner.DrawListenerner;

public class CircleFactory extends ShapeFactory {

	public CircleFactory(DrawListenerner listenerner) {
		super(listenerner);
	}

	@Override
	public void draw(Graphics2D g) {
		// ���ʴ�С
		g.setStroke(g.getStroke());
		// ���û�����ɫ
		c.setGraphicsColor(g);
		// ����Բ�ķ���
		g.fillOval(getX1(), getY1(), getX2() - getX1(), getY2() - getY1());

	}

}
