import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class HorseTest {
    String name = "Blaze";
    double speed = 1;
    double distance = 2;

    @Test
    public void constructor_illegalException_firstParamNull() {
        assertThrows(IllegalArgumentException.class, () -> new Horse(null, speed, distance));
    }

    @Test
    public void constructor_message_firstParamNull() {
        IllegalArgumentException thrown =
                Assertions.assertThrows(IllegalArgumentException.class,
                        () -> new Horse(null, speed, distance));
        assertEquals("Name cannot be null.", thrown.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "\t", " ", "\n", "\f"})
    public void constructor_illegalArgumentException_firstParamSpace(String symbol) {
        assertThrows(IllegalArgumentException.class, () -> new Horse(symbol, speed, distance));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "\t", " ", "\n", "\f"})
    public void constructor_message_firstParamSpace(String symbol) {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> new Horse(symbol, speed, distance));
        assertEquals("Name cannot be blank.", thrown.getMessage());
    }

    @Test
    public void constructor_illegalArgumentException_secondParamOdd() {
        assertThrows(IllegalArgumentException.class, () -> new Horse(name, -1, distance));
    }

    @Test
    public void constructor_message_secondParamOdd() {
        IllegalArgumentException thrown =
                Assertions.assertThrows(IllegalArgumentException.class,
                        () -> new Horse(name, -1, distance));
        assertEquals("Speed cannot be negative.", thrown.getMessage());
    }

    @Test
    public void constructor_illegalArgumentException_thirdParamMinus() {
        assertThrows(IllegalArgumentException.class, () -> new Horse(name, speed, -1));
    }

    @Test
    public void constructor_message_thirdParamMinus() {
        IllegalArgumentException thrown =
                Assertions.assertThrows(IllegalArgumentException.class,
                        () -> new Horse(name, speed, -1));
        assertEquals("Distance cannot be negative.", thrown.getMessage());
    }

    @Test
    public void getNameReflection_returnName_() throws NoSuchFieldException, IllegalAccessException {
        String expectedName = "Blaze";

        Horse horse = new Horse(name, speed);
        Field field = horse.getClass().getDeclaredField("name");
        field.setAccessible(true);
        String actualName = (String) field.get(horse);

        assertEquals(expectedName, actualName);
    }

    @Test
    public void testGetName_returnName_() throws NoSuchFieldException, IllegalAccessException {
        Horse horse = new Horse(name, speed);

        assertEquals(name, horse.getName());
    }

    @Test
    public void getSpeedReflection_returnSpeed_() throws NoSuchFieldException, IllegalAccessException {
        Horse horse = new Horse(name, speed);

        Field field = horse.getClass().getDeclaredField("speed");
        field.setAccessible(true);
        double actualSpeed = (Double) field.get(horse);


        assertEquals(speed, actualSpeed);
    }

    @Test
    public void testGetSpeed_ShouldReturnSpeed_WhenArgumentIsConstructorSpeed_() {
        Horse horse = new Horse(name, speed);

        assertEquals(speed, horse.getSpeed());
    }


    @Test
    public void getDistanceReflection_returnDistance() throws NoSuchFieldException, IllegalAccessException {
        Horse horse = new Horse(name, speed, distance);

        Field field = horse.getClass().getDeclaredField("distance");
        field.setAccessible(true);
        double actualDistance = (Double) field.get(horse);

        assertEquals(distance, actualDistance);
    }

    @Test
    public void getDistance_returnDistance_() {
        Horse horse = new Horse(name, speed, distance);

        assertEquals(distance, horse.getDistance());
    }


    @Test
    public void getDistance_returnZero_twoParam() throws NoSuchFieldException, IllegalAccessException {
        Horse horse = new Horse(name, speed);
        assertEquals(0.0, horse.getDistance());
    }

    @Test
    public void getDistanceReflection_returnZero_twoParam() throws NoSuchFieldException, IllegalAccessException {
        Horse horse = new Horse(name, speed);

        Field field = horse.getClass().getDeclaredField("distance");
        field.setAccessible(true);
        double actualDistance = (Double) field.get(horse);

        assertEquals(0.0, actualDistance);

    }

    @Test
    public void move() {
        Horse horse = new Horse("Lucky", 2, 4);
        //Mockito.verify(horse).move(Horse.getRandomDouble(0.2, 0.9));
    }

//reflex public void getDistance_returnZero_twoParam()
    //move test

}