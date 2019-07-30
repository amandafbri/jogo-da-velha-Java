//Nesta classe, mapeia-se o jogo atraves de uma matriz, como um 'tabuleiro'
package jogodavelha;

class Mapa{
		private int b; //Variavel auxiliar
		private final BotaoJogo[][] botoes;
		
		//Metodo que recebe o numero do botao que foi acionado
		public void acionou(int a){
			b=a;
		}
		
		//Aqui tem-se as combinacoes possiveis para ganhar ou empatar
		public boolean terminoujogo(){
			
			if(combinacaoDiagonal()){
				System.out.println(" Combinacao vencedora: DIAGONAL PRINCIPAL!");
				return true;
			}
			if(combinacaoDiagonalSecundaria()){
				System.out.println(" Combinacao vencedora: DIAGONAL SECUNDARIA!");
				return true;
			}
			if(combinacaoVertical()){
				System.out.println(" Combinacao vencedora: VERTICAL!");
				return true;
			}
			if(combinacaoHorizontal()){
				System.out.println(" Combinacao vencedora: HORIZONTAL!");
				return true;
			}
			return false;
		}
		
		//Percorre-se as linhas para verificar se houve combinacao vencedora
		private boolean combinacaoHorizontal(){
			for(int i=0; i<3;i++){
				int linha=botoes[i][0].getTipo();
				int contagem=1;
				for(int j=1;j<3;j++){
					int modelo=botoes[i][j].getTipo(); //Pega qual tipo -se X ou O- foi acionado e armazena
					if(modelo==BotaoJogo.VAZIO){
						continue; //Se for vazio, ja vai pra proxima verificacao
					}
					if(modelo==linha){ 
						contagem++; //Vai computando os botoes acionados nas linhas
					}
				}
				if(contagem==3){ //Se computou que chegou a 3, houve combinacao na horizontal
					if(linha==1){
						System.out.println("\n X EH O GANHADOR!");
					}
					else{
						System.out.println("\n O EH O GANHADOR!");
					}
					return true;
				}
			}
			return false;
		}
		
		//Analogo ao combinacaoHorizontal
		private boolean combinacaoVertical(){
			for(int i=0; i<3;i++){
				int linha=botoes[0][i].getTipo();
				int contagem=1;
				for(int j=1;j<3;j++){
					int modelo=botoes[j][i].getTipo();
					if(modelo==BotaoJogo.VAZIO){
						continue; 
					}
					if(modelo==linha){
						contagem++;
					}
				}
				if(contagem==3){
					if(linha==1){
						System.out.println("\n X EH O GANHADOR!");
					}
					else{
						System.out.println("\n O EH O GANHADOR!");
					}
					return true;
				}
			}
			return false;
		}
		
		//Analogo ao combinacaoHorizontal
		private boolean combinacaoDiagonal(){
				int linha=botoes[0][0].getTipo();
				int contagem=1;
				for(int j=1;j<3;j++){
					int modelo=botoes[j][j].getTipo();
					if(modelo==BotaoJogo.VAZIO){
						continue; 
					}
					if(modelo==linha){
						contagem++;
					}
				}
				if(contagem==3){
					if(linha==1){
						System.out.println("\n X EH O GANHADOR!");
					}
					else{
						System.out.println("\n O EH O GANHADOR!");
					}
					return true;
				}
			return false;
		}
		
		//Analogo ao combinacaoHorizontal
		private boolean combinacaoDiagonalSecundaria(){
				int linha=botoes[2][0].getTipo();
				int contagem=1;
				for(int j=1;j<3;j++){
					int modelo=botoes[2-j][j].getTipo();
					if(modelo==BotaoJogo.VAZIO){
						continue; 
					}
					if(modelo==linha){
						contagem++;
					}
				}
				if(contagem==3){
					if(linha==1){
						System.out.println("\n X EH O GANHADOR!");
					}
					else{
						System.out.println("\n O EH O GANHADOR!");
					}
					return true;
				}
			return false;
		}
		
		//Construtor da matriz dos botoes
		public Mapa(BotaoJogo[][] botoes){
			this.botoes=botoes;
		}
		
}
