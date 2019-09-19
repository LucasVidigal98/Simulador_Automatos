package entrada;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import model.Automato;
import javax.swing.JOptionPane;

public class Arquivo {

    private String caminho;    //Recebe o caminho do arquivo
    private Automato auto;     //Automato que o arquivo de entrada vai gerar
    private String tipo;       //Tipo do automato (AFD ou AFN)

    public Arquivo(String caminho, String tipo) {
        this.caminho = caminho;
        this.tipo = tipo;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public Automato getAuto() {
        return auto;
    }

    public void setAuto(Automato auto) {
        this.auto = auto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    private void inicializaMatriz(String[][] matriz, int n) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = "";
            }
        }
    }

    private Automato carregaInformacoes(ArrayList<String> result) {  //Carrega as informações para o automato a partir das linhas ja lidas do arquivo

        int estados = 0, transicoes = 0;
        int contador = 0, contadorAlfabeto = 0;
        String falsoTipo = null;
        String alfabeto[] = null;
        String matrizTransicoes[][] = null;
        boolean erro1 = false;
        boolean erro2 = false;
        boolean erro3 = false;
        int contadorEstadoInicial = 0;      //Conta o número de estados iniciais -Mais de um estado inicial = Erro-
        int estadoInicial = 0;             //Guarda o estado inicial lido pelo arquivo
        String desc = "";                       //Guarda a descrição do automato(se houver) 
        ArrayList<Integer> estadosFinais = new ArrayList<>();

        for (String s : result) {
            //Uso o método split da classe String
            //para separar as partes entre os ponto e vírgulas.
            //Guardo o resultado em um array
            String[] linhas = null;

            if (contador == 0) {

                linhas = s.split(" ");
                if (!linhas[0].equals(this.tipo)) {  //Verifica se o tipo passado no arquivo foi o mesmo selecionado na interface
                    erro1 = true;
                    falsoTipo = linhas[0];
                    break;
                }

            } else if (contador == 1) { //Le o numero de estados

                linhas = s.split(" ");
                estados = Integer.parseInt(linhas[0]);
                matrizTransicoes = new String[estados][estados];  //Sabendo o número de estados passados pelo arquivo, podemos definir o tamnho da matriz
                this.inicializaMatriz(matrizTransicoes, estados); //Inicializa a matris com strings vazias

            } else if (contador == 2) { //Le o numero de transicoes

                linhas = s.split(" ");
                transicoes = Integer.parseInt(linhas[0]);

            } else if (contador == 3) {   //Le o alfabeto do automato

                for (int i = 0; i < s.length(); i++) {
                    if (s.substring(i, i + 1).equals("{") || s.substring(i, i + 1).equals("}") || s.substring(i, i + 1).equals(",") || s.substring(i, i + 1).equals(" ")) {

                    } else {
                        contadorAlfabeto++;
                    }
                }

                alfabeto = new String[contadorAlfabeto];
                contadorAlfabeto = 0;
                for (int j = 0; j < s.length(); j++) {
                    if (s.substring(j, j + 1).equals("{") || s.substring(j, j + 1).equals("}") || s.substring(j, j + 1).equals(",") || s.substring(j, j + 1).equals(" ")) {

                    } else {
                        alfabeto[contadorAlfabeto] = s.substring(j, j + 1).toUpperCase();
                        contadorAlfabeto++;
                    }
                }
            }else if(contador == 4){  
                
                if(s.substring(0, 1).equals("\"")) //Verfica se foi passado uma descrição para o automato
                    desc = s;
                else
                    desc = "";
                
            } else if (contador > 4) {  //Preenche a matriz de transições
                int contadorQ = 0;                  //Contadaor para o numero de estados de cada linha ex:q0, q1, etc.
                int posMatriz = 0;                  //Variável que guarda qual linha da matriz será preenchida de acordo com o primeiro estado da linha
                int alfabetoAtual = 0;              //Contador para o alfabeto de acordo com a transição atual em questão
                int contadorChaves = 0;             //Contador para o número de chaves de cada linha
                int contadorEstadosADF = 0;         //Conta o número de estadados dentro de {} -Caso de erro especial para o AFD-

                for (int i = 0; i < s.length(); i++) {

                    if (s.substring(i, i + 1).equals("'")) {

                        if (contadorEstadoInicial >= 1) {   //Verifica se há mais de um estado Incial, se sim = Erro
                            erro3 = true;
                            break;
                        }

                        if (s.subSequence(i + 1, i + 2).equals("*")) { //Verifica se o estado é inicial e final ao mesmo tempo
                            estadosFinais.add(Integer.parseInt(s.substring(i + 3, i + 4)));
                            estadoInicial = Integer.parseInt(s.substring(i + 3, i + 4));
                            contadorEstadoInicial++;
                        } else if (s.substring(i + 1, i + 2).equals("q") || s.substring(i + 1, i + 2).equals("Q")) {  //Não é estado inicial e final ao mesmo tempo
                            estadoInicial = Integer.parseInt(s.substring(i + 2, i + 3));
                            contadorEstadoInicial++;
                        }

                    } else if (s.substring(i, i + 1).equals("*")) {   //Verifica se é um estado final

                        estadosFinais.add(Integer.parseInt(s.substring(i + 2, i + 3))); //Se a linha começar com um asterisco o estado é final

                    } else if ((s.substring(i, i + 1).equals("q") || s.substring(i, i + 1).equals("Q")) && contadorQ == 0) {  //Verifica se é o primeiro estado da linha do arquivo

                        posMatriz = Integer.parseInt(s.substring(i + 1, i + 2)); //Recebe a posicao de qual estado tera suas transicoes preenchidas na matriz
                        contadorQ++;

                    } else if (s.substring(i, i + 1).equals("{") || s.substring(i, i + 1).equals("}")) {

                        if (alfabetoAtual == alfabeto.length) { //Verifica se as tansições foram 
                            erro2 = true;
                            break;
                        }

                        contadorChaves++;

                        if (contadorChaves == 2) { //Verfica se as chaves para a transição do elemento atual do alfabeto foi fechada
                            contadorChaves = 0;  //Reseta o contador para buscar novas chaves
                            contadorQ++;         //Avança para o proximo estado "q"
                            alfabetoAtual++;     //Passa para o próximo elmento do alfabeto
                            if (this.tipo.equals("AFD")) {
                                contadorEstadosADF = 0; //Reseta a variavel de erro de estados do AFD.
                            }
                        }

                    } else if (s.substring(i, i + 1).equals("q") && contadorQ > 0) {

                        //Analise de erro caso o automato seja AFD e passamos mais de um estado por chaves ex:{q1, q2}
                        if (contadorChaves == 1 && this.tipo.equals("AFD") && contadorEstadosADF > 1) {
                            erro2 = true;
                            break;
                        }

                        if (matrizTransicoes[posMatriz][Integer.parseInt(s.substring(i + 1, i + 2))].equals("")) {

                            matrizTransicoes[posMatriz][Integer.parseInt(s.substring(i + 1, i + 2))] = alfabeto[alfabetoAtual];
                        } else {
                            //Se o estado não for vazio concatena os estados
                            matrizTransicoes[posMatriz][Integer.parseInt(s.substring(i + 1, i + 2))] = matrizTransicoes[posMatriz][Integer.parseInt(s.substring(i + 1, i + 2))] + alfabeto[alfabetoAtual];
                        }

                        if (this.tipo.equals("AFD")) {
                            contadorEstadosADF++;
                        }
                    }
                }
            }

            contador++;

            if (erro2) { //Verfica se houve algum erro do tipo 2 -Transições extrapoladas-
                JOptionPane.showMessageDialog(null, "Erro no arquivo, transiçoes invalidas para esse tipo de Automato!\n" + "Carregue um novo arquivo!");
                return null;
            }

            if (erro3) { //Verifica se houve algum erro do tipo3 -Mais de um estado Inicial-
                JOptionPane.showMessageDialog(null, "Erro no arquivo, o automato possui mais de um estado inicial!\n" + "Carregue um novo arquivo!");
                return null;
            }
        }

        if (erro1) {  //Verfica se houve algum erro do tipo 1 -Tipo de automato inválido-
            JOptionPane.showMessageDialog(null, "Tipo de automato inválido!\n" + "Você carregou um automato tipo " + falsoTipo
                    + " sendo que o tipo escolhido foi " + this.tipo + "!\nCarregue um novo arquivo!");
            return null;
        }

        //Todas as informações do automato foram carregadas, agora basta instanciar o objeto do tipo automato
        Automato aux = new Automato(this.tipo, estados, transicoes, desc, estadoInicial, matrizTransicoes, alfabeto, estadosFinais);
        return aux;
    }

    public Automato leituraArquivo() {

        File arquivo = new File(caminho);
        ArrayList<String> result = null;

        //Salva todas as linhas do arquivo e guarda em um arrayList
        try {

            BufferedReader bufferedReader;

            try (FileReader fileReader = new FileReader(arquivo.toString())) {
                bufferedReader = new BufferedReader(fileReader);
                String linha = "";
                result = new ArrayList<>();
                while ((linha = bufferedReader.readLine()) != null) {
                    if (linha != null && !linha.isEmpty()) {
                        result.add(linha);
                    }
                }
            }

            bufferedReader.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao ler ou encontrar caminho do arquivo " + e.getMessage());
        }

        this.auto = this.carregaInformacoes(result);
        return this.auto;
    }
}
