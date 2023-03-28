/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enrollment;
import java.sql.*;
import java.util.*;
/**
 *
 * @author ccslearner
 */
public class report {
    public int term;
    public int schoolyear;
    public ArrayList<Integer>   StudentCount    = new ArrayList<> ();
    public ArrayList<String>    CourseList      = new ArrayList<> ();
    
    public int reset_report() {
        StudentCount.clear();
        CourseList.clear();
        return 1;
    }
    
    public int generate_report() {
        
        try{
            Connection connect;
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678&useSSL=false");
            System.out.println("Connection was made successfully");
            PreparedStatement pstmt = connect.prepareStatement("SELECT      courseid,                                 " +
                                                                "           COUNT(studentid) as students              " +
                                                                "FROM       enrollment                                " +
                                                                "WHERE      term = ?                                  " +
                                                                "AND        schoolyear = ?                            " +
                                                                "GROUP BY   schoolyear AND term                          " );
                                                            
            pstmt.setInt(1, term);
            pstmt.setInt(2, schoolyear);
            ResultSet rs = pstmt.executeQuery();
            
            StudentCount.clear();
            CourseList.clear();
            
            while (rs.next()) {
                StudentCount.add(rs.getInt("students"));
                CourseList.add(rs.getString("courseid"));
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
}


