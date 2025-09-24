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

    @Override
    public List<NhaCungCap> findAll(){
        try(EntityManager em = JPAUtil.getEntityManager()){
            String sql = """
                    SELECT n
                    FROM NhaCungCap n
                    """;
            return em.createQuery(sql, NhaCungCap.class).getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public NhaCungCap getNCCTheoMaNCC(String maNCC){
        try(EntityManager em = JPAUtil.getEntityManager()){
            return em.find(NhaCungCap.class, maNCC);
        }
    }

    @Override
    public void addDienThoai(DienThoai dienThoai){
        try(EntityManager em = JPAUtil.getEntityManager()){
            em.getTransaction().begin();
            em.persist(dienThoai);
            em.getTransaction().commit();
        }
    }
}
