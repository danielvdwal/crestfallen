package de.crestfallen.common.processor.composite;

import de.crestfallen.common.component.RgbLed;
import de.crestfallen.common.component.state.RgbLedState;

/**
 * This class is used to process a RGB LED Matrix.
 * Processing in this case means to determine which RGB LEDs in the matrix can be turned on at the same time.
 */
public class RgbLedMatrixProcessor {

    private final RgbLedColumnsToTurnOn rgbLedColumnsToTurnOn = new RgbLedColumnsToTurnOn();

    RgbLedColumnsToTurnOn getColumnsToTurnOn(RgbLed[] matrixRow, RgbLedState stateToBeProcessed) {
        rgbLedColumnsToTurnOn.setStateToSet(stateToBeProcessed);
        boolean[] columnsToTurnOn = new boolean[matrixRow.length];
        for (int y = 0; y < matrixRow.length; y++) {
            if (matrixRow[y].getState().equals(stateToBeProcessed)) {
                columnsToTurnOn[y] = true;
                matrixRow[y].setState(RgbLedState.OFF);
            } else {
                columnsToTurnOn[y] = false;
            }
        }

        rgbLedColumnsToTurnOn.setColumnsToTurnOn(columnsToTurnOn);

        return rgbLedColumnsToTurnOn;
    }

    boolean hasRowBeenProcessed(RgbLed[] matrixRow) {
        return getFirstUnprocessedStateForRow(matrixRow).equals(RgbLedState.OFF);
    }

    RgbLedState getFirstUnprocessedStateForRow(RgbLed[] matrixRow) {
        for (int x = 0; x < matrixRow.length; x++) {
            RgbLedState state = matrixRow[x].getState();
            if (!state.equals(RgbLedState.OFF)) {
                return state;
            }
        }
        return RgbLedState.OFF;
    }
}
