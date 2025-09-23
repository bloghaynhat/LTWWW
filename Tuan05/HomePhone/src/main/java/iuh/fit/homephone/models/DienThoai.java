package iuh.fit.homephone.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "DIENTHOAI")
@Entity
public class DienThoai {
    @Id
    @Column(name = "MADT")
    private String maDT;

    @Column(name = "TENDT")
    private String tenDT;

    @Column(name = "NAMSANXUAT")
    private int namSanXuat;

    @Column(name = "CAUHINH")
    private String cauHinh;

    @Lob
    @Column(name = "HINHANH", columnDefinition = "LONGBLOB")
    private byte[] hinhAnh;

    @ManyToOne
    @JoinColumn(name = "MANCC")
    @ToString.Exclude
    private NhaCungCap nhaCungCap;
}
