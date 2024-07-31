package modelo;

public class ArvoreAVL {
	private No raiz = null;

	public ArvoreAVL() {

	}

	public void inserir(int ch, String v) {
		raiz = inserir(raiz, ch, v);
	}

	private No inserir(No arv, int ch, String v) {
		if (arv == null)
			return new No(ch, v);

		if (ch < arv.chave)
			arv.esq = inserir(arv.esq, ch, v);
		else if (ch > arv.chave)
			arv.dir = inserir(arv.dir, ch, v);
		else
			return arv;

		arv.alturaNo = 1 + maior(altura(arv.esq), altura(arv.dir));

		int fb = obterFB(arv);
		int fbSubArvEsq = obterFB(arv.esq);
		int fbSubArvDir = obterFB(arv.dir);

		if (fb > 1 && fbSubArvEsq >= 0)
			return rotacaoDireitaSimples(arv);

		if (fb < -1 && fbSubArvDir <= 0)
			return rotacaoEsquerdaSimples(arv);

		if (fb > 1 && fbSubArvEsq < 0) {
			arv.esq = rotacaoEsquerdaSimples(arv.esq);
			return rotacaoDireitaSimples(arv);
		}

		if (fb < -1 && fbSubArvDir < 0) {
			arv.dir = rotacaoDireitaSimples(arv.dir);
			return rotacaoEsquerdaSimples(arv.dir);
		}

		return arv;
	}

	private int maior(int a, int b) {
		return a > b ? a : b;
	}

	private int altura(No arv) {
		if (arv == null)
			return -1;

		return arv.alturaNo;
	}

	private int obterFB(No arv) {
		if (arv == null)
			return 0;

		return altura(arv.esq) - altura(arv.dir);
	}

	private No menorChave(No arv) {
		No temp = arv;
		if (temp == null)
			return null;

		while (temp.esq != null)
			temp = temp.esq;

		return temp;
	}

	private No remover(No arv, int ch) {

	}

	private No remover(No arv, int ch, String v) {
		if (arv == null)
			return arv;

		if (ch < arv.chave)
			arv.esq = remover(arv.esq, ch);
		else
			arv.dir = remover(arv.esq, ch);
	}

	private No rotacaoEsquerdaSimples(No x) {
		No y = x.dir;
		No z = y.esq;

		y.esq = x;
		x.dir = z;

		x.alturaNo = maior(altura(x.esq), altura(x.dir)) + 1;
		y.alturaNo = maior(altura(y.esq), altura(y.dir)) + 1;

		return y;
	}

	private No rotacaoDireitaSimples(No y) {
		No x = y.esq;
		No z = x.dir;

		x.dir = y;
		y.esq = z;

		x.alturaNo = maior(altura(x.esq), altura(x.dir)) + 1;
		y.alturaNo = maior(altura(y.esq), altura(y.dir)) + 1;

		return x;
	}
}
