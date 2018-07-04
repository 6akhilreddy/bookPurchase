import javax.swing.*;
import java.sql.*;
import java.io.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import java.util.*;
import javax.swing.border.Border;


public class Trans implements ActionListener{

Trans(){

JLabel l1,l2,l3,l12;

JLabel[] l4,l5,l6,l7,l8,l9,l10,l11,l13;

JLabel la1,la2;

JTextField t1;
JButton b1;

	JFrame f=new JFrame("TRANSACTION");
	
	f.setContentPane(new JLabel(new ImageIcon("j.jpg")));
	
	
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
	
	l3=new JLabel("All Transactions");
	l3.setFont(new Font("Arial",Font.BOLD,35));
	l3.setForeground(Color.yellow);
	l3.setBounds(600,100,300,50);
	f.add(l3);

	l12=new JLabel("Search using bid");
	l12.setFont(new Font("Arial",Font.BOLD,25));
	l12.setForeground(Color.yellow);
	l12.setBounds(1110,160,300,25);
	f.add(l12);

	t1=new JTextField();
	t1.setForeground(Color.black);
	t1.setBounds(1110,200,200,25);
	f.add(t1);
	
	b1=new JButton("Search");
	b1.setFont(new Font("Arial",Font.BOLD,20));
	b1.setForeground(Color.blue);
	b1.setBounds(1110,250,200,40);
	f.add(b1);

	b1.addActionListener(new ActionListener() {  
        public void actionPerformed(ActionEvent ae) {   

		Object c1="bid";
		Object c2=t1.getText();
		
Search obj=new Search(c1,c2,"admin",t1.getText());		

	}  
});

	la1=new JLabel("Total Income");
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
  
   p.setBackground(Color.blue);

   	
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");  
  
	    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");  
  
		Statement stmt=con.createStatement();  
 
		ResultSet rs=stmt.executeQuery("select * from transaction ");  
		
		int	range=0;
		
		while(rs.next()){
		range++;
		}
		
		System.out.println(range);
		
		l4=new JLabel[range]; 
		l5=new JLabel[range];
		l6=new JLabel[range]; 
		l7=new JLabel[range];
		l8=new JLabel[range];
		l9=new JLabel[range];
		l10=new JLabel[range];
		l11=new JLabel[range];
		l13=new JLabel[range];
		
		String a,b,d,e,ab,cd,ef;
		int c,gh=0,nw=0;
		
		int x=0,y=0;
	
	ResultSet rs1=stmt.executeQuery("select * from transaction ");  
		
		
		for(int i=0;rs1.next();i++){  
			
		 a=rs1.getString("emailid");
		 b=rs1.getString("bid");
		 c=rs1.getInt("quantity");
		 d=rs1.getString("door");
		 e=rs1.getString("street");		
		 ab=rs1.getString("city");		
		 cd=rs1.getString("state");		
		 ef=rs1.getString("pincode");		
		 gh=rs1.getInt("total");		
		
		gbc.fill = GridBagConstraints.HORIZONTAL;  
		gbc.gridx = x;  
		gbc.gridy = y; 
		gbc.anchor = GridBagConstraints.PAGE_START;
		 
		
		l4[i]=new JLabel(a);
		l4[i].setFont(new Font("Arial",Font.BOLD,20));
		l4[i].setForeground(Color.orange);
		p.add(l4[i],gbc);
		
		
		
		gbc.fill = GridBagConstraints.HORIZONTAL;  
		gbc.gridx = x;  
		gbc.gridy = y+1; 
		
		l5[i]=new JLabel("Book id :"+b);
		l5[i].setForeground(Color.green);
		p.add(l5[i],gbc);
		
		
		gbc.fill = GridBagConstraints.HORIZONTAL;  
		gbc.gridx = x;  
		gbc.gridy = y+2; 
		
		l6[i]=new JLabel("Quantity :"+c);
		l6[i].setForeground(Color.white);
		p.add(l6[i],gbc);
		
		
		gbc.fill = GridBagConstraints.HORIZONTAL;  
		gbc.gridx = x;  
		gbc.gridy = y+3; 
		
		
		l7[i]=new JLabel("Door no :"+d);
		l7[i].setForeground(Color.white);
		p.add(l7[i],gbc);
		
		
		gbc.fill = GridBagConstraints.HORIZONTAL;  
		gbc.gridx = x;  
		gbc.gridy = y+4; 
		
		
		l8[i]=new JLabel("Street :"+e);
		l8[i].setForeground(Color.white);
		p.add(l8[i],gbc);
		
		
		gbc.fill = GridBagConstraints.HORIZONTAL;  
		gbc.gridx = x;  
		gbc.gridy = y+5; 
		
		
		l9[i]=new JLabel("City :"+ab);
		l9[i].setForeground(Color.white);
		p.add(l9[i],gbc);
		
		
		gbc.fill = GridBagConstraints.HORIZONTAL;  
		gbc.gridx = x;  
		gbc.gridy = y+6; 
		
		
		l10[i]=new JLabel("State :"+cd);
		l10[i].setForeground(Color.white);
		p.add(l10[i],gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;  
		gbc.gridx = x;  
		gbc.gridy = y+7; 
		
		
		l11[i]=new JLabel("Pincode :"+ef);
		l11[i].setForeground(Color.white);
		p.add(l11[i],gbc);
		
		
		gbc.fill = GridBagConstraints.HORIZONTAL;  
		gbc.gridx = x;  
		gbc.gridy = y+8; 
		
		
		l13[i]=new JLabel("Total :"+gh);
		l13[i].setForeground(Color.yellow);
		p.add(l13[i],gbc);
		
		 
		 x++;
		 
		nw+=gh;
		n.setText(""+nw);
		 
		 if(x==4){
		 x=0;y+=9;}
		 
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
	new Trans();
} 
}