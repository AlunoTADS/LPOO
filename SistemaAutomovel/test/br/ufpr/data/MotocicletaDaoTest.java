package br.ufpr.data;

import br.ufpr.model.Motocicleta;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lucas
 */
public class MotocicletaDaoTest {
    
    public MotocicletaDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of inserir method, of class MotocicletaDao.
     * @throws java.lang.Exception
     */
    @Test
    public void testInserir() throws Exception {
        System.out.println("inserir");
        Motocicleta motocicleta = null;
        MotocicletaDao instance = new MotocicletaDao();
        instance.inserir(motocicleta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editar method, of class MotocicletaDao.
     * @throws java.lang.Exception
     */
    @Test
    public void testEditar() throws Exception {
        System.out.println("editar");
        Motocicleta motocicleta = null;
        MotocicletaDao instance = new MotocicletaDao();
        instance.editar(motocicleta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of excluir method, of class MotocicletaDao.
     * @throws java.lang.Exception
     */
    @Test
    public void testExcluir() throws Exception {
        System.out.println("excluir");
        Motocicleta motocicleta = null;
        MotocicletaDao instance = new MotocicletaDao();
        instance.excluir(motocicleta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscar method, of class MotocicletaDao.
     * @throws java.lang.Exception
     */
    @Test
    public void testBuscar() throws Exception {
        System.out.println("buscar");
        Motocicleta motocicleta = null;
        MotocicletaDao instance = new MotocicletaDao();
        Motocicleta expResult = null;
        Motocicleta result = instance.buscar(motocicleta);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listar method, of class MotocicletaDao.
     * @throws java.lang.Exception
     */
    @Test
    public void testListar() throws Exception {
        System.out.println("listar");
        Motocicleta motocicleta = null;
        MotocicletaDao instance = new MotocicletaDao();
        List<Motocicleta> expResult = null;
        List<Motocicleta> result = instance.listar(motocicleta);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
