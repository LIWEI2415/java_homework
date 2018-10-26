package control_Subway;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import control_Subway.NotFoundException;

public class subwayDA {
	static Connection aConnection;
	static Statement aStatement;
	private static String Sb1="subway1";
	private static String Sb2="subway2";
	private static String Sb3="subway3";
	private static String Sb4="subway4";
	private static String Sb6="subway6";
	private static String Sb7="subway7";
	private static String Sb8="subway8";
	private static String Sb11="subway11";
	private static String SbYL="subwayYL";
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
	//给定站定名，返回经过该站点的所有线路的名称集合
	public static void findLine(String a) throws NotFoundException{
		int i=0;
		try {
		ResultSet rs1=aStatement.executeQuery("SELECT SN FROM "+Sb1+"" );
	while(rs1.next()) {
		if(rs1.getString("SN").indexOf(a)!=-1) {
			i=1;
			break;
		}
			
		else i=0;
	}
	if(i==1)
		System.out.println("1号线");
	   rs1.close();
	   ResultSet rs2=aStatement.executeQuery("SELECT SN FROM "+Sb2+"" );
		while(rs2.next()) {
			if(rs2.getString("SN").indexOf(a)!=-1) {
				i=1;
				break;
			}
				
			else i=0;
		}
		if(i==1)
			System.out.println("2号线");
		   rs2.close();
		   ResultSet rs3=aStatement.executeQuery("SELECT SN FROM "+Sb3+"" );
			while(rs3.next()) {
				if(rs3.getString("SN").indexOf(a)!=-1) {
					i=1;
					break;
				}
					
				else i=0;
			}
			if(i==1)
				System.out.println("3号线");
			   rs3.close();
			   ResultSet rs4=aStatement.executeQuery("SELECT SN FROM "+Sb4+"" );
				while(rs4.next()) {
					if(rs4.getString("SN").indexOf(a)!=-1) {
						i=1;
						break;
					}
						
					else i=0;
				}
				if(i==1)
					System.out.println("4号线");
				   rs4.close();
				   ResultSet rs6=aStatement.executeQuery("SELECT SN FROM "+Sb6+"" );
					while(rs6.next()) {
						if(rs6.getString("SN").indexOf(a)!=-1) {
							i=1;
							break;
						}
							
						else i=0;
					}
					if(i==1)
						System.out.println("6号线");
					   rs6.close();
					   ResultSet rs7=aStatement.executeQuery("SELECT SN FROM "+Sb7+"" );
						while(rs7.next()) {
							if(rs7.getString("SN").indexOf(a)!=-1) {
								i=1;
								break;
							}
								
							else i=0;
						}
						if(i==1)
							System.out.println("7号线");
						   rs7.close();
						   ResultSet rs8=aStatement.executeQuery("SELECT SN FROM "+Sb8+"" );
							while(rs8.next()) {
								if(rs8.getString("SN").indexOf(a)!=-1) {
									i=1;
									break;
								}
									
								else i=0;
							}
							if(i==1)
								System.out.println("8号线");
							   rs8.close();				   
							   ResultSet rsYL=aStatement.executeQuery("SELECT SN FROM "+SbYL+"" );
								while(rsYL.next()) {
									if(rsYL.getString("SN").indexOf(a)!=-1) {
										i=1;
										break;
									}
										
									else i=0;
								}
								if(i==1)
									System.out.println("阳逻号线");
								   rsYL.close();
								   ResultSet rs11=aStatement.executeQuery("SELECT SN FROM "+Sb11+"" );
									while(rs11.next()) {
										if(rs11.getString("SN").indexOf(a)!=-1) {
											i=1;
											break;
										}
											
										else i=0;
									}
									if(i==1)
										System.out.println("11号线");
									   rs11.close();
		}
		
		catch(SQLException e) {
			System.out.println(e);
		}
	}
    //给定线路名和终点方向（比如 2 号线，光谷广场方向），返回 该线路中所有站点的顺序列表
	public static void getStations(String line,String endStation) {
		String sbl = null;
		if(line.equals("1号线")==true) sbl=Sb1;
		if(line.equals("2号线")==true) sbl=Sb2;
		if(line.equals("3号线")==true) sbl=Sb3;
		if(line.equals("4号线")==true) sbl=Sb4;
		if(line.equals("6号线")==true) sbl=Sb6;
		if(line.equals("7号线")==true) sbl=Sb7;
		if(line.equals("8号线")==true) sbl=Sb8;
		if(line.equals("11号线")==true) sbl=Sb11;
		if(line.equals("阳逻线")==true) sbl=SbYL;
		try {
			ArrayList<String> SN=new ArrayList<String>();
			ResultSet rs;
		    rs = aStatement.executeQuery("SELECT SN FROM "+sbl+"");
		    int j=1;
		    int length;
		    String station;
		    
		    while(rs.next()) {
		    	length=rs.getString("SN").indexOf("---");
		    	if(j==1) {
				  SN.add(rs.getString("SN").substring(0, length));
		    	}
		    	else {
		    		SN.add(rs.getString("SN").substring(length+3,rs.getString("SN").length()));
		    	}
		    	j++;
		    }
		    if(SN.get(0).indexOf(endStation)!=-1) {
		    	for(int i=SN.size()-1;i>=0;i--)
		    		if(i==SN.size())
		    		System.out.print(SN.get(i));
		    		else
		    			System.out.print("---"+SN.get(i));
		    }
		    if(SN.get(SN.size()-1).indexOf(endStation)!=-1) {
		    	for(int i=0;i<SN.size();i++)
		    		if(i==0)
		    		System.out.print(SN.get(i));
		    		else
		    			System.out.print("---"+SN.get(i));
		    }
		}catch(SQLException e) {
			System.out.println(e);
		}
	}
}
