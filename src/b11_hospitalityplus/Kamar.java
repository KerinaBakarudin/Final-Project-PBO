/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b11_hospitalityplus;

/**
 *
 * @author ACER
 */
public class Kamar {
    private int id_kamar;
    private String nama_kamar;
    private int harga;
    private String fitur_kamar;

    public Kamar(int id_kamar, String nama_kamar, int harga, String fitur_kamar) {
        this.id_kamar = id_kamar;
        this.nama_kamar = nama_kamar;
        this.harga = harga;
        this.fitur_kamar = fitur_kamar;
    }

    public int getId_kamar() {
        return id_kamar;
    }

    public void setId_kamar(int id_kamar) {
        this.id_kamar = id_kamar;
    }

    public String getNama_kamar() {
        return nama_kamar;
    }

    public void setNama_kamar(String nama_kamar) {
        this.nama_kamar = nama_kamar;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getFitur_kamar() {
        return fitur_kamar;
    }

    public void setFitur_kamar(String fitur_kamar) {
        this.fitur_kamar = fitur_kamar;
    }
    
    
    
}
