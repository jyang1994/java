package com.kaishengit.test;

public class InnerTest {

	public static void main(String[] args) {

		Pc pc = new Pc();
//		Usb usb = new Mp3();
		
		pc.DriverUsb(new Usb(){

			@Override
			public void runUsb() {
				System.out.println("�����ֲ��ڲ������...");
			}
			
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*Map<String, String> maps = new HashMap<>();
		
		Set<Entry<String,String>> sets = maps.entrySet();
		
		*/
//		
//		Outer outer = new Outer();
//		outer.sayOuter();
		
//		new Outer().sayOuter();
		
//		Outer.Inner inner = new Outer().new Inner();
//		Inner inner2 = outer.new Inner();
//		inner.sayInner();
		
		// ������̬�ڲ���
//		Inner in = new Outer.Inner();
//		in.sayInner();
		
		
		
		
		
		
	}

}
