package lexem;
/**
 *
 * @author Gonzalo
 */

public class Tipo {

    static String reservada[] = {"PROGRAM", "ARRAY","VAR","CONST","BEGIN","END", "INTEGER", "IF", "THEN", "REAL", "STEP", "CASE", "ELSE", "CHAR", "FOR", "TO", "DO", "WHILE", "REPEAT", "UNTIL"};
    static String[] relacional = {"<=", "<>", "<", ">=", ">", "=", ":=", ";"};
    static String operador[] = {"+", "-", "*", "/"};

    static boolean flujo = true;
    public static void tipo(String lexema) {
    if (flujo == false){
      flujo = true;
    }
        for (int i = 0; i < 6; i++) {
            switch (i) {
                case 0:
                    palabraReservada(lexema);
                    break;
                case 1:
                    palabraRelacional(lexema);
                    break;
                case 2:
                    operadorNumerico(lexema);
                    break;
                case 3:
                literal(lexema);
                    break;
                case 4:
                    numero(lexema);
                    break;
                case 5:
                    id(lexema);
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }
    public static void palabraReservada(String l) {
        for (int i = 0; i < reservada.length; i++) {
            if (reservada[i].equals(l)) {
               flujo = false;       
                System.out.println(l + "\t" + l + "\t Reservada");
                break;
            }
        }
    }
    public static void palabraRelacional(String l) {
        for (int i = 0; i < relacional.length; i++) {
            if (relacional[i].equals(l)) {
               flujo = false;       
                System.out.println(l + "\t" + "Relac\t" + "\t Relacional");
                break;
            }
        }
    }
    public static void operadorNumerico(String l) {
        for (int i = 0; i < operador.length; i++) {
            if (operador[i].equals(l)) {
               flujo = false;
                System.out.println(l + "\t" + "Op\t" + "\t Operador");
                break;
            }
        }
    }
    public static void id(String l) {
        int aux1;
        aux1 = (int) l.charAt(0);
        if (flujo == true) {
            System.out.println(l + "\t" + "Id\t" + "\t Identificador");
        }
    }
    public static void numero(String l) {
        int aux1;
        aux1 = (int) l.charAt(0);
        if (aux1 != 34 && aux1 >= 48 && aux1 <= 57) {
               flujo = false;
            System.out.println(l + "\t" + "Num\t" + "\t Numero");
        }
    }
    public static void literal(String l) {
        int aux1, aux2;
        aux1 = (int) l.charAt(0);
        aux2 = (int) l.charAt(l.length() - 1);
        if (aux1 == 34 && aux2 == 34) {
               flujo = false;
            System.out.println(l + "\t" + "Literal\t" + "\t Literal");
        }
    }
}
