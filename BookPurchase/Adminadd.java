import javax.swing.*;
import java.sql.*;
import java.io.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import java.util.*;
import javax.swing.border.Border;
 

public class Adminadd extends JApplet implements ActionListener{
	
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
	JButton b1,b2;
	JTextField t1,t2,t3,t4,t6,t7;
	JTextArea t5;
	
	Adminadd(){
		
		
	JFrame f=new JFrame("ADMIN PANNEL");
	

    f.setContentPane(new JLabel(new ImageIcon("d.jpg")));
	
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
	
	l3=new JLabel("Add Books");
	l3.setFont(new Font("Arial",Font.BOLD,35));
	l3.setForeground(Color.yellow);
	l3.setBounds(800,100,300,50);
	f.add(l3);

	l4=new JLabel("Book Name : ");
	l4.setFont(new Font("Arial",Font.BOLD,25));
	l4.setForeground(Color.orange);
	l4.setBounds(680,170,300,50);
	f.add(l4);

	t1=new JTextField(20);
	t1.setForeground(Color.green);
	t1.setOpaque(false);
	t1.setBounds(900,180,200,30);
	f.add(t1);
	
	l5=new JLabel("Book Type : ");
	l5.setFont(new Font("Arial",Font.BOLD,25));
	l5.setForeground(Color.orange);
	l5.setBounds(680,220,300,50);
	f.add(l5);

	t2=new JTextField(20);
	t2.setForeground(Color.green);
	t2.setOpaque(false);
	t2.setBounds(900,230,200,30);
	f.add(t2);
	
	
	l5=new JLabel("Book Cost : ");
	l5.setFont(new Font("Arial",Font.BOLD,25));
	l5.setForeground(Color.orange);
	l5.setBounds(680,270,300,50);
	f.add(l5);

	t3=new JTextField(20);
	t3.setForeground(Color.green);
	t3.setOpaque(false);
	t3.setBounds(900,280,200,30);
	f.add(t3);
	
	
	l6=new JLabel("Book Authour : ");
	l6.setFont(new Font("Arial",Font.BOLD,25));
	l6.setForeground(Color.orange);
	l6.setBounds(680,320,300,50);
	f.add(l6);

	t4=new JTextField(20);
	t4.setForeground(Color.green);
	t4.setOpaque(false);
	t4.setBounds(900,330,200,30);
	f.add(t4);
	
	l7=new JLabel("Book Description : ");
	l7.setFont(new Font("Arial",Font.BOLD,25));
	l7.setForeground(Color.orange);
	l7.setBounds(680,390,300,50);
	f.add(l7);

	t5 = new JTextArea();
    Border border = BorderFactory.createLineBorder(Color.white);
    t5.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
	t5.setForeground(Color.green);
	t5.setOpaque(false);
	JScrollPane scrollPane = new JScrollPane(t5);
	 scrollPane.getViewport().setOpaque(false);
        scrollPane.setOpaque(false);
        t5.setOpaque(false);


	scrollPane.setBounds(900,380,200,70);
	//Container.add(scrollPane);
	f.add(scrollPane);
	
	l8=new JLabel("Upload Photo : ");
	l8.setFont(new Font("Arial",Font.BOLD,25));
	l8.setForeground(Color.orange);
	l8.setBounds(680,460,300,50);
	f.add(l8);

	
	t6=new JTextField(20);
	t6.setForeground(Color.green);
	t6.setOpaque(false);
	t6.setBounds(900,470,200,30);
	f.add(t6);
	
	b1=new JButton("Browse");
	b1.setForeground(Color.white);
	b1.setBackground(Color.gray);
	b1.setBounds(1150,470,150,30);
	f.add(b1);
	
	l9=new JLabel("Book Id : ");
	l9.setFont(new Font("Arial",Font.BOLD,25));
	l9.setForeground(Color.orange);
	l9.setBounds(680,520,300,50);
	f.add(l9);

	t7=new JTextField(20);
	t7.setForeground(Color.green);
	t7.setOpaque(false);
	t7.setBounds(900,520,200,30);
	f.add(t7);
	
	
	b2=new JButton("SAVE");
	b2.setFont(new Font("Arial",Font.BOLD,30));
	b2.setForeground(Color.yellow);
	b2.setBackground(Color.gray);
	b2.setBounds(860,600,130,50);
	f.add(b2);
	
	f.setSize(900,500);  
    f.setLayout(null);  
    f.setVisible(true);
	//f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	b1.addActionListener(this);
	b2.addActionListener(this);
	
	
	}
	
	public void actionPerformed(ActionEvent ae){
	
	String s=ae.getActionCommand();
	
	File file = null;
    String path="";
	 
    if(s.equals("Browse")){	

    
	JFileChooser chooser = new JFileChooser();
    chooser.addChoosableFileFilter(new ImageFileFilter());
    int returnVal = chooser.showOpenDialog(null);

    if(returnVal == JFileChooser.APPROVE_OPTION) {   
    file = chooser.getSelectedFile();
    path=file.getPath();
    t6.setText(path);
    }

    }
	
	else{
    String a,b,d,e,g,fg;
	int c=Integer.parseInt(t3.getText());
	a=t1.getText();b=t2.getText();d=t4.getText();e=t5.getText();g=t6.getText();fg=t7.getText();
	
	if(a.equals("")||b.equals("")||(t3.getText()).equals("")||d.equals("")||e.equals("")||g.equals("")||fg.equals("")){
	
		JOptionPane.showMessageDialog(null,"All Fields Must Be Filled !!");

	
	}
	
	else{
	
	try{
    File f=new File(g);
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
	PreparedStatement psmnt = connection.prepareStatement("insert into adminadd values(?,?,?,?,?,?,?)");
	
	psmnt.setString(1,""+a+"");  
	psmnt.setString(2,""+b+"");
	psmnt.setInt(3,c);
	psmnt.setString(4,""+d+"");
	psmnt.setString(5,""+e+"");
	
	
	FileInputStream fis = new FileInputStream(f);
	psmnt.setBinaryStream(6, (InputStream)fis, (int)(f.length()));
	
	psmnt.setString(7,""+fg+"");
	
	int i = psmnt.executeUpdate();
	JOptionPane.showMessageDialog(null,"Inserted successfully!");
    }
    catch(Exception ex){
        System.out.print(ex);
    }	
t1.setText("");
t2.setText("");
t3.setText("");
t4.setText("");
t5.setText("");
t6.setText("");
t7.setText("");


	}
	
	}


		
	}
	
class ImageFileFilter extends javax.swing.filechooser.FileFilter {
public boolean accept(File file) {
if (file.isDirectory()) return false;
String name = file.getName().toLowerCase();
return (name.endsWith(".jpg") || name.endsWith(".png")|| name.endsWith(".gif"));
}
public String getDescription() { return "Images (*.gif,*.bmp, *.jpg, *.png )"; }
}
	
	public static void main(String args[]){
		
		new Adminadd();
		
	}
}