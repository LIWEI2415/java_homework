package control_Subway;

import java.util.Scanner;

import javax.swing.JFrame;

import control_Subway.NotFoundException;
import control_Subway.subwayDA;
import control_Subway.FindLine;
import control_Subway.FindShortLine;
import control_Subway.GetCost;
import control_Subway.GetStations;
import control_Subway.Demo;
public class text extends JFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//链接数据库
		subwayDA.initialize();
		Demo de = new Demo();
		//关闭数据库
		subwayDA.terminate();
	}

}
