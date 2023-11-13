import java.sql.*;

public class User {
    protected String first_name;
    protected String last_name;
    private int id;
    private String password;
    private String email;
    protected String nickname;
    protected String b_date;
    protected String profession;
    protected String gender;
    protected String country;
    protected String choice;

    public User(String first_name, String last_name, String nickname, String b_date, String profession, String gender,
            String country, String choice) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.nickname = nickname;
        this.b_date = b_date;
        this.gender = gender;
        this.country = country;
        this.profession = profession;
        this.choice = choice;

    }

    public int getID() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setID(int id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void databaseInsert(/*
                                * String f_name, String l_name, int id, String password, String nickname,
                                * String bdate, String gender
                                */) {

        System.out.println(this.gender);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/pfbaliwis", "root", "");
            Statement stmt = con.createStatement();
            stmt.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS User (id int(11) PRIMARY KEY NOT NULL, f_name varchar(30) NOT NULL,  l_name varchar(30) NOT NULL, password varchar(30) NOT NULL, nickname varchar(15) NOT NULL, bdate date NOT NULL, gender ENUM('Male', 'Female', 'Others'), profession ENUM('Student', 'Working', 'Unemployed', 'Retired'), email varchar(30) NOT NULL, country varchar(30) NOT NULL, choice ENUM('EventManager', 'Attendee'))");
            System.out.println("Created table in given database...");

            String sql = "INSERT INTO User(id, f_name, l_name, password, nickname, bdate, gender, profession, email, country, choice)"
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ? ,?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, this.id);
            pstmt.setString(2, this.first_name);
            pstmt.setString(3, this.last_name);
            pstmt.setString(4, this.password);
            pstmt.setString(5, this.nickname);
            pstmt.setString(6, this.b_date);
            pstmt.setString(7, this.gender);
            pstmt.setString(8, this.profession);
            pstmt.setString(9, this.email);
            pstmt.setString(10, this.country);
            pstmt.setString(11, this.choice);
            pstmt.executeUpdate();
            // System.out.println(id + f_name + l_name + password + nickname + bdate +
            // gender);
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
