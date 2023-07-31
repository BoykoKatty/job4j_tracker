package ru.job4j.ex;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FactTest {
    @Test
    public void whenCountException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Fact().calc(-1));
        assertThat(exception.getMessage()).isEqualTo("N could not be less than 0.");
    }

    @Test
    public void whenCountN3Then6() {
        int number = 3;
        int expected = 6;
        int result = new Fact().calc(number);
        assertThat(result).isEqualTo(expected);
    }

}