//声明：此文件根据网址：http://blog.csdn.net/honglei915/article/details/4829866 来建立，仅供学习参考
package com.wlwz.depoly;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Properties;

/**
 * @author honglei915
 * @Email cl-handsome@163.com http://blog.csdn.net/honglei915
 */
public class PropertyData {

	private static String PROPERTY_FILE;

	/**
	 * 指定property文件
	 */
	//以用户组号来区分properties文件
	//private static  String PROPERTY_FILE =  "D:/test/wlwz_"+userGroup+".properties";
	//private  final String PROPERTY_FILE = this.getClass().getResourceAsStream("/wlw.properties"); 据说是可以得到src下目录的方式
	public static void setPropertyFile(Integer userGroup){
		 PROPERTY_FILE = "D:/test/wlwz_"+userGroup+".properties";;
	}
	//test
	public String getPropertyFile(){
		return this.PROPERTY_FILE;
	}
	//test

	/**
	 *根据Key 读取Value
	 * 
	 * @param key
	 * @return
	 */
	public  static String readData(String key) {
		Properties props = new Properties();
		try {
		//	InputStream in = new BufferedInputStream(new FileInputStream(
		//			PROPERTY_FILE));
	//下面解决了从java端写入的中文导致的乱码问题，本项目中正好是这种方式 
    //但是如果用notepad++来写中文的properties文件，一样还是要出问题，这跟不同工具编码方式不同有关，先不管了，后面需要的时候再考虑
	  InputStreamReader in = new InputStreamReader(new FileInputStream(
			  PROPERTY_FILE),"ISO-8859-1");
		
	
			BufferedReader  bf=new BufferedReader(in); 
			props.load(bf);
			in.close();
			String value = props.getProperty(key);
			return value;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	/**
	 * 修改或添加键值对 如果key存在，修改 反之，添加。
	 * 
	 * @param key
	 * @param value
	 */
	public static void writeData(String key, String value) {
		Properties prop = new Properties();
		try {
			File file = new File(PROPERTY_FILE);
			if (!file.exists())
				file.createNewFile();
			InputStream fis = new FileInputStream(file);
			prop.load(fis);
			fis.close();//一定要在修改值之前关闭fis
			OutputStream fos = new FileOutputStream(PROPERTY_FILE);
			prop.setProperty(key, value);
			prop.store(fos, "Update '" + key + "' value");
			fos.close();
		} catch (IOException e) {
			System.err.println("Visit " + PROPERTY_FILE + " for updating "
					+ value + " value error");
		}
	}
	
	
	
	
}