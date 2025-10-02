package me.minhduc.ontapthuoc.daos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import me.minhduc.ontapthuoc.models.Thuoc;
import me.minhduc.ontapthuoc.utils.JPAUtil;

import java.util.List;

public class ThuocDAO {
    public List<Thuoc> getAll(){
        try (EntityManager em = JPAUtil.getEmf().createEntityManager()) {
            String jpql = """
                    SELECT t FROM Thuoc t ORDER BY t.tenThuoc ASC
                    """;
            TypedQuery<Thuoc> query = em.createQuery(jpql, Thuoc.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Thuoc> getThuocByLoaiThuocID(int id){
        try (EntityManager em = JPAUtil.getEmf().createEntityManager()) {
            String jpql = """
                    SELECT t FROM Thuoc t WHERE t.loaiThuoc.id = :id
                    """;
            TypedQuery<Thuoc> query = em.createQuery(jpql, Thuoc.class);
            query.setParameter("id", id);
            return query.getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void save(Thuoc thuoc){
        try (EntityManager em = JPAUtil.getEmf().createEntityManager()) {
            em.getTransaction().begin();
            em.merge(thuoc);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
