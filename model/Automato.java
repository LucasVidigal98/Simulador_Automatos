package model;

import java.util.ArrayList;

public class Automato {

    private String tipo;                        //Tipo do automato AFD ou AFN
    private int nEstados;     			//Guarda o número de estados do automato
    private int nTransicoes;  			//Guarda o númeor de transições do automato
    public String matrizTransicoes[][];         //Matriz que guarda o valor de cada transição
    public String alfabeto[];                  //Vetor que guarda o alfabeto reconhecido pelo automato
    private String palavra;			//Palavra a ser consultada no automato
    private String descricao;                   //Uma breve descrição sobre o automato
    private int estadoInicial;                  //Guarda o estado inicial do automato            
    ArrayList <Integer> estadosFinais;          //Array que gaurda os estados finais do automato

    public Automato(String tipo, int nEstados, int nTransicoes, String descricao, int estadoInicial, String [][]matrizTransicoes, String []alfabeto, ArrayList<Integer>estadosFinais) {
        this.tipo = tipo;
        this.nEstados = nEstados;
        this.nTransicoes = nTransicoes;
        this.descricao = descricao;
        this.estadoInicial = estadoInicial;
        this.matrizTransicoes = matrizTransicoes;
        this.alfabeto = alfabeto;
        this.estadosFinais = estadosFinais;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getnEstados() {
        return nEstados;
    }

    public void setnEstados(int nEstados) {
        this.nEstados = nEstados;
    }

    public int getnTransicoes() {
        return nTransicoes;
    }

    public void setnTransicoes(int nTransicoes) {
        this.nTransicoes = nTransicoes;
    }

    public String[][] getMatrizTransicoes() {
        return matrizTransicoes;
    }

    public void setMatrizTransicoes(String[][] matrizTransicoes) {
        this.matrizTransicoes = matrizTransicoes;
    }

    public String[] getAlfabeto() {
        return alfabeto;
    }

    public void setAlfabeto(String[] alfabeto) {
        this.alfabeto = alfabeto;
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public String getDescricao() {
        if(this.descricao.equals("\"\""))
            return "Não possui";
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public int getEstadoInicial() {
        return estadoInicial;
    }

    public void setEstadoInicial(int estadoInicial) {
        this.estadoInicial = estadoInicial;
    }
    
    public ArrayList<Integer> getEstadosFinais() {
        return estadosFinais;
    }

    public void setEstadosFinais(ArrayList<Integer> estadosFinais) {
        this.estadosFinais = estadosFinais;
    }
}
