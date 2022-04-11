package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Usuario;

public class Demo07 {

	public static void main(String[] args) {
		// Lista los usuarios seg�n el tipo 
		
		// 1. Fabrica el acceso a los datos => DAO		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		// 2. Crea el manejador de entidades
		EntityManager em = fabrica.createEntityManager();	
			
		// 3. Empezar mi transacci�n => registrar, actualizar o eliminar => En b�squeda y listado no va em.getTransaction().begin();		
			
			
		// 4. PROCESOS	
		
		//4.1 En JPQL se usa los atributos como par�metros
		TypedQuery<Usuario> consulta = em.createQuery("select u from Usuario u where u.tipo = :xtipo", Usuario.class);
		
		consulta.setParameter("xtipo", 1);	
		
		// Convertimos con el m�todo para que pueda recorrerse. Tambi�n se puede establecer par�metros
		List<Usuario> lstUsuarios = consulta.getResultList();
								
		for (Usuario u: lstUsuarios) {
			System.out.println(u);
		}
		
		// 5. Cerrar transacci�n
		
		em.close();

	}

}
