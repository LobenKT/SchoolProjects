package enrollment;
import java.sql.*;

public class enrollment {
    public Long studentid;
    public String courseid;
    public int term;
    public int schoolyear;




    public enrollment () {};
    public int modRecord()  {

        try
        {
            Connection connect;
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678&useSSL=false");
            System.out.println("Connection was made successfully");
            PreparedStatement pstmt = connect.prepareStatement("UPDATE enrollment"+
                    "SET courseid = ?"+
                    "SET term = ?"+
                    "SET schoolyear = ?" +
                    "WHERE studentid = ?");

            pstmt.setLong(1, studentid);
            pstmt.setString(2, courseid);
            pstmt.setInt(3, term);
            pstmt.setInt(4, schoolyear);
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
            PreparedStatement pstmt = connect.prepareStatement("DELETE FROM enrollment where studentid=?");
            pstmt.setLong(1, studentid);
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
            PreparedStatement pstmt = connect.prepareStatement("INSERT INTO courses VALUES (?,?,?,?)");
            pstmt.setLong (1, studentid);
            pstmt.setString (2, courseid);
            pstmt.setInt (3, term);
            pstmt.setInt (4, schoolyear);
            pstmt.executeUpdate();
            pstmt.close();
            connect.close();
            return 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0; }
    }
    public int viewRecord() { ;
        try
        {
            Connection connect;
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678&useSSL=false");
            System.out.println("Connection was made successfully");
            PreparedStatement pstmt = connect.prepareStatement("SELECT * FROM enrollment WHERE studentid =?");
            pstmt.setString(1, courseid );
            ResultSet rs = pstmt.executeQuery();
            while (rs.next())
            {
                studentid = rs.getLong("studentid");
                courseid = rs.getString("courseid");
                term = rs.getInt("term");
                schoolyear = rs.getInt("schoolyear");
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
