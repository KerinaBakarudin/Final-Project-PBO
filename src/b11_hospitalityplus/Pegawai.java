/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b11_hospitalityplus;

/**
 *
 * @author Asus
 */
public class Pegawai {
    private int IdPegawai;
    private String username;
    private String password;

    public Pegawai(int IdPegawai, String username, String password) {
        this.IdPegawai = IdPegawai;
        this.username = username;
        this.password = password;
    }

    public int getIdPegawai() {
        return IdPegawai;
    }

    public void setIdPegawai(int IdPegawai) {
        this.IdPegawai = IdPegawai;
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
