package program;

import java.util.Random;

public class Produtor implements Runnable {

	private IIBuffer shared;

	public Produtor(IIBuffer shared) {
		this.shared = shared;
	}

	@Override
	public void run() {

		try {
			Random r = new Random();

			for (int i = 1; i <= 10; i++) {

				System.out.println("Produtor escrevendo o numero" + i);
				
				shared.escrever(i);

				Thread.sleep(r.nextInt(3000));
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
