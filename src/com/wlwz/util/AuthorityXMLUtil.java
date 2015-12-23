package com.wlwz.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.wlwz.vo.AuthorityNoAndName;

public class AuthorityXMLUtil {
	// 初始化系统使用的权限菜单数据结构�?
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AuthorityXMLUtil au = new AuthorityXMLUtil();
		// au.testWriteXml("/root/Desktop/authority.xml");
		// String content=au.readAuthoryContent("/root/Desktop/authority.xml",
		// 1);
		// System.out.println(content);
		List list = au.getAuthoritiesNOAndName("/root/Desktop/authority.xml");
		System.out.println(JSONArray.fromObject(list).toString());
	}

	/**
	 *测试�?
	 */
	private boolean testWriteXml(String xmlfilename) {
		Document document = DocumentHelper.createDocument();
		Element root = document.addElement("authoritys");
		Element authority = root.addElement("authority");
		authority.addAttribute("authNO", 1 + "");
		// Element authoNO=authority.addElement("authNO");
		// authoNO.addText("{fdsafd}");
		Element authoContent = authority.addElement("content");
		authoContent.addText("ceshi");
		authority.addElement("method").addText("sysMenu");
		root.addElement("authority").addAttribute("authNO", 2 + "").addElement(
				"content");
		return writeXML(xmlfilename, document);
	}

	/**
	 * 将代表xml的文件对象，以xml文件的形式保�? *
	 * 
	 * @param xmlfilename
	 *            xml文件�? * @param document 代表xml的文件对�? * @return 成功写入xml
	 *            返回true，否则，返回false
	 */
	public boolean writeXML(String xmlfilename, Document document) {
		boolean flag = false;
		try {
			/** 格式化输�?类型IE浏览�?�� */
			OutputFormat format = OutputFormat.createPrettyPrint();
			/** 将document中的内容写入文件�? */
			XMLWriter writer = new XMLWriter(new OutputStreamWriter(
					new FileOutputStream(xmlfilename)), format);// OutputFormat对象，用于指定显示和编码方式�?
																// writer.write(document);
			writer.close();
			/** 执行成功,�?���? */
			flag = true;
		} catch (Exception ex) {
			// LOGGER.error("", ex);
			ex.printStackTrace();
		}
		return flag;
	}

	private String readAuthoryContent(String xmlFileName, int authNO) {
		File file = new File(xmlFileName);
		if (!file.exists()) {
			System.out.println("读取算法配置文件出错");
			return null;
		}
		SAXReader saxReader = new SAXReader();
		Document document = null;
		try {
			document = saxReader.read(file);
			Element root = document.getRootElement();
			List<Element> list = root.selectNodes("/authoritys/authority");
			String test = null;
			for (Element etest : list) {
				System.out.println(test = etest.elementTextTrim("method"));
				System.out.println(test.equals(""));
				System.out.println(etest.attributeValue("authNO"));
				System.out.println(etest.elementTextTrim("content"));
			}
			return root.selectSingleNode(
					"/authoritys/authority[@authNO=" + authNO + "]/content")
					.getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 从权限文件中获得权限AuthorityNoAndName的对�? * @return
	 */
	public List<AuthorityNoAndName> getAuthoritiesNOAndName(String xmlFileName) {
		// String xmlFileName = SystemConfig.authrityXMLFileAbsolutePath;
		File file = new File(xmlFileName);
		if (!file.exists()) {
			System.out.println("读取算法配置文件出错");
			return null;
		}
		SAXReader saxReader = new SAXReader();
		Document document = null;
		List<AuthorityNoAndName> authoritiesList = null;
		try {
			document = saxReader.read(file);
			Element root = document.getRootElement();
			List<Element> authoritiesElementList = root
					.selectNodes("/authoritys/authority");
			if (authoritiesElementList != null) {
				authoritiesList = new ArrayList<AuthorityNoAndName>(100);
				AuthorityNoAndName auth = null;
				for (Element authority : authoritiesElementList) {
					auth = new AuthorityNoAndName();
					auth.setNO(authority.attributeValue("authNO"));
					auth.setName(authority.selectSingleNode("authName")
							.getText());
					authoritiesList.add(auth);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return authoritiesList;
	}
}
