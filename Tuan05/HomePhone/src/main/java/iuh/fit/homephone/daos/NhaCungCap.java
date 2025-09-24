package iuh.fit.homephone.daos;

import iuh.fit.homephone.models.DienThoai;

import java.util.List;

public interface NhaCungCap {
    List<iuh.fit.homephone.models.NhaCungCap> getAll();

    DienThoai getDienThoaiTheoMaDT(String maDT);

    List<iuh.fit.homephone.models.NhaCungCap> findAll();

    iuh.fit.homephone.models.NhaCungCap getNCCTheoMaNCC(String maNCC);

    void addDienThoai(DienThoai dienThoai);
}
