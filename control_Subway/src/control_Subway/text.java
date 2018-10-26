package control_Subway;

import java.util.Scanner;

import control_Subway.NotFoundException;
import control_Subway.subwayDA;

public class text {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//链接数据库
		subwayDA.initialize();
		//给定站定名，返回经过该站点的所有线路的名称集合
		try {
			System.out.println("请输入想查询的站点名");
			Scanner in=new Scanner(System.in);
			String subwayName=in.nextLine();
			subwayDA.findLine(subwayName);
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//给定线路名和终点方向（比如 2 号线，光谷广场方向），返回 该线路中所有站点的顺序列表
		try {
			System.out.println("请给定线路名和终点方向（比如 2 号线，光谷广场方向）");
			System.out.println("请输入想查询的线路：");
			Scanner in=new Scanner(System.in);
			String lineName=in.nextLine();
			System.out.println("请输入想查询的终点方向：");
			Scanner in1=new Scanner(System.in);
			String endStation=in1.nextLine();
			subwayDA.getStations(lineName, endStation);
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//关闭数据库
		subwayDA.terminate();
	}

}
