/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package signupandlogin;


/**
 *
 * @author RC_Student_lab
 */
public class Signupandlogin {
public static String username;
public static String password;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Login LoginFrame = new Login();
       LoginFrame.setVisible(true);
       LoginFrame.pack();
       LoginFrame.setLocationRelativeTo(null);
    }
    
}
