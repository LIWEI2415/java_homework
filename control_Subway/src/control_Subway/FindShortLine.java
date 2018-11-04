package control_Subway;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.mysql.jdbc.Connection;
import control_Subway.NotFoundException;
import control_Subway.subwayDA;

public class FindShortLine {
	public static double minDistance=0;
	//给定起点站和终点站的名称，返回一条最短路径，该路径是一 个包含从起点开始直到终点，所需要经过的所有站点的数组
		public static String findShortLine(String start,String end) throws NotFoundException{
			String str=null;//最后结果
			try {
				double distance=10000000;//一条路上的距离
				double distance1=0;//换一站的距离（用于循环）
				double distance2=10000000;//换一站的距离（用于取最小）
				double distance3=0;//换两站的距离（用于循环）
				double distance4=10000000;//换两站的距离（用于取最小）
				double min=0;//最小距离
				
				String TL=null;//换一站时换乘的线
				String TL1=null;//换两站时中间的线
				String TL2=null;//换两站时后面的线
				String TL3=null;//一条线
				String TL4=null;//换一站时前面的线
				String TL5=null;//换两站时前面的线
				int j=0;//此战是否是第一站
				int j1=0;//换一站时，前站，如上
				int j2=0;//换一站时，后站，如上
				int j3=0;//换两站时，前站，如上
				int j4=0;//换两站时，中站，如上
				int j5=0;//换两站时，后站，如上
				int w=0;//判断两站是否在一条线上
				int w1=0;//判断换乘两站的中两站是否在两条线上
				int line=0;//找出换一站时换乘的线
				int line1=0;//找出换两站时中间的线
				int line2=0;//找出换两站时后面的线
				int line3=0;//一条线上的线
				int line4=0;//换乘一站时前面的线
				int line5=0;//换乘两站时前面的线
				Statement sta1;//换乘两站时在开始站找换乘站
				Statement sta2;//换乘两站时在终点站找换乘站
				Statement sta;//找两站在一条线上的站集
				Statement sta3;//找起始站的线
				Statement sta4;//找终点站的线
				Statement sta5;//找出两站在一条线上的距离
				Statement sta6;//换一站时，找出起始站与换乘站间的站
				Statement sta7;//换一站时，找出换乘站与终点站间的站
				Statement sta8;//换一站时，找出此距离
				Statement sta9;//换两站时，找出起始站与第一个换乘站间的站
				Statement sta10;//换两站时，找出第一个换乘站与第二个换乘站间的站
				Statement sta11;//换两站时，找出第二个站与终点站间的站
				Statement sta12;//换两站时，找出此距离
				Statement sta13;//换两站时，找第一个换乘站的线
				Statement sta14;//换两站时，找第二个换乘站的线
				Statement sta15;//找出换一站时换乘的后线
				Statement sta16;//找出换两站时中间的线
				Statement sta17;//找出换两站时后面的线
				Statement sta18;//找出不换站的线路
				Statement sta19;//找出换一站时换乘的前站
				Statement sta20;//找出换两站时前面的线
				sta3=subwayDA.aConnection.createStatement();
				sta4=subwayDA.aConnection.createStatement();
				sta=subwayDA.aConnection.createStatement();
	            sta1=subwayDA.aConnection.createStatement();
	            sta2=subwayDA.aConnection.createStatement();
	            sta5=subwayDA.aConnection.createStatement();
	            sta6=subwayDA.aConnection.createStatement();
	            sta7=subwayDA.aConnection.createStatement();
	            sta8=subwayDA.aConnection.createStatement();
	            sta9=subwayDA.aConnection.createStatement();
	            sta10=subwayDA.aConnection.createStatement();
	            sta11=subwayDA.aConnection.createStatement();
	            sta12=subwayDA.aConnection.createStatement();
	            sta13=subwayDA.aConnection.createStatement();
	            sta14=subwayDA.aConnection.createStatement();
	            sta15=subwayDA.aConnection.createStatement();
	            sta16=subwayDA.aConnection.createStatement();
	            sta17=subwayDA.aConnection.createStatement();
	            sta18=subwayDA.aConnection.createStatement();
	            sta19=subwayDA.aConnection.createStatement();
	            sta20=subwayDA.aConnection.createStatement();
				ArrayList<String> transferStations = new ArrayList<String>();
				ArrayList<String> midStation=new ArrayList<String>();//一条线上的两个站间的站集
				ArrayList<String> midStation1=new ArrayList<String>();//换一个站的前站集
				ArrayList<String> midStation2=new ArrayList<String>();//换一个站的后站集
				ArrayList<String> midStation3=new ArrayList<String>();//换一站的总站集（用于循环）
				ArrayList<String> midStation4=new ArrayList<String>();//换一站的总站集（用于取最小）
				ArrayList<String> midStation5=new ArrayList<String>();//换两个站的前站集
				ArrayList<String> midStation6=new ArrayList<String>();//换两个站的中站集
				ArrayList<String> midStation7=new ArrayList<String>();//换两个站的后站集
				ArrayList<String> midStation8=new ArrayList<String>();//换两个站的总站集（用于循环）
				ArrayList<String> midStation9=new ArrayList<String>();//换两个站的总站集（用于取最小）
				ArrayList<String> al=new ArrayList<String>();//最后的结果
				String sql;
				String sql0;
			    String sql1;
			    String sql2;
			    String sql3;
			    String sql4;
			    String sql5;
			    String sql6 = null;
			    String sql7=null;
			    String sql8=null;
			    String sql9=null;
			    String sql10=null;
			    String sql11=null;
			    String sql12=null;
			    String sql13=null;
			    String sql14=null;
			    String sql15=null;
			    String sql16=null;
			    String sql17=null;
			    String sql18=null;
			    String sql19=null;
			    String sql20=null;
			    ResultSet rs = null;
			    ResultSet rs0 = null;
			    ResultSet rs1 = null;
			    ResultSet rs2 = null;
			    ResultSet rs3=null;
			    ResultSet rs4 = null;
			    ResultSet rs5=null;
			    ResultSet rs6=null;
			    ResultSet rs7=null;
			    ResultSet rs8=null;
			    ResultSet rs9=null;
			    ResultSet rs10=null;
			    ResultSet rs11=null;
			    ResultSet rs12=null;
			    ResultSet rs13=null;
			    ResultSet rs14=null;
			    ResultSet rs15=null;
			    ResultSet rs16=null;
			    ResultSet rs17=null;
			    ResultSet rs18=null;
			    ResultSet rs19=null;
			    ResultSet rs20=null;
			    sql3="SELECT BELONG FROM SUBWAYAL WHERE NAME = '"+start+"'";
			    sql4="SELECT BELONG FROM SUBWAYAL WHERE NAME = '"+end+"'";
			    rs3=sta3.executeQuery(sql3);
			    while(rs3.next()) {
			    	rs4=sta4.executeQuery(sql4);
			    	while(rs4.next()) {
			    		if(rs3.getInt("BELONG")==rs4.getInt("BELONG"))
			    			w=1;
			    		break;
			    	}
			    }
			    if(w==1) {
			    	distance=0;
			    sql="SELECT NAME FROM SUBWAYAL WHERE (ID BETWEEN (SELECT ID FROM SUBWAYAL WHERE NAME='"+start+"'"
	               		+ "AND BELONG =(SELECT BELONG FROM SUBWAYAL WHERE NAME='"+start+"'AND BELONG IN "
	               		+ "(SELECT BELONG FROM SUBWAYAL WHERE NAME='"+end+"'))) AND "
	               		+ "(SELECT ID FROM SUBWAYAL WHERE NAME='"+end+"' AND BELONG="
	               		+ "(SELECT BELONG FROM SUBWAYAL WHERE NAME='"+start+"' AND BELONG IN ("
	               		+ "SELECT BELONG FROM SUBWAYAL WHERE NAME ='"+end+"')))) "
	               		+ "OR"
	               		+"(ID BETWEEN (SELECT ID FROM SUBWAYAL WHERE NAME='"+end+"'"
	                    + "AND BELONG =(SELECT BELONG FROM SUBWAYAL WHERE NAME='"+start+"'AND BELONG IN "
	                    + "(SELECT BELONG FROM SUBWAYAL WHERE NAME='"+end+"'))) AND "
	                    + "(SELECT ID FROM SUBWAYAL WHERE NAME='"+start+"' AND BELONG="
	                    + "(SELECT BELONG FROM SUBWAYAL WHERE NAME='"+start+"' AND BELONG IN ("
	                    + "SELECT BELONG FROM SUBWAYAL WHERE NAME ='"+end+"')))) ";
			    rs=sta.executeQuery(sql);
			    while(rs.next()) {
			    	 midStation.add(rs.getString(1));
			    }
			    sql18="SELECT BELONG FROM SUBWAYAL WHERE NAME='"+start+"'AND BELONG IN "
	                  	+ "(SELECT BELONG FROM SUBWAYAL WHERE NAME='"+end+"')";
	        	   rs18=sta18.executeQuery(sql18);
	        	   while(rs18.next())
	        		   line3=rs18.getInt("BELONG");
	        	   if(line3==12)
	        		   TL3="在("+start+")乘阳逻线到("+end+")";
	        	   else
	        		   TL3="在("+start+")乘"+line3+"号线到("+end+")";
			    }
			   // else {
			    sql0 = "SELECT NAME FROM subwayAl WHERE BELONG in"
	                    + "(SELECT BELONG FROM subwayAl WHERE NAME = '"+ start + "')" 
	                    + "and NAME in(SELECT NAME FROM subwayAl WHERE BELONG in ("
	                    + "SELECT BELONG FROM subwayAl WHERE NAME = '" + end + "'))";
			    rs0 = subwayDA.aStatement.executeQuery(sql0);
			    while (rs0.next()) {
			    	transferStations.add(rs0.getString(1));
	            }
			   // if (transferStations.size() == 0) {
	                sql1 = "SELECT NAME FROM subwayAl WHERE BELONG in"
	                        + "(SELECT BELONG FROM subwayAl WHERE NAME = '" + start + "') "
	                        + "and NAME in(SELECT NAME FROM subwayAl WHERE BELONG in("
	                        + "SELECT BELONG FROM subwayAl WHERE BELONG not in"
	                        + "(SELECT BELONG FROM subwayAl WHERE NAME = '" + start + "')));";
	                rs1 = sta1.executeQuery(sql1);
	                while (rs1.next()) {
	                    sql2 = "SELECT NAME FROM subwayAl WHERE BELONG in"
	                            + "(SELECT BELONG FROM subwayAl WHERE NAME = '" + end + "')"
	                            + "and NAME in(SELECT NAME FROM subwayAl WHERE BELONG in("
	                            + "SELECT BELONG FROM subwayAl WHERE BELONG not in"
	                            + "(SELECT BELONG FROM subwayAl WHERE NAME = '" + end + "')))"
	                            + "and NAME in(SELECT NAME FROM subwayAl WHERE BELONG in"
	                            + "(SELECT BELONG FROM subwayAl WHERE NAME in"
	                            + "(SELECT NAME FROM subwayAl WHERE BELONG in"
	                            + "(SELECT BELONG FROM subwayAl WHERE NAME = '" + start + "')"
	                            + "and NAME in(SELECT NAME FROM subwayAl WHERE BELONG in("
	                            + "SELECT BELONG FROM subwayAl WHERE BELONG not in"
	                            + "(SELECT BELONG FROM subwayAl WHERE NAME = '" + start + "'))))))"
	                            + "and NAME in(SELECT NAME FROM subwayAl WHERE BELONG in"
	                            + "(SELECT BELONG FROM subwayAl WHERE NAME='" + rs1.getString(1) + "'));";
	                    rs2 = sta2.executeQuery(sql2);
	                    while (rs2.next()) {
	                    	w1=0;
	                    	 sql13="SELECT BELONG FROM SUBWAYAL WHERE NAME = '"+rs1.getString(1)+"'";
	             		    sql14="SELECT BELONG FROM SUBWAYAL WHERE NAME = '"+rs2.getString(1)+"'";
	             		    rs13=sta13.executeQuery(sql13);
	             		    while(rs13.next()) {
	             		    	rs14=sta14.executeQuery(sql14);
	             		    	while(rs14.next()) {
	             		    		if(rs13.getInt("BELONG")==rs14.getInt("BELONG"))
	             		    			w1++;
	             		    	}
	             		    }
	             		    if(w1>=2) 
	             		    	continue;
	                        //System.out.println("可换乘线路为：" + start + "————>" + rs1.getString(1) + "————>" + rs2.getString(1)
	                          //      + "————>" + end);
	                    sql9="SELECT NAME FROM SUBWAYAL WHERE (ID BETWEEN (SELECT ID FROM SUBWAYAL WHERE NAME='"+start+"'"
	                       		+ "AND BELONG =(SELECT BELONG FROM SUBWAYAL WHERE NAME='"+start+"'AND BELONG IN "
	                       		+ "(SELECT BELONG FROM SUBWAYAL WHERE NAME='"+rs1.getString(1)+"'))) AND "
	                       		+ "(SELECT ID FROM SUBWAYAL WHERE NAME='"+rs1.getString(1)+"' AND BELONG="
	                       		+ "(SELECT BELONG FROM SUBWAYAL WHERE NAME='"+start+"' AND BELONG IN ("
	                       		+ "SELECT BELONG FROM SUBWAYAL WHERE NAME ='"+rs1.getString(1)+"')))) "
	                       		+ "OR"
	                       		+"(ID BETWEEN (SELECT ID FROM SUBWAYAL WHERE NAME='"+rs1.getString(1)+"'"
	                            + "AND BELONG =(SELECT BELONG FROM SUBWAYAL WHERE NAME='"+start+"'AND BELONG IN "
	                            + "(SELECT BELONG FROM SUBWAYAL WHERE NAME='"+rs1.getString(1)+"'))) AND "
	                            + "(SELECT ID FROM SUBWAYAL WHERE NAME='"+start+"' AND BELONG="
	                            + "(SELECT BELONG FROM SUBWAYAL WHERE NAME='"+start+"' AND BELONG IN ("
	                            + "SELECT BELONG FROM SUBWAYAL WHERE NAME ='"+rs1.getString(1)+"')))) ";
	                    
	                    sql10="SELECT NAME FROM SUBWAYAL WHERE (ID BETWEEN (SELECT ID FROM SUBWAYAL WHERE NAME='"+rs2.getString(1)+"'"
	                       		+ "AND BELONG =(SELECT BELONG FROM SUBWAYAL WHERE NAME='"+rs2.getString(1)+"'AND BELONG IN "
	                       		+ "(SELECT BELONG FROM SUBWAYAL WHERE NAME='"+rs1.getString(1)+"'))) AND "
	                       		+ "(SELECT ID FROM SUBWAYAL WHERE NAME='"+rs1.getString(1)+"' AND BELONG ="
	                       		+ "(SELECT BELONG FROM SUBWAYAL WHERE NAME='"+rs2.getString(1)+"' AND BELONG IN ("
	                       		+ "SELECT BELONG FROM SUBWAYAL WHERE NAME ='"+rs1.getString(1)+"')))) "
	                       		+ "OR"
	                       		+"(ID BETWEEN (SELECT ID FROM SUBWAYAL WHERE NAME='"+rs1.getString(1)+"'"
	                            + "AND BELONG =(SELECT BELONG FROM SUBWAYAL WHERE NAME='"+rs2.getString(1)+"'AND BELONG IN "
	                            + "(SELECT BELONG FROM SUBWAYAL WHERE NAME='"+rs1.getString(1)+"'))) AND "
	                            + "(SELECT ID FROM SUBWAYAL WHERE NAME='"+rs2.getString(1)+"' AND BELONG ="
	                            + "(SELECT BELONG FROM SUBWAYAL WHERE NAME='"+rs2.getString(1)+"' AND BELONG IN ("
	                            + "SELECT BELONG FROM SUBWAYAL WHERE NAME ='"+rs1.getString(1)+"')))) ";
	                    
	                    sql11="SELECT NAME FROM SUBWAYAL WHERE (ID BETWEEN (SELECT ID FROM SUBWAYAL WHERE NAME='"+rs2.getString(1)+"'"
	                       		+ "AND BELONG =(SELECT BELONG FROM SUBWAYAL WHERE NAME='"+rs2.getString(1)+"'AND BELONG IN "
	                       		+ "(SELECT BELONG FROM SUBWAYAL WHERE NAME='"+end+"'))) AND "
	                       		+ "(SELECT ID FROM SUBWAYAL WHERE NAME='"+end+"' AND BELONG="
	                       		+ "(SELECT BELONG FROM SUBWAYAL WHERE NAME='"+rs2.getString(1)+"' AND BELONG IN ("
	                       		+ "SELECT BELONG FROM SUBWAYAL WHERE NAME ='"+end+"')))) "
	                       		+ "OR"
	                       		+"(ID BETWEEN (SELECT ID FROM SUBWAYAL WHERE NAME='"+end+"'"
	                            + "AND BELONG =(SELECT BELONG FROM SUBWAYAL WHERE NAME='"+rs2.getString(1)+"'AND BELONG IN "
	                            + "(SELECT BELONG FROM SUBWAYAL WHERE NAME='"+end+"'))) AND "
	                            + "(SELECT ID FROM SUBWAYAL WHERE NAME='"+rs2.getString(1)+"' AND BELONG="
	                            + "(SELECT BELONG FROM SUBWAYAL WHERE NAME='"+rs2.getString(1)+"' AND BELONG IN ("
	                            + "SELECT BELONG FROM SUBWAYAL WHERE NAME ='"+end+"')))) ";
	                   
	                    rs9=sta9.executeQuery(sql9);
	                    rs10=sta10.executeQuery(sql10);
	                    rs11=sta11.executeQuery(sql11);
	                    while(rs9.next()) {
	                 	   midStation5.add(rs9.getString(1));
	                    }
	                    while(rs10.next()) {
	                 	   midStation6.add(rs10.getString(1));
	                    }
	                    while(rs11.next()) {
	                 	   midStation7.add(rs11.getString(1));
	                    }
	                    //前站赋值给总集
	                    if(midStation5.get(0).equals(start)==true)
	                        for(int e1=0 ;e1<midStation5.size();e1++ ) {
	          		    	  j3++;
	          		    	  if(j3==1)
	          		    	  midStation8.add(midStation5.get(e1));
	          		    	  else {
	          		    	midStation8.add(midStation5.get(e1));	  
	          		    	  }
	          		    	  }
	                        else
	                     	   for(int e1=midStation5.size()-1 ;e1>=0;e1-- ) {
	               		    	  j3++;
	               		    	  if(j3==1)
	               		    		 midStation8.add(midStation5.get(e1));
	               		    	  else {
	               		    		midStation8.add(midStation5.get(e1));	  
	               		    	  }
	               		    	  }
	                    //中站赋值给总集
	                    if(midStation6.get(0).equals(rs1.getString(1))==true)
	                        for(int e1=0 ;e1<midStation6.size();e1++ ) {
	          		    	  j4++;
	          		    	  if(j4!=1)
	          		    	  midStation8.add(midStation6.get(e1));
	          		    	  }
	                        else
	                     	   for(int e1=midStation6.size()-1 ;e1>=0;e1-- ) {
	               		    	  j4++;
	               		    	  if(j4!=1)
	               		    		 midStation8.add(midStation6.get(e1));
	               		    	  }
	                    //后站集赋值给总集
	                    if(midStation7.get(0).equals(rs2.getString(1))==true)
	                        for(int e1=0 ;e1<midStation7.size();e1++ ) {
	          		    	  j5++;
	          		    	  if(j5!=1)
	          		    	  midStation8.add(midStation7.get(e1));
	          		    	  }
	                        else
	                     	   for(int e1=midStation7.size()-1 ;e1>=0;e1-- ) {
	               		    	  j5++;
	               		    	  if(j5!=1)
	               		    		 midStation8.add(midStation7.get(e1));
	               		    	  }
	                    for(int z=0;z<midStation8.size();z++) {
	             		   if(z!=0) {
	             		   sql12="SELECT DISTANCE FROM ALSUBWAY WHERE (SN='"+ midStation8.get(z-1)+"---"+midStation8.get(z)+"') OR(SN='"+ midStation8.get(z)+"---"+midStation8.get(z-1)+"')";
	  			    	  rs12=sta12.executeQuery(sql12);
	  			    	  while(rs12.next()) {
	  			    		  distance3=distance3+rs12.getDouble("DISTANCE");
	  			    	  }
	             	   }
	                }
	                    if(distance3<distance4) {
	                    	sql20="SELECT BELONG FROM SUBWAYAL WHERE NAME='"+start+"'AND BELONG IN "
	                              	+ "(SELECT BELONG FROM SUBWAYAL WHERE NAME='"+rs1.getString(1)+"')";
	                    	   rs20=sta20.executeQuery(sql20);
	                    	   while(rs20.next())
	                    		   line5=rs20.getInt("BELONG");
	                    	   if(line5==12)
	                    		   TL5="在("+start+")乘阳逻线到("+rs1.getString(1)+")";
	                    	   else
	                    		   TL5="在("+start+")乘"+line5+"号线到("+rs1.getString(1)+")";
	                    	sql16="SELECT BELONG FROM SUBWAYAL WHERE NAME='"+rs1.getString(1)+"'AND BELONG IN "
	                              	+ "(SELECT BELONG FROM SUBWAYAL WHERE NAME='"+rs2.getString(1)+"')";
	                    	   rs16=sta16.executeQuery(sql16);
	                    	   while(rs16.next())
	                    		   line1=rs16.getInt("BELONG");
	                    	   if(line1==12)
	                    		   TL1="在("+rs1.getString(1)+")换乘阳逻线到("+rs2.getString(1)+")";
	                    	   else
	                    		   TL1="在("+rs1.getString(1)+")换乘"+line1+"号线到("+rs2.getString(1)+")";
	                    	   sql17="SELECT BELONG FROM SUBWAYAL WHERE NAME='"+end+"'AND BELONG IN "
	                                 	+ "(SELECT BELONG FROM SUBWAYAL WHERE NAME='"+rs2.getString(1)+"')";
	                       	   rs17=sta17.executeQuery(sql17);
	                       	   while(rs17.next())
	                       		   line2=rs17.getInt("BELONG");
	                       	   if(line2==12)
	                       		   TL2="再在("+rs2.getString(1)+")换乘阳逻线到("+end+")";
	                       	   else
	                       		   TL2="再在("+rs2.getString(1)+")换乘"+line2+"号线到("+end+")";
	                 	   midStation9=(ArrayList<String>) midStation8.clone();
	                 	   distance4=distance3;
	                    }
	                    midStation5.clear();
	                    midStation6.clear();
	                    midStation7.clear();
	                    midStation8.clear();
	                    distance3=0;
	                    j3=0;
	                    j4=0;
	                    j5=0;
	                    }
	                }
	                
	            //}
			  //  else {
	            	for(int i=0;i<transferStations.size();i++) {
	            		if(start.equals(transferStations.get(i))==true||end.equals(transferStations.get(i))==true)
	            			continue;
	               sql6="SELECT NAME FROM SUBWAYAL WHERE (ID BETWEEN (SELECT ID FROM SUBWAYAL WHERE NAME='"+start+"'"
	               		+ "AND BELONG =(SELECT BELONG FROM SUBWAYAL WHERE NAME='"+start+"'AND BELONG IN "
	               		+ "(SELECT BELONG FROM SUBWAYAL WHERE NAME='"+transferStations.get(i)+"'))) AND "
	               		+ "(SELECT ID FROM SUBWAYAL WHERE NAME='"+transferStations.get(i)+"' AND BELONG="
	               		+ "(SELECT BELONG FROM SUBWAYAL WHERE NAME='"+start+"' AND BELONG IN ("
	               		+ "SELECT BELONG FROM SUBWAYAL WHERE NAME ='"+transferStations.get(i)+"')))) "
	               		+ "OR"
	               		+"(ID BETWEEN (SELECT ID FROM SUBWAYAL WHERE NAME='"+transferStations.get(i)+"'"
	                    + "AND BELONG =(SELECT BELONG FROM SUBWAYAL WHERE NAME='"+start+"'AND BELONG IN "
	                    + "(SELECT BELONG FROM SUBWAYAL WHERE NAME='"+transferStations.get(i)+"'))) AND "
	                    + "(SELECT ID FROM SUBWAYAL WHERE NAME='"+start+"' AND BELONG="
	                    + "(SELECT BELONG FROM SUBWAYAL WHERE NAME='"+start+"' AND BELONG IN ("
	                    + "SELECT BELONG FROM SUBWAYAL WHERE NAME ='"+transferStations.get(i)+"')))) ";
	               sql7="SELECT NAME FROM SUBWAYAL WHERE (ID BETWEEN (SELECT ID FROM SUBWAYAL WHERE NAME='"+end+"'"
	                  		+ "AND BELONG =(SELECT BELONG FROM SUBWAYAL WHERE NAME='"+end+"'AND BELONG IN "
	                   		+ "(SELECT BELONG FROM SUBWAYAL WHERE NAME='"+transferStations.get(i)+"'))) AND "
	                   		+ "(SELECT ID FROM SUBWAYAL WHERE NAME='"+transferStations.get(i)+"' AND BELONG="
	                   		+ "(SELECT BELONG FROM SUBWAYAL WHERE NAME='"+end+"' AND BELONG IN ("
	                   		+ "SELECT BELONG FROM SUBWAYAL WHERE NAME ='"+transferStations.get(i)+"')))) "
	                   		+ "OR"
	                   		+"(ID BETWEEN (SELECT ID FROM SUBWAYAL WHERE NAME='"+transferStations.get(i)+"'"
	                        + "AND BELONG =(SELECT BELONG FROM SUBWAYAL WHERE NAME='"+end+"'AND BELONG IN "
	                        + "(SELECT BELONG FROM SUBWAYAL WHERE NAME='"+transferStations.get(i)+"'))) AND "
	                        + "(SELECT ID FROM SUBWAYAL WHERE NAME='"+end+"' AND BELONG="
	                        + "(SELECT BELONG FROM SUBWAYAL WHERE NAME='"+end+"' AND BELONG IN ("
	                        + "SELECT BELONG FROM SUBWAYAL WHERE NAME ='"+transferStations.get(i)+"')))) ";
	               rs6=sta6.executeQuery(sql6);
	               rs7=sta7.executeQuery(sql7);
	               while(rs6.next()) {
	            	   midStation1.add(rs6.getString(1));
	               }
	               while(rs7.next()) {
	            	   midStation2.add(rs7.getString(1));
	               }
	               //将前站集赋给总站集
	               if(midStation1.get(0).equals(start)==true)
	               for(int e1=0 ;e1<midStation1.size();e1++ ) {
	 		    	  j1++;
	 		    	  if(j1==1)
	 		    	  //System.out.print(midStation1.get(e1));
	 		    	  midStation3.add(midStation1.get(e1));
	 		    	  else {
	 		    	  //System.out.print("————>"+midStation1.get(e1));
	 		    	midStation3.add(midStation1.get(e1));	  
	 		    	  }
	 		    	  }
	               else
	            	   for(int e1=midStation1.size()-1 ;e1>=0;e1-- ) {
	      		    	  j1++;
	      		    	  if(j1==1)
	      		    		 midStation3.add(midStation1.get(e1));
	      		    	  else {
	      		    		midStation3.add(midStation1.get(e1));	  
	      		    	  }
	      		    	  }
	               //将后站集赋给总站集
	               if(midStation2.get(midStation2.size()-1).equals(end)==true)
	                   for(int e2=0 ;e2<midStation2.size();e2++ ) {
	     		    	  j2++;
	     		    	  if(j2!=1)
	     		    		 midStation3.add(midStation2.get(e2));
	     		    	  }
	                   else
	                	   for(int e2=midStation2.size()-1 ;e2>=0;e2-- ) {
	          		    	  j2++;
	          		    	  if(j2!=1)
	          		    		 midStation3.add(midStation2.get(e2));
	          		    	  }
	               
	               for(int z=0;z<midStation3.size();z++) {
	            	  
	            		   //System.out.print(midStation3.get(j3));
	            		   if(z!=0) {
	            		   //System.out.print("————>"+midStation3.get(j3));
	            		   sql8="SELECT DISTANCE FROM ALSUBWAY WHERE (SN='"+ midStation3.get(z-1)+"---"+midStation3.get(z)+"') OR(SN='"+ midStation3.get(z)+"---"+midStation3.get(z-1)+"')";
	 			    	  rs8=sta8.executeQuery(sql8);
	 			    	  while(rs8.next()) {
	 			    		  distance1=distance1+rs8.getDouble("DISTANCE");
	 			    	  }
	            	   }
	               }
	               if(distance1<distance2) {
	            	   sql19="SELECT BELONG FROM SUBWAYAL WHERE NAME='"+start+"'AND BELONG IN "
	                         	+ "(SELECT BELONG FROM SUBWAYAL WHERE NAME='"+transferStations.get(i)+"')";
	               	   rs19=sta19.executeQuery(sql19);
	               	   while(rs19.next())
	               		   line4=rs19.getInt("BELONG");
	               	   if(line4==12)
	               		   TL4="在("+start+")乘阳逻线到("+transferStations.get(i)+")";
	               	   else
	               		   TL4="在("+start+")乘"+line4+"号线到("+transferStations.get(i)+")";
	            	   sql15="SELECT BELONG FROM SUBWAYAL WHERE NAME='"+end+"'AND BELONG IN "
	                      	+ "(SELECT BELONG FROM SUBWAYAL WHERE NAME='"+transferStations.get(i)+"')";
	            	   rs15=sta15.executeQuery(sql15);
	            	   while(rs15.next())
	            		   line=rs15.getInt("BELONG");
	            	   if(line==12)
	            		   TL="在("+transferStations.get(i)+")换乘阳逻线到("+end+")";
	            	   else
	            		   TL="在("+transferStations.get(i)+")换乘"+line+"号线到("+end+")";
	            	   midStation4=(ArrayList<String>) midStation3.clone();
	            	   distance2=distance1;
	               }
	              
	              
	               //重置准备再来
	               midStation1.clear();
	               midStation2.clear();
	               midStation3.clear();
	               distance1=0;
	               j1=0;
	               j2=0;
	            	}
	            	
	          //        }
	 		//      }
			   
	            min=distance;
	            if(min>distance2)
	            	min=distance2;
	           if(min>distance4)
	        	   min=distance4;
	           //一条线上的打印
	           if(min==distance) {
	        	   if(midStation.get(0).equals(start)==true) {
	     		      for(int e=0 ;e<midStation.size();e++ ) {
	     		    	  j++;
	     		    	  if(j==1)
	     		    	  al.add(midStation.get(e));
	     		    	  else {
	     		    	  al.add("————>"+midStation.get(e));
	     		    	  sql5="SELECT DISTANCE FROM ALSUBWAY WHERE (SN='"+ midStation.get(e-1)+"---"+midStation.get(e)+"') OR(SN='"+ midStation.get(e)+"---"+midStation.get(e-1)+"')";
	     		    	  rs5=sta5.executeQuery(sql5);
	     		    	  while(rs5.next()) {
	     		    		  distance=distance+rs5.getDouble("DISTANCE");
	     		    	  }
	     		    	  
	     		    	  }
	     		      }
	     		    }
	     		    else {
	     		    	 for(int e=midStation.size()-1 ;e>=0;e-- ) {
	     			    	  j++;
	     			    	  if(j==1)
	     			    	  al.add(midStation.get(e));
	     			    	  else {
	     			    	  al.add("————>"+midStation.get(e));
	     			    	  sql5="SELECT DISTANCE FROM ALSUBWAY WHERE (SN='"+ midStation.get(e+1)+"---"+midStation.get(e)+"') OR(SN='"+ midStation.get(e)+"---"+midStation.get(e+1)+"')";
	     			    	  rs5=sta5.executeQuery(sql5);
	     			    	  while(rs5.next()) {
	     			    		  distance=distance+rs5.getDouble("DISTANCE");
	     			    	  }
	     			    	  
	     			    	  }
	     			      }
	     		    }
	     		      
	     		     al.add("///"+TL3);
	     		      al.add("///"+"一共"+distance+"千米");
	           }
	           //换乘一站的打印
	           else if(min==distance2) {
	        	   if(midStation4.size()!=0) {
	              	 for(int t=0;t<midStation4.size();t++) {
	                 	   if(t==0)
	                 		   al.add(midStation4.get(t)); 
	                 	   else
	                 		  al.add("————>"+midStation4.get(t));
	                    }
	              	 
	              	 al.add("///"+TL4+"，"+TL);
	                    al.add("///"+"一共"+distance2+"千米");
	              	}
	           }
	           //换乘两站的打印
	           else if(min==distance4) {
	        	   for(int t=0;t<midStation9.size();t++) {
	            	   if(t==0)
	            		   al.add(midStation9.get(t)); 
	            	   else
	            		   al.add("————>"+midStation9.get(t));
	               }
	               al.add("///"+TL5+"，"+TL1+"，"+TL2);
	             al.add("///"+"一共"+distance4+"千米");
	          }
	          /* rs.close();rs1.close();rs2.close();rs3.close();rs4.close();rs5.close();rs6.close();rs7.close();
	           rs8.close();rs9.close();rs10.close();rs11.close();rs12.close();rs13.close();rs14.close();
	           rs15.close();rs16.close();rs17.close();rs18.close();rs19.close();rs20.close();为什么关闭会报错！！*/
	           minDistance=min; //System.out.println(distance);
	           str= String.join("",al);
			} 
			  
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return str;
			
		}
}
