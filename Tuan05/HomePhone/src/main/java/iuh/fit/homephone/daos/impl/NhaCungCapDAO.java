package iuh.fit.homephone.daos.impl;

import iuh.fit.homephone.models.DienThoai;
import iuh.fit.homephone.models.NhaCungCap;
import iuh.fit.homephone.utils.JPAUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class NhaCungCapDAO implements iuh.fit.homephone.daos.NhaCungCap {
    @Override
    public List<NhaCungCap> getAll(){
        try(EntityManager em = JPAUtil.getEntityManager()){
            String sql = """
                    SELECT DISTINCT n
                    FROM NhaCungCap n
                    LEFT JOIN FETCH n.dienThoais
                    """;
            return em.createQuery(sql, NhaCungCap.class).getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public DienThoai getDienThoaiTheoMaDT(String maDT){
        try(EntityManager em = JPAUtil.getEntityManager()){
            return em.find(DienThoai.class, maDT);
        }
    }
}
