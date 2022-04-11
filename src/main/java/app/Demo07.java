package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Usuario;

public class Demo07 {

	public static void main(String[] args) {
		// Lista los usuarios según el tipo 
		
		// 1. Fabrica el acceso a los datos => DAO		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		// 2. Crea el manejador de entidades
		EntityManager em = fabrica.createEntityManager();	
			
		// 3. Empezar mi transacción => registrar, actualizar o eliminar => En búsqueda y listado no va em.getTransaction().begin();		
			
			
		// 4. PROCESOS	
		
		//4.1 En JPQL se usa los atributos como parámetros
		TypedQuery<Usuario> consulta = em.createQuery("select u from Usuario u where u.tipo = :xtipo", Usuario.class);
		
		consulta.setParameter("xtipo", 1);	
		
		// Convertimos con el método para que pueda recorrerse. También se puede establecer parámetros
		List<Usuario> lstUsuarios = consulta.getResultList();
								
		for (Usuario u: lstUsuarios) {
			System.out.println(u);
		}
		
		// 5. Cerrar transacción
		
		em.close();

	}

}
