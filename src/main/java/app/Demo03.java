package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo03 {
	
	public static void main(String[] args) {
		
		//Eliminar un usuario 
		
		// 1. Fabrica el acceso a los datos => DAO
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		// 2. Crea el manejador de entidades
		EntityManager em = fabrica.createEntityManager();	
			
		// 3. Empezar mi transacción => registrar, actualizar o eliminar
		
			em.getTransaction().begin();
			
		// 4. PROCESOS
			
			// 4.1 Eliminar el usuario (manera lógica) => cambia de estado
			
			// 4.2 Eliminar el usuario (manera física) => borra totalmente
			
			Usuario u = new Usuario();
			u.setCodigo(13);
					
			em.remove(u);
			
		// 5. Confirmar la transacción
				
		em.getTransaction().commit();			
		
		// 6. Cerrar transacción
		
		em.close();
		
		System.out.println("Terminó...");
		
	}
	
}
