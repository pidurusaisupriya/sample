package com.training.utils;

import java.util.*;

/**
 * Class for sample project
 * Created by sudheer on 17/12/16.
 */
public class StringOperations {
    public static void main(String[] args) {
        StringOperations operations = new StringOperations ( );
        /*String input = "Sudheer;Supraja;Supriya;Sample1;sample2;sample3";
        List<String> result = operations.getArrayImpl2 ( input,';');
        System.out.println ( Arrays.toString ( result.toArray () ) );
        System.out.println ( Arrays.toString ( input.split ( ";" ) ) );*/
        String sample = "Sudheer is writing something";
        /*System.out.println ( operations.substr1 ( 5, sample ) );
        System.out.println ( operations.substr2 (  sample ,11) );
        System.out.println ( operations.substr3 ( 5,10,sample ) );
        System.out.println ( operations.substr4 ( "writing", sample ) );
        System.out.println ( operations.substr5 ( "writing", sample ) );

        System.out.println ( "*********************************" );

        System.out.println ( sample.substring ( 5 ) );
        System.out.println ( sample.substring ( 0,11 ) );
        System.out.println ( sample.substring ( 5,10 ) );
        System.out.println ( sample.substring ( sample.indexOf ( "writing" ) ) );*/
        /*System.out.println ( "*********************************" );
        StringBuilder builder = new StringBuilder ( sample );
        System.out.println ( builder.toString ( ) );
        System.out.println ( builder.reverse ( ).toString ( ) );
        char c = 's';
        System.out.println ( builder.replace ( 0, 6, "Somebody" ).toString ( ) );
        System.out.println ( sample.replaceAll ( "s", "S" ) )*/
        ;
        //System.out.println ( operations.countCharOccurances ( sample ) );
        //System.out.println ( operations.getDuplicates1 ( sample ) );
        //System.out.println ( operations.getDuplicates2 ( sample ) );
       //System.out.println ( operations.areAnagram ( "School MASTER", "The ClassROOM" ) );
        //System.out.println ( operations.areAnagram ( "madam", "madam" ) );
        //System.out.println ( operations.areAnagram ( "sudheer", "test" ) );
       // System.out.println ( operations.reverseEachWordOfString ("sudheer is here"));
       // operations.printvowelConsonantCount ("sudheer");
        List<String> list = new ArrayList<> (  );
        list.add ( "abc" );
        list.add ( "def" );
        System.out.println ( operations.isSortedStrings(list, "cabdef") );
        System.out.println ( operations.isSortedStrings(list, "badcaf") );

    }

    private boolean isSortedStrings(List<String> list, String checkString) {
        int beginIndex = 0;
        for (String s: list) {
            int length =s.length ();
            String subString = checkString.substring ( beginIndex, length+beginIndex );
            boolean valid=areAnagram (  s,subString );
            if(!valid){
                return false;
            }
            beginIndex = beginIndex+length;
        }
        return true;
    }

    public void printLength(String input) {
        System.out.println ( input.length ( ) );
    }

    public String reverseWithStringClass(String sample) {
        int length = sample.length ( );
        StringBuilder builder = new StringBuilder ( );
        for (int i = length; i > 0; i--) {
            builder.append ( sample.charAt ( i - 1 ) );
        }
        return builder.toString ( );
    }

    public String[] getArrayImpl1(String input) {


        int length = input.length ( );
        String[] students = new String[6];
        String s = new String ( );
        int counter = 0;
        for (int i = 0; i < length; i++) {

            char c = input.charAt ( i );
            if (c == ',') {
                System.out.println ( "Adding to array : " + s + "at position " + counter );
                students[counter++] = s;
                System.out.println ( "array now : " + Arrays.toString ( students ) );
                s = new String ( );
            } else {
                s = s + c;
            }

        }
        students[counter] = s;
        return students;
    }

    public List<String> getArrayImpl2(String input, char symbol) {
        List<String> students = new ArrayList<String> ( );
        String s = new String ( );
        for (int i = 0; i < input.length ( ); i++) {
            char c = input.charAt ( i );
            if (c == symbol) {
                students.add ( s );
                s = new String ( );
            } else {
                s = s + c;
            }
        }
        students.add ( s );
        return students;

    }

    public String substr1(int start, String sample) {
        String s = new String ( );
        for (int i = start - 1; i < sample.length ( ); i++) {
            s = s + sample.charAt ( i );
        }
        return s;

    }

    public String substr2(String sample, int end) {
        String s = new String ( );
        for (int i = 0; i < end; i++) {
            s = s + sample.charAt ( i );
        }
        return s;

    }

    public String substr3(int stat, int end, String sample) {
        String s = new String ( );
        for (int i = stat - 1; i < end; i++) {
            s = s + sample.charAt ( i );
        }
        return s;
    }

    public String substr4(String match, String sample) {
        int stat = sample.indexOf ( match );
        String s = new String ( );
        for (int i = stat - 1; i < sample.length ( ); i++) {
            s = s + sample.charAt ( i );
        }
        return s;
    }

    public String substr5(String match, String sample) {
        int stat = sample.indexOf ( match );
        String s = new String ( );
        for (int i = 0; i < stat; i++) {
            s = s + sample.charAt ( i );
        }
        return s;
    }


    public Map<Character, Integer> countCharOccurances(String input) {
        input = input.toUpperCase ( );
        Map<Character, Integer> characterIntegerMap = new HashMap<> ( );
        char[] strArray = input.toCharArray ( );

        for (char c : strArray) {
            if (characterIntegerMap.containsKey ( c )) {

                characterIntegerMap.put ( c, characterIntegerMap.get ( c ) + 1 );
            } else {

                characterIntegerMap.put ( c, 1 );
            }
        }

        return characterIntegerMap;
    }


    public List<Character> getDuplicates1(String input) {
        List<Character> duplicates = new ArrayList<> ( );
        Map<Character, Integer> charMap = countCharOccurances ( input );
        Set<Character> set = charMap.keySet ( );
        for (Character c : set) {
            int value = charMap.get ( c );
            if (value > 1) {
                duplicates.add ( c );
            }
        }
        return duplicates;
    }

    public Set<Character> getDuplicates2(String input) {
        input = input.toUpperCase ( );
        Set<Character> duplicates = new HashSet<> ( );
        Set<Character> set = new HashSet<> ( );
        for (int i = 0; i < input.length ( ); i++) {
            char c = input.charAt ( i );
            if (!set.add ( c )) {
                duplicates.add ( c );
            }
        }
        return duplicates;
    }

    public boolean areAnagram(String a, String b) {
        String copyOfa = a.replaceAll ( " ", "" ).toLowerCase ( );
        String copyOfb = b.replaceAll ( " ", "" ).toLowerCase ( );
        boolean status = true;
        if (copyOfa.length ( ) != copyOfb.length ( )) {

            status = false;
        } else {
            char[] aToArray = copyOfa.toCharArray ( );

            for (char c : aToArray) {
                int index = copyOfb.indexOf ( c );

                if (index != -1) {

                    copyOfb = copyOfb.substring ( 0, index ) + copyOfb.substring ( index + 1, copyOfb.length ( ) );
                } else {

                    status = false;

                    break;
                }
            }
        }
        return status;
    }

    public static String reverseEachWordOfString(String input) {
        String[] words = input.split ( " " );

        StringBuilder reverseString = new StringBuilder (  );

        for (int i = 0; i < words.length; i++) {
            StringBuilder word = new StringBuilder ( words[i] );
            reverseString.append ( word.reverse () );
            reverseString.append ( " " );
        }
        return reverseString.toString ();

    }

    public static void printvowelConsonantCount(String input){
        int vowels = 0;
        int consonants = 0;
        for (int i = 0; i < input.length(); i++)
        {
            char ch = input.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' ||
                ch == 'o' || ch == 'u')
            {
                vowels++;
            }
            else
            {
                consonants++;
            }
        }
        System.out.println ( "Vowels : "+vowels );
        System.out.println ( "Consonants : "+consonants );


    }


}
