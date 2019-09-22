package design_pattern.decorator;

import java.util.Vector;

public class ProdCon {
	public static void main(String[] args) {
		Vector v = new Vector();

		Thread one = new Thread(new Producer(v, 4), "Producer");
		Thread two = new Thread(new Consumer(v, 4), "Consumer");

		one.start();
		two.start();

	}

}

class Producer implements Runnable {
	Vector v;
	int size;

	public Producer(Vector v, int size) {
		this.v = v;
		this.size = size;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			pruduce(i);
		}
	}

	private void pruduce(int i) {
		synchronized (v) {
			while (v.size() == size) {
				try {
					v.wait();
					System.out.println("producer waiting");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

		synchronized (v) {
			v.add(i);
			System.out.println(i + " : has been added");
			v.notifyAll();
		}

	}
}

class Consumer implements Runnable {
	Vector v;
	int size;

	public Consumer(Vector v, int size) {
		this.v = v;
		this.size = size;
	}

	@Override
	public void run() {
		while (true) {
			consume();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void consume() {
		synchronized (v) {
			while (v.isEmpty()) {
				try {
					System.out.println("consumer waiting as nothing to consume");
					v.wait();

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			synchronized (v) {
				System.out.println(v.remove(0) + " : has been removed  ");
				v.notifyAll();
			}

		}

	}
}
