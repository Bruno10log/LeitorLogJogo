package br.com.amil.leitorlog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/*
 * PROBLEMA
Dado o seguinte log de um jogo de tiro em primeira pessoa:

23/04/2013 15:34:22 - New match 11348965 has started
23/04/2013 15:36:04 - Roman killed Nick using M16
23/04/2013 15:36:33 - <WORLD> killed Nick by DROWN
23/04/2013 15:39:22 - Match 11348965 has ended

Resultado esperado

A partir de um input de um arquivo de log do formato acima, montar o ranking de cada partida, com a quantidade assassinatos e a quantidade de mortes de cada jogador;
Observações

Assassinatos realizados pelo <WORLD> devem ser desconsiderados, no entanto, as mortes causadas pelo <WORLD> devem ser consideradas para o jogador que foi morto.
Bônus

Não obrigatório. Faça apenas caso se identifique com o problema ou se achar que há algo interessante a ser mostrado na solução

Descobrir a arma preferida (a que mais matou) do vencedor;
Identificar a maior sequência de assassinatos efetuadas por um jogador (streak) sem morrer, dentro da partida;
Jogadores que vencerem uma partida sem morrerem devem ganhar um "award";
Jogadores que matarem 5 vezes em 1 minuto devem ganhar um "award".
 */
@Entity
public class Ranking {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRanking;
	
	@ManyToOne @JoinColumn(name="idPartida")
	private Partida partida;
	
	private String user;
	
	private int qtdMatou;
	private int qtdMorreu;
	
	
	
	public int getQtdAssassinatos() {
		return qtdMatou;
	}
	
	public void setQtdAssassinatos(int qtdMatou) {
		this.qtdMatou = qtdMatou;
	}

	public int getQtdMortes() {
		return qtdMorreu;
	}

	public void setQtdMortes(int qtdMortes) {
		this.qtdMorreu = qtdMortes;
	}

	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getIdRanking() {
		return idRanking;
	}

	public void setIdRanking(int idRanking) {
		this.idRanking = idRanking;
	}

}
