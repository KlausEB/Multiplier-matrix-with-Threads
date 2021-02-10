package hw;

import java.util.concurrent.atomic.AtomicInteger;

public class MultiplierMatrix {
    final private int[][] matrixFirst;
    final private int[][] matrixSecond;
    private final int[][] multipliedMatrix;
    private final AtomicInteger position = new AtomicInteger(0);

    public MultiplierMatrix(int[][] matrixFirst, int[][] matrixSecond) {
        if((matrixCheck(matrixFirst, matrixSecond.length))) {
            throw new IllegalArgumentException("Некорректно заданы матрицы");
        }
        this.matrixFirst = matrixFirst;
        this.matrixSecond = matrixSecond;
        this.multipliedMatrix = new int[matrixFirst.length][matrixSecond[0].length];
    }

    public void multiplyMatrix(){
        int currentPosition;
        while ((currentPosition = position.getAndIncrement()) < (matrixFirst.length * matrixSecond[0].length)){
            for (int k = 0; k < matrixFirst[0].length; k++) {
                multipliedMatrix [currentPosition / multipliedMatrix[0].length][currentPosition % multipliedMatrix[0].length] += matrixFirst[currentPosition/multipliedMatrix[0].length][k] * matrixSecond[k][currentPosition % multipliedMatrix[0].length];
            }
        }
    }

    public void printMultipliedMatrix(){
        for (int[] stringElements : multipliedMatrix) {
            for (int element : stringElements) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    boolean matrixCheck(int[][] matrix, int length){
        for (int[] elements : matrix) {
            if (elements.length != length){
                return true;
            }
        }
        return false;
    }
}
