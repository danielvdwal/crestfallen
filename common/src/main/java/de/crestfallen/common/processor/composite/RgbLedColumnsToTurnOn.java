package de.crestfallen.common.processor.composite;

import de.crestfallen.common.component.state.RgbLedState;

/**
 * This class is used to determine which columns of a RGB LED Matrix can be turned on at the same time in a specific state.
 */
public class RgbLedColumnsToTurnOn {

    private RgbLedState stateToSet;
    private boolean[] columnsToTurnOn;

    public RgbLedState getStateToSet() {
        return stateToSet;
    }

    public void setStateToSet(RgbLedState stateToSet) {
        this.stateToSet = stateToSet;
    }

    public boolean[] getColumnsToTurnOn() {
        return columnsToTurnOn;
    }

    public void setColumnsToTurnOn(boolean[] columnsToTurnOn) {
        this.columnsToTurnOn = columnsToTurnOn;
    }
}
