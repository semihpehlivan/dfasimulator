package database;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import javax.swing.ImageIcon.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

public class Question1 extends JFrame {
		
	 JPanel p1 = new JPanel();
     JLabel l1 = new JLabel();
    
     Button b1=new Button("SOLUTION");
	
	 public Question1(String title) {
		 
		super(title);
	        
        setTitle("QUESTION 1");
        setVisible(true);
        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        l1.setIcon(new ImageIcon("C:\\Users\\Semih\\Eclipse-workspace\\database\\src\\resources\\Q1.png"));
        
        b1.setBounds(600, 600, 100, 50);b1.setBackground(new Color(135, 206, 250));
        b1.addActionListener(new ActionListener() {
        	
        	public void actionPerformed(ActionEvent e) {
        		
        		setVisible(false);
        		Answer1 a=new Answer1("ANSWER 1");
        		
        	}
        	
        });
        
        p1.add(l1);p1.add(b1);        
        add(p1);
        validate();
        
	}
	
}
