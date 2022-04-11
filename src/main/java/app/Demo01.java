package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo01 {
	
	public static void main(String[] args) {
		
		//Agregar un nuevo usuario
		
		Usuario u = new Usuario();
		u.setCodigo(11);
		u.setNombre("Jair");
		u.setApellido("Cayahua");
		u.setUsuario("cael11@correo.com");
		u.setClave("contrasenia123");
		u.setFchnacim("2000/01/01");
		u.setTipo(1);
		u.setEstado(1);
		
		//Proceso de registro
		
		// 1. fabrica el acceso a los datos
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		// 2. crea el manejador de entidades
		EntityManager em = fabrica.createEntityManager();
		
		try {
			
			// 3. Empezar mi transacción
			em.getTransaction().begin();
			
			// 4. PROCESOS
			
			// 4.1 Registrar el usuario
			
			em.persist(u);
			
			// 5. Confirmar la transacción
			em.getTransaction().commit();
			
		} catch (Exception e) {
			System.err.println("Error al registrar." + e.getMessage());			
		}		
		
		// 6. Cerrar transacción
		
		em.close();
		
		System.out.println("Terminó...");
		
	}
	
}
