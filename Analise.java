/*------------------------------------
Tema: Gestão de uma Lavandaria
Nome: António Manuel
Número: 34370
Ficheiro: Analise.java
Data: 27/07/2025
--------------------------------------*/
/*
1. Objetivo
Desenvolver um sistema para gerir clientes, peças de roupa e vendas de serviços numa lavandaria. 
O sistema deve permitir o cadastro de clientes, registo de peças entregues para lavagem, controle das vendas realizadas, e métodos de pagamento utilizados.

2. Visão [Interfaces Gráficas]
- ApresentacaoVisao
- LoginVisao
- MenuPrincipalVisao
- ClienteVisao
- PecaVisao
- VendaVisao

3. Entidades Fortes e Seus Atributos (Modelo)
- ClienteModelo
    int id
    String nome
    String telefone
    String email
    String genero
    String nacionalidade
    String provincia
    String municipio
    String comuna
    boolean status

- PecaModelo
    int id
    ClienteModelo cliente   // [FK] relação: uma peça pertence a um cliente
    String tipoDePeca             // exemplo: camisa, calça, lençol
    int quantidade
    String dataEntrega
    String horario
    boolean status

- VendaModelo
    int id
    ClienteModelo cliente   
    PecaModelo[] pecas      
    String data
    String nomeFuncionario
    float pagamento
    String metodoPagamento
    boolean status

4. Ficheiros (Persistência de Dados)
- ClienteFile.dat
- PecaFile.dat
- VendaFile.dat

5. Tabelas de Apoio (Auxiliares) = Entidades Fracas
- MetodoPagamento.tab
- Nacionalidades.tab
- Provincias.tab
- Municipios.tab
- Comunas.tab
- Funcionario.tab
- Horario.tab
- TipoPeca.tab              // camisa, calça, vestido, etc. (nova tabela auxiliar opcional)

6. Listagens e Pesquisas
- Listagem Geral de Clientes
    Pesquisa por Nome
    Pesquisa por Telefone 

- Listagem Geral de Peças
	Pesquisa por Quantidade
    Pesquisa por Horário

- Listagem Geral de Vendas
    Pesquisa por Id
    Pesquisa por Nome do Funcionário

7. Diversos
7.1 - Implementação: Java Swing
7.2 - IDE: Notepad++
*/
