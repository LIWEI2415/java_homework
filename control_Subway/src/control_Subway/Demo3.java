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
import javax.swing.SwingConstants;

import control_Subway.FindShortLine;
import control_Subway.GetCost;
import control_Subway.subwayDA;
public class Demo3 extends JFrame implements ActionListener {
	JTextField messageText1;
	JTextField messageText2;
	JTextField messageText3;
	JTextArea resultText;
	JButton calBtn;
	Container c=this.getContentPane();
	public Demo3(Demo demo) {
		c.setLayout(new FlowLayout());
		JPanel centerPanel=new JPanel(new GridLayout(4,2,20,10));
		messageText1=new JTextField(10);
		messageText2=new JTextField(10);
		messageText3=new JTextField(10);
		JLabel messageLabel=new JLabel("请输入起点站名：");
		JLabel messageLabel1=new JLabel("请输入终点站名：");
		JLabel messageLabel2=new JLabel("<html><body>"+"请输入的票类型"+"<br>"+"（普通单程票，武汉通和日票）："+"<body></html>");
		messageLabel.setHorizontalAlignment(SwingConstants.RIGHT); 
		messageLabel1.setHorizontalAlignment(SwingConstants.RIGHT); 
		messageLabel2.setHorizontalAlignment(SwingConstants.RIGHT); 
		calBtn=new JButton("查询");
		resultText=new JTextArea("查询结果：",8,40);
		resultText.setLineWrap(true);
		resultText.setWrapStyleWord(true);
	
		centerPanel.add(messageLabel);
		centerPanel.add(messageText1);
		centerPanel.add(messageLabel1);
		centerPanel.add(messageText2);
		centerPanel.add(messageLabel2);
		centerPanel.add(messageText3);
		centerPanel.add(calBtn);
		c.add(centerPanel);
		c.add(resultText);
		calBtn.addActionListener(this);
		this.setTitle("乘车找我");
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
		resultText.setText("线路：");
		try {
			resultText.append("\n"+FindShortLine.findShortLine(messageText1.getText(),messageText2.getText()));
		} catch (NotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//resultText.setText("\n价格：");
		try {
			resultText.append("\n"+GetCost.getCost(messageText3.getText()));
		} catch (NotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}
		subwayDA.terminate();
	}

}
