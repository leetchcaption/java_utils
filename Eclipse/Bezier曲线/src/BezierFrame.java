import java.awt.*;
import javax.swing.*;
public class BezierFrame extends JFrame
{
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				JFrame frame = new JFrame();
				frame.setTitle("BezierTest");
				frame.setSize(600,600);
				BezierPanel bezier = new BezierPanel();
				bezier.setPreferredSize(new Dimension(580, 580));
				frame.add(bezier, BorderLayout.CENTER);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}
