
package user;

import java.sql.*;
import javax.faces.bean.*;
import veritabani.VTbaglanti;



@ManagedBean
@SessionScoped
@RequestScoped
public class UyeEkle {
    private String email;
    private String uye_ad;
    private String uye_soyad;
    private String uye_telefon;
    private String uye_dogumtarihi;
    private String uye_sifre; 
    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUye_ad() {
        return uye_ad;
    }

    public void setUye_ad(String uye_ad) {
        this.uye_ad = uye_ad;
    }

    public String getUye_soyad() {
        return uye_soyad;
    }

    public void setUye_soyad(String uye_soyad) {
        this.uye_soyad = uye_soyad;
    }

    public String getUye_telefon() {
        return uye_telefon;
    }

    public void setUye_telefon(String uye_telefon) {
        this.uye_telefon = uye_telefon;
    }

    public String getUye_dogumtarihi() {
        return uye_dogumtarihi;
    }

    public void setUye_dogumtarihi(String uye_dogumtarihi) {
        this.uye_dogumtarihi = uye_dogumtarihi;
    }

    public String getUye_sifre() {
        return uye_sifre;
    }

    public void setUye_sifre(String uye_sifre) {
        this.uye_sifre = uye_sifre;
    }
    
    
    public String Ekle() {        
        VTbaglanti vtb=new VTbaglanti();            //VTbaglanti classından bir nesne oluşturduk.
        Connection baglan=null;
        PreparedStatement sorgu=null;
        String st="insert into users (email,name,surname,phone_number,birth_day,password) values(?,?,?,?,?,?)";
        int i=0;
        
        
        try {
            baglan=vtb.VTbaglan();   //VTBaglanti classındaki, bağlantıyı sağlayan VTBaglan isimli metodu "baglan" 
                                                //isimli Connection nesnesine atadık.
                                                
            sorgu=baglan.prepareStatement(st);
            sorgu.setString(1, email);            
            sorgu.setString(2, uye_ad);
            sorgu.setString(3, uye_soyad);
            sorgu.setString(4, uye_telefon);
            sorgu.setString(5, uye_dogumtarihi);
            sorgu.setString(6, uye_sifre);
            i=sorgu.executeUpdate();
            
        } catch (Exception e) {
            System.err.println("Üye ekleme hatası"+e);
        }
        finally{
            try {
                baglan.close();
                sorgu.close();
            } catch (Exception e) {
                System.err.println("Hata"+e);
            }
        }
        if(i>0){
            System.out.println("Kayıt başarılı.");
            return "anasayfa?faces-redirect=true";
        }
        else{
            System.out.println("Kayıt başarısız oldu.");
            return "control?faces-redirect=true";
        }
        
        
    }
    
    
    
    
    
    
    
}
