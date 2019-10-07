import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Tester {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		frame.setLayout(new FlowLayout());
		JButton zoomIn = new JButton("Zoom in");
		JButton zoomOut = new JButton("Zoom out");
		
		CarIcon c = new CarIcon(100);
		JLabel label = new JLabel(c);
		
		final int increment = 25;
		zoomIn.addActionListener(event -> {
			c.setWidth(c.getIconWidth() + increment);
			label.repaint();
		});
		
		zoomOut.addActionListener(event -> {
			c.setWidth(c.getIconWidth() - increment);
			label.repaint();
		});
		
		frame.add(label);
		frame.add(zoomIn);
		frame.add(zoomOut);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
//	public static ActionListener changeCarWidthButtonListener(int dir) {
//		
//	}
	
}
