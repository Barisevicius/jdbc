package program.db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class EntityManagerHelper {

   private static EntityManagerFactory entityManagerFactory;

   static {
       try{

           entityManagerFactory = Persistence.createEntityManagerFactory("persistence-unit");

       } catch(Throwable ex){
           System.err.println("Initial EntityManagerFactory creation failed."+ ex);
           throw new ExceptionInInitializerError(ex);
       }
   }



    public static EntityManager getEntityManager() {

        return entityManagerFactory.createEntityManager();

    }

}
