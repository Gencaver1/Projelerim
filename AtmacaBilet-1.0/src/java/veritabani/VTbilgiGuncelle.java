
package veritabani;

import java.sql.*;




public class VTbilgiGuncelle {

    public VTbilgiGuncelle() {
        
        try {
            Connection baglanti=DriverManager.getConnection("jdbc:mysql://localhost:3306/projedatabase", "root", "root");
            
            
            
        } catch (SQLException ex) {
            
        }
    }
    
}
