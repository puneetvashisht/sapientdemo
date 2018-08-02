package java101.java8;

interface LamdaStringLength {
	public int getLength(String message);
}

public class TestGreeter {
	
	
	
	public static void main(String[] args) {
		Greeter greeter = new Greeter();
		
		IGreeting japaneseGreeting = new JapaneseGreeting();
		
		IGreeting frenchGreeting = new IGreeting(){
			@Override
			public void sayHello() {
				System.out.println("Bonjour!!");
			}
		};
		
		IGreeting lamdaGreeting = ()-> System.out.println("Welcome to lamda");
		String m = "Some message";
		
		LamdaStringLength lsl= s -> s.length();
		System.out.println(lsl.getLength(m));
	
		
		
		
//		LamdaStringLength lsl = ("test") -> "test".length();
		
		Thread t = new Thread(()->{
			System.out.println("Running in a thread!!");
			System.out.println(Thread.currentThread().getName());
		});
		t.start();
		
		greeter.greet(lamdaGreeting);
	}

}
