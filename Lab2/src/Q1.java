import java.awt.FlowLayout;

import javax.swing.*;

public class Q1 {

	
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		
		JButton b1 = new JButton("Repaint Red");
		JButton b2 = new JButton("Repaint Blue");
		JButton b3 = new JButton("Repaint Green");
		
		b1.addActionListener(null);
		
		frame.setLayout(new FlowLayout());
		//frame.setSize(1000, 300);
		
		MyIcon circle = new MyIcon(200);
		circle.paintIcon(c, g, x, y);
		
		frame.add(b1);
		frame.add(b2);
		frame.add(b3);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
