package control_Subway;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import control_Subway.NotFoundException;
import control_Subway.subwayDA;
import com.mysql.jdbc.Connection;

public class FindLine {
	//给定站定名，返回经过该站点的所有线路的名称集合
	private static String Sb1="subway1";
	private static String Sb2="subway2";
	private static String Sb3="subway3";
	private static String Sb4="subway4";
	private static String Sb6="subway6";
	private static String Sb7="subway7";
	private static String Sb8="subway8";
	private static String Sb11="subway11";
	private static String SbYL="subwayYL";
		public static String findLine(String a) throws NotFoundException{
			int i=0;
			try {
			ResultSet rs1=subwayDA.aStatement.executeQuery("SELECT SN FROM "+Sb1+"" );
		while(rs1.next()) {
			if(rs1.getString("SN").indexOf(a)!=-1) {
				i=1;
				break;
			}
				
			else i=0;
		}
		if(i==1)
			return "1号线";
		   rs1.close();
		   ResultSet rs2=subwayDA.aStatement.executeQuery("SELECT SN FROM "+Sb2+"" );
			while(rs2.next()) {
				if(rs2.getString("SN").indexOf(a)!=-1) {
					i=1;
					break;
				}
					
				else i=0;
			}
			if(i==1)
				return ("2号线");
			   rs2.close();
			   ResultSet rs3=subwayDA.aStatement.executeQuery("SELECT SN FROM "+Sb3+"" );
				while(rs3.next()) {
					if(rs3.getString("SN").indexOf(a)!=-1) {
						i=1;
						break;
					}
						
					else i=0;
				}
				if(i==1)
					return ("3号线");
				   rs3.close();
				   ResultSet rs4=subwayDA.aStatement.executeQuery("SELECT SN FROM "+Sb4+"" );
					while(rs4.next()) {
						if(rs4.getString("SN").indexOf(a)!=-1) {
							i=1;
							break;
						}
							
						else i=0;
					}
					if(i==1)
						return("4号线");
					   rs4.close();
					   ResultSet rs6=subwayDA.aStatement.executeQuery("SELECT SN FROM "+Sb6+"" );
						while(rs6.next()) {
							if(rs6.getString("SN").indexOf(a)!=-1) {
								i=1;
								break;
							}
								
							else i=0;
						}
						if(i==1)
							return("6号线");
						   rs6.close();
						   ResultSet rs7=subwayDA.aStatement.executeQuery("SELECT SN FROM "+Sb7+"" );
							while(rs7.next()) {
								if(rs7.getString("SN").indexOf(a)!=-1) {
									i=1;
									break;
								}
									
								else i=0;
							}
							if(i==1)
								return("7号线");
							   rs7.close();
							   ResultSet rs8=subwayDA.aStatement.executeQuery("SELECT SN FROM "+Sb8+"" );
								while(rs8.next()) {
									if(rs8.getString("SN").indexOf(a)!=-1) {
										i=1;
										break;
									}
										
									else i=0;
								}
								if(i==1)
									return("8号线");
								   rs8.close();				   
								   ResultSet rsYL=subwayDA.aStatement.executeQuery("SELECT SN FROM "+SbYL+"" );
									while(rsYL.next()) {
										if(rsYL.getString("SN").indexOf(a)!=-1) {
											i=1;
											break;
										}
											
										else i=0;
									}
									if(i==1)
										return("阳逻号线");
									   rsYL.close();
									   ResultSet rs11=subwayDA.aStatement.executeQuery("SELECT SN FROM "+Sb11+"" );
										while(rs11.next()) {
											if(rs11.getString("SN").indexOf(a)!=-1) {
												i=1;
												break;
											}
												
											else i=0;
										}
										if(i==1)
											return("11号线");
										   rs11.close();
			}
			
			catch(SQLException e) {
				System.out.println(e);
			}
			return "错误输入";
		}
}
