package program;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SharedPrincipalTeste {
	public static void main(String[] args) {
		
		ExecutorService pool = Executors.newCachedThreadPool();
		
		IIBuffer shared = new BufferCirc();
		
		Produtor p8 = new Produtor(shared);
		Produtor p9 = new Produtor(shared);

		Consu c8 = new Consu(shared);
		Consu c9 = new Consu(shared);

		pool.execute(p8);
		pool.execute(p9);

		pool.execute(c8);
		pool.execute(c9);

		pool.shutdown();
	}
}
