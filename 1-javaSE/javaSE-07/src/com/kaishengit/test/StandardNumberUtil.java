package com.kaishengit.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StandardNumberUtil {

	private static Map<Integer, Double> tmaps = new HashMap<>();

	static {
		tmaps.put(1, 63.657);
		tmaps.put(2, 9.925);
		tmaps.put(3, 5.841);
		tmaps.put(4, 4.604);
		tmaps.put(5, 4.032);
		tmaps.put(6, 3.707);
		tmaps.put(7, 3.499);
		tmaps.put(8, 3.355);
		tmaps.put(9, 3.250);
		tmaps.put(10, 3.169);
		tmaps.put(11, 3.106);
		tmaps.put(12, 3.055);
		tmaps.put(13, 3.012);
		tmaps.put(14, 2.977);
		tmaps.put(15, 2.947);
		tmaps.put(16, 2.921);
	}

	public static double getStandardNum(double[] nums){
		List<Double> lists = new ArrayList<>();
		
		for(double num : nums) {
			lists.add(num);
		}
		return getStandardNum(lists);
	}
	
	public static double getStandardNum(List<Double> numList) {
		// ����
		Collections.sort(numList);

		// �޳�0.0
		for (int i = 0; i < numList.size(); i++) {
			if (numList.get(i) <= 0.0) {
				numList.remove(i);
			}
		}

		cleanMax(numList, numList.size() - 1);
		cleanMin(numList, 0);
		
		return getMean(numList);
	}

	private static void cleanMax(List<Double> numList,int index) {
		
		// �������ݷ�����ʱ����
		double temp = numList.get(index);
		// ȥ���±�Ϊindex��ֵ
		numList.remove(index);
		// ����ƽ����
		double mean = getMean(numList);
		// �����׼��
		double standard = getStandardDeviation(numList,mean);

		double derta = tmaps.get(numList.size()) * standard;
		
		System.out.println("ƽ������" + mean + "����׼�" + standard + ", derta:" + derta);
		
		// �Ա�|temp-��ȥ��temp��ƽ��ֵ| > derta Ϊ�쳣����
		if(Math.abs(temp - mean) > derta) {
			cleanMax(numList, numList.size() - 1);
		} else {
			numList.add(temp);
		}		
	}
	
	private static void cleanMin(List<Double> numList,int index) {
		
		// �������ݷ�����ʱ����
		double temp = numList.get(index);
		// ȥ���±�Ϊindex��ֵ
		numList.remove(index);
		// ����ƽ����
		double mean = getMean(numList);
		// �����׼��
		double standard = getStandardDeviation(numList,mean);

		double derta = tmaps.get(numList.size()) * standard;
		
		System.out.println("ƽ������" + mean + "����׼�" + standard + ", derta:" + derta);
		
		// �Ա�|temp-��ȥ��temp��ƽ��ֵ| > derta Ϊ�쳣����
		if(Math.abs(temp - mean) > derta) {
			cleanMin(numList, 0);
		} else {
			numList.add(0, temp);
		}		
		
	}
	

	/**
	 * ��������ƽ����
	 * 
	 * @param numList  ��������ƽ�����ļ���
	 * 
	 * @return ����ƽ����
	 */
	private static double getMean(List<Double> lists) {
		if (lists == null) {
			return 0.0;
		}

		if (lists.size() < 1) {
			return 0.0;
		}

		double sum = 0.0;
		for (Double res : lists) {
			sum += res;
		}
		return sum / lists.size();
	}

	/**
	 * ���ȥ���±�Ϊindex��list���ϵı�׼ֵ
	 * @param numList 
	 * @param mean ����ƽ��ֵ
	 * @param index ����Ϊ�쳣���ݵ�ֵ������Ϊ��ǰ�������ֵ��������Сֵ
	 * @return ��׼ֵ
	 */
	private static double getStandardDeviation(List<Double> numList, double mean) {

		//�������ֵƽ����
		double variance = 0.0;
		for(double num : numList) {
			variance += Math.pow((num - mean), 2); //�������sum((Ԫ��ֵ��- ƽ����)^��)
		}
		
		//���ر�׼������ƽ����=(��ֵƽ����/n-1)��ƽ����
		return Math.sqrt(variance / (numList.size() - 1));
	}

}
