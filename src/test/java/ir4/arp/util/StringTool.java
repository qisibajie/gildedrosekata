package ir4.arp.util;

import org.junit.Test;

import java.util.*;

public class StringTool {
	
	@Test
	public void test() {
//		System.out.println((char) ('A' + 1) + "");
		String[] strArray = "str,str,str,bcd".split(",");
		List<String> stringList = Arrays.asList(strArray);
		Set<String> set = new HashSet<>(stringList);
		for(String s: set){
			System.out.println(s);
		}
	}

}
