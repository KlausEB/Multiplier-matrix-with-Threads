package hw;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        int[][] matrix1 =  {{1, 2, 3},
                            {4, 5, 6},
                            {7, 8, 9}};

        int[][] matrix2 =  {{1,2},
                            {3,4},
                            {5,6}};

        final MultiplierMatrix multiplierMatrix = new MultiplierMatrix(matrix1,matrix2);

        int numberOfThreads = Character.getNumericValue(System.in.read());

        for (int i = 0; i < numberOfThreads; i++) {
            new Thread(){
                @Override
                public void run() {
                    multiplierMatrix.multiplyMatrix();
                }
            }.start();
        }
        multiplierMatrix.printMultipliedMatrix();
    }
}
