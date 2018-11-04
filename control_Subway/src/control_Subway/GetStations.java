package control_Subway;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import control_Subway.NotFoundException;
import control_Subway.subwayDA;
import com.mysql.jdbc.Connection;

public class GetStations {
	static ArrayList al=new ArrayList();
	private static String Sb1="subway1";
	private static String Sb2="subway2";
	private static String Sb3="subway3";
	private static String Sb4="subway4";
	private static String Sb6="subway6";
	private static String Sb7="subway7";
	private static String Sb8="subway8";
	private static String Sb11="subway11";
	private static String SbYL="subwayYL";
	//给定线路名和终点方向（比如 2 号线，光谷广场方向），返回 该线路中所有站点的顺序列表
		public static String getStations(String line,String endStation) {
			String str=null;
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
			    rs = subwayDA.aStatement.executeQuery("SELECT SN FROM "+sbl+"");
			    int j=1;
			    int length;
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
			    		if(i==SN.size()-1)
			    		al.add(SN.get(i));
			    		else
			    			al.add("---"+SN.get(i));
			    }
			    if(SN.get(SN.size()-1).indexOf(endStation)!=-1) {
			    	for(int i=0;i<SN.size();i++)
			    		if(i==0)
			    		al.add(SN.get(i));
			    		else
			    		al.add("---"+SN.get(i));
			    }
			    rs.close();
			    
			    str= String.join("",al);
			}catch(SQLException e) {
				System.out.println(e);
			}
			return str;
		}
}
