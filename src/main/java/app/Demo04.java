package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo04 {
	
	public static void main(String[] args) {
		
		//Encontrar y devolver los datos de un usuario seg�n su c�digo
		
		// 1. Fabrica el acceso a los datos => DAO
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		// 2. Crea el manejador de entidades
		EntityManager em = fabrica.createEntityManager();	
			
		// 3. Empezar mi transacci�n => registrar, actualizar o eliminar => En b�squeda no va em.getTransaction().begin();		
			
			
		// 4. PROCESOS	
		
			//4.1 Buscar el usuario 
			
			Usuario u = em.find(Usuario.class, 13);
			
			//4.2 Devuelve un Obj entidad si existe el ID, sino devuelve NULL
			System.out.println(u);						
		
		// 5. Cerrar transacci�n
		
		em.close();
		
		System.out.println("Termin�...");
		
	}
	
}
