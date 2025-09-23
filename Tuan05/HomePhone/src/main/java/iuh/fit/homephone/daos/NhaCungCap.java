package iuh.fit.homephone.daos;

import iuh.fit.homephone.models.DienThoai;

import java.util.List;

public interface NhaCungCap {
    List<iuh.fit.homephone.models.NhaCungCap> getAll();

    DienThoai getDienThoaiTheoMaDT(String maDT);
}
