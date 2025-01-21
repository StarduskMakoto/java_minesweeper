/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.stardusk.minesweeper;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author tolis
 */
public class GUI {
    
    private JFrame frame;
    
    private JButton[] buttons = new JButton[25];
    
    private ActionListener actionManager;
    
    public JFrame getFrame(){
        return frame;
    }
    
    public void setFrame(JFrame newFrame){
        frame = newFrame;
    }
    
    public JButton[] getButtons(){
        return buttons;
    }
    
    public void setButtons(JButton newButton, int index) throws Exception{
        if (index < 0 || index >= buttons.length)
        {
            throw new Exception("INDEX NOT IN RANGE");
        }
        buttons[index] = newButton;
    }
    
    public void setButtons(JButton[] newButtons) throws Exception{
        if (newButtons.length != buttons.length)
        {
            throw new Exception("ARRAYS NOT SAME SIZE");
        }
        buttons = newButtons;
    }
    
    public void updateButtons(){
        for (int i = 0; i < buttons.length; i++)
        {
            buttons[i].setActionCommand(Integer.toString(i));
            buttons[i].addActionListener(actionManager);
        }
    }
    
    public ActionListener getActionManager(){
        return actionManager;
    }
    
    public void setActionManager(ActionListener newManager){
        actionManager = newManager;
        updateButtons();
    }
    
    public GUI() {
        frame = new JFrame("Frame Test");
        
        JPanel rootpanel = new JPanel();
        rootpanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        rootpanel.setLayout(new BorderLayout());
        
        JLabel label = new JLabel("Minesweaper");
        label.setHorizontalAlignment(JLabel.CENTER);
        rootpanel.add(label, BorderLayout.PAGE_START);
        
        JPanel gridpanel = new JPanel();
        gridpanel.setLayout(new GridLayout(5, 5));
        
        for (int i = 0; i < 25; i++){
            buttons[i] = new JButton(Integer.toString(i + 1));
            gridpanel.add(buttons[i]);
        }
        rootpanel.add(gridpanel, BorderLayout.CENTER);
        
        frame.add(rootpanel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    
    
}
