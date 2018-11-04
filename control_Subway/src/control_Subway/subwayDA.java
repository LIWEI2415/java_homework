package control_Subway;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import control_Subway.NotFoundException;

public class subwayDA {
	public static Connection aConnection;
	public static Statement aStatement;
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
}
