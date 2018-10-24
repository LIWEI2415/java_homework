package control_Subway;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

import control_Subway.NotFoundException;

public class subwayDA {
	static Connection aConnection;
	static Statement aStatement;
	//连接数据库
	public static Connection initialize(){
		try {
			aConnection = (Connection) DriverManager.getConnection(
				       "jdbc:mysql://localhost:3306/subwayline?useSSL=false&useUnicode=true&characterEncoding=utf8"  
				      ,"root","SatanWYW"
				     // +"user=root&password=SatanWYW"
				      //+"&serverTimezone=Asia/Shanghai"
				     // +"&useSSL=true"
				      //+"&allowPublicKeyRetrieval=true"
				        );
			aStatement = aConnection.createStatement();
		}
		catch(SQLException e) {
			System.out.println(e);
		}
		return aConnection;
	}
	//关闭数据库
	public static void terminate() {
		try {
			aStatement.close();
			aConnection.close();
		}
		catch(SQLException e) {
			System.out.println(e);
		}
	}
	public static void findTarget() throws NotFoundException{
		try {
		ResultSet rs1=aStatement.executeQuery("SELECT distance FROM subway1 WHERE SN='三店---码头潭公园'");
	while(rs1.next()) {
		double d=0;
		d=rs1.getDouble("distance");
			System.out.println(d);
	}
		
	   rs1.close();
		}
		catch(SQLException e) {
			System.out.println(e);
		}
	}
}
