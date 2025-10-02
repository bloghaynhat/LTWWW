package me.minhduc.ontapthuoc.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "THUOC")
public class Thuoc {

    @Id
    @Column(name = "MATHUOC")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maThuoc;

    @NotBlank(message = "Tên thuốc không được để trống")
    @Size(min = 2, max = 100, message = "Tên thuốc phải từ 2–100 ký tự")
    @Column(name = "TENTHUOC")
    private String tenThuoc;

    @Column(name = "GIA")
    private Double gia;

    @Min(value = 1900, message = "Năm sản xuất phải >= 1900")
    @Max(value = 2100, message = "Năm sản xuất phải <= 2100")
    @Column(name = "NAMSX")
    private int namSX;

    @Column(name = "HINHANH")
    private String hinhAnh;

    @ManyToOne
    @JoinColumn(name = "MALOAI")
    private LoaiThuoc loaiThuoc;

}
