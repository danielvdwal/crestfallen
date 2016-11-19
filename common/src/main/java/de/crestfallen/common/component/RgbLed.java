package de.crestfallen.common.component;

import de.crestfallen.common.component.state.RgbLedState;

/**
 * This class represents a RGB LED with four pins.
 */
public class RgbLed {

    private RgbLedState state;

    public RgbLedState getState() {
        return state;
    }

    public void setState(RgbLedState state) {
        this.state = state;
    }
}
