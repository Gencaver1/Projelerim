
package veritabani;

import java.sql.*;


public class VTbaglanti {
    
    public Connection VTbaglan(){
        Connection baglan=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            baglan=DriverManager.getConnection("jdbc:mysql://localhost:3306/atmacavt","root","");
        } catch (Exception e) {
            System.out.println(e);
        }
        return baglan;
    }
    
    public static void main(String[] args) {
        VTbaglanti test=new VTbaglanti();
        System.out.println(test.VTbaglan());
    }
}















