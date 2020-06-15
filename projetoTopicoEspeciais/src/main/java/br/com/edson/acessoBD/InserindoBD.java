package br.com.edson.acessoBD;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.edson.Model.Bandeirinha;
import br.com.edson.Model.Campeonato;
import br.com.edson.Model.FormatoCampeonatoEnum;
import br.com.edson.Model.Jogador;
import br.com.edson.Model.Jogo;
import br.com.edson.Model.Juiz;
import br.com.edson.Model.Resultado;
import br.com.edson.Model.Time;
import br.com.edson.Util.JpaUtil;

public class InserindoBD {
	
public static void inserir(EntityManager em) throws ParseException {
		
		Bandeirinha b1 = new Bandeirinha();
		b1.setNome("jose da silva");
		
		Bandeirinha b2 = new Bandeirinha();
		b2.setNome("joao da silva");
		
		Juiz j = new Juiz();
		j.setNome(" marcos de souza");
		
		Jogador player = new Jogador("atacante");
		player.setNome("romario silva");
		
		Jogador player2 = new Jogador("atacante");
		player2.setNome("ronaldinho");
		
		Campeonato camp = new Campeonato();
		camp.setDataInicio(new SimpleDateFormat("dd/MM/yyyy").parse("30/06/2020"));
		camp.setDataFim(new SimpleDateFormat("dd/MM/yyyy").parse("30/06/2020"));
		camp.setNome("campeonato rua");
		camp.setTipoCampeonato(FormatoCampeonatoEnum.MATAMATA);
		
		em.persist(b1);
		em.persist(b2);
		
		em.persist(j);
		
		em.persist(player);
		em.persist(player2);
		
		em.persist(camp);
		// ok 
		
		Time t = new Time("Palmeiras");
		Time t2 = new Time("flamengo");
		
		List<Jogador> jogadores = new ArrayList<Jogador>();
		jogadores.add(player);
		jogadores.add(player2);
		
		em.persist(t);
		em.persist(t2);	
		
		Jogo game = new Jogo();
		game.setBandeira1(b1);
		game.setBandeira2(b2);
		game.setData(new SimpleDateFormat("dd/MM/yyy").parse("30/06/2020"));
		game.setLocal("palestra italia");
		game.setHora("11:00");
		game.setTimeCasa(t);
		game.setVisitante(t2);
		game.setJuiz(j);
		game.setCampeonato(camp);
		
		Resultado res = new Resultado();
		
		res.setVencedor(t2.getNome());
		t2.setPontuacao(3);
		res.setEmpate(false);
		
		game.setResultado(res);
			
		
		em.persist(game);

		em.persist(res);
		
		
		
	}

	public static void main(String[] args) throws ParseException {
		EntityManager em = JpaUtil.obterEntity();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			inserir(em);
			et.commit();
			System.out.println("ok");
		} catch (Exception e) {
			et.rollback();
			System.out.println("nao deu");
		}finally {
			em.close();
		}
		

	}

}
