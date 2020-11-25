package hse.cs.se.seminar2;

public class Sample_3_VariableNames {

    public static void main(String[] args){
        System.out.println((char)65);
        System.out.println((char)66);
        System.out.println((char)67);
        System.out.println("Character.isJavaIdentifierStart('8') -> " + Character.isJavaIdentifierStart('8'));
        System.out.println("Character.isJavaIdentifierPart('8') -> " + Character.isJavaIdentifierPart('8'));
        char c = '\u0008'; // это символ "зобой" (см. https://unicode-table.com/ru/#0008 )
        System.out.println(c);
    }
}
