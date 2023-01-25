import java.sql.*;

public class Main {

    private final String URL = "jdbc:postgresql://localhost:5432/hotel";
    private final String USER = "postgres";
    private final String PASSWORD = "postgres";

    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

    public int getStudentsCountByName() {
        String SQL = "SELECT count(*) as countStudents FROM students where name like '%a%'";
        int count = 0;
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            rs.next();
            count = rs.getInt("countStudents");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }

    public int getMaxAge() {
        String SQL = "SELECT max(age) as maxAge FROM students";
        int count = 0;
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            rs.next();
            count = rs.getInt("maxAge");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }

    public double getAverageScore() {
        String SQL = "SELECT avg(average_score) as average FROM students";
        int count = 0;
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            rs.next();
            count = rs.getInt("average");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }

    public int getStudentCount() {
        String SQL = "SELECT count(*) as maxAge FROM students";
        int count = 0;
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            rs.next();
            count = rs.getInt("maxAge");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }

    public int getMinAge() {
        String SQL = "SELECT min(age) as minAge FROM students";
        int count = 0;
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            rs.next();
            count = rs.getInt("minAge");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }

    public int getSumS() {
        String SQL = "SELECT sum(scholarship) as totalSholarship FROM students";
        int count = 0;
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            rs.next();
            count = rs.getInt("totalSholarship");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }

    public static void main(String[] args) {
        Main main = new Main();
        int count = main.getStudentsCountByName();
        System.out.println("количевство студентво к-е содержать букву а " + count);

        int age = main.getMaxAge();
        System.out.println("максимальный возраст " + age);

        double average = main.getAverageScore();
        System.out.println(average);

        int number = main.getStudentCount();
        System.out.println(number);

        int minAge = main.getMinAge();
        System.out.println(minAge);

        int total = main.getSumS();
        System.out.println(total);
    }
}
