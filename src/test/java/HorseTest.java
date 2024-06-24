import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class HorseTest {
    //@Test(expected = IllegalArgumentException.class)
    @Test
    public void ifNullShouldBeIllegalException() {
        assertThrows(IllegalArgumentException.class, () -> new Horse(null, 1, 1));
    }

    @Test
    public void messageIfNull() {
        IllegalArgumentException thrown =
                Assertions.assertThrows(IllegalArgumentException.class,
                        () -> new Horse(null,1,1),"Name cannot be null.");
        assertEquals("Name cannot be null.", thrown.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"","\\t"," "})
    public void ifSpaseInConstructor(){
       // assertThrows(IllegalArgumentException.class, () -> new Horse(, 1, 1));
    }

}