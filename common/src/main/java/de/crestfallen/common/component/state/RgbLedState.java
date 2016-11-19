package de.crestfallen.common.component.state;

/**
 * An enum to represent the possible states of a RGB LED.
 * Each state has three boolean flags which define if the respective pins (red, green, blue)
 * need to be turned on or off to achieve a desired color.
 */
public enum RgbLedState {

    RED(true, false, false),
    GREEN(false, true, false),
    BLUE(false, false, true),
    YELLOW(true, true, false),
    MAGENTA(true, false, true),
    CYAN(false, true, true),
    WHITE(true, true, true),
    OFF(false, false, false);

    private boolean redOn;
    private boolean greenOn;
    private boolean blueOn;

    RgbLedState(boolean redOn, boolean greenOn, boolean blueOn) {
        this.redOn = redOn;
        this.greenOn = greenOn;
        this.blueOn = blueOn;
    }

    public boolean isRedOn() {
        return redOn;
    }

    public boolean isGreenOn() {
        return greenOn;
    }

    public boolean isBlueOn() {
        return blueOn;
    }
}