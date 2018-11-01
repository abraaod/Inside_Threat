/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author henriquedavid
 */
public class UI implements ActionListener{
    
    JFrame frame;
    private JButton botaoFile;
    
    public void janela(){
        frame = new JFrame();
        botaoFile = new JButton();
        botaoFile.addActionListener(this);
        botaoFile.setText("Abrir arquivos");
        botaoFile.setSize(100, 20);
        botaoFile.setFont(new Font("SansSerif", Font.BOLD, 10));
        
        frame.add(botaoFile);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        OpenFiles of = new OpenFiles();
        try {
            of.getFiles();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
    
    public static void main(String[] args) {
        UI tela = new UI();
        tela.janela();
    }
            
}
