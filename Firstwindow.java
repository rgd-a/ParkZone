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

//call imports
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Firstwindow extends JFrame {

    //Declear comppnents
     private JPanel Panel= new JPanel();
     private JPanel Panel2= new JPanel();
     private JPanel greetpan;
     private JLabel greetlabel;
     private JLabel greetlabe2;
     private JLabel sigin;
     private JButton LoginButton;
     private JLabel creat;
     private JButton creatButton;  
     private ImageIcon   image = new ImageIcon("C:\\Users\\lenovo\\OneDrive\\المستندات\\لقطات الشاشة\\ghina.png");
     private JLabel imageLabell = new JLabel (image);
     private ImageIcon   image2 = new ImageIcon("C:\\Users\\lenovo\\OneDrive\\المستندات\\لقطات الشاشة\\جدة.jpg");
     private JLabel imageLabel2 = new JLabel (image2);
     private ImageIcon   image3= new ImageIcon("C:\\Users\\lenovo\\Desktop\\city.gif" );
     private JLabel imageLabel3 = new JLabel (image3);
  // End of variables declaration  
      
    //consrctor
     public Firstwindow()
             
     {
    //program title name
      setTitle("ParkZone");
      //Specify what happens when the close button is clicked.
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //set a layout for the window
      setLayout(new GridLayout(2,3)); 
    //set size for window
      setSize(1300,800);

//call for each method
buildGreetPan(); 
bulidsiginlabel();
    
 //add panel to consrector
add(Panel);
 //set background color for panel
Panel.setBackground(Color.WHITE);
 //set back ground color for panel2
Panel2.setBackground(Color.WHITE);
   //set layout for panel2
add(Panel2,BorderLayout.SOUTH); 
//add each componet in the appropriate panel 
 Panel.add(imageLabell);
 Panel. add(imageLabel2);
 Panel. add(greetpan);
 Panel. add(sigin);
 Panel. add(LoginButton);
 Panel. add(creat);
 Panel. add(creatButton);
 //add each componet in the appropriate panel2
Panel2. add(imageLabel3);

//method to set size for each image
   image.setImage(image.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT));
   image2.setImage(image2.getImage().getScaledInstance(200, 100, Image.SCALE_DEFAULT));
   image3.setImage(image3.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT));    
  //display window 
 setVisible(true);  
     }
     
     //method bulid greet
    private void buildGreetPan(){
           
greetpan = new JPanel();
greetlabel= new JLabel("                   Welcome to parking booking system              "); 
         
         //set for text and background Color & size 
greetlabel.setFont(new Font("Serif", Font.PLAIN, 60));
greetpan.add(greetlabel);
greetpan.setBackground(Color.WHITE);
greetlabel.setForeground(new Color(240,230,140));
       
      }//end 0f meth0d   
 
    
    //method
     private void bulidsiginlabel(){
    
     
 sigin = new JLabel(" Login ");
LoginButton = new JButton("Login");
//set for text and background Color & size  
 sigin.setForeground(new Color(0,128,128));
 sigin.setFont(new Font("Serif", Font.PLAIN, 30));
 LoginButton.setFont(new Font("Serif", Font.PLAIN, 20));
 //set help messege 
 LoginButton.setToolTipText("Login your account.");
 
 creat = new JLabel("      Create new account ");
 creatButton = new JButton("Create");
 //set for text and background Color & size  
 creat.setForeground(new Color(0,128,128));
 creat.setFont(new Font("Serif", Font.PLAIN, 30));
 creatButton.setFont(new Font("Serif", Font.PLAIN, 20));
  //set help messege 
 creatButton.setToolTipText("Create your account.");

     
     //Add action lisner methed to each button
 creatButton.addActionListener(new Account()); 
 LoginButton.addActionListener(new Login());
  
     
     }//End of method
     
     
//do action Performed to conceted the other windows to the buttons
  private class Account implements ActionListener
  {
         public void actionPerformed(ActionEvent e)      
 {

 if (e.getSource() ==(creatButton))
 {
     setVisible(false);
     CreateAccount Create = new CreateAccount();

}}}
            
  private class Login implements ActionListener
{
         public void actionPerformed(ActionEvent e)      
 {
 
 if (e.getSource() ==(LoginButton))
{
    
    setVisible(false);
    //Set visuble to next window
  login Login = new login();
     
 }}}
     
  
  
  
     public static void main(String[] args) {
        new Firstwindow(); //call of class name
  

}


}//End of class