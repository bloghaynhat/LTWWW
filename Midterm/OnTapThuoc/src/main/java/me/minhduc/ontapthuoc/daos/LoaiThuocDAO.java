package me.minhduc.ontapthuoc.daos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import me.minhduc.ontapthuoc.models.LoaiThuoc;
import me.minhduc.ontapthuoc.utils.JPAUtil;

import java.util.List;

public class LoaiThuocDAO {
    public List<LoaiThuoc> getAll(){
        try (EntityManager em = JPAUtil.getEmf().createEntityManager()) {
            String jpql = """
                    SELECT t FROM LoaiThuoc t ORDER BY t.id ASC
                    """;
            TypedQuery<LoaiThuoc> query = em.createQuery(jpql, LoaiThuoc.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public LoaiThuoc getLoaiThuocByID(int id){
        try (EntityManager em = JPAUtil.getEmf().createEntityManager()) {
            return em.find(LoaiThuoc.class, id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
