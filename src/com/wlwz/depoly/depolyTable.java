package com.wlwz.depoly;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.http.HttpSession;

import com.wlwz.util.ReqRes;

public class depolyTable {
	private String driverName = "com.mysql.jdbc.Driver";
	private String sourceURL = "jdbc:mysql://localhost:3306/wlwz";
	private Connection conn = null;
	private Statement statement = null;
//	private ResultSet resultSet = null;
	
	private Integer userGroup;
	
	public void setUsergroup(Integer userGroup) {
		this.userGroup = userGroup;
	}
	
	public void createDepolyTable() throws Exception{
		try{
		Class.forName(driverName);
		Properties prop = new Properties();
		prop.setProperty("user", "root");
		prop.setProperty("password", "102023");
		conn = DriverManager.getConnection(sourceURL, prop);
		statement = conn.createStatement();
		
		//HttpSession ses = ReqRes.getSession();
		
		//以用户组号来区分数据库表格
		String tableName = "runningData"+userGroup;
		System.out.println(tableName);
		int num = Integer.parseInt(PropertyData.readData("depolyNum"));
		//这里可以改进的地方是，创建数据库表格之前先看有没有同名表格存在，有则删除，这样用户发现不对了还可以再改
	//	String sql = " create table "+ tableName +"(deviceId int(8) PRIMARY KEY,";
		String sql = " create table "+ tableName +"(recordId int(8) PRIMARY KEY AUTO_INCREMENT,deviceId int(8),createTime datetime,";
		
		for(int i = 1; i <= num; i++){
			
			if(PropertyData.readData("depolyDataType_"+i).equals("timestamp")){
		      sql +=  "field_"+i+" "+PropertyData.readData("depolyDataType_"+i)
		         +", ";
			}
			else {
				if(PropertyData.readData("depolyDataLength_"+i) != null){
						sql +=  "field_"+i+" "+PropertyData.readData("depolyDataType_"+i)
							+"("+PropertyData.readData("depolyDataLength_"+i)+"), ";
				}
				else return;
					//TODO 这里可以发送一个msg，让前台提示数据配置信息不完整，出错了。
			}
			
			
		}
		sql = sql.substring(0, sql.length()-2)+ ");" ;
		System.out.println(sql);
		statement.executeUpdate(sql);	
		//以下是加入数据库外键关联，关联到device表格
	   String sql2 = "alter table "+ tableName + " add constraint FK_Reference_" + (19+userGroup)+" foreign key (deviceId) references device (deviceId) on delete restrict on update restrict;";
	   System.out.println(sql2);
	   statement.executeUpdate(sql2);
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					// 切记要关闭
					statement.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}		
	}
	}
}

