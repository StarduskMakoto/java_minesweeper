/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.stardusk.minesweeper;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author tolis
 */
public class GUI {
    
    public static final int MAX_X = 10;
    public static final int MAX_Y = 10;
    
    private JFrame frame;
    
    private JButton[][] buttons = new JButton[MAX_Y][MAX_X];
    
    private ActionListener actionManager;
    
    public JFrame getFrame(){
        return frame;
    }
    
    public void setFrame(JFrame newFrame){
        frame = newFrame;
    }
    
    public JButton[][] getButtons(){
        return buttons;
    }
    
    public void setButtons(JButton newButton, int id_x, int id_y) throws Exception{
        if (id_y < 0 || id_y >= buttons.length || id_x < 0 || id_x >= buttons[0].length)
        {
            throw new Exception("INDEX NOT IN RANGE");
        }
        buttons[id_y][id_x] = newButton;
    }
    
    public void setButtons(JButton[][] newButtons) throws Exception{
        if (newButtons.length != buttons.length)
        {
            throw new Exception("ARRAYS NOT SAME SIZE");
        }
        buttons = newButtons;
    }
    
    public void updateButtons(){
        for (int y = 0; y < buttons.length; y++) {
            for (int x = 0; x < buttons[y].length; x++)
            {
                buttons[y][x].setActionCommand(Integer.toString(y) + "-" + Integer.toString(x));
                buttons[y][x].addActionListener(actionManager);
            }
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
        
        frame.setMinimumSize(new Dimension(480, 480));
        
        JPanel rootpanel = new JPanel();
        rootpanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        rootpanel.setLayout(new BorderLayout());
        
        JLabel label = new JLabel("Minesweaper");
        label.setHorizontalAlignment(JLabel.CENTER);
        rootpanel.add(label, BorderLayout.PAGE_START);
        
        JPanel gridpanel = new JPanel();
        gridpanel.setLayout(new GridLayout(MAX_Y, MAX_X));
        gridpanel.setMinimumSize(new Dimension(40 * MAX_Y, 40 * MAX_X));
        
        for (JButton[] button : buttons) {
            for (int x = 0; x < button.length; x++) {
                URL url = getClass().getClassLoader().getResource("Minesweeper_slot.png");
                ImageIcon icon = new ImageIcon(url);
                Image n_img = icon.getImage();
                n_img = n_img.getScaledInstance(40, 40, Image.SCALE_FAST);
                icon.setImage(n_img);
                button[x] = new JButton(icon);
                button[x].setOpaque(false);
                button[x].setContentAreaFilled(false);
                button[x].setBorderPainted(false);
                //Integer.toString(new ImageIcon("assets/Minesweeper_slot.png").getIconHeight())
                gridpanel.add(button[x]);
            }
        }
        rootpanel.add(gridpanel, BorderLayout.CENTER);
        
        frame.add(rootpanel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        
        frame.setSize(480, 480);
        
        frame.setVisible(true);
    }
    
    private static final String[] sprites = {
        "Empty_slot.png",
        "num1.png",
        "num2.png",
        "num3.png",
        "num4.png",
        "num5.png",
        "num6.png",
        "num7.png",
        "num8.png",
        "num9.png",
        "mine.png"
    };
    
    public void revealButton(int id_x, int id_y, int val){
        URL url = getClass().getClassLoader().getResource(sprites[val]);
        ImageIcon icon = new ImageIcon(url);
        Image n_img = icon.getImage();
        n_img = n_img.getScaledInstance(40, 40, Image.SCALE_FAST);
        icon.setImage(n_img);
        buttons[id_y][id_x].setIcon(icon);
    }
}
