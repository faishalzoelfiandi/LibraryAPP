package model.pojo;
// Generated Jun 14, 2021 3:18:10 PM by Hibernate Tools 4.3.1



/**
 * Pasien generated by hbm2java
 */
public class Pasien  implements java.io.Serializable {


     private Integer id;
     private String namaPasien;
     private String jenisKelamin;
     private String alamat;

    public Pasien() {
    }

    public Pasien(String namaPasien, String jenisKelamin, String alamat) {
       this.namaPasien = namaPasien;
       this.jenisKelamin = jenisKelamin;
       this.alamat = alamat;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNamaPasien() {
        return this.namaPasien;
    }
    
    public void setNamaPasien(String namaPasien) {
        this.namaPasien = namaPasien;
    }
    public String getJenisKelamin() {
        return this.jenisKelamin;
    }
    
    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }
    public String getAlamat() {
        return this.alamat;
    }
    
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }




}

