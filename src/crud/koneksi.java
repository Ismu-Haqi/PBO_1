/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
/**
 *
 * @author ASUS
 */
public class koneksi {
    private String databaseName = "2210010105";
    private String username = "root";
    private String password = "";
    public Connection koneksiDB;
    
    public koneksi(){
        try {
            String location = "jdbc:mysql://localhost/"+databaseName;
            Class.forName("com.mysql.jdbc.Driver");
            koneksiDB = DriverManager.getConnection(location, username, password);
            System.out.println("database terkoneksi");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void simpanAkomodasi(int id_ako, String jdl_ako, String tgl_ako, String info_ako, String alamat_ako, String status){
        try {
            String sql = "insert into akomodasi (id_ako, jdl_ako, tgl_ako, info_ako, alamat_ako, status) value (?, ?, ?, ?, ?, ?)";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setInt(1, id_ako);
            perintah.setString(2, jdl_ako);
            perintah.setString(3, tgl_ako);
            perintah.setString(4, info_ako);
            perintah.setString(5, alamat_ako);
            perintah.setString(6, status);
            
            perintah.executeUpdate();
            System.out.println("data berhasil disimpan");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void ubahAkomodasi(int id_ako, String jdl_ako, String tgl_ako, String info_ako, String alamat_ako, String status){
        try {
            String sql = "update akomodasi set jdl_ako = ?, tgl_ako = ?, info_ako = ?, alamat_ako = ?, status = ? where id_ako = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, jdl_ako);
            perintah.setString(2, tgl_ako);
            perintah.setString(3, info_ako);
            perintah.setString(4, alamat_ako);
            perintah.setString(5, status);
            perintah.setInt(6, id_ako);
            
            perintah.executeUpdate();
            System.out.println("data berhasil diubah");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void hapusAkomodasi(int id_ako){
        try {
            String sql = "delete from akomodasi where id_ako = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setInt(1, id_ako);
            perintah.executeUpdate();
            System.out.println("data berhasil dihapus");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void cariAkomodasi(int id_ako){
        try {
            String sql = "select * from akomodasi where id_ako = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setInt(1, id_ako);
            ResultSet data = perintah.executeQuery();
            while(data.next()){
                System.out.println("ID AKOMODASI : "+data.getInt("id_ako"));
                System.out.println("JUDUL AKOMODASI : "+data.getString("jdl_ako"));
                System.out.println("TANGGAL AKOMODASI : "+data.getString("tgl_ako"));
                System.out.println("INFO AKOMODASI : "+data.getString("info_ako"));
                System.out.println("ALAMAT AKOMODASI : "+data.getString("alamat_ako"));
                System.out.println("STATUS : "+data.getString("status"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void dataAkomodasi(int id_ako){
        try {
            Statement stmt = koneksiDB.createStatement();
            ResultSet baris = stmt.executeQuery("select * from akomodasi order by id_ako asc");
            while(baris.next()){
                System.out.println(baris.getInt("id_ako")+" | "+
                        baris.getString("jdl_ako")+" | "+
                        baris.getString("tgl_ako")+" | "+
                        baris.getString("info_ako")+" | "+
                        baris.getString("alamat_ako")+" | "+
                        baris.getString("status"));              
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void simpanGaleri(int id_gal, String tgl_gal, String judul, String pathfoto){
        try {
            String sql = "insert into galeri (id_gal, tgl_gal, judul, pathfoto) value (?, ?, ?, ?)";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setInt(1, id_gal);
            perintah.setString(2, tgl_gal);
            perintah.setString(3, judul);
            perintah.setString(4, pathfoto);
            
            perintah.executeUpdate();
            System.out.println("data berhasil disimpan");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void ubahGaleri(int id_gal, String tgl_gal, String judul, String pathfoto){
        try {
            String sql = "update galeri set tgl_gal = ?, judul = ?, pathfoto = ? where id_gal = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, tgl_gal);
            perintah.setString(2, judul);
            perintah.setString(3, pathfoto);
            perintah.setInt(4, id_gal);
            
            perintah.executeUpdate();
            System.out.println("data berhasil diubah");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void hapusGaleri(int id_gal){
        try {
            String sql = "delete from galeri where id_gal = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setInt(1, id_gal);
            perintah.executeUpdate();
            System.out.println("data berhasil dihapus");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void cariGaleri(int id_gal){
        try {
            String sql = "select * from galeri where id_gal = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setInt(1, id_gal);
            ResultSet data = perintah.executeQuery();
            while(data.next()){
                System.out.println("ID GALERI : "+data.getInt("id_gal"));
                System.out.println("TANGGAL GALERI : "+data.getString("tgl_gal"));
                System.out.println("JUDUL : "+data.getString("judul"));
                System.out.println("PATHFOTO : "+data.getString("pathfoto"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void dataGaleri(int id_gal){
        try {
            Statement stmt = koneksiDB.createStatement();
            ResultSet baris = stmt.executeQuery("select * from galeri order by id_gal asc");
            while(baris.next()){
                System.out.println(baris.getInt("id_gal")+" | "+
                        baris.getString("tgl_gal")+" | "+
                        baris.getString("judul")+" | "+
                        baris.getString("pathfoto"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void simpanInformasi(int id_info, String jdl_info, String tgl_info, String info, String alamat_gmb){
        try {
            String sql = "insert into informasi (id_info, jdl_info, tgl_info, info, alamat_gmb) value (?, ?, ?, ?, ?)";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setInt(1, id_info);
            perintah.setString(2, jdl_info);
            perintah.setString(3, tgl_info);
            perintah.setString(4, info);
            perintah.setString(5, alamat_gmb);
            
            perintah.executeUpdate();
            System.out.println("data berhasil disimpan");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void ubahInformasi(int id_info, String jdl_info, String tgl_info, String info, String alamat_gmb){
        try {
            String sql = "update informasi set jdl_info = ?, tgl_info = ?, info = ?, alamat_gmb = ? where id_info = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, jdl_info);
            perintah.setString(2, tgl_info);
            perintah.setString(3, info);
            perintah.setString(4, alamat_gmb);
            perintah.setInt(5, id_info);
            
            perintah.executeUpdate();
            System.out.println("data berhasil diubah");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void hapusInformasi(int id_info){
        try {
            String sql = "delete from informasi where id_info = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setInt(1, id_info);
            perintah.executeUpdate();
            System.out.println("data berhasil dihapus");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void cariInformasi(int id_info){
        try {
            String sql = "select * from informasi where id_info = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setInt(1, id_info);
            ResultSet data = perintah.executeQuery();
            while(data.next()){
                System.out.println("ID INFORMASI : "+data.getInt("id_info"));
                System.out.println("JUDUL INFORMASI : "+data.getString("jdl_info"));
                System.out.println("TANGGAL INFORMASI : "+data.getString("tgl_info"));
                System.out.println("INFORMASI : "+data.getString("info"));
                System.out.println("ALAMAT GMB : "+data.getString("alamat_gmb"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void dataInformasi(int id_info){
        try {
            Statement stmt = koneksiDB.createStatement();
            ResultSet baris = stmt.executeQuery("select * from informasi order by id_info asc");
            while(baris.next()){
                System.out.println(baris.getInt("id_info")+" | "+
                        baris.getString("jdl_info")+" | "+
                        baris.getString("tgl_info")+" | "+
                        baris.getString("info")+" | "+
                        baris.getString("alamat_gmb"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void simpanWisata(int id_wisata, String jdl_wisata, String tgl_wisata, String info_wisata, String alamat_wisata, String jns_wisata){
        try {
            String sql = "insert into wisata (id_wisata, jdl_wisata, tgl_wisata, info_wisata, alamat_wisata, jns_wisata) value (?, ?, ?, ?, ?, ?)";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setInt(1, id_wisata);
            perintah.setString(2, jdl_wisata);
            perintah.setString(3, tgl_wisata);
            perintah.setString(4, info_wisata);
            perintah.setString(5, alamat_wisata);
            perintah.setString(6, jns_wisata);
            
            perintah.executeUpdate();
            System.out.println("data berhasil disimpan");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void ubahWisata(int id_wisata, String jdl_wisata, String tgl_wisata, String info_wisata, String alamat_wisata, String jns_wisata){
        try {
            String sql = "update wisata set jdl_wisata = ?, tgl_wisata = ?, info_wisata = ?, alamat_wisata = ?, jns_wisata = ? where id_wisata = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, jdl_wisata);
            perintah.setString(2, tgl_wisata);
            perintah.setString(3, info_wisata);
            perintah.setString(4, alamat_wisata);
            perintah.setString(5, jns_wisata);
            perintah.setInt(6, id_wisata);
            
            perintah.executeUpdate();
            System.out.println("data berhasil diubah");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void hapusWisata(int id_wisata){
        try {
            String sql = "delete from wisata where id_wisata = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setInt(1, id_wisata);
            perintah.executeUpdate();
            System.out.println("data berhasil dihapus");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void cariWisata(int id_wisata){
        try {
            String sql = "select * from wisata where id_wisata = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setInt(1, id_wisata);
            ResultSet data = perintah.executeQuery();
            while(data.next()){
                System.out.println("ID WISATA : "+data.getInt("id_wisata"));
                System.out.println("JUDUL WISATA : "+data.getString("jdl_wisata"));
                System.out.println("TANGGAL WISATA : "+data.getString("tgl_wisata"));
                System.out.println("INFO WISATA : "+data.getString("info_wisata"));
                System.out.println("ALAMAT WISATA : "+data.getString("alamat_wisata"));
                System.out.println("JENIS WISATA : "+data.getString("jns_wisata"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void dataWisata(int id_wisata){
        try {
            Statement stmt = koneksiDB.createStatement();
            ResultSet baris = stmt.executeQuery("select * from wisata order by id_wisata asc");
            while(baris.next()){
                System.out.println(baris.getInt("id_wisata")+" | "+
                        baris.getString("jdl_wisata")+" | "+
                        baris.getString("tgl_wisata")+" | "+
                        baris.getString("info_wisata")+" | "+
                        baris.getString("alamat_wisata")+" | "+
                        baris.getString("jns_wisata"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
