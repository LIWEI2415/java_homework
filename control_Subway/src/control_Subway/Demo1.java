package control_Subway;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import control_Subway.FindLine;
import control_Subway.subwayDA;
public class Demo1 extends JFrame implements ActionListener {
	JTextField messageText;
	JTextArea resultText;
	JButton calBtn;
	Container c=this.getContentPane();
    public Demo1(Demo demo) {
    	
		c.setLayout(new FlowLayout());
		JPanel centerPanel=new JPanel(new FlowLayout());
		messageText=new JTextField(10);
		JLabel messageLabel=new JLabel("请输入站点名：");
		calBtn=new JButton("查询");
		resultText=new JTextArea("查询结果：",8,25);
		centerPanel.add(messageLabel);
		centerPanel.add(messageText);
		centerPanel.add(calBtn);
		c.add(centerPanel);
		c.add(resultText);
		calBtn.addActionListener(this);
		this.setTitle("按站寻线");
		this.setSize(500, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(200, 200);
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		subwayDA.initialize();
		// TODO Auto-generated method stub
		if(e.getSource()==calBtn) {
		resultText.setText("此站在的线路有：");
		try {
			resultText.append("\n"+FindLine.findLine(messageText.getText()));
		} catch (NotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}
		subwayDA.terminate();
	}

}
