
import java.awt.*;
import java.awt.geom.Ellipse2D;

import javax.swing.*;

public class MyIcon implements Icon{

	private int size;
	private int color;
	
	public MyIcon(int size) {
		this.size = size;
	}

	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		// TODO Auto-generated method stub
		Graphics2D g2 = (Graphics2D) g;
		Ellipse2D.Double icon = new Ellipse2D.Double(x, y, size, size);
		if (color == 0) {
			g2.setColor(Color.RED);
		} else if (color == 1) {
			g2.setColor(Color.BLUE);
		} else if (color == 2) {
			g2.setColor(Color.GREEN);
		}
		g2.fill(icon);
	}

	public void setColor(int i) {
		color = i;
	}
	
	@Override
	public int getIconWidth() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public int getIconHeight() {
		// TODO Auto-generated method stub
		return size;
	}
}
