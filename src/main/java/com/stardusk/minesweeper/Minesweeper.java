/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.stardusk.minesweeper;

/**
 *
 * @author tolis
 */
public class Minesweeper {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        GameLogic game = new GameLogic();
        
        GUI gui = new GUI();
        
        gui.setActionManager(game.getActionManager());
        
    }
}
