package enrollment;
import java.sql.*;

public class courses {
    public String  courseid;
    public String  coursename;
    public String  department;
    
    public courses () {};
    public int modRecord()  { 
        
        try
        {
            Connection connect;
         connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678&useSSL=false");
        System.out.println("Connection was made successfully");
        PreparedStatement pstmt = connect.prepareStatement("UPDATE courses"+
                                                           "SET coursename = ?"+
                                                           "SET department = ?"+
                                                           "WHERE courseid = ?");
        
        pstmt.setString(1, coursename);
        pstmt.setString(2, department);
        pstmt.setString(3, courseid);
                    pstmt.executeUpdate();   
            pstmt.close();
            connect.close();
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
        PreparedStatement pstmt = connect.prepareStatement("DELETE FROM courses where courseid=?");
        pstmt.setString(1, courseid);
            pstmt.executeUpdate();   
            pstmt.close();
            connect.close();
            return 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());  
            return 0;
        }   };
    public int addRecord()  { 
        try
        {
        Connection connect;
        connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678&useSSL=false");
        System.out.println("Connection was made successfully");
                PreparedStatement pstmt = connect.prepareStatement("INSERT INTO courses VALUES (?,?,?)");
            pstmt.setString (1, courseid );
            pstmt.setString (2, coursename);
            pstmt.setString (3, department);
            pstmt.executeUpdate();   
            pstmt.close();
            connect.close();
            return 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage()); 
        return 0; }
    }
        
    public int viewRecord() { ;
        try{
            Connection connect;
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678&useSSL=false");
            System.out.println("Connection was made successfully");
            PreparedStatement pstmt = connect.prepareStatement("SELECT * FROM courses WHERE courseid =?");
               pstmt.setString(1, courseid );
               ResultSet rs = pstmt.executeQuery();
               while (rs.next())
               {
                   courseid = rs.getString("courseid");
                   coursename = rs.getString("coursename");
                   department = rs.getString("department");
               }
                 rs.close();
                pstmt.close();
                connect.close();
                return 1;
            } catch (SQLException e) {
                System.out.println(e.getMessage());  
                return 0;
        }   
           
           
    }
        
    
    public static void main(String args[]) {
        
    }
}
