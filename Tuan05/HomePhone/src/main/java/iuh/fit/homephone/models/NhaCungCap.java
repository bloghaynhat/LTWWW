package iuh.fit.homephone.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "NHACUNGCAP")
@Entity
public class NhaCungCap {
    @Id
    @Column(name = "MANCC")
    private String maNCC;

    @Column(name = "TENNHACC")
    private String tenNCC;

    @Column(name = "DIACHI")
    private String diaChi;

    @OneToMany(mappedBy = "nhaCungCap")
    @ToString.Exclude
    private List<DienThoai> dienThoais;

}
