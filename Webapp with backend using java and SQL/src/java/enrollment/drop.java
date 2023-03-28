/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enrollment;
import java.sql.*;
import java.util.*;

public class drop {
    
    public Long studentid;
    public String courseid;
    public int term;
    public int schoolyear;
    
    students                        Student         = new students();           //Student using site
    public ArrayList<enrollment>    EnrollmentList  = new ArrayList<> ();       //List of enrolled classes
    public ArrayList<enrollment>    DropList        = new ArrayList<> ();       //List of dropped classes

    public drop() {                                     // perform all the necessary data loading from DB
        EnrollmentList.clear();
        DropList.clear();
    };                        
    
    public int clearDrop ()         {                   // clears dropping data of the student (almost like resetting array)
        DropList.clear();
        return 0;   
    }  
    public int loadEnrollment ()    {                   // load enrollment data of the student from specific parameters
        try{
            Connection connect;
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678&useSSL=false");
            System.out.println("Connection was made successfully");
            PreparedStatement pstmt = connect.prepareStatement("SELECT courseid, FROM enrollment WHERE studentid=? AND term=? AND schoolyear=?");
            pstmt.setLong(1, studentid);
            pstmt.setInt(2, term);
            pstmt.setInt(3, schoolyear);
            pstmt.executeUpdate(); 
            ResultSet rs = pstmt.executeQuery();
            EnrollmentList.clear();
            while (rs.next())
            {
                enrollment E = new enrollment();
                E.studentid = rs.getLong("studentid");
                E.courseid = rs.getString("coursid");
                E.term = rs.getInt("term");
                E.schoolyear = rs.getInt("schoolyear");
                EnrollmentList.add(E);
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
    
    public int addtoDropCart(Long studentid, String courseid, int term, int schoolyear) {
        // Adding the chosen subject to the dropcart
        
        enrollment D = new enrollment();
        D.studentid = studentid;
        D.courseid = courseid;
        D.term = term;
        D.schoolyear = schoolyear;
        DropList.add(D);
        return 1;
    }   
    public int confirmDrop()   {                   // saves dropping data into the Database
        // Removing the subject from the enrollment table in DB
        try{
            Connection connect;
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678&useSSL=false");
            System.out.println("Connection was made successfully");               
            PreparedStatement pstmt = connect.prepareStatement("SELECT * FROM enrollment WHERE studentid=? AND courseid=? AND term=? AND schoolyear=?");   
               pstmt.setLong(1, studentid);
               pstmt.setString(2, courseid);
               pstmt.setInt(3, term);
               pstmt.setInt(4, schoolyear);
               pstmt.executeUpdate(); 
               
            pstmt.close();
            
            for (int i= 0; i < DropList.size(); i++){
                enrollment D = new enrollment();
                D = (enrollment) DropList.get(i);
                D.delRecord();
            }
            
            
            connect.close();
            return 1;
            } catch (SQLException e) {
                System.out.println(e.getMessage());  
                return 0;
        }   
        
    }   
    
}
