import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JLabel school_id, password;
    JTextField t_school_id;
    JPasswordField t_password;
    JButton b_enter;
    public Login(){

        
     school_id = new JLabel("School ID:");
     password = new JLabel("Password:");
     t_school_id = new JTextField();
     t_password = new JPasswordField();
     b_enter = new JButton("Enter");
    
     //textfield
     t_school_id.setBounds(225, 150, 200, 30);
     t_password.setBounds(225, 250, 200, 30);

     //label
     school_id.setBounds(125, 150, 150, 30);
     school_id.setFont(new Font("Serif", Font.PLAIN, 20));
     password.setBounds(125, 250, 150, 30);
     password.setFont(new Font("Serif", Font.PLAIN, 20));

     //button
     b_enter.setBounds(250,350,100,30); 
     b_enter.addActionListener(this);

    //frame
    this.setTitle("Login");
    this.setSize(600, 600);
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(null);

    //add components
    this.add(t_school_id);
    this.add(school_id);
    this.add(t_password);
    this.add(password);
    this.add(b_enter);
   // this.add(t_password);

    }
    @Override
    public void actionPerformed(ActionEvent ef) {
       if(ef.getSource()==b_enter){

           int id = Integer.parseInt(t_school_id.getText());
           String password = String.valueOf(t_password.getPassword());

              try{
                Class.forName("com.mysql.cj.jdbc.Driver");  
        
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost/pfbaliwis","root","");
                
                PreparedStatement pStatement = con.prepareStatement("SELECT school_id, password FROM User WHERE school_id = ? AND password = ?");
                pStatement.setInt(1, id);
                pStatement.setString(2, password);

                ResultSet rs = pStatement.executeQuery();

                if(rs.next() == true){
                    System.out.println("Valid");
                }
                else{
                    System.out.println("Invalid");
                

                /*Statement stmt=con.createStatement(); 
                ResultSet rs = stmt.executeQuery("SELECT school_id, password FROM User");
                while(rs.next()){
                    int sql_id = rs.getInt("school_id");
                    String sql_pass = String.valueOf(rs.getString("password"));

                   if(sql_pass == password){
                        System.out.println("Valid Credentials");
                         System.out.println(id + " " + password);
                        System.out.println(rs.getInt("school_id") + " " + rs.getString("password"));
                    }
                    else if(sql_pass != password){
                        System.out.println("Invalid Credentials");
                        System.out.println("User Input: " + " \n"  + "ID: " + id + " \n" + "Password: " + password);
                        System.out.println("From SQL Database: " + " \n" + "ID: " +  rs.getInt("school_id") + " \n" + "Password: " + rs.getString("password"));
            }*/
        }
    }
            catch(Exception e){ 
            System.out.println(e);

        }  
    }

}

}




