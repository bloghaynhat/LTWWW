package iuh.fit.bai1.daos.impl;

import iuh.fit.bai1.entities.User;
import iuh.fit.bai1.utils.JPAUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class UserDAOImpl implements iuh.fit.bai1.daos.UserDAO {

    @Override
    public List<User> getAll() {
        try (EntityManager em = JPAUtil.getEntityManager()) {
            return em.createQuery("SELECT u FROM User u", User.class).getResultList();
        }
    }

    @Override
    public User findById(int id) {
        try (EntityManager em = JPAUtil.getEntityManager()) {
            return em.find(User.class, id);
        }
    }

    @Override
    public boolean addUser(User user) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
        }
    }

    @Override
    public boolean updateUser(User user) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(user); // merge để update
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            em.close();
        }
    }

    @Override
    public boolean deleteUser(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            User user = em.find(User.class, id);
            if (user != null) {
                em.remove(user);
                em.getTransaction().commit();
                return true;
            } else {
                em.getTransaction().rollback(); // không có user thì rollback
                return false;
            }
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            em.close();
        }
    }
}
