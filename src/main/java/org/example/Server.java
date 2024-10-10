package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyPair;
import java.security.PublicKey;
import java.util.Scanner;

public class Server {
    Socket socketClient;
    ServerSocket serversocket;

    public boolean connect() {
        try{
            socketClient = serversocket.accept();
            return true;
        } catch (IOException e) {
            System.err.println("não fez a conexão" + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args){
         try {
             Server servidor = new Server();
             servidor.rodarServidor();
         } catch (Exception e) {
             e.printStackTrace();
         }
    }

    public void rodarServidor() throws Exception {
        String textoRecebido = "";
        String textoEnviado = "oiiiiiiii";
        String textoDecifrado;
        String textoCifrado;

        Scanner input = new Scanner(System.in);
        serversocket = new ServerSocket(9600);
        System.out.println("server iniciado!");

        while (true) {
            if (connect()) {
                System.out.println("gerando chaves RSA...");
                KeyPair chaves = CriptografiaClienteServidor.gerarChavesPublicoPrivada();

                System.out.println("enviando chave pública...");
                Conexao.enviarChave(socketClient, chaves.getPublic());

                System.out.println("recebendo chave pública do cliente...");
                PublicKey chavePublica = Conexao.receberChave(socketClient);

                textoRecebido = Conexao.receber(socketClient);
                System.out.println("\nmensagem criptografada recebida: " + textoRecebido);
                textoDecifrado = CriptografiaClienteServidor.decifrar(textoRecebido, chaves.getPrivate());

                System.out.println("cliente enviou: " + textoDecifrado);
                System.out.print("\ndigite a sua mensagem: ");
                textoEnviado = input.nextLine();

                textoCifrado = CriptografiaClienteServidor.cifrar(textoEnviado, chavePublica);

                System.out.println("Mensagem criptografada enviada: " + textoCifrado);
                Conexao.enviar(socketClient, textoCifrado);

                socketClient.close();
            }
        }
    }
}
