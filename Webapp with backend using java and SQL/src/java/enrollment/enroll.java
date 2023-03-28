package enrollment;
import java.sql.*;
import java.util.*;

public class enroll {

    public Long studentid;
    public String courseid;
    public int term;
    public int schoolyear;

    students                        Student         = new students();
    public ArrayList<enrollment>    EnrollmentList  = new ArrayList<> ();
    public ArrayList<enrollment>    CourseList        = new ArrayList<> ();

    public enroll() { // perform all the necessary data loading from DB
        EnrollmentList.clear();
       CourseList.clear();
    };

    public int clearEnrollment ()         { // clears enrollment data of the student
        CourseList.clear();
        return 0;
    }
    public int loadCourses()    { // load valid courses into the course list
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
                E.courseid = rs.getString("courseid");
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

    public int addEnrollment(Long studentid, String courseid, int term, int schoolyear) {


        enrollment E = new enrollment();
        E.studentid = studentid;
        E.courseid = courseid;
        E.term = term;
        E.schoolyear = schoolyear;
        CourseList.add(E);
        return 1;
    }
    public int confirmEnrollment()   {

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

            for (int i= 0; i < CourseList.size(); i++){
                enrollment E = new enrollment();
                E = (enrollment) CourseList.get(i);
                E .addRecord();
            }


            connect.close();
            return 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }

    }

}
