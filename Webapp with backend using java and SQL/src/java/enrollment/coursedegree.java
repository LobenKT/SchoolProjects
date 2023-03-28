package enrollment;
import java.sql.*;

public class coursedegree {
    public String  courseid;
    public String  degree;
    
    public coursedegree () {};
    public int modRecord()  { 
         try
         {
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678&useSSL=false");
            System.out.println("Connection was made successfully");
            PreparedStatement pstmt = conn.prepareStatement("UPDATE coursedegree SET degree=? WHERE courseid=?");
            pstmt.setString(2, courseid);
            pstmt.setString(1, degree);
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
            PreparedStatement pstmt = connect.prepareStatement("DELETE FROM coursedegree WHERE courseid=?");
            pstmt.setString(1, courseid);
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
            PreparedStatement pstmt = connect.prepareStatement("INSERT INTO coursedegree VALUES (?,?)");
            pstmt.setString (1, courseid );
            pstmt.setString (2, degree);
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
            PreparedStatement pstmt = connect.prepareStatement("SELECT * FROM coursedegree WHERE courseid =?");
            pstmt.setString(1, courseid );
            ResultSet rs = pstmt.executeQuery();
            while (rs.next())
            {
                courseid = rs.getString("courseid");
                degree = rs.getString("degree");
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
