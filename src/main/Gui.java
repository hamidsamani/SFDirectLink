/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import clipboardManager.TxtTransfer;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import logic.MirrorList;

/**
 *
 * @author hamid
 */
public class Gui extends JFrame {
    JButton btn;
    JLabel lbl;
    JTextField txt;
    JComboBox<String> cmb;
    public Gui(){
        this.setLayout(new GridLayout(2, 2, 10, 10));
        lbl = new JLabel("lbl");
        btn = new JButton("btn");
        txt = new JTextField("My name is hamid");
        cmb = new JComboBox<>();
        for (MirrorList mirrors : MirrorList.values()) {
            cmb.addItem(mirrors.toString().toLowerCase());
            
        }
        cmb.addActionListener(new ActionListener() {
            //TODO clear this section of file
            @Override
            public void actionPerformed(ActionEvent e) {
                String txt = cmb.getSelectedItem().toString();
                txt = txt.toUpperCase();
                for (MirrorList mirrors : MirrorList.values()){
                    if (txt.equals(mirrors.toString())){
                        lbl.setText(mirrors.getHost());
                    }
                }
            }
        });
        this.add(cmb);
        this.add(txt);
        this.add(lbl);
        this.add(btn);
        
    }
    public static void main(String[] args) {
        Gui g = new Gui();
        g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        g.setSize(320, 240);
        g.setVisible(true);
    }
    
}
