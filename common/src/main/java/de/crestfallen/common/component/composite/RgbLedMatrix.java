package de.crestfallen.common.component.composite;

import de.crestfallen.common.component.RgbLed;

/**
 * This class represents a number of RGB LEDs connected in a matrix.
 */
public class RgbLedMatrix {

    private final int nrOfRows;
    private final int nrOfCols;
    private final RgbLed[][] matrix;

    public RgbLedMatrix(int nrOfRows, int nrOfCols) {
        this.nrOfRows = nrOfRows;
        this.nrOfCols = nrOfCols;
        this.matrix = new RgbLed[nrOfRows][nrOfCols];
        for (int x = 0; x < nrOfRows; x++) {
            for (int y = 0; y < nrOfCols; y++) {
                matrix[x][y] = new RgbLed();
            }
        }
    }

    public int getNrOfRows() {
        return nrOfRows;
    }

    public int getNrOfCols() {
        return nrOfCols;
    }

    public RgbLed getRgbLedAt(int row, int col) {
        return matrix[row][col];
    }

    public RgbLed[] getRowAt(int row) {
        return matrix[row];
    }
}
