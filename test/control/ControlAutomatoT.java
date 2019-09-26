package control;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import model.Automato;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lucas F. Vidigal
 */
public class ControlAutomatoIT {
    
    private ControlAutomato contolAuto;
    
    public ControlAutomatoIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.contolAuto = new ControlAutomato();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of inicializaPesquisa method, of class ControlAutomato.
     */
    @Test
    public void testInicializaPesquisa() {
        System.out.println("inicializaPesquisa");
        
        String [][]matrizTransicoes = new String[2][2];
        matrizTransicoes[0][0] = "1";
        matrizTransicoes[0][1] = "0";
        matrizTransicoes[1][0] = "0";
        matrizTransicoes[1][1] = "1";
        
        String []alfabeto = new String[2];
        alfabeto[0] = "0";
        alfabeto[1] = "1";
        
        ArrayList <Integer> estadosFinais = new ArrayList();
        estadosFinais.add(0);
        
        Automato auto = new Automato("AFD", 2, 4, "TesteJunit", 0, matrizTransicoes, alfabeto, estadosFinais);
        auto.setPalavra("00");
        ArrayList<Object> passos = new ArrayList<>();
        
        assertEquals(true, this.contolAuto.inicializaPesquisa(auto, passos));
        
    }

    @Test
    public void testEhEstadoFinal_Automato_int() {
        System.out.println("ehEstadoFinal");
       
        String [][]matrizTransicoes = new String[2][2];
        matrizTransicoes[0][0] = "1";
        matrizTransicoes[0][1] = "0";
        matrizTransicoes[1][0] = "0";
        matrizTransicoes[1][1] = "1";
        
        String []alfabeto = new String[2];
        alfabeto[0] = "0";
        alfabeto[1] = "1";
        
        ArrayList <Integer> estadosFinais = new ArrayList();
        estadosFinais.add(0);
        
        Automato auto = new Automato("AFD", 2, 4, "TesteJunit", 0, matrizTransicoes, alfabeto, estadosFinais);
        
        int estadoAtual = 0;
        
        assertEquals(true, this.contolAuto.ehEstadoFinal(auto, estadoAtual));
    }

    @Test
    public void testEhEstadoFinal_Automato_Queue() {
        System.out.println("ehEstadoFinal");
        
        String [][]matrizTransicoes = new String[2][2];
        matrizTransicoes[0][0] = "1";
        matrizTransicoes[0][1] = "0";
        matrizTransicoes[1][0] = "0";
        matrizTransicoes[1][1] = "1";
        
        String []alfabeto = new String[2];
        alfabeto[0] = "0";
        alfabeto[1] = "1";
        
        ArrayList <Integer> estadosFinais = new ArrayList();
        estadosFinais.add(0);
        
        Automato auto = new Automato("AFD", 2, 4, "TesteJunit", 0, matrizTransicoes, alfabeto, estadosFinais);
        
        Queue<Integer> estados = new LinkedList<>();
        estados.add(0);
        
        assertEquals(true, this.contolAuto.ehEstadoFinal(auto, estados));
    }
    
    @Test
    public void testEhAlfabeto() {
        System.out.println("ehAlfabeto");
        String [][]matrizTransicoes = new String[2][2];
        matrizTransicoes[0][0] = "1";
        matrizTransicoes[0][1] = "0";
        matrizTransicoes[1][0] = "0";
        matrizTransicoes[1][1] = "1";
        
        String []alfabeto = new String[2];
        alfabeto[0] = "0";
        alfabeto[1] = "1";
        
        ArrayList <Integer> estadosFinais = new ArrayList();
        estadosFinais.add(0);
        
        Automato auto = new Automato("AFD", 2, 4, "TesteJunit", 0, matrizTransicoes, alfabeto, estadosFinais);
        auto.setPalavra("00");
        
        assertEquals(true, this.contolAuto.ehAlfabeto(auto));
    }

    @Test
    public void testPesquisaAFD() {
        System.out.println("pesquisaAFD");
        
        String [][]matrizTransicoes = new String[2][2];
        matrizTransicoes[0][0] = "1";
        matrizTransicoes[0][1] = "0";
        matrizTransicoes[1][0] = "0";
        matrizTransicoes[1][1] = "1";
        
        String []alfabeto = new String[2];
        alfabeto[0] = "0";
        alfabeto[1] = "1";
        
        ArrayList <Integer> estadosFinais = new ArrayList();
        estadosFinais.add(0);
        
        Automato auto = new Automato("AFD", 2, 4, "TesteJunit", 0, matrizTransicoes, alfabeto, estadosFinais);
        auto.setPalavra("00");
        ArrayList<Object> passos = new ArrayList<>();
        
        assertEquals(true, this.contolAuto.inicializaPesquisa(auto, passos));
    }
    
    @Test
    public void testPesquisaAFN() {
        System.out.println("pesquisaAFN");
        
        String [][]matrizTransicoes = new String[3][3];
        matrizTransicoes[0][0] = "0";
        matrizTransicoes[0][1] = "0";
        matrizTransicoes[0][2] = "";
        matrizTransicoes[1][0] = "";
        matrizTransicoes[1][1] = "1";
        matrizTransicoes[1][2] = "1";
        matrizTransicoes[2][0] = "";
        matrizTransicoes[2][1] = "";
        matrizTransicoes[2][2] = "";
        
        String []alfabeto = new String[2];
        alfabeto[0] = "0";
        alfabeto[1] = "1";
        
        ArrayList <Integer> estadosFinais = new ArrayList();
        estadosFinais.add(2);
        
        Automato auto = new Automato("AFN", 3, 4, "TesteJunit", 0, matrizTransicoes, alfabeto, estadosFinais);
        auto.setPalavra("01");
        ArrayList<Object> passos = new ArrayList<>();
        
        assertEquals(true, this.contolAuto.inicializaPesquisa(auto, passos));
    }
}
