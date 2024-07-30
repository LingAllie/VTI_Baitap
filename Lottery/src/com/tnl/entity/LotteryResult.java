package com.tnl.entity;

public class LotteryResult {

    private String ngayQT;
    private String giaiDB;
    private String giaiNhat;
    private String giaiNhi;
    private String[] giaiBa = new String[2];
    private String[] giaiTu = new String[7];
    private String giaiNam;
    private String[] giaiSau = new String[3];
    private String giaiBay;
    private String giaiTam;
    
    public LotteryResult() {}

    public LotteryResult(String ngayQT, String giaiDB, String giaiNhat, String giaiNhi, String[] giaiBa,
            String[] giaiTu, String giaiNam, String[] giaiSau, String giaiBay, String giaiTam) {
        
        this.ngayQT = ngayQT;
        this.giaiDB = giaiDB;
        this.giaiNhat = giaiNhat;
        this.giaiNhi = giaiNhi;
        this.giaiBa = giaiBa;
        this.giaiTu = giaiTu;
        this.giaiNam = giaiNam;
        this.giaiSau = giaiSau;
        this.giaiBay = giaiBay;
        this.giaiTam = giaiTam;
    }

    public String getNgayQT() {
        return ngayQT;
    }

    public void setNgayQT(String ngayQT) {
        this.ngayQT = ngayQT;
    }

    public String getGiaiDB() {
        return giaiDB;
    }

    public void setGiaiDB(String giaiDB) {
        this.giaiDB = giaiDB;
    }

    public String getGiaiNhat() {
        return giaiNhat;
    }

    public void setGiaiNhat(String giaiNhat) {
        this.giaiNhat = giaiNhat;
    }

    public String getGiaiNhi() {
        return giaiNhi;
    }

    public void setGiaiNhi(String giaiNhi) {
        this.giaiNhi = giaiNhi;
    }

    public String[] getGiaiBa() {
        return giaiBa;
    }

    public void setGiaiBa(String[] giaiBa) {
        this.giaiBa = giaiBa;
    }

    public String[] getGiaiTu() {
        return giaiTu;
    }

    public void setGiaiTu(String[] giaiTu) {
        this.giaiTu = giaiTu;
    }

    public String getGiaiNam() {
        return giaiNam;
    }

    public void setGiaiNam(String giaiNam) {
        this.giaiNam = giaiNam;
    }

    public String[] getGiaiSau() {
        return giaiSau;
    }

    public void setGiaiSau(String[] giaiSau) {
        this.giaiSau = giaiSau;
    }

    public String getGiaiBay() {
        return giaiBay;
    }

    public void setGiaiBay(String giaiBay) {
        this.giaiBay = giaiBay;
    }

    public String getGiaiTam() {
        return giaiTam;
    }

    public void setGiaiTam(String giaiTam) {
        this.giaiTam = giaiTam;
    }

    @Override
    public String toString() {
        return "\nKết quả xổ số ngày " + this.ngayQT + "\n" +
               "------------------------------------------\n" +
               "Giải 8  |               " + this.giaiTam + "               |\n" +
               "------------------------------------------\n" +
               "Giải 7  |               " + this.giaiBay + "              |\n" +
               "------------------------------------------\n" +
               "Giải 6  |   " + this.giaiSau[0] + "   |   " + this.giaiSau[1] + "   |   " + this.giaiSau[2] + "   |\n" +
               "------------------------------------------\n" +
               "Giải 5  |              " + this.giaiNam + "              |\n" +
               "------------------------------------------\n" +
               "Giải 4  |  " + this.giaiTu[0] + " | " + this.giaiTu[1] + " | " + this.giaiTu[2] + " | " + this.giaiTu[3] + " |\n" + "        |  " + this.giaiTu[4] + "  |   " + this.giaiTu[5] + "   |   " + this.giaiTu[6] + "  |\n" +
               "------------------------------------------\n" +
               "Giải 3  |     " + this.giaiBa[0] + "     |     " + this.giaiBa[1] + "      |\n" +
               "------------------------------------------\n" +
               "Giải 2  |             " + this.giaiNhi + "              |\n" +
               "------------------------------------------\n" +
               "Giải 1  |             " + this.giaiNhat + "              |\n" +
               "------------------------------------------\n" +
               "Giải ĐB |             " + this.giaiDB + "             |\n" +
               "------------------------------------------";
    }

}
