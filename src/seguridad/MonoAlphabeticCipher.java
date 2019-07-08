/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad;

import java.util.Hashtable;

/**
 *
 * @author Oriana
 */
public class MonoAlphabeticCipher {

    public static Hashtable<Integer, Integer> alfabetoASCII = new Hashtable<Integer, Integer>();
    public static char alfabeto[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
        'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
        'w', 'x', 'y', 'z'};

    public static String encryption(String text, int offset) {
        text = text.toLowerCase();
        int i;
        char[] planeText = text.toCharArray();

        for (i = 0; i < planeText.length; i++) {
            planeText[i] = changeLetterE(planeText[i], offset);
        }
        return String.copyValueOf(planeText);
    }

    public static String decryption(String cipherText, int offset) {
        cipherText = cipherText.toLowerCase();
        System.out.println("Texto cifrado en metodo: " + cipherText);
        int i;
        char[] planeText = cipherText.toCharArray();

        for (i = 0; i < planeText.length; i++) {
            planeText[i] = changeLetterD(planeText[i], offset);
        }
        return String.copyValueOf(planeText);
    }

    //Construye el diccionario ASCII para cambiar las letras de acuerdo al offset.
    //
    public static void buildAlphabet(int offset, int modo) {
        int i;
        int j;
        int aux;
        //encryption
        if (modo == 1) {
            for (i = 26, j = 97; i < 52; i++, j++) {
                aux = (char) j;
                alfabetoASCII.put(i, aux);
            }
        }
        //decryption
        if (modo == 2) {
            for (i = 0, j = 97; i < 52; i++, j++) {
                aux = (char) j;
                alfabetoASCII.put(i, aux);
            }
        }

    }

    //Recibe una letra y la cambia según el offset.
    public static char changeLetterE(char letter, int offset) {
        int intLetter = (int) letter;
        intLetter += offset;

        if (letter < 97 || letter > 122) {
            return (char) letter;
        }
        if (letter == 32) {
            return (char) 32;
        } else {
            if (intLetter > 122) {
                intLetter = MonoAlphabeticCipher.alfabetoASCII.get(intLetter - 97);
                return (char) intLetter;
            }
        }
        return (char) intLetter;
    }

    public static char changeLetterD(char letter, int offset) {
        int intLetter = (int) letter;
        intLetter -= offset;

        if (letter < 97 || letter > 122) {
            return (char) letter;
        }
        if (letter == 32) {
            return (char) 32;
        } else {
            if (intLetter < 97) {
                intLetter = MonoAlphabeticCipher.alfabetoASCII.get(intLetter - 71);
                return (char) intLetter;
            }
        }

        return (char) intLetter;
    }

    public static String fuerzaBruta(String password) {
        int maxchr = 255;
        StringBuilder result = new StringBuilder();
        int length = 0;

        while (true) {
            if (password.equals(result) || length >= password.length()) {
                break;
            }

            for (int i = 0; i <= maxchr; i++) {
                char current = password.charAt(length);
                char chrMatch = (char) i;

                if (current == chrMatch) {
                    result.append(current);
                    length++;
                    break;
                }
            }
        }

        System.out.println(String.format("result: %s", result));
        return result.toString();
    }

}
