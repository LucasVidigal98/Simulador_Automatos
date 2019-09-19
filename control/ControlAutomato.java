package control;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import model.Automato;

public class ControlAutomato {
    
    public boolean inicializaPesquisa(Automato auto, ArrayList <Object> passos){
        
        boolean palavraAceita = false;
        switch (auto.getTipo()) {
            case "AFD":
                palavraAceita = this.pesquisaAFD(auto, passos);
                break;
            case "AFN":
                palavraAceita = this.pesquisaAFN(auto, passos);
                break;
        }
        
        return palavraAceita;
    }
    
    public boolean ehEstadoFinal(Automato auto, int estadoAtual){
        
        //Verifica se o estado atual da busca profundidade é final, se for a palavra é aceita pelo o automato
        for(int i=0; i<auto.getEstadosFinais().size(); i++)
            if(estadoAtual == auto.getEstadosFinais().get(i)) return true;
        
        return false;
    }
    
    public boolean ehEstadoFinal(Automato auto, Queue <Integer> estados){
        
        while(estados.size() > 0){
            int estado = estados.poll();
            for(int i=0; i<auto.getEstadosFinais().size(); i++)
                if(estado == auto.getEstadosFinais().get(i)) return true;
        }
   
        return false;
    }
    
    public boolean ehAlfabeto(Automato auto){
        
        String palavra = auto.getPalavra();
        String []alfabeto = auto.getAlfabeto();
        int contadorIgual = 0;
        
        for(int i=0; i<auto.getPalavra().length(); i++){
            for(int j=0; j<auto.getAlfabeto().length; j++){
               if(palavra.substring(i, i+1).equals(alfabeto[j]))
                   contadorIgual++;
            }
            
            if(contadorIgual == 0) return false;
            contadorIgual = 0;
        }
        
        return true;
    }
    
    //Função faz basicamente uma busca em profundiade no grafo do automato para ver se a palavra pertence a ele
    public boolean pesquisaAFD(Automato auto, ArrayList<Object> passos){  
        
        int proxSimbolo = 0;                         //Contador para percorrer o array da palavra
        int estadoAtual = auto.getEstadoInicial();   //Recebe o estado inicial do automato
        boolean palavraAceita;                       //Variavel que verifica se a palavra foi aceita
        
        if(auto.getPalavra().equals("E"))    //Verifica se a palavra vazia é aceita
            return this.ehEstadoFinal(auto, auto.getEstadoInicial());
        
        if(!this.ehAlfabeto(auto)) return false;   //Verifica se os simbolos da palavra correspondem ao do automato
        
        while(proxSimbolo < auto.getPalavra().length()){
            
            passos.add("I");//Começou a iteração
            
            boolean encontrouEstado = false;
            String simboloAtual;     //Simbolo atual da palavra de busca passada pelo campo de pesquisa
            
            try{
               simboloAtual = auto.getPalavra().substring(proxSimbolo, proxSimbolo+1).toUpperCase();
            }catch(Exception e){
                return this.ehEstadoFinal(auto, estadoAtual);
            }
            
            String simbolo = "S" + simboloAtual;
            passos.add(simbolo);
            String expandido = "E" + estadoAtual;
            passos.add(expandido);
            
            //------------BUSCA EM PROFUNDIDADE------------//
            for(int i=0; i<auto.getnEstados(); i++){
                //Percorre cada posição da matriz de transições de acordo com o tamanho da string naquela posição
                for(int j=0; j<auto.matrizTransicoes[estadoAtual][i].length(); j++){
                    if(auto.matrizTransicoes[estadoAtual][i].substring(j, j+1).equals(simboloAtual)){
                        //Se essa posição possuir alguma substring igual ao simbolo atual este estado possui transição para esse simbolo
                        encontrouEstado = true;
                        estadoAtual = i;
                        proxSimbolo++;
                        String vizinho = "V" + i;
                        passos.add(vizinho);
                        break;
                    }
                }
                
                if(encontrouEstado) break;
            }
            
            passos.add("I"); //Terminou a iteração
            
            //Se o estado nao tiver transições para o símbolo atual então o automato nao aceita a palavra
            //Sai do loop
            if(!encontrouEstado) break;
        }
        //------------BUSCA EM PROFUNDIDADE------------//
        
        //Verifica se o último estado da busca é um estado final
        //Se sim a palavra é aceita pelo automato
        palavraAceita = this.ehEstadoFinal(auto, estadoAtual); 
        return palavraAceita;
    }
    
    public void insereEstados(Queue <Integer> f1, Queue <Integer> f2){
        
        while(f2.size() > 0)
            f1.add(f2.poll());
    }
    
    public boolean pesquisaAFN(Automato auto, ArrayList<Object> passos){
        
        int proxSimbolo = 0;                                    //Contador para percorrer o array da palavra
        int estadoAtual = 0;                                    //Recebe o estado inicial do automato
        boolean palavraAceita;                                  //Variavel que verifica se a palavra foi aceita
        boolean erro = false;                                   //Varialvel de controle para as transições
        Queue <Integer> estados = new LinkedList<>();           //Fila que recebe os estados da iteração atual
        Queue <Integer> proxEstados = new LinkedList<>();       //Fila que recebe os estados da próxima iteração
        estados.add(auto.getEstadoInicial());
        
        if(auto.getPalavra().equals("E"))
            return this.ehEstadoFinal(auto, auto.getEstadoInicial());
        
        if(!this.ehAlfabeto(auto)) return false;
        
        while(proxSimbolo < auto.getPalavra().length()){
            
            String simboloAtual;     //Simbolo atual da palavra de busca passada pelo campo de pesquisa
            
            try{
               simboloAtual = auto.getPalavra().substring(proxSimbolo, proxSimbolo+1).toUpperCase();
            }catch(Exception e){
                return this.ehEstadoFinal(auto, estadoAtual);
            }
            
            String simbolo = "S" + simboloAtual; //Recebe o simbolo a ser processado
            
            passos.add("I"); //Marca onde começa uma iteração
            passos.add(simbolo);
            
            while(estados.size() > 0){  //Percorre as transições dos estados atuais
                
                estadoAtual = estados.poll();
                String expandidos = "E" + estadoAtual;
                passos.add(expandidos);
                
                boolean encontrouEstado = false;
                
                for (int i = 0; i < auto.getnEstados(); i++) {
                    //Percorre cada posição da matriz de transições de acordo com o tamanho da string naquela posição
                    for (int j = 0; j < auto.matrizTransicoes[estadoAtual][i].length(); j++) {
                        
                        if (auto.matrizTransicoes[estadoAtual][i].substring(j, j + 1).equals(simboloAtual)) {
                            //Se essa posição possuir alguma substring igual ao simbolo atual este estado possui transição para esse simbolo
                            proxEstados.add(i); //Adciona o estado como proximo
                            String vizinho = "V" + i;
                            passos.add(vizinho);      //Adciona o estado no passo a passo da pesquisa
                            encontrouEstado = true;
                        }
                        
                        if(auto.matrizTransicoes[estadoAtual][i].substring(j, j + 1).equals("&")){
                            estados.add(i);   //Ativa o estado para o processamento do caracter atual
                            String vizinho = "V" + i;
                            passos.add(vizinho);
                        }
                        
                    }
                    
                }
                
               if(!encontrouEstado) erro = true; 
            }
            
            this.insereEstados(estados, proxEstados);   //Tranfere os proximos estados para os estados atuais
            proxSimbolo++;
            passos.add("I");  //Marca onde termina uma iteração
        }
        
        //if(erro) return false; //Se o ultimo estado nao possuir transições válidas a palavra não é aceita
                
        palavraAceita = this.ehEstadoFinal(auto, estados); 
        return palavraAceita;
    }
}
