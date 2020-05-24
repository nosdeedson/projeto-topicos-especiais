package br.com.edson.acessoBD;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

public class GeradorTabelas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory em = null;
		try {
			em = Persistence.createEntityManagerFactory("projeto_tpPU");
			JOptionPane.showMessageDialog(null, " ok");
		} catch (Exception e) {
			em.close();
			JOptionPane.showMessageDialog(null, " naõ deu" + e.getMessage());
			
		}finally {
			em.close();
		}
	}

}
