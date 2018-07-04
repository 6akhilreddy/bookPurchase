import javax.swing.*;
import java.sql.*;
import java.io.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import java.util.*;

public class Admin extends JApplet implements ActionListener{
	JLabel l1,l2,l3,l4;
	JButton b1,b2,b3,b4,b5;
	
Admin(){
	
	JFrame f=new JFrame("ADMIN PANNEL");
	

    f.setContentPane(new JLabel(new ImageIcon("c.jpg")));
	
	l1=new JLabel("OnlineBookStore");
	l1.setFont(new Font("Arial",Font.BOLD,50));
	l1.setForeground(Color.yellow);
	l1.setBounds(100,0 ,500,100);
	f.add(l1);
	
	l2=new JLabel("Admin Pannel");
	l2.setFont(new Font("Arial",Font.BOLD,40));
	l2.setForeground(Color.cyan);
	l2.setBounds(1100,0,500,100);
	f.add(l2);
	
	l3=new JLabel("USERS");
	l3.setFont(new Font("Arial",Font.BOLD,30));
	l3.setForeground(Color.orange);
	l3.setBounds(130,150,300,50);
	f.add(l3);
	
	
	l4=new JLabel("BOOKS");
	l4.setFont(new Font("Arial",Font.BOLD,30));
	l4.setForeground(Color.orange);
	l4.setBounds(530,150,300,50);
	f.add(l4);
	
    b1=new JButton("View Users");
	b1.setFont(new Font("Arial",Font.BOLD,20));
	b1.setForeground(Color.cyan);
    b1.setBackground(Color.gray);
	b1.setBounds(50,250,300,40);
	f.add(b1);
	
	
	b2=new JButton("View Transactions");
	b2.setFont(new Font("Arial",Font.BOLD,20));
	b2.setForeground(Color.cyan);
	b2.setBackground(Color.gray);
	b2.setBounds(50,350,300,40);
	f.add(b2);
	
	
	b3=new JButton("Add Books");
	b3.setFont(new Font("Arial",Font.BOLD,20));
	b3.setForeground(Color.cyan);
	b3.setBackground(Color.gray);
	b3.setBounds(450,250,300,40);
	f.add(b3);
	
	
	b4=new JButton("View Books");
	b4.setFont(new Font("Arial",Font.BOLD,20));
	b4.setForeground(Color.cyan);
	b4.setBackground(Color.gray);
	b4.setBounds(450,350,300,40);
	f.add(b4);
	
    b5=new JButton("Delete Books");
	b5.setFont(new Font("Arial",Font.BOLD,20));
	b5.setForeground(Color.cyan);
	b5.setBackground(Color.gray);
	b5.setBounds(450,450,300,40);
	f.add(b5);
	

	b1.addActionListener(this);
	b2.addActionListener(this);
	b3.addActionListener(this);
	b4.addActionListener(this);
	b5.addActionListener(this);
	
	
	
	f.setSize(900,500);  
    f.setLayout(null);  
    f.setVisible(true);
	//f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
	
}

public void actionPerformed(ActionEvent ae){
	
String s=ae.getActionCommand();

if(s.equals("Add Books")){
	Adminadd ob=new Adminadd();
	ob.setVisible(true);
}
if(s.equals("View Books")){
	
	System.out.println("clicked view books");
	AdminView ob1=new AdminView("Admin");
	ob1.setVisible(true);
}


if(s.equals("Delete Books")){
	
	//System.out.println("clicked Delete books");
	Delete ob4=new Delete("Admin");
	ob4.setVisible(true);
	}


if(s.equals("View Users")){
	
	System.out.println("clicked view Users");
	Users ob2=new Users();
	
	}


if(s.equals("View Transactions")){
	
	System.out.println("clicked view Transactions");
	Trans ob3=new Trans();
	
}
	

	}

public static void main(String args[]){
	
	new Admin();
	
}
}