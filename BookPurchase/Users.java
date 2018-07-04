import javax.swing.*;
import java.sql.*;
import java.io.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import java.util.*;

public class Users implements ActionListener{

JLabel l1,l2,l3,la1;	

JLabel[] l4,l5,l6,l7,l8;


Users(){
	
	JFrame f=new JFrame("Users");
	
	f.setContentPane(new JLabel(new ImageIcon("j.jpg")));


	l1=new JLabel("OnlineBookStore");
	l1.setFont(new Font("Arial",Font.BOLD,50));
	l1.setForeground(Color.yellow);
	l1.setBounds(100,0 ,500,100);
	f.add(l1);
	
	l2=new JLabel("Admin Panel");
	l2.setFont(new Font("Arial",Font.BOLD,40));
	l2.setForeground(Color.cyan);
	l2.setBounds(1100,0,500,100);
	f.add(l2);
	
	l3=new JLabel("All Users");
	l3.setFont(new Font("Arial",Font.BOLD,35));
	l3.setForeground(Color.yellow);
	l3.setBounds(600,100,300,50);
	f.add(l3);

	la1=new JLabel("Total Users");
	la1.setFont(new Font("Arial",Font.BOLD,25));
	la1.setForeground(Color.black);
	la1.setBounds(1150,460,200,30);
	f.add(la1);
	
	JLabel n=new JLabel();
	n.setFont(new Font("Arial",Font.BOLD,30));
	n.setForeground(Color.white);
	n.setBounds(1200,500,200,30);
	f.add(n);
		
	
JPanel p=new JPanel();
  GridBagLayout grid = new GridBagLayout();  
            GridBagConstraints gbc = new GridBagConstraints();  
			gbc.insets = new Insets(10,25,5,25);
            p.setLayout(grid);  
  
   p.setBackground(Color.getHSBColor(0.56f, 1.0f, 0.8f));

   	
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");  
  
	    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");  
  
		Statement stmt=con.createStatement();  
 
		ResultSet rs=stmt.executeQuery("select * from users ");  
		
		int	range=0;
		
		while(rs.next()){
		range++;
		}
		
		System.out.println(range);
		n.setText(""+range);
		
		
		l4=new JLabel[range]; 
		l5=new JLabel[range];
		l6=new JLabel[range]; 
		l7=new JLabel[range];
		l8=new JLabel[range];
		
		String a,b,c,d,e;
		int gh=0,nw=0;
		
		int x=0,y=0;
	
	ResultSet rs1=stmt.executeQuery("select * from Users ");  
		
		
		for(int i=0;rs1.next();i++){  
			
		 a=rs1.getString("email");
		 b=rs1.getString("fname");
		 c=rs1.getString("lname");
		 d=rs1.getString("dob");
		 e=rs1.getString("gender");		
				
		
		gbc.fill = GridBagConstraints.HORIZONTAL;  
		gbc.gridx = x;  
		gbc.gridy = y; 
		gbc.anchor = GridBagConstraints.PAGE_START;
		 
		
		l4[i]=new JLabel("Email ID: "+a);
		l4[i].setFont(new Font("Arial",Font.BOLD,20));
		l4[i].setForeground(Color.orange);
		p.add(l4[i],gbc);
		
		
		
		gbc.fill = GridBagConstraints.HORIZONTAL;  
		gbc.gridx = x;  
		gbc.gridy = y+1; 
		
		l5[i]=new JLabel("First Name :"+b);
		l5[i].setForeground(Color.green);
		p.add(l5[i],gbc);
		
		
		gbc.fill = GridBagConstraints.HORIZONTAL;  
		gbc.gridx = x;  
		gbc.gridy = y+2; 
		
		l6[i]=new JLabel("Last Name :"+c);
		l6[i].setForeground(Color.white);
		p.add(l6[i],gbc);
		
		
		gbc.fill = GridBagConstraints.HORIZONTAL;  
		gbc.gridx = x;  
		gbc.gridy = y+3; 
		
		
		l7[i]=new JLabel("Date Of Birth :"+d);
		l7[i].setForeground(Color.white);
		p.add(l7[i],gbc);
		
		
		gbc.fill = GridBagConstraints.HORIZONTAL;  
		gbc.gridx = x;  
		gbc.gridy = y+4; 
		
		
		l8[i]=new JLabel("Gender :"+e);
		l8[i].setForeground(Color.white);
		p.add(l8[i],gbc);
		
		
		 
		x++;
		 
		 
		 if(x==3){
		 x=0;y+=5;}
		 
        }
		
	

	con.close();  
  
}catch(Exception e){ System.out.println(e);}  

	
	JScrollPane pane = new JScrollPane(p,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	//pane.setViewportView(p);
	pane.setBounds(40,160,1050,520);
	f.add(pane);  

	
	
	
	
	f.setSize(900,500);  
    f.setLayout(null);  
    f.setVisible(true);
	//f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}


	
	

public void actionPerformed(ActionEvent ae){
	
}

public static void main(String args[]){
	
	new Users();
}
}