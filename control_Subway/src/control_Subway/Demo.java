package control_Subway;


import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Demo extends JFrame{
	public  Demo(){
		JFrame jf=new JFrame();
		Container container=jf.getContentPane();
		container.setLayout(new GridLayout(3, 1, 10, 10));
		JButton b1=new JButton("按站寻线");
		JButton b2=new JButton("以线找站");
		JButton b3=new JButton("乘车点我");
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new Demo1(Demo.this).setVisible(true);
			}
		});
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new Demo2(Demo.this).setVisible(true);
			}
		});
		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new Demo3(Demo.this).setVisible(true);
			}
		});
		container.add(b1);
		container.add(b2);
		container.add(b3);
		jf.setTitle("地铁作业");
		jf.setSize(500,400);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLocation(200, 200);
		jf.setVisible(true);
    }

}
	


