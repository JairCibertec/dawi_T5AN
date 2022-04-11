package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo04 {
	
	public static void main(String[] args) {
		
		//Encontrar y devolver los datos de un usuario según su código
		
		// 1. Fabrica el acceso a los datos => DAO
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		// 2. Crea el manejador de entidades
		EntityManager em = fabrica.createEntityManager();	
			
		// 3. Empezar mi transacción => registrar, actualizar o eliminar => En búsqueda no va em.getTransaction().begin();		
			
			
		// 4. PROCESOS	
		
			//4.1 Buscar el usuario 
			
			Usuario u = em.find(Usuario.class, 13);
			
			//4.2 Devuelve un Obj entidad si existe el ID, sino devuelve NULL
			System.out.println(u);						
		
		// 5. Cerrar transacción
		
		em.close();
		
		System.out.println("Terminó...");
		
	}
	
}
