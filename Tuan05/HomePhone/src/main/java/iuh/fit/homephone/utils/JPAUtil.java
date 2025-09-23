package iuh.fit.homephone.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
    private static EntityManagerFactory emf;

    static {
        try{
            emf = Persistence.createEntityManagerFactory("default");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }

    public static void close(){
        emf.close();
    }

//    public static void main(String[] args) {
//        getEntityManager();
//    }
}
