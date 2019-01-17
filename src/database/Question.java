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
import java.sql.Statement;
//screen for questions
public class Question extends JFrame{
	
	Button b1,b2,b3,b25;
	TextField tf1;
	Label l1;
	
	public Question(String title) {
		
		super(title);
		
		l1=new Label("SELECTED QUESTION");	
		l1.setBounds(100, 20, 150, 20);
		tf1=new TextField("........................................");tf1.setBounds(250, 20, 100, 20);
		b1=new Button("QUESTION 1");
		b1.setBounds(50, 55, 100, 50);b1.setBackground(new Color(135, 206, 250));
		b1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				tf1.setText("QUESTION 1");
				
					setVisible(false);
					Question1 q1=new Question1("QUESTION 1");
								
				/*
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
        			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/SE360", "root", "");
        			
        			
        			String query="Select * from dfa where current_state=? and next_input=? and accept_state=?";
        		
        			PreparedStatement statement = con.prepareStatement(query);
        			
        			
				}
				*/
			}
			
		});
		
		b2=new Button("QUESTION 2");
		b2.setBounds(230, 55, 100, 50);b2.setBackground(new Color(135, 206, 250));
		b2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				tf1.setText("QUESTION 2");
				
					setVisible(false);
					Question2 q2=new Question2("QUESTION 2");
				
			}
			
		});
		
		b3=new Button("QUESTION 3");
		b3.setBounds(410, 55, 100, 50);b3.setBackground(new Color(135, 206, 250));
		b3.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				tf1.setText("QUESTION 3");
				
					setVisible(false);
					Question3 q3=new Question3("QUESTION 3");
				
			}
			
		});
		/*
		b25=new Button("ADD");
		b25.setBounds(50,500,100,50);b25.setBackground(Color.GREEN);
		b25.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				NewQuestion nq=new NewQuestion("NEW QUESTION");
			}
			
		});
		*/
		add(b1);add(b2);add(b3);add(tf1);/*add(b25);*/add(l1);
		getContentPane().setBackground(new Color(173, 216, 230));
        setSize(600,400);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        /*
        String s=tf1.getText();
        switch(s) {
        case "Question 1": setVisible(false);Question1 q1=new Question1("QUESTION 1");break;
        	
        }
        */
	}

}
