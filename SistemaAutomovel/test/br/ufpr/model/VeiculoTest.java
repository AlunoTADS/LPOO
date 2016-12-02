package br.ufpr.model;

import java.util.Calendar;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lucas
 */
public class VeiculoTest {
    
    @Test
    public void testPlacaPattern() {
        try {
            Automovel automovel = new Automovel(null, null, null, null, null, null, null, "DDDD-1111", null);
        }
        catch(IllegalArgumentException ex) {
            fail();
        }
            
    }

    
}
