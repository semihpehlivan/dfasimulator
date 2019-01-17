package database;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import javax.swing.ImageIcon.*;

import java.awt.event.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

public class Answer2 extends JFrame {
	Question2 q1=new Question2("QUESTION 2");
	String c;
	
public Answer2(String title) {
		
		super(title);
		TextField tf1=new TextField("current state");
		tf1.setBounds(150,20,100,20);
		TextField l1=new TextField(" Current State");
		l1.setBounds(40,20,100,20);l1.setEditable(false);
		add(l1);
		
		//Graphics d1=getGraphics();
		
		
		try {
			
			 Class.forName("com.mysql.cj.jdbc.Driver")/*.newInstance()*/;

	         Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/se360","root","");
	         Statement smt=cn.createStatement();

	         String q="Select count(distinct current_state) from question2";

	         ResultSet rs=smt.executeQuery(q);
			 if(rs.next()) {
				 
				if((rs.getString(1)).equals("4")) {
										
					System.out.println("vcjhsvdjkcds");
					Button b=new Button("SHOW DFA");
					b.setBounds(100,400,100,100);
					b.setBackground(new Color(135, 206, 250));					
					b.addActionListener(new ActionListener() {
						
						public void actionPerformed(ActionEvent e) {
							
							System.out.println("grap");
							
							
							
							Label l1=new Label("A");
					        l1.setBounds(123,240,10,15);
					        add(l1);
					        
							Graphics d1=getGraphics();
					        d1.setColor(Color.RED);					        
					        d1.drawOval(100,150,70,70);
					        
									        
					        Label l2=new Label("B");
					        l2.setBounds(212,240,10,15);
					        add(l2);
					        Graphics d2=getGraphics();
					        d2.setColor(Color.RED);
					        d2.drawOval(190,150,70,70);
					        
					        Label l3=new Label("C");
					        l3.setBounds(300,240,10,15);
					        add(l3);
					        Graphics d3=getGraphics();
					        d3.setColor(Color.RED);
					        d3.drawOval(280,150,70,70);
					        
					        Label l4=new Label("D");
					        l4.setBounds(390,240,10,15);
					        add(l4);
					        Graphics d4=getGraphics();
					        d4.setColor(Color.RED);
					        d4.drawOval(370,150,70,70);
					        
					        Graphics d5=getGraphics();
					        d5.setColor(Color.BLUE);
					        d5.drawOval(380, 160, 50, 50);
					        
					        
					        b.setVisible(false);
					        
					        Button start=new Button("START");
					        start.setBounds(60,400,100,100);
					        start.setBackground(new Color(135, 206, 250));
					        add(start);
					        start.addActionListener(new ActionListener() {
								
								public void actionPerformed(ActionEvent e) {
								
									add(tf1);
									String currentState="A";
									
									
									d1.setColor(Color.BLUE);
									d1.drawOval(100,150,70,70);
									tf1.setText(currentState);
								}
								
							});
					        
					        Button zero=new Button("0");
					        zero.setBounds(165,400,100,100);
					        zero.setBackground(new Color(135, 206, 250));
					        add(zero);
					        zero.addActionListener(new ActionListener() {
					        	public void actionPerformed(ActionEvent e) {
					        		
					        			
					        		
					        		try {
					        			
					        			
					        		String currentState=tf1.getText();
					        		String nextInput=zero.getLabel();
					        		
					        		System.out.println(currentState);
					        		System.out.println(nextInput);
					        		
					        		Class.forName("com.mysql.cj.jdbc.Driver");
				        			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/SE360", "root", "");
				        			
				        			String query="Select next_state from question2 where current_state=? and next_input=?";
				        			
				        			PreparedStatement statement = con.prepareStatement(query);
				        			statement.setString(1, currentState);
				        			statement.setString(2, nextInput);
				        			ResultSet set = statement.executeQuery();
				        			
				        			if(set.next()) {
				        				
				        				System.out.println(set.getString(1));
				        				currentState=set.getString(1);
				        				tf1.setText(currentState);
				        				
				        				
				        				if(currentState.equals("A")) {
				        					
				        				d1.setColor(Color.BLUE);
										d1.drawOval(100,150,70,70);
										
										d2.setColor(Color.RED);
								        d2.drawOval(190,150,70,70);
										
										d3.setColor(Color.RED);
								        d3.drawOval(280,150,70,70);
								        
								        d4.setColor(Color.RED);
								        d4.drawOval(370,150,70,70);
								        
				        				}else if(currentState.equals("B")) {
				        					
				        					
					        				d1.setColor(Color.RED);
											d1.drawOval(100,150,70,70);
											
											d2.setColor(Color.BLUE);
									        d2.drawOval(190,150,70,70);
											
											d3.setColor(Color.RED);
									        d3.drawOval(280,150,70,70);
									        
									        d4.setColor(Color.RED);
									        d4.drawOval(370,150,70,70);
									        	
				        					
				        				}else if(currentState.equals("C")) {
				        					d1.setColor(Color.RED);
											d1.drawOval(100,150,70,70);
											
											d2.setColor(Color.RED);
									        d2.drawOval(190,150,70,70);
											
											d3.setColor(Color.BLUE);
									        d3.drawOval(280,150,70,70);
									        
									        d4.setColor(Color.RED);
									        d4.drawOval(370,150,70,70);
				        				}else if(currentState.equals("D")) {
				        					d1.setColor(Color.RED);
											d1.drawOval(100,150,70,70);
											
											d2.setColor(Color.RED);
									        d2.drawOval(190,150,70,70);
											
											d3.setColor(Color.RED);
									        d3.drawOval(280,150,70,70);
									        
									        d4.setColor(Color.BLUE);
									        d4.drawOval(370,150,70,70);
				        					
				        				}
				        				
				        				
				        			}else {
				        				
				        			}
					        			}
				        			
	
									
								    
										
										
									catch(ClassNotFoundException | SQLException x) {
											
										x.printStackTrace();
											
									}
										
					        		}	
										
					        	
					        	
					        });
					        
					        Button one=new Button("1");
					        one.setBounds(270,400,100,100);
					        one.setBackground(new Color(135, 206, 250));
					        add(one);
					        one.addActionListener(new ActionListener() {
					        	public void actionPerformed(ActionEvent e) {
					        		
					        			
					        		
					        		try {
					        			
					        			
					        		String currentState=tf1.getText();
					        		String nextInput=one.getLabel();
					        		
					        		System.out.println(currentState);
					        		System.out.println(nextInput);
					        		
					        		Class.forName("com.mysql.cj.jdbc.Driver");
				        			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/SE360", "root", "");
				        			
				        			String query="Select next_state from question2 where current_state=? and next_input=?";
				        			
				        			PreparedStatement statement = con.prepareStatement(query);
				        			statement.setString(1, currentState);
				        			statement.setString(2, nextInput);
				        			ResultSet set = statement.executeQuery();
				        			
				        			if(set.next()) {
				        				
				        				System.out.println(set.getString(1));
				        				currentState=set.getString(1);
				        				tf1.setText(currentState);
				        				
				        				
				        				if(currentState.equals("A")) {
				        					
				        				d1.setColor(Color.BLUE);
										d1.drawOval(100,150,70,70);
										
										d2.setColor(Color.RED);
								        d2.drawOval(190,150,70,70);
										
										d3.setColor(Color.RED);
								        d3.drawOval(280,150,70,70);
								        
								        d4.setColor(Color.RED);
								        d4.drawOval(370,150,70,70);
								        
				        				}else if(currentState.equals("B")) {
				        					
				        					
					        				d1.setColor(Color.RED);
											d1.drawOval(100,150,70,70);
											
											d2.setColor(Color.BLUE);
									        d2.drawOval(190,150,70,70);
											
											d3.setColor(Color.RED);
									        d3.drawOval(280,150,70,70);
									        
									        d4.setColor(Color.RED);
									        d4.drawOval(370,150,70,70);
									        	
				        					
				        				}else if(currentState.equals("C")) {
				        					d1.setColor(Color.RED);
											d1.drawOval(100,150,70,70);
											
											d2.setColor(Color.RED);
									        d2.drawOval(190,150,70,70);
											
											d3.setColor(Color.BLUE);
									        d3.drawOval(280,150,70,70);
									        
									        d4.setColor(Color.RED);
									        d4.drawOval(370,150,70,70);
				        				}else if(currentState.equals("D")) {
				        					d1.setColor(Color.RED);
											d1.drawOval(100,150,70,70);
											
											d2.setColor(Color.RED);
									        d2.drawOval(190,150,70,70);
											
											d3.setColor(Color.RED);
									        d3.drawOval(280,150,70,70);
									        
									        d4.setColor(Color.BLUE);
									        d4.drawOval(370,150,70,70);
				        					
				        				}
				        				
				        				
				        			}else {
				        				
				        			}
					        			}
				        			
	
									
								    
										
										
									catch(ClassNotFoundException | SQLException x) {
											
										x.printStackTrace();
											
									}
										
					        		}	
										
					        	
					        	
					        });
					        
					        
					       
							
					        
					        
						}
						
					});
					add(b);
					
					
					Button b1=new Button("RETURN QUESTIONS");
					b1.setBounds(400,400,150,100);
					b1.setBackground(new Color(135, 206, 250));	
					b1.addActionListener(new ActionListener() {
						
						public void actionPerformed(ActionEvent e) {
							
							setVisible(false);
							q1.setVisible(false);
							Question q=new Question("QUESTION");
							
							
						}
					});
					add(b1);
					
																						  
				}
								
			 }else {
				 
			 }
						
		}
		catch(ClassNotFoundException | SQLException x) {
			
			x.printStackTrace();
			
		}
		
		
		setTitle("ANSWER 2");
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
        setVisible(true);
        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
		
	
	
	
	}
	void C(String s) {
		this.c=s;
		if(s.equals("A")) {
			
		}
	}
	
	
	
}
