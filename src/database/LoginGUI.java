package database;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;

import java.awt.event.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
//login screen
public class LoginGUI extends JFrame implements ActionListener {
	
    TextField tf1,tf3,tf4;
    JPasswordField tf2;
    Button b1,b2;
    Label l1,l2;
    
    LoginGUI(String title){
    	
        super(title);
        
        tf4=new TextField("     WELCOME TO SIMULATING DFA");tf4.setBounds(10,20,230,20);tf4.setEditable(false);tf4.setBackground(new Color(135,206,250));
        tf3 = new TextField("  Please enter your user id and password"); tf3.setBounds(10, 50, 230,20);tf3.setBackground(new Color(135, 206, 250));
        l1 = new Label("USER ID"); l1.setBounds(10, 100, 80, 20);
        l2 = new Label("PASSWORD"); l2.setBounds(10, 150, 80, 20);
        tf1 = new TextField(); tf1.setBounds(100, 100, 150, 20);
        tf2 = new JPasswordField(); tf2.setBounds(100, 150, 150, 20);        
        tf3.setEditable(false);
        b1 = new Button("Login"); b1.setBounds(20, 200, 100, 50);b1.setBackground(new Color(135, 206, 250));
        b1.addActionListener(new ActionListener() {
        	
        	public void actionPerformed(ActionEvent e) {
        		
        		try {
        			Class.forName("com.mysql.cj.jdbc.Driver");
        			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/SE360", "root", "");
        			
        			String name = tf1.getText();
        			String password= tf2.getText();
        			String query="Select * from student where username=? and password=?";
        		
        			PreparedStatement statement = con.prepareStatement(query);
        			statement.setString(1, name);
        			statement.setString(2, password);
        			ResultSet set = statement.executeQuery();
        			if(set.next()) {
        				JOptionPane.showMessageDialog(null, "Connection Is Successful! To Continue Please Press 'OK'");
        				setVisible(false);
        				Question q=new Question("QUESTIONS");
        			}else {
        				JOptionPane.showMessageDialog(null, "Invalid User Id Or Password!");
        			}
        		}
        		catch(ClassNotFoundException | SQLException x){
        			x.printStackTrace();
        			}
        		
        	}
        	
        });
        
        b2=new Button("Register");
        b2.setBounds(140, 200, 100, 50);b2.setBackground(new Color(135, 206, 250));
        b2.addActionListener(new ActionListener() {
        	
        	public void actionPerformed(ActionEvent e) {
        		
        	try {
        		
    			Class.forName("com.mysql.cj.jdbc.Driver");
    			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/SE360", "root", "");
    			
    			String name = tf1.getText();
    			String password= tf2.getText();
    			if(name!=null && password!=null) {
    			String query="Insert into student (username,password) values (?,?) ";
    		
    		
    			PreparedStatement statement = con.prepareStatement(query);
    			statement.setString(1, name);
    			statement.setString(2, password);
    			statement.executeUpdate();
    			
    			String query1="Select * from student where username=? and password=?";
    			PreparedStatement statement1 = con.prepareStatement(query1);
    			statement1.setString(1, name);
    			statement1.setString(2, password);
    			ResultSet set = statement1.executeQuery();
    			if(set.next()) {
    				JOptionPane.showMessageDialog(null, "Registration Is Successful!");
    				setVisible(false);
    				Question q=new Question("QUESTIONS");
    				
    			}else {
    				
    				JOptionPane.showMessageDialog(null, "Registration Is Not Successful!");
    				
    			}
    			
    		}else {
    				
    			JOptionPane.showMessageDialog(null,  "Null");
    		}
    			
    			
            	
    	}
        	
    	catch(ClassNotFoundException | SQLException x) {
    		
    			x.printStackTrace();
    			
    			}
        	}
        	
        });
        
        add(l1); add(l2); add(tf1); add(tf2); add(tf3); add(tf4); add(b1); add(b2);
        getContentPane().setBackground(new Color(173, 216, 230));
        setSize(300,300);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    public void actionPerformed(ActionEvent e) {
    	
        String s1 = tf1.getText();
        String s2 = tf2.getText();
        String loginResult = "username is "+s1 + " and password is " + s2;
        tf3.setText(loginResult);
        
    }
    



}