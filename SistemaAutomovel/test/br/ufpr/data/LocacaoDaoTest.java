package br.ufpr.data;

import br.ufpr.model.Locacao;
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
public class LocacaoDaoTest {
    
    public LocacaoDaoTest() {
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
     * Test of inserir method, of class LocacaoDao.
     * @throws java.lang.Exception
     */
    @Test
    public void testInserir() throws Exception {
        System.out.println("inserir");
        Locacao locacao = null;//new Locacao(new ClienteDao()., Integer.SIZE, dataInicio, Double.NaN);
        LocacaoDao instance = new LocacaoDao();
        instance.inserir(locacao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editar method, of class LocacaoDao.
     * @throws java.lang.Exception
     */
    @Test
    public void testEditar() throws Exception {
        System.out.println("editar");
        Locacao locacao = null;
        LocacaoDao instance = new LocacaoDao();
        instance.editar(locacao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of excluir method, of class LocacaoDao.
     * @throws java.lang.Exception
     */
    @Test
    public void testExcluir() throws Exception {
        System.out.println("excluir");
        Locacao locacao = null;
        LocacaoDao instance = new LocacaoDao();
        instance.excluir(locacao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscar method, of class LocacaoDao.
     * @throws java.lang.Exception
     */
    @Test
    public void testBuscar() throws Exception {
        System.out.println("buscar");
        Locacao locacao = null;
        LocacaoDao instance = new LocacaoDao();
        Locacao expResult = null;
        Locacao result = instance.buscar(locacao);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listar method, of class LocacaoDao.
     * @throws java.lang.Exception
     */
    @Test
    public void testListar() throws Exception {
        System.out.println("listar");
        Locacao locacao = null;
        LocacaoDao instance = new LocacaoDao();
        List<Locacao> expResult = null;
        List<Locacao> result = instance.listar(locacao);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
