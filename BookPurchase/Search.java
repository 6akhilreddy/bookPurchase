import javax.swing.*;
import java.sql.*;
import java.io.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import java.util.*;
import javax.swing.border.Border;


public class Search implements ActionListener{

JLabel[] l1,l2,l3,l4,l5;
JButton[] b1;
JLabel l6,l7,l8,l9,l10,l11;
	
Search(Object ab,Object cd,String name,String bid){

JFrame f=new JFrame("User View");
	
	
    f.setContentPane(new JLabel(new ImageIcon("e.jpg")));

	
	l6=new JLabel("OnlineBookStore");
	l6.setFont(new Font("Arial",Font.BOLD,50));
	l6.setForeground(Color.yellow);
	l6.setBounds(100,0 ,500,100);
	f.add(l6);
	
	l7=new JLabel();
	l7.setText(name);
	l7.setFont(new Font("Arial",Font.BOLD,25));
	l7.setForeground(Color.white);
	l7.setBounds(1000,0,600,100);
	f.add(l7);
	
	l8=new JLabel("All Books");
	l8.setFont(new Font("Arial",Font.BOLD,35));
	l8.setForeground(Color.black);
	l8.setBounds(500,100,300,50);
	f.add(l8);

	
	l9=new JLabel();
	l10=new JLabel();
	l11=new JLabel();
	l11.setText(bid);
  
JPanel p=new JPanel();
  GridBagLayout grid = new GridBagLayout();  
            GridBagConstraints gbc = new GridBagConstraints();  
			gbc.insets = new Insets(10,25,5,25);
            p.setLayout(grid);  
  
   p.setBackground(Color.getHSBColor(0.56f, 1.0f, 0.8f));
		
        //p.setBounds(40,160,1500,500);    
        //p.setBackground(Color.gray);
		//p.setLayout(null);
		//f.add(p);
	
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");  
  
	    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");  
  
		Statement stmt=con.createStatement();  
 
		ResultSet rs=stmt.executeQuery("select * from adminadd ");  
		
		int	range=0;
		
		while(rs.next()){
		//range=rs.getInt("count(*)");
		range++;
		}
		
		ImageIcon[] icon=new ImageIcon[range];
		
		Image[] img=new Image[range];
		
		l1=new JLabel[range]; 
		l2=new JLabel[range];
		l3=new JLabel[range]; 
		l4=new JLabel[range];
		l5=new JLabel[range];
		
		b1=new JButton[range];
		
		String[] a=new String[range];
		String[] b=new String[range];
		String[] c=new String[range];
		int[] d=new int[range];
		
		
		//int x=50,y=200,w=150,h=170;
		//int x1=50,y1=370,w1=200,h1=30;
		
		int x=0,y=0;
		
		ResultSet rs1=stmt.executeQuery("select * from adminadd where "+ab+"='"+cd+"'");

		
		
		for(int i=0;rs1.next();i++){  
			
			
			byte[] image = null;
            image = rs1.getBytes("bimage");
            img[i] = Toolkit.getDefaultToolkit().createImage(image);
			icon[i] = new ImageIcon(new ImageIcon(img[i]).getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
         
		gbc.fill = GridBagConstraints.HORIZONTAL;  
		gbc.gridx = x;  
		gbc.gridy = y; 
		gbc.anchor = GridBagConstraints.PAGE_START;
		 
		 l1[i]=new JLabel();
		 l1[i].setIcon(icon[i]);
	//	 l1[i].setBounds(x,y,w,h);
	
		 p.add(l1[i],gbc);
		 
		 
		 a[i]=rs1.getString("bname");
		 b[i]=rs1.getString("btype");
		 c[i]=rs1.getString("bauthour");
		 d[i]=rs1.getInt("bcost");
				
		gbc.fill = GridBagConstraints.HORIZONTAL;  
		gbc.gridx = x;  
		gbc.gridy = y+1; 
		
		l2[i]=new JLabel(a[i]);
		l2[i].setFont(new Font("Arial",Font.BOLD,20));
		l2[i].setForeground(Color.white);
		p.add(l2[i],gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;  
		gbc.gridx = x;  
		gbc.gridy = y+2; 
		
		
		l3[i]=new JLabel("Book Type :"+b[i]);
		l3[i].setForeground(Color.orange);
		p.add(l3[i],gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;  
		gbc.gridx = x;  
		gbc.gridy = y+3; 
		
		
		l4[i]=new JLabel("Book Author :"+c[i]);
		l4[i].setForeground(Color.yellow);
		p.add(l4[i],gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;  
		gbc.gridx = x;  
		gbc.gridy = y+4; 
		
		
		l5[i]=new JLabel("Book Cost :"+d[i]);
		l5[i].setForeground(Color.green);
		p.add(l5[i],gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;  
		gbc.gridx = x;  
		gbc.gridy = y+5; 
		
		b1[i]=new JButton("View Book");
		b1[i].setFont(new Font("Arial",Font.BOLD,25));
		b1[i].setForeground(Color.black);
		b1[i].setOpaque(false);
		b1[i].setContentAreaFilled(false);
		b1[i].setBorderPainted(false);
		p.add(b1[i],gbc);
		b1[i].putClientProperty("id",i);
		b1[i].addActionListener(this);
		 
		 x++;
		 
		 
		 if(x==4){
		 x=0;y+=6;}
		 
        }
		
		
		//System.out.println(range);


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
  
  if( ae.getSource() instanceof JButton) {
	  
     ((JButton)ae.getSource()).setOpaque(true);
  }
  
 JButton source = (JButton)ae.getSource();
            int id = (int) source.getClientProperty("id");
            System.out.println(id);
  
String m=l2[id].getText(); 
 
 
  try{
		Class.forName("oracle.jdbc.driver.OracleDriver");  
  
	    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");  
  
		Statement stmt=con.createStatement();  
 
 
		ResultSet rs=stmt.executeQuery("select bimage,bdescription from adminadd where bname='"+m+"'");  
		
		
		
		
		while(rs.next()){
		
			byte[] image = null;
            image = rs.getBytes("bimage");
            Image img = Toolkit.getDefaultToolkit().createImage(image);
			ImageIcon icon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT));
					l9.setIcon(icon);	
					l10.setText(rs.getString("bdescription"));
		}
  
    


	
Fullpage page3=new Fullpage(l9.getIcon(),l2[id].getText(),l3[id].getText(),l4[id].getText(),l5[id].getText(),l10.getText(),l11.getText(),l7.getText());
        // page.setVisible(true);
	
			 con.close();  
  
}catch(Exception e){ System.out.println(e);}
	

	
	
	
	}





}	
