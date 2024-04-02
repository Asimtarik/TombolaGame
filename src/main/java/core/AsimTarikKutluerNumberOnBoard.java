/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

/**
 *
 * @author Lenovo
 */
public class AsimTarikKutluerNumberOnBoard {
    private int number;
    private boolean check;

    public AsimTarikKutluerNumberOnBoard(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public boolean isChecked() {
        return check;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    
    public void setChecked(boolean check) {
        this.check = check;
    }

    @Override
    public String toString() {
        return number + "";
    }

    

    
    
    
}
