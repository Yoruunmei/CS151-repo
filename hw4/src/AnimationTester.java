import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.*;

/**
   This program implements an animation that moves
   a car shape.
*/
public class AnimationTester
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();

      final MoveableShape shape = new CarShape(0, 0, CAR_WIDTH);
      ShapeIcon icon = new ShapeIcon(shape, ICON_WIDTH, ICON_HEIGHT);
      
      final MoveableShape shape2 = new CarShape(0, 0, CAR_WIDTH);  
      ShapeIcon icon2 = new ShapeIcon(shape2, ICON_WIDTH, ICON_HEIGHT);
      
      
      final JLabel car1 = new JLabel(icon);
      final JLabel car2 = new JLabel(icon2);
      
      JPanel carContainer = new JPanel();
      JPanel carContainer2 = new JPanel();
      
      // BorderLayout auto resizes JPanel
      carContainer.setLayout(new BorderLayout());
      carContainer.add(car1);
      
      carContainer2.setLayout(new BorderLayout());
      carContainer2.add(car2);
      
      JPanel container = new JPanel();
      container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
      container.add(carContainer);
      container.add(carContainer2);
      
      frame.setLayout(new BorderLayout());
      frame.add(container, BorderLayout.CENTER);
      
      
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setPreferredSize(new Dimension(900, 600));
      frame.pack();
      frame.setVisible(true);

      // Thread animation.
      ExecutorService service = Executors.newFixedThreadPool(2);
      int delay = 7; // time thread sleeps before re-executing animation.
      Runnable r1 = () -> {
			while (true) {
				shape.move(); // animates car moving.
				car1.repaint();
				try {
					Thread.sleep(delay); // 1 animate every 7 ms. about 144 pixels per sec.
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
      };
 
      int delay2 = 14;
	  Runnable r2 = () -> { 
			while (true) {
				shape2.move();
				car2.repaint();
				try {
					Thread.sleep(delay2);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	  };
	  
      service.execute(r1);
      service.execute(r2);
      service.shutdown();   
   }

   private static final int ICON_WIDTH = 400;
   private static final int ICON_HEIGHT = 100;
   private static final int CAR_WIDTH = 100;
}
