package cn.csu.swing;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawSimplePicture {

	public DrawSimplePicture() {

	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("my frame"); // ��ʼ��һ������
		frame.setSize(500, 500); // ���ô��ڴ�С
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���û�ͼ������Ĳ������˳���ͼ����
		frame.setVisible(true); // ��ʾ����, ��Ȼɶ������ʾ

		JPanel panel = new JPanel() { // ��ʼ��һ���»���
			private static final long serialVersionUID = 1L; // ���ùܣ��ɼӿɲ���

			@Override
			public void paint(Graphics g) { // ��д pait ����
				super.paint(g); // ���Ҫ���ϣ�������Ҳ��������ʾ
				
				g.setColor(null); // ���û�����ɫ
				g.drawLine(80, 200, 50, 50); // ��ֱ��
				g.setColor(Color.RED); // ���û�����ɫ
				g.fillRect(80, 60, 40, 60); // ���һ������
				g.fillOval(10, 20, 30, 40);
//				g.drawOval(10, 20, 30, 20); // ��һ����Բ
			}
		};
		frame.setContentPane(panel); // ��������ӵ�������
	}
}
