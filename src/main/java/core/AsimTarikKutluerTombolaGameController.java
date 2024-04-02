/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

import core.AsimTarikKutluerPlayerBoard;
import core.AsimTarikKutluerNumberOnBoard;
import core.AsimTarikKutluerTombolaLinkedList;
import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author Lenovo
 */
public class AsimTarikKutluerTombolaGameController {

    private static final int NODES_PER_ROW = 9;

    Random random = new Random();
    AsimTarikKutluerTombolaLinkedList<AsimTarikKutluerNumberOnBoard> tombolaLinkedList = new AsimTarikKutluerTombolaLinkedList<>();
    AsimTarikKutluerTombolaLinkedList<AsimTarikKutluerPlayerBoard> players = new AsimTarikKutluerTombolaLinkedList<>();

    LinkedList<Integer> usedValues = new LinkedList<>();
    
    int[][] matrix = {
    {5, 19, -1, 35, -1, -1, 64, -1, 80},
    {1, -1, 23, -1, 49, 52, -1, 79, -1},
    {-1, 11, 27, 31, -1, -1, -1, 74, 87}
};

    public void assignRandomValues() {

        for (int i = 0; i < 3; i++) {

            // Generate random values for each row
            for (int j = 0; j < NODES_PER_ROW; j++) {
                int lowerBound = j * 10 + 1;
                int upperBound = lowerBound + 8;

                int value;

                // Attempt to find a unique value within available nodes
                do {
                    value = random.nextInt(upperBound - lowerBound + 1) + lowerBound;

                } while (usedValues.contains(value) || value == 0);

                usedValues.add(value);

            }
            // Change 4 random values from the row to -1
            for (int k = 0; k < 4; k++) {
                int indexToChange;
                do {
                    indexToChange = random.nextInt(NODES_PER_ROW);
                } while (usedValues.get(i * NODES_PER_ROW + indexToChange) == -1); // Make sure not to replace -1
                usedValues.set(i * NODES_PER_ROW + indexToChange, -1);
            }

        }

    }

    public AsimTarikKutluerTombolaLinkedList<AsimTarikKutluerNumberOnBoard> addNonNegativeValuesToTombola() {
        int index = 0;
        for (Integer value : usedValues) {
            if (value != -1) {

                tombolaLinkedList.addToIndex(index, new AsimTarikKutluerNumberOnBoard(value));
                index++;
            }
        }
        return tombolaLinkedList;
    }
    
    
    public AsimTarikKutluerTombolaLinkedList<AsimTarikKutluerNumberOnBoard> addNonNegativeValuesToTombola(int[][] matrix) {
        
        this.matrix=matrix;
        
    int index = 0;
    for (int[] row : matrix) {
        for (int value : row) {
            if (value != -1) {
                tombolaLinkedList.addToIndex(index, new AsimTarikKutluerNumberOnBoard(value));
                index++;
            }
        }
    }
    return tombolaLinkedList;
}

    public void printValues() {
        int index = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < NODES_PER_ROW; j++) {
                if (index < usedValues.size()) {
                    int value = usedValues.get(index++);
                    System.out.print(value + " ");
                } else {
                    System.out.print("0 "); // Assuming missing values are replaced by 0
                }
            }
            System.out.println();
        }
    }

    public void printMatrixWithoutNegatives() {
        for (int i = 0; i < tombolaLinkedList.size(); i++) {
            System.out.print(tombolaLinkedList.getFromChild(i) + ", ");
        }
    }

    public AsimTarikKutluerTombolaLinkedList<AsimTarikKutluerPlayerBoard> createPlayers(int numberOfPlayers) {

        // Generate PlayerBoard objects for each player
        for (int i = 1; i <= numberOfPlayers; i++) {
            String playerName = "Player " + i; // Example player name
            // Create a new TombolaLinkedList for each player (assuming you have a method to create this)
            AsimTarikKutluerTombolaLinkedList<AsimTarikKutluerNumberOnBoard> numbers = createNewNumbers(); // You need to implement this method
            AsimTarikKutluerPlayerBoard player = new AsimTarikKutluerPlayerBoard(i, playerName, numbers);
            players.addLast(player);
        }

        return players;
    }

    public AsimTarikKutluerTombolaLinkedList<AsimTarikKutluerNumberOnBoard> createNewNumbers() {
        AsimTarikKutluerTombolaGameController tombolaGameController = new AsimTarikKutluerTombolaGameController();
        tombolaGameController.assignRandomValues();

        return tombolaGameController.addNonNegativeValuesToTombola();

    }
}
