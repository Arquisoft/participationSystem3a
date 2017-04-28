package pSystem;

import javax.persistence.*;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.sun.security.ntlm.Client;



/**
 * Fuerza a que se cargen los parámetros de configuración,
 * se analizen todos los mapeos y, si procede, se crea la BDD
 */
public class LoadEntityManagerFactory {

	 public static void main(String[] args) {
			EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("test");

			EntityManager ent = emf.createEntityManager();
			EntityTransaction trx = ent.getTransaction();

			trx.begin();

			/**
			 * Se usa para comprobar que est� realmente bien mapeado. Si salta
			 * alguna excepcion est� mal.
			 * 
			 * Esta prueba debe realizarse con tu base de datos, no con la primera
			 * que te dan ellos.
			 * 
			 */

			/* Hacer esto para todas las entity
			 *
			 * Comprobar que en la base de datos existe una entitidad con esos id
			 * 
			 */

//			ent.find(Averia.class, 1L);
//			ent.find(Bono.class, 4L);
//			ent.find(Cargo.class, new CargoKey(1L, 1l));
//			ent.find(Cliente.class, 1L);
//			ent.find(DetallesPedido.class, new DetallesPedidoKey(1L, 10L));
//			ent.find(Factura.class, 1L);
//			ent.find(Intervencion.class, new IntervencionKey(1L,4L));
//			ent.find(Mecanico.class, 1L);
//			ent.find(MedioPago.class, 1L);
//			ent.find(Metalico.class, 1L);
//			ent.find(Pedido.class, 1L);
//			ent.find(Proveedor.class, 1L);
//			ent.find(Repuesto.class, 1L);
//			ent.find(Suministra.class, new SuministraKey(1L,1L));
//			ent.find(Sustitucion.class, new SustitucionKey(3L,new IntervencionKey(1L, 4L)));
//			ent.find(TarjetaCredito.class, 9L);
//			ent.find(TipoVehiculo.class, 1L);
//			ent.find(Vehiculo.class, 1L);
//
//			trx.commit();
//
//			ent.close();
//			emf.close();

			System.out.println("--> Si no hay excepciones todo va bien");
			System.out.println("\n\t (O no hay ninguna clase mapeada)");
		    }

}
