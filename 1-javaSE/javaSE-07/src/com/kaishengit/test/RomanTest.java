package com.kaishengit.test;

import org.apache.commons.math3.analysis.function.Abs;
import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;
import org.apache.commons.math3.stat.descriptive.moment.Variance;

public class RomanTest {

	public static void main(String[] args) {
		/*double[] values = new double[] { 0.33, 1.33, 0.27333, 0.3, 0.501, 0.444, 0.44, 0.34496, 0.33, 0.3, 0.292,0.667 };*/
//		double[] values = new double[] {1.05,1.05,1.06,1.06,1.05,1.09,1.09,1.09,1.08,1.08,1.08,1.08,1.09,1.09,1.08,1.09 };
//		double[] values = new double[] {1.10,1.10,1.09,1.08,1.08,1.07,1.04,1.06,1.08,1.07,1.08,1.07,1.06,1.05,1.03,1.09 };
//		double[] values = {1.07,1.02,1.08,1.08,1.18,1.55,1.09,1.08,1.07,1.09,1.11,1.12,1.11,1.13,1.10,0.00};
//		double[] values = {1.07,1.05,1.07,1.08,1.08,1.08,1.09,1.08,1.08,1.03,1.08,1.08,0.00,0.00,0.00,0.00};
//		double[] values = {1.07,1.05,1.07,1.08,1.08,1.08,1.09,1.08,1.08,0.00,0.00,0.00,0.00,0.00,0.00,0.00};
//		double[] values = {1.07,1.05,1.07,1.08,1.08,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00};
		
		double[] values = {6.02,5.70,6.09,5.97,5.76,6.10,4.83,4.79,5.52,5.98,5.37,6.01,6.00,6.06,6.08,5.76};
		
		System.out.println("���鳤��N:" + values.length);

		Mean mean = new Mean(); // ����ƽ��ֵ
		Variance variance = new Variance();// ����
		StandardDeviation StandardDeviation = new StandardDeviation();// ��׼��

		double meanValue = mean.evaluate(values);
		double varianceValue = variance.evaluate(values);
		double standardValue = StandardDeviation.evaluate(values);

		System.out.println("����ƽ��ֵ: " + meanValue);
		System.out.println("���" + varianceValue);
		System.out.println("��׼��s1: " + standardValue);

		System.out.println("----------------------------");
		Abs abs = new Abs();// ����ֵ
		  
		  
		for (int i = 0; i < values.length; i++) {
			// ����ÿ��������ͳ����k0��ֵ k0 = |����ֵ - ����ƽ��ֵ| / ��׼��
			double k0 = abs.value(values[i] - meanValue) / standardValue;
			System.out.println(values[i] + "-->" + k0);
			if (k0 > 0.85) {
				System.out.println(values[i] + "Ϊ�쳣����");
			}
		}
		  
		  
		  
		  
		  
		  
		  
	}

}
