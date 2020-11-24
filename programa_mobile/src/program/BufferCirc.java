package program;

public class BufferCirc implements IIBuffer {

	private int buffer [] = {0, 0, 0};
	
	private int lotado;
	
	private int e, l;
	
	@Override
	public synchronized void escrever(int valor) throws InterruptedException {
		
		while(lotado == buffer.length) {
			System.out.println("Buffer lotado");
			wait();
		}
		
		buffer[e] = valor;
		
		lotado++;
		
		e = e + 1;
		
		if(buffer.length == e) {
			e = 0;
		}
		
		notify();		
	}

	@Override
	public synchronized int ler() throws InterruptedException {
		int b;
		
		while(lotado == 0) {
			System.out.println("Buffer vazio");
			wait();
		}
		
		b = buffer[l];
		
		lotado--;
		
		l = l + 1;

		if(buffer.length == l) {
			l = 0;
		}
		
		notify();
		
		return b;
	}

}
