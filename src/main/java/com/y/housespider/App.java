package com.y.housespider;

import java.io.File;
import java.io.FileOutputStream;

import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.SimpleNodeIterator;

public class App {
	
	
	
	public static void main(String[] args) {
		Parser parser = new Parser();
		
		try {
			//设置url 及编码
			parser.setURL("https://hz.zu.anjuke.com/");
			parser.setEncoding("utf-8");
			//设置过滤器
			NodeFilter filter = new HasAttributeFilter("id", "list-content");
			//
			NodeList list = parser.parse(filter);
			
			//写文件
			File file = new File("E:\\info.txt");
			FileOutputStream fos = new FileOutputStream(file);

			SimpleNodeIterator iterator = list.elements();
			while(iterator.hasMoreNodes()){
				Node node = iterator.nextNode();
				fos.write(node.toHtml().getBytes());
				
				
			}
			System.out.println("完成了");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("出错了");
			e.printStackTrace();
		}
		
		
		
	}
}
