package org.example;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

public class RSA_EC {

    public static void main(String args[]) {
        String msg = "lesgoooo";
        String msgcifrada = null;
        String msgdecifrada = null;

        // valores:
        BigInteger p = new BigInteger("47");
        BigInteger q = new BigInteger("61");
        BigInteger n = p.multiply(q);
        BigInteger e = new BigInteger("7");
        BigInteger m = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));

        // valor calculado de d (inverso multiplicativo de e modulo m)
        BigInteger d = e.modInverse(m);

        System.out.println("p: " + p);
        System.out.println("q: " + q);
        System.out.println("n: " + n);
        System.out.println("e: " + e);
        System.out.println("d: " + d);

        // converter mensagem em bytes e criptografar
        byte[] msgBytes = msg.getBytes(StandardCharsets.US_ASCII);

        StringBuilder cifradaStringBuilder = new StringBuilder();
        for (byte b : msgBytes) {
            BigInteger msgBigInt = BigInteger.valueOf(b & 0xFF); // corrigido para evitar problemas de sinal
            BigInteger cifrada = msgBigInt.modPow(e, n);
            cifradaStringBuilder.append(cifrada).append(" ");
        }
        msgcifrada = cifradaStringBuilder.toString().trim();

        System.out.println("msg cifrada: " + msgcifrada);

        // descriptografar a mensagem
        String[] cifradaParts = msgcifrada.split(" ");
        StringBuilder decifradaStringBuilder = new StringBuilder();
        for (String part : cifradaParts) {
            BigInteger cifradaBigInt = new BigInteger(part);
            BigInteger decifrada = cifradaBigInt.modPow(d, n);
            decifradaStringBuilder.append((char) decifrada.intValue()); // usar intValue() para conversão
        }
        msgdecifrada = decifradaStringBuilder.toString();

        System.out.println("msg decifrada: " + msgdecifrada);
    }
}
