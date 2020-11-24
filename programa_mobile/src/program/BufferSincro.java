package program;

public class BufferSincro implements IIBuffer{

	private int buffer;
	
	private boolean lotado;
	
	@Override
	public synchronized void escrever(int valor) throws InterruptedException {
		
		while(lotado) {
			System.out.println("Bufferlotado.");
			wait();
		}
		
		this.buffer = valor;

		lotado = true;
	
		notify();
	}

	@Override
	public synchronized int ler() throws InterruptedException {
		int b;
		
		while(!lotado) {
			System.out.println("Buffer vazio.");
			wait();
		}
		
		b = this.buffer;
		
		lotado = false;
		
		notify();
		
		return b;
	}
}

