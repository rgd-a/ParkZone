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
import java.io.FileWriter;
public class CreateAccount extends JFrame{
    
 //Declear comppnents 
    private JPanel Panel= new JPanel();
    private JPanel Panel2= new JPanel();
    private JButton CreatButton; // To reference a button              
    private JPanel greetpan;
    private JLabel greetlabel;
    private JPanel textpan;
    private JTextField name;
    private JLabel namelabel;    
    private JTextField id;
    private JLabel idlabel;    
    private JTextField pass;
    private JLabel passlabel;   
    private ImageIcon   image = new ImageIcon("C:\\Users\\lenovo\\OneDrive\\المستندات\\لقطات الشاشة\\ghina.png");
    private JLabel imageLabell = new JLabel (image);
    private ImageIcon   image3= new ImageIcon("C:\\Users\\lenovo\\Desktop\\wish.gif" );
    private JLabel imageLabel3 = new JLabel (image3);   
    public String id2;
     // End of variables declaration  

    //consrctor
   public CreateAccount(){
     //set a Title for window   
   setTitle("ParkZone");
     //Specify what happens when the close button is clicked.
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     //set a layout for the window
   setLayout(new GridLayout(2,3)); 

   //set size for window
   setSize(1300,800);

//call methods
    buildGreetPan();   
    buildTextPan();  
   
    //set two panel for window
   Panel.setBackground(Color.WHITE);
   add(Panel);
   Panel2.setBackground(Color.WHITE);
   add(Panel2,BorderLayout.SOUTH); 
   Panel. add(imageLabell, BorderLayout.EAST);
  //add each componet in the appropriate panel 
   Panel. add(greetpan, BorderLayout.SOUTH);
   Panel. add(textpan, BorderLayout.CENTER); 
   //add each componet in the appropriate panel 
   Panel2. add(imageLabel3 );
      
 //methods to set size images
 image.setImage(image.getImage().getScaledInstance(500, 100, Image.SCALE_DEFAULT));
 image3.setImage(image3.getImage().getScaledInstance(700, 370, Image.SCALE_DEFAULT));

   String id2 =(String) id.getText();
//display window
    setVisible(true);   
    
 }//end 0f c0nstruct0r

   //build panel methoed
  private void  buildTextPan(){
      
       textpan = new JPanel();
       name= new JTextField(10);
       namelabel= new JLabel("First Name: ", SwingConstants.CENTER);  
       namelabel.setFont(new Font("Serif", Font.PLAIN, 35));
       namelabel.setForeground(new Color(0,128,128));
       id= new JTextField(6);
       idlabel= new JLabel("Student ID: ", SwingConstants.CENTER);  
       idlabel.setFont(new Font("Serif", Font.PLAIN, 35));
        idlabel.setForeground(new Color(0,128,128));
        pass= new JTextField(8);
        passlabel= new JLabel("Password: ", SwingConstants.CENTER);         
        passlabel.setFont(new Font("Serif", Font.PLAIN, 35));
        passlabel.setForeground(new Color(0,128,128));
        CreatButton= new JButton("Create!");
        CreatButton.setFont(new Font("Serif", Font.PLAIN, 20));
        CreatButton.setToolTipText("Create your account");
        CreatButton.addActionListener(new logins()); 
      
        textpan.add(namelabel);
        textpan.add(name);
        textpan.add(idlabel);
        textpan.add(id);
        textpan.add(passlabel);
        textpan.add(pass);
        textpan.add(CreatButton);
        textpan.setBackground(Color.WHITE);
  
      }  //end 0f meth0d
        
   private void buildGreetPan(){
           
 greetpan = new JPanel();
 greetlabel= new JLabel("                 Create new account               ");  
 greetlabel.setFont(new Font("Serif", Font.PLAIN, 60));
 greetpan.add(greetlabel);
 greetpan.setBackground(Color.WHITE);
 greetlabel.setForeground(new Color(240,230,140)); 
      }//end 0f meth0d   
   
     
//do action Performed to conceted the other windows to the buttons
private class logins implements ActionListener
 {
 public void actionPerformed(ActionEvent e)
 {
 String name1 = name.getText();
 Boolean valid = true;
                 try {
                         
 if((id.getText().length() !=7 )){JOptionPane.showMessageDialog(null, "Please enter your Student ID And Composed of 7 Number Just");return;}
 // if((name.getText().length()< 0)){JOptionPane.showMessageDialog(null, "Please enter your Username And Composed of 15 Characters or More");return;}
if((pass.getText().length()<8)){JOptionPane.showMessageDialog(null, "Please enter your Passowrd And Composed of 8 Characters or More");return;}                   
 
              { 
   JOptionPane.showMessageDialog(null,"The Account Was Successfully Created");
  
   Savedata();
 }
    setVisible(false);
    login Create = new login(); 
                     }
  catch (Exception ex){}  }

   
  public void Savedata(){

    try{
    FileWriter fw = new FileWriter ("Data.txt",true);
    fw.write(id.getText()+"\n");
    fw.close();
    }
catch(Exception ec){System.out.println("File not found");}
 }                    
}        
    public static void main(String[] args) {
       new CreateAccount(); 
    }

}
 