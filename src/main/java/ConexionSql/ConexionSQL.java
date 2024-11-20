
package ConexionSql;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ConexionSQL {
    
    
    Connection conectar= null;
    Statement statement;
    ResultSet rs;
    
    
    public Connection conexion(){
        
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conectar=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/sgce", "root","mycele");
            JOptionPane.showMessageDialog(null, "Conexion Exitosa");
            
            statement=conectar.createStatement();
            statement.executeUpdate("INSERT INTO personaladmin(idAdmin,contraseña,nombres,cargo,email,telefono) VALUES (10254685,'playamar','Paola','Superv','Paol@gmail.com','3106254173')");
            rs=statement.executeQuery("SELECT * FROM personaladmin ");
            rs.next();
            
             do{
                System.out.println(rs.getInt("idAdmin")+" : "+rs.getString("nombres")+" "+rs.getString("email"));
            }while(rs.next());
            
        } catch (HeadlessException | ClassNotFoundException |SQLException ex) {
            Logger.getLogger(ConexionSQL.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null,"Error de conexion" + ex.getMessage());
        }
        return conectar;
        
    }
}
