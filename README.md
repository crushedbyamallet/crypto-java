<h2>projeto de comunicação segura com criptografia RSA</h2>

este repositório contém uma implementação básica de um cliente e servidor utilizando sockets Java e criptografia RSA. o objetivo é demonstrar como estabelecer uma comunicação segura entre um cliente e um servidor, garantindo a confidencialidade das mensagens através da criptografia.

<h2>funcionalidades</h2>
<h3>geração de chaves RSA:</h3> o servidor gera um par de chaves (pública e privada) para criptografar e decifrar mensagens.
<h3>troca de chaves:</h3> o cliente e o servidor trocam suas chaves públicas para permitir a criptografia mútua.
<h3>criptografia de Mensagens:</h3> as mensagens enviadas pelo cliente são criptografadas com a chave pública do servidor antes de serem transmitidas.
<h3>decifragem de Mensagens:</h3> o servidor decifra as mensagens recebidas usando sua chave privada e vice-versa.


<h2>estrutura do projeto</h2>
<h3>client:</h3> classe responsável por iniciar o cliente, estabelecer a conexão com o servidor, enviar mensagens criptografadas e receber respostas.
<h3>server:</h3> classe que representa o servidor, que aguarda conexões, recebe mensagens e responde ao cliente.
<h3>conexao:</h3> classe auxiliar para facilitar a comunicação entre cliente e servidor.
<h3>CriptografiaClienteServidor:</h3> classe que contém métodos para gerar chaves e realizar a criptografia e decifragem de mensagens.
<h3>RSA_EC:</h3> exemplo adicional de implementação de criptografia RSA com números primos.

<h2>como usar</h2>
<p>compile o projeto usando um IDE de java ou ferramentas de linha de comando.</p>
<p>inicie o servidor (Server).</p>
<p>em outra instância, inicie o cliente (Client).</p>
<p>siga as instruções no terminal para enviar e receber mensagens.</p>



<h2>validação com RSA Express Encryption-Decryption Calculator</h2>

![RSA CALCULATOR](https://github.com/user-attachments/assets/2f654dcc-d7d0-48e4-b780-f08c4f13bb40)

a imagem acima exibe o uso do simulador RSA Express Encryption-Decryption Calculator da Drexel University, que foi utilizado para validar o funcionamento do nosso aplicativo de criptografia RSA desenvolvido em java.

usamos os seguintes valores:

módulo (N): 2867
chave de criptografia (e): 7
chave de descriptografia (d): 1183
a mensagem original "lesgoooo" foi convertida para sua forma numérica ASCII, exibida como: 108 101 115 103 111 111 111 111


essa mensagem foi então criptografada utilizando a chave pública e o módulo fornecido, gerando o seguinte texto cifrado em formato numérico: 2609 1607 2763 484 2024 2024 2024 2024
aa segunda etapa, o simulador utilizou a chave privada (d) e o módulo (N) para decifrar o texto criptografado, retornando o valor original em forma numérica ASCII e sua conversão para texto legível: "lesgoooo".

<h2>RSA_ECO</h2>

![RSA_EC_VALORES](https://github.com/user-attachments/assets/f9631da0-aa27-4d6b-9e4d-448fde588871)

essa imagem mostra a execução de um programa Java que implementa criptografia RSA usando os seguintes valores:

valores iniciais:

números primos: p = 47 e q = 61 foram escolhidos para gerar o módulo n. a segurança do rsa baseia-se na dificuldade de fatorar o produto de dois números primos grandes. números pequenos são usados para facilitar o entendimento.
módulo: n = 2867 é a multiplicação de p e q (n = p × q) e é utilizado na chave pública, sendo essencial para a criptografia e descriptografia.
chave pública: e = 7 é o expoente da chave pública, escolhido por ser pequeno e coprimo ao totiente φ(n). esse valor deve garantir que a inversa multiplicativa d possa ser calculada.
chave privada: d = 1183 é o inverso multiplicativo de e módulo φ(n). essa chave é usada para decifrar as mensagens.

mensagem cifrada e decifrada: a string "lesgoooo" foi convertida em valores numéricos e criptografada com (e, n). a mensagem foi corretamente decifrada usando a chave privada (d), demonstrando a funcionalidade do rsa e assegurando a confidencialidade.

processo de criptografia e decifragem:
mensagem cifrada: 2609 1607 2763 484 2024 2024 2024 2024 2024
a mensagem "lesgoooo" foi convertida para números e criptografada.
mensagem decifrada: "lesgoooo"
a mensagem foi corretamente decifrada, indicando que o processo de criptografia RSA funcionou conforme o esperado.

