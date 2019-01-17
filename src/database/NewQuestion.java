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

public class NewQuestion extends JFrame {
	
	Button b1,b2;
	Label l1,l2,l3;
	TextField tf1,tf2,tf3;
	
	public NewQuestion(String title) {
		
		super(title);
		
		l1=new Label("current state");l2=new Label("next input");l3=new Label("accept state");
		tf1=new TextField();tf2=new TextField();tf3=new TextField();
		l1.setBounds(10,50,100,20);l2.setBounds(10,100,100,20);l3.setBounds(10,150,100,20);
		tf1.setBounds(150,50,100,20);tf2.setBounds(150,100,100,20);tf3.setBounds(150,150,100,20);		
		b2=new Button("COMPLETE");
		b2.setBounds(150,200,100,50);b2.setBackground(Color.GREEN);
		b2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				Question q=new Question("QUESTION");
				Button b1=new Button("QUESTION 2");
				b1.setBounds(250, 55, 100, 50);b1.setBackground(new Color(135, 206, 250));
				b1.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						
						tf1.setText("QUESTION 2");
						q.tf1.setText("Question 2");
					}
					
				});
				
				q.add(b1);
				
			}
			
		});
		
		b1=new Button("ADD");
		b1.setBounds(30,200,100,50);b1.setBackground(Color.GREEN);
		b1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/SE360", "root", "");
					
					
					
					String cur=tf1.getText();
					String in=tf2.getText();
					String ac=tf3.getText();
					String query="Insert into dfa (current_state,next_input,next_state) values (?,?,?)";
					
					PreparedStatement s=con.prepareStatement(query);
					s.setString(1,cur);
					s.setString(2, in);
					s.setString(3, ac);
					s.executeUpdate();
					
					String query1="Select * from dfa where current_state=? and next_input=? and next_state=?";
	    			PreparedStatement s1 = con.prepareStatement(query1);
	    			s1.setString(1, cur);
	    			s1.setString(2, in);
	    			s1.setString(3, ac);
	    			ResultSet r = s1.executeQuery();
					
					if(r.next()) {
						
        				JOptionPane.showMessageDialog(null, "Line Is Added Successfully!");

        			}else {
        				
        				JOptionPane.showMessageDialog(null, "Invalid User Id Or Password!");
        			}
					
        		}
        		catch(ClassNotFoundException | SQLException x){
        			
        			x.printStackTrace();
        			
        			}
						
			}
			
		});
		
		add(b1);add(b2);add(tf1);add(tf2);add(tf3);add(l1);add(l2);add(l3);
		add(b1);add(tf1);
		getContentPane().setBackground(new Color(173, 216, 230));
        setSize(400,400);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
