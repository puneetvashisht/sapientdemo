package java102.threads;

class OrderTask implements Runnable{
	Cart cart;
	
	public OrderTask(Cart cart) {
		super();
		this.cart = cart;
	}

	@Override
	public void run() {
		
		cart.placeOrder(7);
		
	}
}

public class RaceConditionDemo {

	public static void main(String[] args) {
		Cart cart = new Cart();
		OrderTask task = new OrderTask(cart);
		
//		cart.placeOrder(5);
//		cart.placeOrder(4);
		new Thread(task).start();
		new Thread(task).start();

	}

}
