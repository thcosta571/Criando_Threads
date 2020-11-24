package program;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrincipalPrograma {
	
	public static void main(String[] args) {
	
		System.out.println("Thread principal vai comecar...");
		
		ExecutorService pool = Executors.newCachedThreadPool();
		
		PTask p5 = new PTask("5");
		PTask p6 = new PTask("6");
		PTask p7 = new PTask("7");
		
		pool.execute(p5);
		pool.execute(p6);
		pool.execute(p7);
		
		pool.shutdown();
		
		System.out.println("Thread principal terminou...");
	}
}
