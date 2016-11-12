package de.crestfallen.common.component;

/**
 * This class represents a RGB LED with four pins.
 */
public class RgbLed {

    private RgbLed.Color color;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * An enum to represent the possible color states of a RGB LED.
     * Each color has three boolean flags which define if the respective pins (red, green, blue)
     * need to be turned on or off to achieve that color.
     */
    public enum Color {

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

        Color(boolean redOn, boolean greenOn, boolean blueOn) {
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
}
