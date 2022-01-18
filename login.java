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
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class login extends JFrame{

  private JButton LoginButton; // To reference a button
  private JPanel Panel= new JPanel();
  private JPanel Panel2= new JPanel();
  private JPanel greetpan;
  private JLabel greetlabel;
  private JPanel textpan;
  private JTextField name;
  private JLabel namelabel; 
  private JTextField id;
  private JLabel idlabel;    
  private JTextField pass;
  private JLabel passlabel;   
  private ImageIcon   image = new ImageIcon("C:\\Users\\lenovo\\Desktop\\car-dribble.gif");
  private JLabel imageLabell = new JLabel (image);
  private ImageIcon   image2 = new ImageIcon("C:\\Users\\lenovo\\OneDrive\\المستندات\\لقطات الشاشة\\ghina.png");
  private JLabel imageLabel2 = new JLabel (image2);
  File Path_Folder;
     

    //consrctor
     public login(){
        
    setTitle("ParkZone");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new GridLayout(2,3)); 
    setFont(new Font("serif", Font.PLAIN, 100));
    setSize(1300,800);


    buildGreetPan();   
    buildTextPan();  
    
     Panel.setBackground(Color.WHITE);
     add(Panel);
     Panel2.setBackground(Color.WHITE);
     add(Panel2,BorderLayout.NORTH);
     Panel. add(imageLabel2, BorderLayout.WEST);
     Panel. add(greetpan, BorderLayout.SOUTH);
     Panel. add(textpan, BorderLayout.CENTER); 
     Panel2. add(imageLabell, BorderLayout.EAST);

      image.setImage(image.getImage().getScaledInstance(700, 300, Image.SCALE_DEFAULT));
      image2.setImage(image2.getImage().getScaledInstance(500, 100, Image.SCALE_DEFAULT));
 
    setVisible(true);   
    
 }//end 0f c0nstruct0r

  private void  buildTextPan(){
      
textpan = new JPanel();
name= new JTextField(6);
namelabel= new JLabel("Name: ", SwingConstants.CENTER);  
namelabel.setFont(new Font("Serif", Font.PLAIN, 35));
 namelabel.setForeground(new Color(154,205,50)); 
 id= new JTextField(6);
idlabel= new JLabel("Student ID: ", SwingConstants.CENTER);  
idlabel.setFont(new Font("Serif", Font.PLAIN, 35));
idlabel.setForeground(new Color(154,205,50)); 
pass= new JTextField(8);
passlabel= new JLabel("Password: ", SwingConstants.CENTER);         
passlabel.setFont(new Font("Serif", Font.PLAIN, 35));
passlabel.setForeground(new Color(154,205,50)); 
LoginButton= new JButton("Login!");
LoginButton.setFont(new Font("Serif", Font.PLAIN, 20));
LoginButton.setToolTipText("Login your account.");
       
 textpan.add(namelabel);
     textpan.add(name);
     textpan.add(idlabel);
     textpan.add(id);
     textpan.add(passlabel);
     textpan.add(pass);
     textpan.add(LoginButton);
  textpan.setBackground(Color.WHITE);
     
  LoginButton.addActionListener(new maping());
     
      }  //end 0f meth0d
        
   private void buildGreetPan(){
           
 greetpan = new JPanel();
 greetlabel= new JLabel("Welcome back! Login to your account", SwingConstants.CENTER);  
 greetlabel.setFont(new Font("Serif", Font.PLAIN, 60));
 greetpan.add(greetlabel);
 greetpan.setBackground(Color.WHITE);
 greetlabel.setForeground(new Color(240,230,140)); 
      }//end 0f meth0d   
 
  
    public void read() {
        String id1=null;
       
    try{
    Scanner input = new Scanner(new File ("Parkingbook.txt"));

     while (input.hasNext())  
     {
     id1=input.nextLine();
     if (!id1.equals(id.getText())){
     
     }
     
    else {
       JOptionPane.showMessageDialog(null,"WELCOME!");

        setVisible(false);        
        Map  bo=new Map();
          bo.setVisible(true);
      }//end if 
     
     }//end whi1e
    }//end try
     catch(Exception ec)
     
          {
              System.out.println("File not found");
          }
    
    }
 
    //Action for Parkingmap
 private class maping implements ActionListener
 {
 public void actionPerformed(ActionEvent e)
 {
      try {
           read();
           
            if(!(id.getText().length()>0)){JOptionPane.showMessageDialog(null, "Please enter your Student ID");return;}
            if(!(pass.getText().length()>0)){JOptionPane.showMessageDialog(null, "Please enter the Password");return;}           
        
            Savedata();
           
        } catch (Exception ex){}
      
 }
 }
 
 public void Savedata(){
 
    try{
    FileWriter fw = new FileWriter ("Parkingbook.txt");
    fw.write(name.getText()+ "\n"+id.getText()+ "\n");
    fw.close();
    }
catch(Exception ec){System.out.println("File not found");}
 }
   
  
    public static void main(String[] args) {
new login();
    
    }
}


           