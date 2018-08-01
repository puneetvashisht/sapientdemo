package java102.threads;

public class Cart {
	
	int totalQuantity = 10;
	
	synchronized void placeOrder(int quantity){
		if(totalQuantity > quantity){
			try {
				Thread.sleep(5000);
				System.out.println(totalQuantity);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			totalQuantity-=quantity;
			System.out.println("Order placed successfully!!");
		}
		else{
			System.out.println("Order couldn't be placed!!");
		}
		System.out.println("Quantity left: " + totalQuantity);
		
	}

}
