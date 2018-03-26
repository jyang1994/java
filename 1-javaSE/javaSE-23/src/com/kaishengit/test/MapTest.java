package com.kaishengit.test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapTest {

	public static void main(String[] args) {
		
		Map<String,String> maps = new Hashtable<>();
		maps.put("k1", "v1");
		maps.put("k2", "v2");
		maps.put("k3", "v3");
		
		Set<Entry<String,String>> entrys = maps.entrySet();
		
		for(Entry<String,String> entry : entrys) {
			
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + "-->" + value);
		}
		
		
		//����
		/*Set<String> keys = maps.keySet();// ���map���ϵ�key��Set����
		for(String key : keys) {//����key��Set����
			String value = maps.get(key); // ����ÿ�ε�����key���ӳ���value
			System.out.println(key + "-->" + value);
		}*/
		
		
		
		
		/*maps.remove("k1");
		System.out.println(maps.containsKey("k2"));
		System.out.println(maps.containsValue("v3"));
		
		System.out.println(maps.size());
		
		//get
		System.out.println(maps.get("k1"));*/
		
		
		
	}

}
