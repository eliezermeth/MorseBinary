package main.java.MorseBinary;

import java.util.*;

public class MorseOperator
{
    private final String[] morseRegularAlphabet = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-",
            ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

    private final String[] morseSpecialCharacters = {".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..",
            "----.", "-----", "--..--", "..--..", "---...", "-....-", ".-.-.-", "-.-.-.", "-..-.", ".----.", ".-..-.",
            "-.--.", "-...-", "-..-", "..--.-", "-.--.-", ".-.-.", ".--.-."};
    private final char[] morseSpecialLetters = {'1', '2', '3', '4','5', '6', '7', '8', '9', '0', ',', '?', ':', '-', '.',
            ';', '/', '\'', '"', '(', '=', '*', '_', ')', '+', '@'};


    private Map<Character, String> map = new LinkedHashMap<>();

    public static void main(String[] args)
    {
        new MorseOperator();
    }


    public MorseOperator()
    {
        // initialize map

        // regular letters
        for (int i = 0; i < 26; i++)
        {
            map.put((char) ('A' + i), morseRegularAlphabet[i]);
        }

        // characters
        for (int i = 0; i < morseSpecialCharacters.length; i++)
        {
            map.put(morseSpecialLetters[i], morseSpecialCharacters[i]);
        }

        map.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    public String getMorseCode(char letter)
    {
        return map.get(letter);
    }

    public char getCharacter(String morseCode)
    {
        for (Map.Entry<Character, String> entry : map.entrySet())
        {
            if (Objects.equals(morseCode, entry.getValue()))
                return entry.getKey();
        }
        return '\0'; // should never be reached
    }
}
