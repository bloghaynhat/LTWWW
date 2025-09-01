package iuh.fit.bai4_gson.models;

public class User {
    private String id;
    private String mssv;
    private String hoTen;
    private String lop;

    public User(String id, String mssv, String hoTen, String lop) {
        this.id = id;
        this.mssv = mssv;
        this.hoTen = hoTen;
        this.lop = lop;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }
}
