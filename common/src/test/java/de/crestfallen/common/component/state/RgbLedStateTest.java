package de.crestfallen.common.component.state;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RgbLedStateTest {

    @Test
    public void testStates() {
        RgbLedState state = RgbLedState.RED;
        assertThat(state.isRedOn()).isTrue();
        assertThat(state.isGreenOn()).isFalse();
        assertThat(state.isBlueOn()).isFalse();

        state = RgbLedState.GREEN;
        assertThat(state.isRedOn()).isFalse();
        assertThat(state.isGreenOn()).isTrue();
        assertThat(state.isBlueOn()).isFalse();

        state = RgbLedState.BLUE;
        assertThat(state.isRedOn()).isFalse();
        assertThat(state.isGreenOn()).isFalse();
        assertThat(state.isBlueOn()).isTrue();

        state = RgbLedState.YELLOW;
        assertThat(state.isRedOn()).isTrue();
        assertThat(state.isGreenOn()).isTrue();
        assertThat(state.isBlueOn()).isFalse();

        state = RgbLedState.MAGENTA;
        assertThat(state.isRedOn()).isTrue();
        assertThat(state.isGreenOn()).isFalse();
        assertThat(state.isBlueOn()).isTrue();

        state = RgbLedState.CYAN;
        assertThat(state.isRedOn()).isFalse();
        assertThat(state.isGreenOn()).isTrue();
        assertThat(state.isBlueOn()).isTrue();

        state = RgbLedState.WHITE;
        assertThat(state.isRedOn()).isTrue();
        assertThat(state.isGreenOn()).isTrue();
        assertThat(state.isBlueOn()).isTrue();

        state = RgbLedState.OFF;
        assertThat(state.isRedOn()).isFalse();
        assertThat(state.isGreenOn()).isFalse();
        assertThat(state.isBlueOn()).isFalse();
    }

}