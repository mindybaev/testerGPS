package testerGPS;

import javax.swing.*;
import java.awt.*;

public class Layout extends JFrame{
    public Layout (String title)
{
    super(title);
    this.setSize(700, 300);
    this.setLocation(100,100);      
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   

}public static void main(String[] args) {
  Layout mLayout = new Layout("Test");
  mLayout.setVisible(true);  
    
}
}
