package com.excilys.tondeuse.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.excilys.tondeuse.exception.modelexception.ModelException;
import com.excilys.tondeuse.exception.utilsexception.UtilsException;
import com.excilys.tondeuse.modele.Point;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PointUtilsTest {

    @InjectMocks
    PointUtils pointUtils;
    
    @Test
    void string_to_point() throws UtilsException, ModelException{
        String[] entree = {"1","2"};
        Point expected = new Point(1,2);

        Point result = pointUtils.stringToPoint(entree);

        assertEquals(expected, result);
        
    }

    @Test
    void string_to_point_negative() throws UtilsException, ModelException{
        String[] entree = {"1","-2"};

        assertThrows(UtilsException.class,() -> pointUtils.stringToPoint(entree));
        
    }

    @Test
    void string_to_point_not_integer() throws UtilsException, ModelException{
        String[] entree = {"1","E"};

        assertThrows(UtilsException.class,() -> pointUtils.stringToPoint(entree));
        
    }

}
