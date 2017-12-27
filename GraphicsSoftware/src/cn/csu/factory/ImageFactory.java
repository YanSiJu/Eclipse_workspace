package cn.csu.factory;

import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;

public class ImageFactory extends ShapeFactory {

	public ImageFactory(Color color, int x1, int y1, int x2, int y2) {
		super(x1, y1, x2, y2, null, null);

	}

	@Override
	public void draw(Graphics2D g) {
		ImageIcon im = new ImageIcon("C:\\Users\\ĳĳ\\Desktop\\·��\\1.jpg");// ����ͼƬ
		g.drawImage(im.getImage(), getX1(), getY1(), getX2() - getX1(), getY2() - getY1(), null);// �ͷ���껭��ͼƬ
	}

	

}
