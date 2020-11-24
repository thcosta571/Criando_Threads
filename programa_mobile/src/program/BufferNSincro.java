package program;

public class BufferNSincro implements IIBuffer{

	private int buffer;
	
	@Override
	public void escrever(int valor) {
		this.buffer = valor;
	}

	@Override
	public int ler() {
		return this.buffer;
	}
}
