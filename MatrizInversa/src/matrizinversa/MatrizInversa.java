/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrizinversa;

import javax.swing.JFrame;

/**
 *
 * @author marco
 */
public class MatrizInversa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        matriz m = new matriz();
        m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        m.setVisible(true);
        m.setSize(1000,600);
        m.setLocationRelativeTo(null);
        
    }
    
}
