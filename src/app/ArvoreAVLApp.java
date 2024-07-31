ackage app;

import modelo.ArvoreAVL;

public class ArvoreAVLApp {
	public static void main(String[] args) {
		ArvoreAVL ava = new ArvoreAVL();

		ava.inserir(21, "21");
		ava.inserir(20, "20");
		ava.inserir(24, "24");

		ava.ordem();
	}
}
