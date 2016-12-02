package de.crestfallen.common.processor.composite;

import de.crestfallen.common.component.RgbLed;
import de.crestfallen.common.component.composite.RgbLedMatrix;
import de.crestfallen.common.component.state.RgbLedState;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RgbLedMatrixProcessorTest {

    private RgbLedMatrixProcessor sut = new RgbLedMatrixProcessor();

    @Test
    public void testRowHasBeenProcessed() {
        RgbLed[] row = new RgbLed[3];
        row[0] = new RgbLed();
        row[0].setState(RgbLedState.OFF);
        row[1] = new RgbLed();
        row[1].setState(RgbLedState.OFF);
        row[2] = new RgbLed();
        row[2].setState(RgbLedState.OFF);

        assertThat(sut.hasRowBeenProcessed(row)).isTrue();
    }

    @Test
    public void testRowHasBeenNotProcessed() {
        RgbLed[] row = new RgbLed[3];
        row[0] = new RgbLed();
        row[0].setState(RgbLedState.OFF);
        row[1] = new RgbLed();
        row[1].setState(RgbLedState.RED);
        row[2] = new RgbLed();
        row[2].setState(RgbLedState.OFF);

        assertThat(sut.hasRowBeenProcessed(row)).isFalse();
    }

    @Test
    public void testFirstUnprocessedStateIsNotOff() {
        RgbLed[] row = new RgbLed[3];
        row[0] = new RgbLed();
        row[0].setState(RgbLedState.OFF);
        row[1] = new RgbLed();
        row[1].setState(RgbLedState.OFF);
        row[2] = new RgbLed();
        row[2].setState(RgbLedState.RED);

        RgbLedState state = sut.getFirstUnprocessedStateForRow(row);
        assertThat(state).isEqualTo(RgbLedState.RED);
    }

    @Test
    public void testFirstUnprocessedStateIsOff() {
        RgbLed[] row = new RgbLed[3];
        row[0] = new RgbLed();
        row[0].setState(RgbLedState.OFF);
        row[1] = new RgbLed();
        row[1].setState(RgbLedState.OFF);
        row[2] = new RgbLed();
        row[2].setState(RgbLedState.OFF);

        RgbLedState state = sut.getFirstUnprocessedStateForRow(row);
        assertThat(state).isEqualTo(RgbLedState.OFF);
    }

    @Test
    public void testGetColumnsToTurnOn() {
        RgbLed[] row = new RgbLed[5];
        row[0] = new RgbLed();
        row[0].setState(RgbLedState.OFF);
        row[1] = new RgbLed();
        row[1].setState(RgbLedState.RED);
        row[2] = new RgbLed();
        row[2].setState(RgbLedState.BLUE);
        row[3] = new RgbLed();
        row[3].setState(RgbLedState.RED);
        row[4] = new RgbLed();
        row[4].setState(RgbLedState.MAGENTA);

        boolean[] expected = new boolean[]{false, true, false, true, false};
        RgbLedColumnsToTurnOn result = sut.getColumnsToTurnOn(row, RgbLedState.RED);

        assertThat(result.getStateToSet()).isEqualTo(RgbLedState.RED);
        assertThat(result.getColumnsToTurnOn()).isEqualTo(expected);

        assertThat(row[0].getState()).isEqualTo(RgbLedState.OFF);
        assertThat(row[1].getState()).isEqualTo(RgbLedState.OFF);
        assertThat(row[2].getState()).isEqualTo(RgbLedState.BLUE);
        assertThat(row[3].getState()).isEqualTo(RgbLedState.OFF);
        assertThat(row[4].getState()).isEqualTo(RgbLedState.MAGENTA);
    }

    @Test
    public void testCopy() {
        RgbLedMatrix matrix = new RgbLedMatrix(2, 3);
        matrix.getRgbLedAt(0, 0).setState(RgbLedState.RED);
        matrix.getRgbLedAt(0, 1).setState(RgbLedState.BLUE);
        matrix.getRgbLedAt(0, 2).setState(RgbLedState.OFF);
        matrix.getRgbLedAt(1, 0).setState(RgbLedState.YELLOW);
        matrix.getRgbLedAt(1, 1).setState(RgbLedState.RED);
        matrix.getRgbLedAt(1, 2).setState(RgbLedState.GREEN);

        RgbLed[][] result = sut.copy(matrix);

        assertThat(result.length).isEqualTo(2);
        assertThat(result[0].length).isEqualTo(3);
        assertThat(result[1].length).isEqualTo(3);

        assertThat(result[0][0].getState()).isEqualTo(RgbLedState.RED);
        assertThat(result[0][1].getState()).isEqualTo(RgbLedState.BLUE);
        assertThat(result[0][2].getState()).isEqualTo(RgbLedState.OFF);
        assertThat(result[1][0].getState()).isEqualTo(RgbLedState.YELLOW);
        assertThat(result[1][1].getState()).isEqualTo(RgbLedState.RED);
        assertThat(result[1][2].getState()).isEqualTo(RgbLedState.GREEN);
    }
}