package com.excilys.tondeuse.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.excilys.tondeuse.exception.utilsexception.UtilsException;
import com.excilys.tondeuse.modele.Direction;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DirectionUtilsTest {
    
    @InjectMocks
    DirectionUtils directionUtils;

    @Test
    void string_to_direction_e() throws UtilsException{
        String entree = "E";
        Direction expected = Direction.EAST;

        Direction result = directionUtils.stringToDirection(entree);

        assertEquals(expected, result);
    }

    @Test
    void string_to_direction_s() throws UtilsException{
        String entree = "S";
        Direction expected = Direction.SOUTH;

        Direction result = directionUtils.stringToDirection(entree);

        assertEquals(expected, result);
    }

    @Test
    void string_to_direction_w() throws UtilsException{
        String entree = "W";
        Direction expected = Direction.WEST;

        Direction result = directionUtils.stringToDirection(entree);

        assertEquals(expected, result);
    }

    @Test
    void string_to_direction_n() throws UtilsException{
        String entree = "N";
        Direction expected = Direction.NORTH;

        Direction result = directionUtils.stringToDirection(entree);

        assertEquals(expected, result);
    }

    @Test
    void string_to_direction_other() throws UtilsException{
        String entree = "A";

        assertThrows(UtilsException.class,() -> directionUtils.stringToDirection(entree));
    }

}
