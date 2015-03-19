package ajr.mapp;

import java.util.LinkedList;
import java.util.List;


public class Util {

    /**Función que averigua si un entero es primo
     *
     * @param 	n
     * 			Número que se va a comprobar que sea primo.
     * 			-Debe ser mayor que 0
     *
     * @throws	IllegalArgumentException
     * 			Salta excepción si el número es negativo.
     *
     * @return	Devuelve true si es primo.
     *
     * @since 7/I/2015
     * @author Andrés M. Jiménez
     */
    public static Boolean esPrimo(Integer n){
        //checkArgument(n>=0);

        Boolean res=false;
        Integer cont=0;

        for(int j=2; j<=Math.sqrt(n);j++) {
            if (n%j==0) {
                cont++;
                break;
            }
        }

        if (cont==0){
            res=true;
        }

        if (n==1 || n==0) {
            res=false;
        }
        return res;
    }


    /**Función que calcula la descomposición en primos de un número dado
     *
     * @param 	n
     * 			Número que se va a descomponer
     * 			-Debe ser mayor que 0
     *
     * @throws	IllegalArgumentException
     * 			Salta excepción si el número es negativo.
     *
     * @return	Devuelve la lista de los primos en que se puede factorizar
     *
     * @since 7/I/2015
     * @author Andrés M. Jiménez
     */
    public static List<Integer> factorizacion(Integer n) {
        //checkArgument(n>=0);

        List<Integer> res=new LinkedList<Integer>();
        Integer a=n;

        for(int i=2; a>1; i++) {
            while(a%i==0) {
                res.add(i);
                a/=i;
            }
        }

        if(n==0 || n==1) {
            res.add(n);
        }

        return res;
    }


    /**Función que pasa a binario un número
     *
     * @param 	n
     * 			Número que se va a pasar a binario
     * 			-Debe ser mayor que 0
     *
     * @throws	IllegalArgumentException
     * 			Salta excepción si el número es negativo.
     *
     * @return	Devuelve un String del número en binario
     *
     * @since 7/I/2015
     * @author Andrés M. Jiménez
     */
    public static Integer decimalABinario(Integer n) {
        //checkArgument(n>=0);

        String res="";
        String aux="";

        while(n>=1) {
            if(n%2==0) {
                aux=aux+'0';
            } else{
                aux=aux+'1';
            }

            n=(int)Math.floor(n/2);
        }

        for(int i=aux.length()-1; i>=0; i--) {
            res=res+aux.charAt(i);
        }

        return new Integer (res);
    }


    /**Función que pasa a binario un número
     *
     * @param 	n
     * 			Número que se va a pasar a binario
     * 			-Debe ser binario natural
     *
     * @throws	IllegalArgumentException
     * 			Salta excepción si el número no es binario
     *
     * @return	Devuelve un String del número en decimal
     *
     * @since 7/I/2015
     * @author Andrés M. Jiménez
     */
    public static Integer binarioADecimal(Integer n){
        //checkArgument(esBinario(n.toString()));

        Integer res=0;
        String aux=n.toString();

        for(int i=aux.length()-1; i>=0; i--){
            if(aux.charAt(i)=='1'){
                res=res+(int)Math.pow(2,aux.length()-i-1);
            }
        }

        return res;
    }

    public static Boolean esBinario(String n) {
        Boolean r=true;

        for(int i=0; i<n.length(); i++) {
            if(!(n.charAt(i)=='1' || n.charAt(i)=='0')) {
                r=false;
                break;
            }
        }

        return r;
    }


    /**Función que calcula una potencia de 2
     *
     * @param 	n
     * 			Exponente de 2
     * 			-Debe ser mayor que 0
     *
     * @throws	IllegalArgumentException
     * 			Salta excepción si el número es negativo
     *
     * @return	Devuelve un la 2 elevado a n
     *
     * @since 7/I/2015
     * @author Andrés M. Jiménez
     */
    public static Integer pot2(Integer n) {
        //checkArgument(n>=0);

        return (int) (Math.pow(2, n));
    }


    /**Función que calcula un número aleatorio dentro de un intervalo cerrado
     *
     * @param 	minimo
     * 			Máximo del intervalo
     * @param	maximo
     * 			Mínmo del intervalo
     *
     * @throws	IllegalArgumentException
     * 			Salta excepción si mínimo es mayor o igual al máximo
     *
     * @return	Devuelve el número aletorio
     *
     * @since 7/I/2015
     * @author Andrés M. Jiménez
     */
    public static Integer numeroAleatorio(int minimo, int maximo){
        //checkArgument(max>min);

        //Para que sea un intervalo cerrado
        int m=maximo+1;
        return (int) (minimo + ((m-minimo)*Math.random()));
    }
}
