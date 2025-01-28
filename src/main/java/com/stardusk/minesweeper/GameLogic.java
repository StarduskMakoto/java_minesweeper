/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.stardusk.minesweeper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 *
 * @author tolis
 */
public final class GameLogic {
    public class ActionManager implements ActionListener{
        
        public GameLogic gl;
        
        public ActionManager(GameLogic gameLogic){
            gl = gameLogic;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            String str_val = e.getActionCommand();
            String[] val_list = str_val.split("-");
            int val_y = Integer.parseInt(val_list[0]);
            int val_x = Integer.parseInt(val_list[1]);
            if(val_y < 0 || val_y >= GUI.MAX_Y || val_x < 0 || val_x >= GUI.MAX_X){
                return;
            }
            System.out.println(val_y + " - " + val_x);
            gl.checkGrid(val_x, val_y);
        }
        
    }
    
    private final ActionManager actionManager;
    
    private int[][] grid = new int[GUI.MAX_Y][GUI.MAX_X];
    
    private GUI gui;
    
    public GUI getGui(){
        return gui;
    }
    
    public void setGui(GUI new_gui){
        gui = new_gui;
    }
    
    public ActionManager getActionManager(){
        return actionManager;
    }
    
    public int[][] getGrid(){
        return grid;
    }
    
    public int getGrid(int id_x, int id_y) throws Exception{
        if (id_y < 0 || id_y >= GUI.MAX_Y || id_x < 0 || id_x >= GUI.MAX_X)
        {
            throw new Exception("INDEX OUT OF RANGE");
        }
        return grid[id_y][id_x];
    }
    
    public void setGrid(int[][] newGrid) throws Exception{
        if (newGrid.length != grid.length)
        {
            throw new Exception("GRIDS ARE NOT THE SAME SIZE");
        }
        grid = newGrid;
    }
    
    public void setGrid(int id_x, int id_y, int value) throws Exception{
        if (id_y < 0 || id_y >= GUI.MAX_Y || id_x < 0 || id_x >= GUI.MAX_X)
        {
            throw new Exception("INDEX OUT OF RANGE");
        }
        else if (value < 0 || value > 10)
        {
            throw new Exception("INAPPROPRIATE VALUE");
        }
        grid[id_y][id_x] = value;
    }
    
    public GameLogic(){
        actionManager = new ActionManager(this);
        generate();
    }
    
    private static final int[][] pairs = {
        {-1, -1}, {-1, 0}, {-1, 1},
        {0, -1}, {0, 0}, {0, 1},
        {1, -1}, {1, 0}, {1, 1}
    };
    
    public void generate(){
        Random rand = new Random();
        for (int[] rows : grid)
        {
            for (int x = 0; x < rows.length; x++)
            {
                int val = rand.nextInt(10);
                if (val == 9)
                {
                    rows[x] = 10;
                }
                else
                    rows[x] = 0;
            }
        }
        
        for (int y = 0; y < grid.length; y++)
        {
            for (int x = 0; x < grid[y].length; x++)
            {
                if (grid[y][x] == 10)
                {
                    continue;
                }
                
                int val = 0;
                
                for (int[] pair : pairs)
                {
                    int r_y = y + pair[0];
                    int r_x = x + pair[1];
                    
                    if (r_y < 0 || r_y >= GUI.MAX_Y || r_x < 0 || r_x >= GUI.MAX_X)
                    {
                        continue;
                    }
                    
                    if (grid[r_y][r_x] == 10)
                    {
                        val += 1;
                    }
                }
                
                grid[y][x] = val;
            }
        }
    }
    
    public void checkGrid(int id_x, int id_y){
        gui.revealButton(id_x, id_y, grid[id_y][id_x]);
    }
}
