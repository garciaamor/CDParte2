package examenfinalparte2;

import javax.swing.JOptionPane;

/**
 * Clase que nos indicara y nos mostrara por pantalla todos los numeros primos que cumplan con la caracteristica que le indiquemos
 * El programa nos pedira introducir un numero mayor que 0 y nos mostrara por pantalla todos los numeros primos existentes con el numero de digitos que nosotros indicamos
 * @author jgarciaamor
 */
public class Principal {

    public static boolean p = false;
    /**
         * Se declaran dos variables, de tipo int y static, para asi poder tener el tronco del programa en metodos
         * 
         */
        static int numeroDigitos = 0;
        static int ndig = 0;
        
        
/**
 * El metodo main simplemente llama a los dos metodos en los que convertimos el programa:
 * El metodo Validar(), con el que se confirma el numero de digitos y se comprueba que sea el correcto para correr el programa
 * El metodo Calculo(), que contiene la mayor parte del codigo del programa y se encarga de, por medio de for, if y while de calcular y mostrar correctamente los numeros primos por orden
 * @param arg 
 */
    public static void main(String arg[]) {
        Validar();
        Calculo();
        
        
        
        
        
    }
    /**
     * El metodo a continuacion realiza un for para hacer el calculo de los numeros primos
     * El for a continuacion contempla hasta el numero 99999, es decir, 5 digitos, el programa no sirve para calcular un numero mayor     
     * El metodo es declarado static para poder trabajar con el m�s comodamente desde la misma clase
     * Este meto
     */
    
    public static void Calculo(){
    for (int i = 1; i <= 99999; i++) {
            int aux = i;

            int contador = 0;

            while (aux != 0) {
                aux = aux / 10;
                contador++;
            }
            ndig = contador;

            if (ndig == numeroDigitos) {
                if (i < 4) {
                    p = true;
                } else {
                    if (i % 2 == 0) {
                        p = false;
                    } else {
                        int contador1 = 0;
                        int i1 = 1;
                        int k = (i - 1) / 2;
                        if (k % 2 == 0) {
                            k--;
                        }

                        while (i1 <= k) {
                            if (i % i1 == 0) {
                                contador1++;
                            }
                            i1 += 2;
                            if (contador1 == 2) {
                                i1 = k + 1;
                            }
                        }

                        if (contador1 == 1) {
                            p = true;
                        }
                    }
                }

                if (p == true) {
                    System.out.println(i);
                }
            }
        }
    }
    /**
     * Metodo llamado Validar con el inicio del programa, es decir la validacion del numero de digitos y la asginacion del propio numero de digitos del que queremos saber los numeros primos
     */
    public static void Validar(){
        /**
         * Se le asigna a la variable dig un numero que nosotros le indicaremos por teclado
         */
        numeroDigitos = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese como parametro, un numero de digitos correcto (mayor que 0): "));
        
        /**
         * Cambiados el mensaje que nos muestra por consola y la condicion del if, para que sean mas exactos
         * El numero maximo de digitos establecido a 5, ya que el for del codigo no llega a los 6 digitos
         */
        if (numeroDigitos <= 0 ||numeroDigitos>5) {
            System.out.println("Ingrese como parámetro, un numero de digitos entre 1 y 5 : ");
        }
    }
}
