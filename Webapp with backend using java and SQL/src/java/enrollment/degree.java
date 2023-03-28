package enrollment;
import java.sql.*;

public class degree {
    public String  degreeid;
    public String  degreename;
    
    public degree () {};
    public int modRecord()  { ;
    try
         {
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678&useSSL=false");
            System.out.println("Connection was made successfully");
            PreparedStatement pstmt = conn.prepareStatement("UPDATEdegree SET degreename=? WHERE degreeid=?");
            pstmt.setString(2, degreeid);
            pstmt.setString(1, degreename);
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
            return 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    };
    public int delRecord()  { 
        try
        {
            Connection connect;
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678&useSSL=false");
            System.out.println("Connection was made successfully");
            PreparedStatement pstmt = connect.prepareStatement("DELETE FROM degree where degreeid=?");
            pstmt.setString(1, degreeid);
            pstmt.executeUpdate();   
            pstmt.close();
            connect.close();
            return 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());  
            return 0;
        }
    };
    public int addRecord()  { 
        try
        {
            Connection connect;
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678&useSSL=false");
            System.out.println("Connection was made successfully");
            PreparedStatement pstmt = connect.prepareStatement("INSERT INTO degree VALUES (?,?)");
            pstmt.setString (1, degreeid );
            pstmt.setString (2, degreename);
            pstmt.executeUpdate();   
            pstmt.close();
            connect.close();
            return 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage()); 
        return 0; } 
    };
    public int viewRecord() { 
        try
        {
            Connection connect;
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678&useSSL=false");
            System.out.println("Connection was made successfully");
            PreparedStatement pstmt = connect.prepareStatement("SELECT * FROM degree WHERE degreeid =?");
            pstmt.setString(1, degreeid );
            ResultSet rs = pstmt.executeQuery();
            while (rs.next())
            {
                degreeid = rs.getString("degreeid");
                degreename = rs.getString("degreename");
            }
            rs.close();
            pstmt.close();
            connect.close();
            return 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());  
            return 0;
        }  
    };
    
    public static void main(String args[]) {
        
    }
}
