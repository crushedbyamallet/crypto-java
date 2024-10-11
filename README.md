# projeto de comunicação segura com criptografia RSA

este repositório contém uma implementação básica de um **cliente e servidor** utilizando **sockets Java** e **criptografia RSA**. o objetivo é demonstrar como estabelecer uma comunicação segura entre um cliente e um servidor, garantindo a **confidencialidade das mensagens** através da criptografia.

## funcionalidades

### **geração de chaves RSA:**
o servidor gera um par de chaves (**pública e privada**) para criptografar e decifrar mensagens.

### **troca de chaves:**
o cliente e o servidor trocam suas chaves públicas para permitir a **criptografia mútua**.

### **criptografia de mensagens:**
as mensagens enviadas pelo cliente são **criptografadas com a chave pública do servidor** antes de serem transmitidas.

### **decifragem de mensagens:**
o servidor **decifra as mensagens** recebidas usando sua chave privada e vice-versa.

## estrutura do projeto

### **client:**
classe responsável por iniciar o cliente, estabelecer a conexão com o servidor, enviar mensagens criptografadas e receber respostas.

### **server:**
classe que representa o servidor, que aguarda conexões, recebe mensagens e responde ao cliente.

### **conexao:**
classe auxiliar para facilitar a comunicação entre cliente e servidor.

### **CriptografiaClienteServidor:**
classe que contém métodos para gerar chaves e realizar a criptografia e decifragem de mensagens.

### **RSA_EC:**
exemplo adicional de implementação de criptografia RSA com números primos.

## como usar

1. compile o projeto usando um **IDE de Java** ou ferramentas de linha de comando.
2. inicie o **servidor (Server)**.
3. em outra instância, inicie o **cliente (Client)**.
4. siga as instruções no terminal para **enviar e receber mensagens**.

![CLIENT_TERMINAL](https://github.com/user-attachments/assets/510fab65-3ce7-4aae-b6c3-3f2bba36f133)

![SERVER_TERMINAL](https://github.com/user-attachments/assets/4b7a4fc3-c3a5-4452-a24b-b5da997f74dd)


## validação com RSA Express Encryption-Decryption Calculator

![RSA CALCULATOR](https://github.com/user-attachments/assets/2f654dcc-d7d0-48e4-b780-f08c4f13bb40)

a imagem acima exibe o uso do simulador **RSA Express Encryption-Decryption Calculator** da **Drexel University**, que foi utilizado para validar o funcionamento do nosso aplicativo de criptografia RSA desenvolvido em Java.

usamos os seguintes valores:

- **módulo (N):** 2867
- **chave de criptografia (e):** 7
- **chave de descriptografia (d):** 1183

a mensagem original "lesgoooo" foi convertida para sua forma numérica ASCII, exibida como: **108 101 115 103 111 111 111 111**.

essa mensagem foi então criptografada utilizando a **chave pública** e o **módulo** fornecido, gerando o seguinte texto cifrado em formato numérico: **2609 1607 2763 484 2024 2024 2024 2024**. na segunda etapa, o simulador utilizou a **chave privada (d)** e o **módulo (N)** para decifrar o texto criptografado, retornando o valor original em forma numérica ASCII e sua conversão para texto legível: "lesgoooo".

## RSA_EC

![RSA_EC_VALORES](https://github.com/user-attachments/assets/f9631da0-aa27-4d6b-9e4d-448fde588871)

essa imagem mostra a execução de um programa java que implementa criptografia RSA usando os seguintes valores:

### valores iniciais:

- **números primos:** **p = 47** e **q = 61** foram escolhidos para gerar o módulo **n**. a segurança do RSA baseia-se na dificuldade de fatorar o produto de dois números primos grandes. números pequenos são usados para facilitar o entendimento.
- **módulo:** **n = 2867** é a multiplicação de **p** e **q** (**n = p × q**) e é utilizado na chave pública, sendo essencial para a criptografia e descriptografia.
- **chave pública:** **e = 7** é o expoente da chave pública, escolhido por ser pequeno e coprimo ao totiente **φ(n)**. esse valor deve garantir que a inversa multiplicativa **d** possa ser calculada.
- **chave privada:** **d = 1183** é o inverso multiplicativo de **e** módulo **φ(n)**. essa chave é usada para decifrar as mensagens.

![image](https://github.com/user-attachments/assets/8290f763-b341-4adc-9b97-b8bc22f909c9)

### mensagem cifrada e decifrada:
a string "lesgoooo" foi convertida em valores numéricos e criptografada com (**e**, **n**). a mensagem foi corretamente decifrada usando a **chave privada (d)**, demonstrando a funcionalidade do RSA e assegurando a confidencialidade.

### processo de criptografia e decifragem:
- **mensagem cifrada:** **2609 1607 2763 484 2024 2024 2024 2024.**
  - a mensagem "lesgoooo" foi convertida para números e criptografada.
- **mensagem decifrada:** **"lesgoooo".**
  - a mensagem foi corretamente decifrada, indicando que o processo de criptografia RSA funcionou conforme o esperado.

## intelliJ IDEA
optamos pelo IntelliJ para este projeto devido às suas características que facilitam o desenvolvimento em java, especialmente em aplicações de criptografia e comunicação em rede.

principais Vantagens:
- **autocompletar e inteligência:** oferece autocompletar avançado, ajudando a reduzir erros e acelerar o desenvolvimento.
- **suporte ao java:** esse editor de código possui suporte robusto para Java, com recursos de refatoração e navegação de código que facilitam a manutenção.
- **depuração eficiente:** o depurador poderoso permite rastrear e corrigir erros de forma eficaz, essencial para algoritmos de criptografia.-
- **integração com controle de versão:** a IDE se integra facilmente com git, facilitando o trabalho em equipe.

