import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

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
//stream
        List<Horse> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add(new Horse("Zephyr " + i, i, i));
        }
        Hippodrome hippodrome = new Hippodrome(list);
        assertEquals(list, hippodrome.getHorses());
    }

    @Test
    public void testMove() {
       //stream
        List<Horse> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            list.add(Mockito.mock(Horse.class));
        }
        Hippodrome hippodrome = new Hippodrome(list);
        hippodrome.move();
        for (Horse horse : list) {
            Mockito.verify(horse, Mockito.times(1)).move();//stream
        }
    }

    @Test
    public void testWinner() {
        Horse horse = new Horse("Lobster", 1, 10);
        Horse horse1 = new Horse("Pegasus", 2, 20);
        Horse horse2 = new Horse("Cherry", 3, 30);
        Hippodrome hippodrome = new Hippodrome(List.of(horse, horse1, horse2));
        assertSame(horse2,hippodrome.getWinner());
    }
}