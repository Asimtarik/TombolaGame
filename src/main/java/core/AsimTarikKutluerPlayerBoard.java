/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

import core.AsimTarikKutluerNumberOnBoard;
import core.AsimTarikKutluerTombolaLinkedList;

/**
 *
 * @author Lenovo
 */
public class AsimTarikKutluerPlayerBoard {
    
    public int id;
    public String name;
    public AsimTarikKutluerTombolaLinkedList<AsimTarikKutluerNumberOnBoard> numbers;
    public int tombolacount = 0;
    
    
    
    public AsimTarikKutluerPlayerBoard(int id, String name, AsimTarikKutluerTombolaLinkedList<AsimTarikKutluerNumberOnBoard> numbers ){
        this.id=id;
        this.name=name;
        this.numbers=numbers;
    }
    
    

    
}
