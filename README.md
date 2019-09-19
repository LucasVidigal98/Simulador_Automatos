# Simulador_Automatos

Trabalho Prático Teoria de Linguagens
Aluno: Lucas de Freitas Vidigal

O simulador foi implementado em JAVA e, tem o objetivo receber um arquivo representando um autômato (AFD ou AFN) e fazer pesquisas a partir de strings e símbolos para verficar se os mesmos são aceitos ou rejeitados pelo autômato. Para a avaliação do professor enviarei um arquivo do tipo .jar para a execução do programa e a pasta do projeto que acompanha os códigos de implementação e testes (Foi utilizado a biblioteca Junit para os testes), mais dois arquivos para serem processados, um do tipo AFD e outro do tipo AFN. Os pacotes com os códigos estão na pasta “src” do projeto e os pacotes com os códigos de testes estão na pasta  “test”. O projeto foi desenvolvido pelo NetBeans IDE 8.0.1, dessa forma, se o professor tiver a necessidade de utilizar alguma IDE para a visualização do código aconselho utilizar o NetBeans.
Após aberto o programa, irá aparecer uma janela inicial com duas opções de carregamento de arquivos (Formatação explanada no próximo tópico), uma para o tipo AFN e outra para o tipo AFD.  Com o carregamento do arquivo completo aparecerá uma janela para com três opções e um campo de texto para digitar a palavra de pesquisa do autômato. Uma opção fornece as informações do autômato (Número de transições, número de estados, alfabeto, etc). A segunda faz uma pesquisa rápida no autômato, somente para verificar se a palavra é aceita ou não. E a última opção fornece uma pesquisa que realiza uma sequência de passos a serem percorridos pelo autômato de acordo com a palavra pesquisada (Estados atuais, símbolo a ser processado, etc.). Se o campo de texto estiver vazio a palavra de pesquisa será considerada como vazia (Símbolo utilizado para palavra vazia foi a letra “E”).
O arquivo para a formalização do autômato é composto por um cabeçalho de cinco linhas que compõem suas informações como tipo (AFN ou AFD), número de estados, número de transições, seu alfabeto e uma pequena descrição sobre o mesmo. As linhas restantes denotam sua tabela de transições. O alfabeto deve estar entre chaves e a descrição entre aspas, aspas vazias representam que o autômato não possui descrição. A divisão entre cabeçalho e tabela de transições é feita por uma linha vazia.




Ex Cabeçalho:

AFN   	 	<Tipo>
5         		<Número de estados>
10		<Número de transições>
{&, 0, 1}	<Alfabeto>
"Autômato com transição vazia" <Descrição>  

	
Para a tabela de transição foi feito o seguinte esquema: As primeiras colunas das linhas da tabela representam o estado que terá suas transições preenchidas. Dessa forma, as outras colunas representam suas transições. Cada transição é representadas por chaves, composta pelos os estados desta transição. E elas seguem a precedência do alfabeto passado pelo autômato. Ex: foi passado o alfabeto {A, B}, então o primeiro conjunto de chaves representa os estados que que possuem transição “A” e o segundo os estados que possuem transição “B”.  Todos os estados devem ser representados pela letra “q”. A extensão dos arquivos é do tipo .txt.
Ex Tabela:
'q0 {q1, q3} {} {}
*q1 {} {q2} {q1}
q2 {} {q1} {q2}
*q3 {} {q3} {q4}
q4 {} {q4} {q3}

#Símbolos notáveis: 
' = Indica que é um estado inicial.
* = Indica que é um estado final.
& = Transição vazia.
Obs.: Se um estado for inicial e final ao mesmo tempo o símbolo ‘ deve aparecer antes do símbolo *.

	

Ex arquivo completo:

	AFN
5
10
{&, 0, 1}
"Autômato com transição vazia"

'q0 {q1, q3} {} {}
*q1 {} {q2} {q1}
q2 {} {q1} {q2}
*q3 {} {q3} {q4}
q4 {} {q4} {q3}

Autômato representado pelo arquivo:
![Automato][Automato]

[Automato]: ./automato.png
