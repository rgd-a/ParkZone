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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import javax.swing.*;

public class myprofile extends JFrame {
 private JPanel Panel= new JPanel();
 private JPanel Panel2= new JPanel();
 private JLabel Name= new JLabel ("Name: ");
 private JLabel Studentid= new JLabel ("Student ID: ");
 private JLabel numbooking= new JLabel ("Last use: ");
 private JLabel info2Lable = new JLabel("                                                     MY PROFILE                                                       ");
 private JTextField  userName=new JTextField (10);
 private JTextField  userStudentid=new JTextField (10);
 private JTextField  usernumbooking=new JTextField (15);
 private ImageIcon   image = new ImageIcon("C:\\Users\\lenovo\\OneDrive\\المستندات\\لقطات الشاشة\\street and car.png");
 private JLabel imageLabel = new JLabel (image);
 private JMenuBar Menubar= new JMenuBar(); 
 private JMenu fileMenu=new JMenu() ; 
 private JMenu Viwe=new JMenu() ; 
 private JMenuItem signout=new JMenu() ;
 private JMenuItem Myprofile=new JMenu() ;
 private JMenuItem  parkingMapu=new JMenu() ;
 String name , id , LastBooking;
 
       //consructer
       myprofile(){
           
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setLayout(new GridLayout(2,2));
       setSize(1300,800);
          buildPanel();
          buildMenuBar();  
           time() ;
           
         Panel.setBackground(Color.WHITE);
         add(Panel);
         Panel2.setBackground(Color.WHITE);
         add(Panel2,BorderLayout.SOUTH);
         Panel.add(info2Lable);
         Panel.add(Name);
         Panel.add(userName);
         Panel.add(Studentid);
         Panel.add(userStudentid); 
         Panel.add(numbooking); 
         Panel.add(usernumbooking);
         Panel2. add(imageLabel,BorderLayout.SOUTH);

   setTitle("ParkZone");
  pack();
setVisible(true);  
         } 
       
       
        private void buildPanel()
 {
     //Resize the image 
 image.setImage(image.getImage().getScaledInstance(1400, 270, Image.SCALE_DEFAULT));
     
 info2Lable.setForeground(new Color(32,178,170));  
 info2Lable.setFont(new Font("Serif", Font.PLAIN, 70));  
Name.setForeground(new Color(32,178,170)); 
Name.setFont(new Font("Dubai", Font.BOLD, 25));

 userName.setForeground(Color.BLACK);  
 userName.setFont(new Font("Serif", Font.PLAIN, 20));  
 
 Studentid.setForeground(new Color(32,178,170)); 
 Studentid.setFont(new Font("Dubai", Font.BOLD, 25));

 userStudentid.setForeground(Color.BLACK);  
 userStudentid.setFont(new Font("Serif", Font.PLAIN, 20));  
 
 numbooking.setForeground(new Color(32,178,170)); 
 numbooking.setFont(new Font("Dubai", Font.BOLD, 25));

 usernumbooking.setForeground(Color.BLACK);  
 usernumbooking.setFont(new Font("Serif", Font.PLAIN, 20));  
  
 read();
   userName.setText("\n"+name);
   userStudentid.setText("\n"+id);
   usernumbooking.setText("\n"+LastBooking);

 // Make the text field uneditable.
 userName.setEditable(false);
 userStudentid.setEditable(false);
 usernumbooking.setEditable(false);
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
 
 //Add action lisner methode to each button 
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


 //Add action lisner method to each button 
parkingMapu.addActionListener(new maping());

 
 // Add the History menu item to the booking menu.
  Viwe.add(parkingMapu);

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
    }
    
  catch(Exception ec)      
      {System.out.println("File not found");}
    }
    
 public void time() {
     DateTimeFormatter d = DateTimeFormatter.ofPattern("yyyy/mm/d  hh:mm:ss");
     LocalDateTime now = LocalDateTime.now();
     usernumbooking.setText(d.format(now));
     }     
 
    public static void main(String[] args) {
    new myprofile();
    
    }
    
}
