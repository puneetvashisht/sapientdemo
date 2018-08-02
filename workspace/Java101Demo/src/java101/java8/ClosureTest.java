package java101.java8;

public class ClosureTest {
	final static Integer j = 32;
	@FunctionalInterface
	interface Process{
		void doProcess(int a);
	}

	public void m1(){
//		final Integer j = 32;
//		j = null;
		Process p  = (i)->{
			System.out.println(i+ j);
			System.out.println(this);
		};
		p.doProcess(34);
		p.doProcess(33);
	}
	public static void main(String[] args) {
		new ClosureTest().m1();
		
		
		Process p1 = new Process(){
			@Override
			public void doProcess(int a){
				System.out.println(a+ j);
				System.out.println(this);
			}
			
		};
		p1.doProcess(33);

	}

}
