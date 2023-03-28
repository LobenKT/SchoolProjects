package enrollment;
import java.sql.*;

public class students {
    public int studentid;
    public String completename;
    public String degreeid;

    public students () {
        studentid= 0;
        completename="";
        degreeid="";
    }
    public int modRecord()  {

        try
        {
            Connection connect;
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678&useSSL=false");
            System.out.println("Connection was made successfully");
            PreparedStatement pstmt = connect.prepareStatement("UPDATE students"+
                    "SET completename = ?"+
                    "SET degreeid = ?"+
                    "WHERE studentid = ?");

            pstmt.setInt(3, studentid);
            pstmt.setString(1, completename);
            pstmt.setString(2, degreeid);
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
            PreparedStatement pstmt = connect.prepareStatement("DELETE FROM students WHERE studentid=?");
            pstmt.setInt(1, studentid);
            pstmt.executeUpdate();
            pstmt.close();
            connect.close();
            return 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }   };
    public int addRecord()  {
        try {
            Connection connect;
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678&useSSL=false");
            PreparedStatement pstmt = connect.prepareStatement("INSERT INTO students VALUES (?,?,?)");
            pstmt.setInt(1, studentid);
            pstmt.setString(2, completename);
            pstmt.setString(3, degreeid);
            pstmt.executeUpdate();
            pstmt.close();
            connect.close();
            return 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
    public int viewRecord() { ;
        try
        {
            Connection connect;
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678&useSSL=false");
            System.out.println("Connection was made successfully");
            PreparedStatement pstmt = connect.prepareStatement("SELECT * FROM students WHERE studentid =?");
            pstmt.setInt(1, studentid );
            ResultSet rs = pstmt.executeQuery();
            while (rs.next())
            {
                studentid = rs.getInt("studentid");
                completename = rs.getString("completename");
                degreeid = rs.getString("degreeid");
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