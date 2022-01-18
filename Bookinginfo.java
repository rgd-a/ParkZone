/*
Student 1 : Mada Abdullah Omar 
ID:1912174
E-mail:1912174@uj.edu.sa

Student 2 : Raghad Aymn Alharbi
ID:1875953
E-mail:1875953@uj.edu.sa

Topic: Parking booking system (Project)
setion: C1

*/
package windowfirstpage;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;
import javax.swing.DefaultListModel;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
//import windowfirstpage.CreateAccount.book;
public class Bookinginfo extends JFrame implements Serializable {
 private JPanel Panel= new JPanel();
 private JPanel Panel2= new JPanel();
 private JLabel infoLable = new JLabel ("                                    Booking complete!! Thank you for reservation                                     ");
 private JLabel Name= new JLabel ("Name: ");
 private JLabel info2Lable = new JLabel("Booking info:  ");
 private JLabel Studentid= new JLabel ("  Student ID: ");
 private JLabel date= new JLabel ("  Date: ");
 private JLabel spot= new JLabel ("  Parking spot: ");
 private JLabel TimeLabel= new JLabel ("  Time: ");
 private JTextField  userName=new JTextField(10);
 private JTextField  userStudentid=new JTextField (10);
 private JTextField  userdate=new JTextField (10);
 private JTextField  userspot=new JTextField (10);
 private JTextField  userTime=new JTextField (10);
 private ImageIcon   image = new ImageIcon("C:\\Users\\lenovo\\OneDrive\\المستندات\\لقطات الشاشة\\click.gif");
 private JLabel imageLabel = new JLabel (image);
 private ImageIcon   image2 = new ImageIcon("C:\\Users\\lenovo\\Desktop\\QR.jpg");
 private JLabel imageLabel2 = new JLabel (image2);
 private JMenuBar Menubar= new JMenuBar(); 
 private JMenu fileMenu=new JMenu() ; 
 private JMenu Viwe=new JMenu() ; 
 private JMenuItem signout=new JMenu() ;
 private JMenuItem Myprofile=new JMenu() ;
 private JMenuItem  parkingMapu=new JMenu() ;

String name , id , time,parking,strDate;
    // End of variables declaration                 

//consrator
Bookinginfo (){
 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setLayout(new GridLayout(2,3));
       
    setSize(1300,800);
          buildPanel();
          buildMenuBar();  
time();
      
Panel.setBackground(Color.WHITE);
add(Panel);
Panel2.setBackground(Color.WHITE);
add(Panel2,BorderLayout.WEST);
Panel.add(infoLable);
Panel.add(info2Lable);
Panel.add(Name);
Panel.add(userName);
Panel.add(Studentid);
Panel.add(userStudentid); 
Panel.add(spot);
Panel.add(userspot); 
Panel.add(TimeLabel); 
Panel.add(userTime);
Panel.add(date);
Panel.add(userdate);
  Panel2. add(imageLabel2,BorderLayout.WEST);
  Panel2. add(imageLabel,BorderLayout.EAST);
 
   setTitle("ParkZone"); 
             pack();
       setVisible(true);  
       
         } 
 
        private void buildPanel()
 {
     infoLable.setForeground(new Color(32,178,170));  
 infoLable.setFont(new Font("Serif", Font.PLAIN, 50));
 
    info2Lable.setForeground(new Color(32,178,170));  
 info2Lable.setFont(new Font("Serif", Font.PLAIN, 28));  
 
 
     //Resize the image 
      image.setImage(image.getImage().getScaledInstance(800, 300, Image.SCALE_DEFAULT));
      image2.setImage(image2.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT));
 
     
   read();
    userName.setText("\n"+name);
    userStudentid.setText("\n"+id);
 //userdate.setText("\n"+strDate);
    userspot.setText("\n"+parking);
    userTime.setText("\n"+time);
   
 // Make the text field uneditable.
 userName.setEditable(false);
 userStudentid.setEditable(false);
 userdate.setEditable(false);
 userspot.setEditable(false);
 userTime.setEditable(false);
 
 
 
Name.setForeground(new Color(37 , 41 ,88)); 
Name.setFont(new Font("Dubai", Font.BOLD, 25));

Studentid.setForeground(new Color(37 , 41 ,88)); 
Studentid.setFont(new Font("Dubai", Font.BOLD, 25));


spot.setForeground(new Color(37 , 41 ,88)); 
spot.setFont(new Font("Dubai", Font.BOLD, 25));


TimeLabel.setForeground(new Color(37 , 41 ,88)); 
TimeLabel.setFont(new Font("Dubai", Font.BOLD, 25));


date.setForeground(new Color(37 , 41 ,88)); 
date.setFont(new Font("Dubai", Font.BOLD, 25));
 
 
 
userName.setForeground(Color.BLACK); 
userName.setFont(new Font("Dubai", Font.PLAIN, 15));
userStudentid.setForeground(Color.BLACK); 
userStudentid.setFont(new Font("Dubai", Font.PLAIN, 15));
userdate.setForeground(Color.BLACK); 
userdate.setFont(new Font("Dubai", Font.PLAIN,15));
userspot.setForeground(Color.BLACK); 
userspot.setFont(new Font("Dubai", Font.PLAIN, 15));
userTime.setForeground(Color.BLACK); 
userTime.setFont(new Font("Dubai", Font.PLAIN, 15));
 
 
 }
        private void buildMenuBar()
 {
    //Call to all menu to menuBar 

 buildproFileMenu();
 buildViewMenu();
 // Add  menus to the menu bar.  
 Menubar.add(fileMenu);
   Menubar.add(Viwe);

//profileMenu.add(textMenu);
 setJMenuBar(Menubar);
 
 }
 private void buildproFileMenu(){
    
 // Create a JMenu object for the proFile menu.
 fileMenu = new JMenu("File");
 //Ctrl+F
 fileMenu.setMnemonic(KeyEvent.VK_F);
 
 Myprofile = new JMenuItem("My profile");
 //Ctrl+S
 Myprofile.setMnemonic(KeyEvent.VK_S);
 
 
 // Create an sig out menu item.
 signout = new JMenuItem("Sign out");
 //Ctrl+x
 signout.setMnemonic(KeyEvent.VK_X);
 
 signout.addActionListener(new ExitListener());

 //Add action lisner method to each button 
   Myprofile.addActionListener(new myprofil());
 signout.addActionListener(new ExitListener());

 // Add the sign out menu item to the proFile menu.
  fileMenu.add(Myprofile);
 fileMenu.add(signout);
 
 } 

  private void buildViewMenu(){
 // Create a JMenu object for the proFile menu.
   Viwe = new JMenu("View");
 //Ctrl+P
   Viwe.setMnemonic(KeyEvent.VK_P);
   parkingMapu = new JMenuItem("Parking map"); 

 // Add the History menu item to the booking menu.
   Viwe.add(parkingMapu);
 
  //Add action lisner method to each button 
   parkingMapu.addActionListener(new maping());

  }
 
  //Action for sign out 
 private class ExitListener implements ActionListener
 {
 public void actionPerformed(ActionEvent e)
 {
 System.exit(0);
 }
 }
 
 
 //Action for my proflie
 private class myprofil implements ActionListener
 {
 public void actionPerformed(ActionEvent e)
 {
   setVisible(false);
     myprofile myfile = new myprofile();  

 }
 }
  
 //Action for Parkingmap
 private class maping implements ActionListener
 {
 public void actionPerformed(ActionEvent e)
 {
   setVisible(false);
     Map myfile = new Map();  

 }
 }
 
    public void read() {
    try{
    Scanner input = new Scanner(new File ("Parkingbook.txt"));
    name=input.nextLine();
      id=input.nextLine(); 
      parking=input.nextLine();
        time=input.nextLine();

    }
  catch(Exception ec)
          
          {System.out.println("File not found");}
    }
    
    
       public void time() {
     DateTimeFormatter d = DateTimeFormatter.ofPattern("yyyy/mm/d");
     LocalDateTime now = LocalDateTime.now();
     userdate.setText(d.format(now));
     }       
 
    public static void main(String[] args) {
       
        new Bookinginfo();
    }
}

