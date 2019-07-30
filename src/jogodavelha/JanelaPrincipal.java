//Classe com a interface grafica de usuario
package jogodavelha;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class JanelaPrincipal extends Frame {	 
		private final BotaoJogo[][] botoes= new BotaoJogo[3][3]; //Apenas instanciando, mas ta vazia
		private int jogou=0; //Contador de jogadas. Quando um botao eh acionado, jogou++.
		private int acionado; //Armazena numero do botao acionado
		private final Mapa m; 
		
		//Classe interna para receber eventos associados com a janela
		class EscutaJanela extends WindowAdapter{
                        @Override
			public void windowClosing(WindowEvent e){
				System.out.println("Janela foi fechada");
				System.exit(0);            
				}    	
			}

		//Classe que recebe os eventos dos botoes
		class EscutaBotao implements ActionListener{
			
                        @Override
			public void actionPerformed( ActionEvent e) {
				jogou++;
				BotaoJogo botao = (BotaoJogo)e.getSource(); //Cast
				botao.setEnabled(false); //Desbilita o botao para nao poder mais ser selecionado
				System.out.println(" Jogada "+jogou);
				acionado = botao.getNumero(); //Armazena numero do botao acionado
				m.acionou(acionado); //Metodo 'acionado' do mapa pega esse numero
				System.out.println("    Botao " + acionado + " acionado");
				
				if(jogou%2==0){ //Jogada de numero par: vez do X
					botao.setFont(new Font("Arial", Font.BOLD, 30));  
					botao.setLabel("X");
					botao.setTipo(BotaoJogo.X); //Acessa direto da classe, pois eh static
					botao.setBackground(Color.pink);
				}
				else{ //Jogada de numero impar: vez do O
					botao.setFont(new Font("Arial", Font.BOLD, 30));  
					botao.setLabel("O");
					botao.setTipo(BotaoJogo.O);
					botao.setBackground(Color.cyan);

				}
				
				if(m.terminoujogo()){ //Ve se alguma das combinacoes aconteceu e finaliza jogo
					System.out.println("\n FIM DE JOGO");
					//Tratador pra fechar a janela da interface grafica
					try {
						Thread.sleep(5000);        
						System.exit(0);
					}
					catch(InterruptedException ex){
						Thread.currentThread().interrupt();
					}
				}
				
				if(jogou>8 && !m.terminoujogo()){ //Se acabou numero de jogadas e nao teve nenhuma combinacao, empatou 
					System.out.println("\n DEU VELHA");
					try {
						Thread.sleep(5000);        
						System.exit(0);
					}
					catch(InterruptedException ex){
						Thread.currentThread().interrupt();
					}
				}
			}
		}		
			
		//Construtor que inicializa o frame
		public JanelaPrincipal() {
			
			System.out.println("BEM-VINDO(A) AO JOGO DA VELHA! \n");

			this.setTitle("Jogo da Velha");
			setLayout(new GridLayout(3,3,5,5));
			
			EscutaBotao eb = new EscutaBotao();
			int n=0;
			for(int i=0; i<3;i++){ //da matriz pega linhas
				for(int j=0;j<3;j++){ //linhas pega elementos
					botoes[i][j] = new BotaoJogo(n);
					n++;
					this.add(botoes[i][j]);
					botoes[i][j].addActionListener(eb);
				}			
			}
				
			m = new Mapa(botoes);

			// Para pegar o fechamento da janela
			EscutaJanela ej = new EscutaJanela();
			this.addWindowListener(ej);

			// Mostra
			this.pack();
			this.setVisible(true);	// "this" eh opcional
			}

			// Informa o tamanho preferido
                @Override
			public Dimension getPreferredSize() {
				return new Dimension(400, 400);
			}
	}