package modelo;

public class No {
	int chave;
	String valor;
	int alturaNo;
	No esq, dir;

	public No() {
	}

	public No(int ch, String v) {
		this.chave = ch;
		this.valor = v;
	}
}
