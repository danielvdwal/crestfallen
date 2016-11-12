package de.crestfallen.common.component;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RgbLedTest {

    private RgbLed sut = new RgbLed();

    @Test
    public void testColors() {
        sut.setColor(RgbLed.Color.RED);
        RgbLed.Color color = sut.getColor();
        assertThat(color.isRedOn()).isTrue();
        assertThat(color.isGreenOn()).isFalse();
        assertThat(color.isBlueOn()).isFalse();

        sut.setColor(RgbLed.Color.GREEN);
        color = sut.getColor();
        assertThat(color.isRedOn()).isFalse();
        assertThat(color.isGreenOn()).isTrue();
        assertThat(color.isBlueOn()).isFalse();

        sut.setColor(RgbLed.Color.BLUE);
        color = sut.getColor();
        assertThat(color.isRedOn()).isFalse();
        assertThat(color.isGreenOn()).isFalse();
        assertThat(color.isBlueOn()).isTrue();

        sut.setColor(RgbLed.Color.YELLOW);
        color = sut.getColor();
        assertThat(color.isRedOn()).isTrue();
        assertThat(color.isGreenOn()).isTrue();
        assertThat(color.isBlueOn()).isFalse();

        sut.setColor(RgbLed.Color.MAGENTA);
        color = sut.getColor();
        assertThat(color.isRedOn()).isTrue();
        assertThat(color.isGreenOn()).isFalse();
        assertThat(color.isBlueOn()).isTrue();

        sut.setColor(RgbLed.Color.CYAN);
        color = sut.getColor();
        assertThat(color.isRedOn()).isFalse();
        assertThat(color.isGreenOn()).isTrue();
        assertThat(color.isBlueOn()).isTrue();

        sut.setColor(RgbLed.Color.WHITE);
        color = sut.getColor();
        assertThat(color.isRedOn()).isTrue();
        assertThat(color.isGreenOn()).isTrue();
        assertThat(color.isBlueOn()).isTrue();

        sut.setColor(RgbLed.Color.OFF);
        color = sut.getColor();
        assertThat(color.isRedOn()).isFalse();
        assertThat(color.isGreenOn()).isFalse();
        assertThat(color.isBlueOn()).isFalse();
    }

}