/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b11_hospitalityplus;

/**
 *
 * @author ACER
 */
public class FasilitasInput {
    private int id_fasilitas;
    private String nama_fasilitas;
    private int harga;
    private String deskripsi;

    public FasilitasInput(int id_fasilitas, String nama_fasilitas, int harga, String deskripsi) {
        this.id_fasilitas = id_fasilitas;
        this.nama_fasilitas = nama_fasilitas;
        this.harga = harga;
        this.deskripsi = deskripsi;
    }

    public int getId_fasilitas() {
        return id_fasilitas;
    }

    public void setId_fasilitas(int id_fasilitas) {
        this.id_fasilitas = id_fasilitas;
    }

    public String getNama_fasilitas() {
        return nama_fasilitas;
    }

    public void setNama_fasilitas(String nama_fasilitas) {
        this.nama_fasilitas = nama_fasilitas;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
    
    
}
