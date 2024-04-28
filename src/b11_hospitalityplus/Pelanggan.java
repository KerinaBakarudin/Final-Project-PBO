/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b11_hospitalityplus;

/**
 *
 * @author Asus
 */
public class Pelanggan {
    private int IdPelanggan;
    private String username;
    private String password;

    public Pelanggan(int IdPelanggan, String username, String password) {
        this.IdPelanggan = IdPelanggan;
        this.username = username;
        this.password = password;
    }

    public int getIdPelanggan() {
        return IdPelanggan;
    }

    public void setIdPelanggan(int IdPelanggan) {
        this.IdPelanggan = IdPelanggan;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
