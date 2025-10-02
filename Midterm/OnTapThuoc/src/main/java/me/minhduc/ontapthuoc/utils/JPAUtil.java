package me.minhduc.ontapthuoc.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lombok.Getter;

public class JPAUtil {
    @Getter
    private static EntityManagerFactory emf;

    public static void init(){
        if(emf == null)
            emf = Persistence.createEntityManagerFactory("default");
    }

    public static void close(){
        if (emf.isOpen())
            emf.close();
    }
}
