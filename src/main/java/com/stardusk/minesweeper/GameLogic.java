/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.stardusk.minesweeper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author tolis
 */
public class GameLogic {
    public class ActionManager implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int val = Integer.parseInt(e.getActionCommand());
            if(val < 0 || val >= 25){
                return;
            }
            System.out.println(val);
        }
        
    }
    
    private final ActionManager actionManager;
    
    private int[] grid;
    
    public ActionManager getActionManager(){
        return actionManager;
    }
    
    public int[] getGrid(){
        return grid;
    }
    
    public int getGrid(int index) throws Exception{
        if (index < 0 || index >= 25)
        {
            throw new Exception("INDEX OUT OF RANGE");
        }
        return grid[index];
    }
    
    public void setGrid(int[] newGrid) throws Exception{
        if (newGrid.length != grid.length)
        {
            throw new Exception("GRIDS ARE NOT THE SAME SIZE");
        }
        grid = newGrid;
    }
    
    public void setGrid(int index, int value) throws Exception{
        if (index < 0 || index >= 25)
        {
            throw new Exception("INDEX OUT OF RANGE");
        }
        else if (value < 0 || value > 9)
        {
            throw new Exception("INAPPROPRIATE VALUE");
        }
        grid[index] = value;
    }
    
    public GameLogic(){
        actionManager = new ActionManager();
        grid = new int[25];
        
    }
}
