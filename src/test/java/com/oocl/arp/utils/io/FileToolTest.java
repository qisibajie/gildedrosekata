package com.oocl.arp.utils.io;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.Test;

public class FileToolTest {
	
	@Test
	public void execute(){
		InputStreamTest();
	}
	
	public void InputStreamTest(){
		FileInputStream fin = null;
		try {
			fin = new FileInputStream("D:\\tmp\\test\\bea.txt");
			int a = -1;
			while((a=fin.read()) != -1){
				System.out.println("current: "+(char)a);
			}
			fin.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void InputStreamReaderTest(){
		InputStreamReader fin = null;
		try {
			fin = new InputStreamReader(new FileInputStream("D:\\tmp\\test\\bea.txt"), "UTF-8");
	
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
