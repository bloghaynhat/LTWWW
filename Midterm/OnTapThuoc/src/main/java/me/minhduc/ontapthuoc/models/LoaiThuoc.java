package me.minhduc.ontapthuoc.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "LOAITHUOC")
@ToString
public class LoaiThuoc {

    @Id
    @Column(name = "MALOAI")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maLoai;

    @Column(name = "TENLOAI")
    private String tenLoai;

    @OneToMany(mappedBy = "loaiThuoc")
    private List<Thuoc> danhSachThuoc;
}
