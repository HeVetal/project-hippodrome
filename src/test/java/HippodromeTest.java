import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;
import static org.junit.jupiter.api.Assertions.*;

class HippodromeTest {

    @Test
    public void constructor_illegalArgumentException_paramNull() {
        assertThrows(IllegalArgumentException.class, () -> new Hippodrome(null));
    }

    @Test
    public void constructor_message_paramNull() {
        IllegalArgumentException thrown =
                Assertions.assertThrows(IllegalArgumentException.class,
                        () -> new Hippodrome(null));
        assertEquals("Horses cannot be null.", thrown.getMessage());
    }

    @Test
    public void constructor_illegalArgumentException_emptyList() {
        assertThrows(IllegalArgumentException.class, () -> new Hippodrome(List.of()));
    }

    @Test
    public void constructor_message_emptyList() {
        var thrown = assertThrows(IllegalArgumentException.class, () -> new Hippodrome(List.of()));
        assertEquals("Horses cannot be empty.", thrown.getMessage());
    }

    @Test
    public void getHorses_returnHorses_() {
        List<Horse> list = IntStream.range(0, 30).mapToObj(i -> new Horse("Zephyr " + i, i, i)).toList();
        Hippodrome hippodrome = new Hippodrome(list);
        assertEquals(list, hippodrome.getHorses());
    }

    @Test
    public void testMove() {
        List<Horse> list = IntStream.range(0, 50).mapToObj(i -> Mockito.mock(Horse.class)).toList();
        Hippodrome hippodrome = new Hippodrome(list);
        hippodrome.move();
        list.forEach(horse -> Mockito.verify(horse, Mockito.times(1)).move());
    }

    @Test
    public void testWinner() {
        Horse horse = new Horse("Lobster", 1, 10);
        Horse horse1 = new Horse("Pegasus", 2, 20);
        Horse horse2 = new Horse("Cherry", 3, 30);
        Hippodrome hippodrome = new Hippodrome(List.of(horse, horse1, horse2));
        assertSame(horse2, hippodrome.getWinner());
    }
}