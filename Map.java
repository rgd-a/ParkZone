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

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.*;
import java.io.FileWriter;
        
public class Map   extends JFrame implements Serializable {
    
    

   private JMenuBar Menubar= new JMenuBar(); 
     private JMenu fileMenu=new JMenu() ; 
      private JMenu Viwe=new JMenu() ; 
      private JMenuItem signout=new JMenu() ;
       private JMenuItem Myprofile=new JMenu() ;
  private JMenuItem  parkingMapu=new JMenu() ;

    JLabel listlabel, timelabel;
    JTextField  timetextField;
    JRadioButton radioButton1, radioButton2, radioButton3,radioButton4;
    JButton button2;
    String radiotime;
String[] parking = { "A1","A2","A3","A4","A5","A6","B1","B2","B3",
             "B4","B5","B6","C1","C2","C3",
             "C4","C5","C6","D1","D2","D3",
             "D4","D5","D6"};
    JComboBox combo = new JComboBox(parking);
    
      //background
        ImageIcon backg = new ImageIcon("C:\\Users\\lenovo\\Downloads\\mywhitemap.jpeg");
       JLabel imageLabell = new JLabel (backg);
        ImageIcon back2 = new ImageIcon("C:\\Users\\lenovo\\Desktop\\parkk.jpg");
       JLabel imageLabel2 = new JLabel (back2);
  JButton  BookButton= new JButton("Book!");
  JPanel panel = new JPanel();
 
 
    public Map() {
        //frame
        setTitle("Parkingone");
        setSize(1300,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   setLayout(new GridLayout(3, 2));
       
       add(panel);

  panel.setBackground(Color.WHITE);

 buildMenuBar(); 
 
      
 backg.setImage(backg.getImage().getScaledInstance(650, 280, Image.SCALE_DEFAULT));
    

//add action lisner to each button
  BookButton.addActionListener(new Booking()); 
       BookButton.setBackground(new Color(32,178,170));
       BookButton.setForeground( Color.WHITE);
 BookButton.setFont(new Font("Dubai", Font.BOLD, 15));

  //set info for each button 
  BookButton.setToolTipText("Click to set up a parking");
   

        //---------components setting-----------------
        listlabel = new JLabel(" Select parking spot! ");
         listlabel.setForeground(new Color(32,178,170));
      // listlabel.setBackground(Color.WHITE);
        listlabel.setFont(new Font("Dubai", Font.BOLD, 30));

    panel.add(listlabel);  
   add(imageLabell); 
   
        combo.setBackground(Color.WHITE);
        
        combo.setFont(new Font("Dubai", Font.BOLD, 15));
     add(combo); 
    
        //---------components setting-----------------
        JPanel radiopanel = new JPanel();
       add(radiopanel);
  radiopanel.setBorder(BorderFactory.createTitledBorder("Select your time:"));
   combo.setBorder(BorderFactory.createTitledBorder(   "Select your parking spot:"));
  
        radiopanel.setBackground(Color.WHITE);
        timelabel = new JLabel("Time:"); 
        timelabel.setFont(new Font("Dubai", Font.BOLD, 15));
        radioButton1 = new JRadioButton("Now");
        radioButton1.setBackground(Color.WHITE);
        radioButton1.setFont(new Font("Dubai", Font.BOLD, 15));
        radioButton2 = new JRadioButton("After 10 min");
        radioButton2.setFont(new Font("Dubai", Font.BOLD, 15));
        radioButton2.setBackground(Color.WHITE);
        
        radioButton3 = new JRadioButton("After 30 min");
        radioButton3.setFont(new Font("Dubai", Font.BOLD, 15));
        radioButton3.setBackground(Color.WHITE);        

        radioButton4 = new JRadioButton("After 1 hour");
        radioButton4.setFont(new Font("Dubai", Font.BOLD, 15));
        radioButton4.setBackground(Color.WHITE);        
       
        
        
        
        ButtonGroup BGroup = new ButtonGroup();
        BGroup.add(radioButton1);BGroup.add(radioButton2);
        BGroup.add(radioButton3);BGroup.add(radioButton4);
        radiopanel.add(radioButton1);radiopanel.add(radioButton2);
radiopanel.add(radioButton3); radiopanel.add(radioButton4);

  back2.setImage(back2.getImage().getScaledInstance(700, 400, Image.SCALE_DEFAULT));

        add(imageLabel2);
      add(BookButton); 
          setVisible(true);   

     
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
 //Ctrl+P
 Myprofile.setMnemonic(KeyEvent.VK_P);
 
 
 // Create an sig out menu item.
 signout = new JMenuItem("Sign out");
 //Ctrl+x
 signout.setMnemonic(KeyEvent.VK_X);
 
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
 Viwe.setMnemonic(KeyEvent.VK_V);
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
 
  

 

 
 public String Radiotime(){
 
 String resultetime = null;
 
   if (radioButton1.isSelected()){
                resultetime="Now";
            } if (radioButton2.isSelected()){
                resultetime="After 10 minutes";
            }  if (radioButton3.isSelected()){
                resultetime="After 30 minutes";
            }  if (radioButton4.isSelected()){
                resultetime="After 1 hour";
            }
            
            return resultetime;
 }
 
 
 
          
          public void Savedata(){
 
     
    try{
    FileWriter fw = new FileWriter ("Parkingbook.txt",true);
    fw.write(String.valueOf(combo.getSelectedItem())+ "\n"+Radiotime());
    fw.close();
    }
catch(Exception ec){System.out.println("File not found");}
 }
   
         
          private class Booking implements ActionListener
 {
 public void actionPerformed(ActionEvent e){
     
 
     Savedata();
             setVisible(false);
      
         Bookinginfo history = new Bookinginfo();}  
          
          }   
    public static void main(String[] args) {
        new Map();
    }
    
}
