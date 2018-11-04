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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import control_Subway.GetStations;
import control_Subway.subwayDA;
public class Demo2 extends JFrame implements ActionListener {
	JTextField messageText1;
	JTextField messageText2;
	JTextArea resultText;
	JButton calBtn;
	Container c=this.getContentPane();
	public Demo2(Demo demo) {
		c.setLayout(new FlowLayout());
		JPanel centerPanel=new JPanel(new GridLayout(4,2,20,10));
		messageText1=new JTextField(10);
		messageText2=new JTextField(10);
		JLabel messageLabel=new JLabel("请输入线路名：");
		JLabel messageLabel1=new JLabel("请输入终点名：");
		calBtn=new JButton("查询");
		resultText=new JTextArea("请给定线路名和终点方向（比如 2 号线，光谷广场方向）\n"+"查询结果：",8,40);
		resultText.setLineWrap(true);
		resultText.setWrapStyleWord(true);
	
		centerPanel.add(messageLabel);
		centerPanel.add(messageText1);
		centerPanel.add(messageLabel1);
		centerPanel.add(messageText2);
		centerPanel.add(calBtn);
		c.add(centerPanel);
		c.add(resultText);
		calBtn.addActionListener(this);
		this.setTitle("以线找站");
		this.setSize(500, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(200, 200);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		subwayDA.initialize();
		// TODO Auto-generated method stub
		if(e.getSource()==calBtn) {
		resultText.setText("此线路有的站有：");
		resultText.append("\n"+GetStations.getStations(messageText1.getText(),messageText2.getText()));
		}
		subwayDA.terminate();
	}

}
