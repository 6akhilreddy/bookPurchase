import javax.swing.*;
import java.sql.*;
import java.io.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import java.util.*;
import javax.swing.border.Border;


public class AdminFullpage {
	
	JLabel h1,h2,h3;
	JLabel l1,l2,l3,l4,l5,l6,l8;
	JTextField l7;
	JButton b1;
	
	
	AdminFullpage(Icon x,String a,String b,String c,String d,String e,String g,String h){
		
		JFrame f=new JFrame("Fullpage");
		
		f.setContentPane(new JLabel(new ImageIcon("f.jpg")));
	
		
	h1=new JLabel("OnlineBookStore");
	h1.setFont(new Font("Arial",Font.BOLD,50));
	h1.setForeground(Color.yellow);
	h1.setBounds(100,0 ,500,100);
	f.add(h1);
	
	h2=new JLabel(h);
	h2.setFont(new Font("Arial",Font.BOLD,25));
	h2.setForeground(Color.black);
	h2.setBounds(1000,0,600,100);
	f.add(h2);
	
	//	ImageIcon icon=(ImageIcon) x.getIcon();
	
	
	l1=new JLabel();
	l1.setIcon(x);
	l1.setBounds(50,150,500,500);
	f.add(l1);
	
	l2=new JLabel();
	l2.setText(a);
	l2.setFont(new Font("Arial",Font.BOLD,40));
	l2.setForeground(Color.red);
	l2.setBounds(600,150,800,50);
	f.add(l2);
	
	l3=new JLabel();
	l3.setText(b);
	l3.setFont(new Font("Arial",Font.BOLD,25));
	l3.setForeground(Color.black);
	l3.setBounds(600,220,800,50);
	f.add(l3);
	
	l4=new JLabel();
	l4.setText(c);
	l4.setFont(new Font("Arial",Font.BOLD,25));
	l4.setForeground(Color.black);
	l4.setBounds(600,270,800,50);
	f.add(l4);
	
	l5=new JLabel();
	l5.setText(d);
	l5.setFont(new Font("Arial",Font.BOLD,25));
	l5.setForeground(Color.black);
	l5.setBounds(600,320,300,50);
	f.add(l5);
	
	l6=new JLabel("Description:");
	l6.setFont(new Font("Arial",Font.BOLD,25));
	l6.setForeground(Color.black);
	l6.setBounds(600,390,800,50);
	f.add(l6);
	
	l7=new JTextField();
	l7.setText(e);
	l7.setFont(new Font("Arial",Font.BOLD,25));
	l7.setForeground(Color.blue);
	l7.setEditable(false);
	JScrollPane scrollPane = new JScrollPane(l7);
	// scrollPane.getViewport().setOpaque(false);
      scrollPane.setBackground(Color.white);
        l7.setOpaque(false);


	scrollPane.setBounds(600,460,600,100);
	//Container.add(scrollPane);
	f.add(scrollPane);
	
	l8=new JLabel(g);
	f.add(l8);
	
	
	
	
	f.setSize(900,500);  
    f.setLayout(null);  
    f.setVisible(true);
	//f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
	
	
	
	

	
}		