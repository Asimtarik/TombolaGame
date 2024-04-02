/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

import core.AsimTarikKutluerNode;

/**
 *
 * @author Lenovo
 */
public class AsimTarikKutluerTombolaLinkedList<T> {

    public AsimTarikKutluerNode<T> head;
    private int size;

    public int size() {
        return size;
    }

public void addFirst(T data) {
        AsimTarikKutluerNode<T> newNode = new AsimTarikKutluerNode<>(data);
        if (size == 0) {
            head = newNode;
            size++;
        } else {
            newNode.next = head;
            head = newNode;
            size++;
        }
    }

    public void addLast(T data) {

        AsimTarikKutluerNode<T> newNode = new AsimTarikKutluerNode<>(data);
        if (size == 0) {
            head = newNode;
            size++;
            return;
        }

        AsimTarikKutluerNode<T> tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }

        tmp.next = newNode;
        
        size++;
    }

public void addToIndex(int index, T data) {
        
        AsimTarikKutluerNode<T> newNode = new AsimTarikKutluerNode<>(data);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
            size++;
            return;
        }
        
        AsimTarikKutluerNode<T> temp = head;
        AsimTarikKutluerNode<T> prev = null;
        
        int currentIndex = 0;
        while (temp != null && currentIndex != index) {
            prev = temp;
            
            if (currentIndex % 5 == 4) {
                temp = temp.child;
            }else{
                temp = temp.next;
            }
            currentIndex++;
        }
        
        if (index % 5 == 0) {
            prev.child = newNode;
            newNode.next = temp;
            //System.out.println("Added to the child");
        }else{
            prev.next = newNode;
            newNode.next = temp;
            //System.out.println("Added to the next");
        }
        
        size++;

    }
    
    public T get(int index) {

        if (index >= size || index < 0) {
            System.out.println("Size: " + size + ", given index: " + index);
            throw new IndexOutOfBoundsException();
            //return null;
        }

        AsimTarikKutluerNode<T> tmp = head;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }

        return tmp.data;
    }
    
    public T getFromChild(int index){
        AsimTarikKutluerNode<T> temp = head;

        int currentIndex = 0; 
        while (currentIndex != index) {
            
            if (currentIndex % 5 == 4) {
                temp = temp.child;
            }else{
                temp = temp.next;
            }
            currentIndex++;
        }
         if (temp == null) {
        throw new IndexOutOfBoundsException("Index out of bounds: " + index);
    }
        
        return temp.data;
    }
    

public void removeWithData(T data) {
        AsimTarikKutluerNode<T> temp = head;
        AsimTarikKutluerNode<T> prev = null;
        while (temp != null) {
            if (temp.data == data) {
                if (temp == head) {
                    head = head.next;
                } else if (prev != null && prev.next == null) {
                    prev.child = temp.next;
                } else if (prev != null && prev.child == null) {
                    prev.next = temp.next;
                }
                size--;
            }
            prev = temp;
            temp = (temp.next == null && temp.child != null) ? temp.child : temp.next;
        }

    }

    public void print() {
        if (size == 0) {
            return;
        }

        AsimTarikKutluerNode<T> tmp = head;
        while (tmp.next != null) {
            System.out.print(tmp.data.toString() + ", ");

            tmp = tmp.next;
        }

        System.out.println(tmp.data.toString());
    }
}