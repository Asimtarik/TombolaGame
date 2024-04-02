/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

/**
 *
 * @author Lenovo
 */
public class AsimTarikKutluerNode<T> {
    
    public T data;
    public AsimTarikKutluerNode<T> next;
    public AsimTarikKutluerNode<T> child;

    public AsimTarikKutluerNode(T data) {
        this.data = data;
    }
}
