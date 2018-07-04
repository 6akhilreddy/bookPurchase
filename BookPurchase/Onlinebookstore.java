/*<applet code=Onlinebookstore height=500 width=500></applet>*/

import javax.swing.*;
import java.sql.*;
import java.io.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import java.util.*;

public class Onlinebookstore extends JApplet implements ActionListener,ItemListener{

	JLabel l1,l2,l3,l4;
	JLabel la1,la2;
	JButton b1,b2;
	JTextField t1,t3,t4,t5,t6,t7,t8,t9,t10;
	JPasswordField t2;
	JRadioButton r1,r2;

	Onlinebookstore(){
	
	
	JFrame f=new JFrame("OnlineBookStore");
	

    f.setContentPane(new JLabel(new ImageIcon("b.jpg")));
   

	
	l1=new JLabel("OnlineBookStore");
	l1.setFont(new Font("Arial",Font.BOLD,50));
	l1.setForeground(Color.yellow);
	l1.setBounds(100,0 ,500,100);
	f.add(l1);
	
	l2=new JLabel("Already have an account");
	l2.setFont(new Font("Arial",Font.BOLD,30));
	l2.setForeground(Color.orange);
	l2.setBounds(750,10,400,50);
	f.add(l2);
	
	
	t1=new HintTextField("UserName");
	t1.setForeground(Color.yellow);
	t1.setOpaque(false);
	t1.setBounds(700,60,170,30);
	f.add(t1);
	
	la1=new JLabel("Email");
	la1.setForeground(Color.yellow);
	la1.setBounds(750,100,200,20);
	f.add(la1);
	
	
	t2=new JPasswordField();
	t2.setForeground(Color.yellow);
	t2.setOpaque(false);
	t2.setBounds(950,60,170,30);
	f.add(t2);
	
	la2=new JLabel("Password");
	la2.setForeground(Color.yellow);
	la2.setBounds(1000,100,200,20);
	f.add(la2);
	
	b1=new JButton("LOGIN");
	b1.setBounds(1150,60,70,30);
	f.add(b1);
	
	
	l4=new JLabel("Create a New Account");
	l4.setFont(new Font("Arial",Font.BOLD,30));
	l4.setForeground(Color.green);
	l4.setBounds(760,125,400,30);
	f.add(l4);
	
	t3=new HintTextField("FirstName");
	t3.setForeground(Color.yellow);
	t3.setOpaque(false);
	t3.setBounds(750,200,150,30);
	f.add(t3);
	
	
	t4=new HintTextField("LastName");
	t4.setForeground(Color.yellow);
	t4.setOpaque(false);
	t4.setBounds(950,200,152,30);
	f.add(t4);
	
	t5=new HintTextField("Email");
	t5.setForeground(Color.yellow);
	t5.setOpaque(false);
	t5.setBounds(750,250,358,30);
	f.add(t5);
	
	t6=new HintTextField("Set Password");
	t6.setForeground(Color.yellow);
	t6.setOpaque(false);
	t6.setBounds(750,300,358,30);
	f.add(t6);
	
	t7=new HintTextField("Confirm Password");
	t7.setForeground(Color.yellow);
	t7.setOpaque(false);
	t7.setBounds(750,350,358,30);
	f.add(t7);
	
	
	t8=new HintTextField("DATE OF BIRTH-DD/MM/YYYY");
	t8.setForeground(Color.yellow);
	t8.setOpaque(false);
	t8.setBounds(750,400,358,30);
	f.add(t8);
	

	
	ButtonGroup group = new ButtonGroup();
	
	r1=new JRadioButton("MALE");
	r1.setFont(new Font("Arial",Font.BOLD,20));
	r1.setOpaque(false);
	r1.setForeground(Color.yellow);
	r1.setBounds(750,450,100,50);
	group.add(r1);
	f.add(r1);
	
	
	r2=new JRadioButton("FEMALE");
	r2.setFont(new Font("Arial",Font.BOLD,20));
	r2.setOpaque(false);
	r2.setForeground(Color.yellow);
	r2.setBounds(900,450,150,50);
	group.add(r2);
	f.add(r2);
	
	b2=new JButton("Create");
	b2.setFont(new Font("Arial",Font.BOLD,20));
	b2.setBounds(850,550,150,50);
	f.add(b2);
	
	
	b1.addActionListener(this);
	b2.addActionListener(this);
	
	

	
	//r1.addActionListener(sliceActionListener);
    //r2.addActionListener(sliceActionListener);
	
	
	f.setSize(900,500);  
    f.setLayout(null);  
    f.setVisible(true);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		}

	  /*  ActionListener sliceActionListener = new ActionListener() {
      public void actionPerformed(ActionEvent actionEvent) {
        AbstractButton r1 = (AbstractButton) actionEvent.getSource();
        //AbstractButton r2 = (AbstractButton) actionEvent.getSource();
		System.out.println("Selected: " + r1.getText());
      }
    };*/

	


 
	 
	public void actionPerformed(ActionEvent ae){
		

//	AbstractButton r1 = (AbstractButton) ae.getSource();

String a,b,c,d,x,y;     
String s=ae.getActionCommand();
 
if(s.equals("Create")){	

if(r1.isSelected()) 
y="MALE";
else
y="FEMALE";


a=t3.getText();b=t4.getText();c=t5.getText();d=t6.getText();x=t8.getText();
//System.out.println(a+b+c+d+x+y);  

			try{  
//step1 load the driver class  
Class.forName("oracle.jdbc.driver.OracleDriver");  
  
//step2 create  the connection object  
Connection con=DriverManager.getConnection(  
"jdbc:oracle:thin:@localhost:1521:xe","system","system");  
  
//step3 create the statement object  
Statement stmt=con.createStatement();  
 
//step4 execute query  


ResultSet rs=stmt.executeQuery("insert into users values('"+a+"','"+b+"','"+c+"','"+d+"','"+x+"','"+y+"')");  


//step5 close the connection object  

JOptionPane.showMessageDialog(null,"Account Created Successfully !!");

con.close();  

t3.setText("");
t4.setText("");
t5.setText("");
t6.setText("");
t7.setText("");
t8.setText("");
  
}catch(Exception e){ System.out.println(e);}  

}
else{
	String a1,a2,b1,b2,x1,y1;
	
	a2="admin";
	b2="Admin@123";
	
	a1=t1.getText();
	b1=t2.getText();



if((a2.equals(a1))&&(b2.equals(b1))){
	    
		JOptionPane.showMessageDialog(null,"Successfully logged in as "+a2+"!");
		
		t1.setText("");
		t2.setText("");
		
		Admin page1=new Admin();
         page1.setVisible(true);
		}	
else{
			try{  
//step1 load the driver class  
Class.forName("oracle.jdbc.driver.OracleDriver");  
  
//step2 create  the connection object  
Connection con=DriverManager.getConnection(  
"jdbc:oracle:thin:@localhost:1521:xe","system","system");  
  
//step3 create the statement object  
Statement stmt=con.createStatement();  
 
//step4 execute query  


ResultSet rs=stmt.executeQuery("select email,password from users");  
 while(rs.next()){
	 x1=rs.getString("email");
	 y1=rs.getString("password");

		if((a1.equals(x1))&&(b1.equals(y1))){
	
		JOptionPane.showMessageDialog(null,"Successfully logged in as "+x1+"!");
		
		t1.setText("");
		t2.setText("");
		
		View page2=new View(x1);
        page2.setVisible(true);
		break;}
        
}

//step5 close the connection object  

con.close();  
  
}catch(Exception e){ System.out.println(e);}  
	
}
	
}
}

	public void itemStateChanged(ItemEvent ie){


}



class HintTextField extends JTextField implements FocusListener {

  private final String hint;
  private boolean showingHint;

  public HintTextField(final String hint) {
    super(hint);
    this.hint = hint;
    this.showingHint = true;
    super.addFocusListener(this);
  }

  @Override
  public void focusGained(FocusEvent e) {
    if(this.getText().isEmpty()) {
      super.setText("");
      showingHint = false;
    }
  }
  @Override
  public void focusLost(FocusEvent e) {
    if(this.getText().isEmpty()) {
      super.setText(hint);
      showingHint = true;
    }
  }

  @Override
  public String getText() {
    return showingHint ? "" : super.getText();
  }
}


	public static void main(String args[]){
		
    

	new Onlinebookstore();


}	
}
