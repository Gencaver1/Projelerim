
package veritabani;

import java.io.Serializable;
import java.sql.*;
import javax.faces.bean.*;

@ManagedBean
@SessionScoped
@RequestScoped
public class VTadmin implements Serializable{
    private String admin_mail;
    private String admin_password;
    private String s;

    public String getAdmin_mail() {
        return admin_mail;
    }

    public void setAdmin_mail(String admin_mail) {
        this.admin_mail = admin_mail;
    }

    public String getAdmin_password() {
        return admin_password;
    }

    public void setAdmin_password(String admin_password) {
        this.admin_password = admin_password;
    }

    
    
    
    
    public String adminsayfasiGiris() { 
        Connection baglan=null;
        PreparedStatement sorgu=null;
        VTbaglanti vtb=new VTbaglanti();
        
        try {            
            baglan=vtb.VTbaglan();           
            sorgu=baglan.prepareStatement("select * from admin");
            ResultSet getir=sorgu.executeQuery();
            
            while(getir.next()){
                if((admin_mail.equals(getir.getString("admin_email")) && (admin_password.equals(getir.getString("admin_password")) ))){
                    s="/admin?faces-redirect=true";
                    return s;
                }
                else s="hata var";
                
            }
                
        } catch (SQLException ex) {
            s="aha bir hata çıktı!";
        }
        finally{
            try {
                baglan.close();
                sorgu.close();
            } catch (Exception e) {
                System.err.println("Final hatası"+e);
            }
        }
        
        return s;
    }  
    
}
