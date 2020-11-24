package program;

import java.util.Random;

public class Consu implements Runnable {

	private IIBuffer shared;

	public Consu(IIBuffer shared) {
		this.shared = shared;
	}

	@Override
	public void run() {

		try {
			Random r = new Random();

			for (int i = 1; i <= 10; i++) {
				System.out.println("Consumido o valor e: " + shared.ler());

				Thread.sleep(r.nextInt(3000));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
