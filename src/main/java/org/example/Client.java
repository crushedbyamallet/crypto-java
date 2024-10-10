package org.example;

import java.net.Socket;
import java.security.KeyPair;
import java.security.PublicKey;
import java.util.Scanner;

public class Client {
    Socket socket;

    public void comunicarComServidor() throws Exception {
        String textoRequisicao = "conexao estabelecida";
        String textoRecebido = "";
        String textoDecifrado = "";
        String textoCifrado = "";

        //socket = new Socket("192.168.1.10", 9600);
        socket = new Socket("localhost", 9600);

        // gerar chave pública e privada
        System.out.println("gerando chaves RSA...");
        KeyPair chaves = CriptografiaClienteServidor.gerarChavesPublicoPrivada();

        Scanner input = new Scanner(System.in);
        // receber a chave pública do servidor
        System.out.println("recebendo chave pública do servidor...");
        PublicKey chavePublica = Conexao.receberChave(socket);

        // enviar chave pública para o servidor
        System.out.println("enviando chave pública...");
        Conexao.enviarChave(socket, chaves.getPublic());

        System.out.print("\ndigite a sua mensagem: ");
        textoRequisicao = input.nextLine();

        textoCifrado = CriptografiaClienteServidor.cifrar(textoRequisicao, chavePublica);

        // enviar mensagem para o servidor
        System.out.println("mensagem criptografada enviada: " + textoCifrado);
        Conexao.enviar(socket, textoCifrado);

        // receber mensagem do servidor
        textoRecebido = Conexao.receber(socket);

        // decifrar texto do servidor
        textoDecifrado = CriptografiaClienteServidor.decifrar(textoRecebido, chaves.getPrivate());

        System.out.println("\nmensagem criptografada recebida: " + textoRecebido);
        System.out.println("servidor enviou: " + textoDecifrado);
    }


    public static void main(String[] args) {
        try {
            Client cliente = new Client();
            cliente.comunicarComServidor();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}

