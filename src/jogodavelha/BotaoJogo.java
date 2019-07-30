//Esta classe herda a classe Button, adicionando metodos e construtores
package jogodavelha;

import java.awt.Button;

public class BotaoJogo extends Button{
		//Numero de cada botao e seu tipo - se X ou O
		private final int nb; 
		private int tipo;
		
		public static final int X=1;
		public static final int O=2;
		public static final int VAZIO=0;
		
		
		int getNumero(){
			return nb;
		}
		
		void setTipo(int tipo){
			this.tipo=tipo;
		}
		
		int getTipo(){
				return tipo;
		}
		
		//Construtor que faz com que o botao seja identificado por um numero inteiro
		public BotaoJogo(int n){
			super();
			nb=n;
		}
	}
