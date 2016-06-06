package examenfinalparte2;

import javax.swing.JOptionPane;

/**
 * Clase que nos indicara y nos mostrara por pantalla todos los numeros primos que cumplan con la caracteristica que le indiquemos
 * El programa nos pedira introducir un numero mayor que 0 y nos mostrara por pantalla todos los numeros primos existentes con el numero de digitos que nosotros indicamos
 * @author jgarciaamor
 */
public class Principal {

    public static boolean numPrimo = false;
    /**
         * Se declaran dos variables, de tipo int y static, para asi poder tener el tronco del programa en metodos
         * 
         */
        static int numeroDigitos = 0;
        static int numComparacion = 0;
        
        
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
     * El for a continuacion contempla hasta el numero 99999, es decir, 5 digitos, el programa no sirve para calcular un numero mayor, ya que el numero de valores a devolver seria demasiado alto y haria el programa muy lento    
     * El metodo es declarado static para poder trabajar con el m�s comodamente desde la misma clase
     * La variable de tipo int divisNoDecimal comprueba que el numero es un numero entero
     * El boolean numPrimo es el que nos indicara al final si el numero comparado es primo; de serlo, cambiara su valor a true y se nos devolvera por pantalla la variable numero
     */
    
    public static void Calculo(){
    for (int numero = 1; numero <= 99999; numero++) {
            int divisNoDecimal = numero;

            int contador = 0;

            while (divisNoDecimal != 0) {
                divisNoDecimal = divisNoDecimal / 10;
                contador++;
            }
            numComparacion = contador;

            if (numComparacion == numeroDigitos) {
                if (numero < 4) {
                    numPrimo = true;
                } else {
                    if (numero % 2 == 0) {
                        numPrimo = false;
                    } else {
                        int contador1 = 0;
                        int divisores = 1;
                        int compPar = (numero - 1) / 2;
                        if (compPar % 2 == 0) {
                            compPar--;
                        }

                        while (divisores <= compPar) {
                            if (numero % divisores == 0) {
                                contador1++;
                            }
                            divisores += 2;
                            if (contador1 == 2) {
                                divisores = compPar + 1;
                            }
                        }

                        if (contador1 == 1) {
                            numPrimo = true;
                        }
                    }
                }

                if (numPrimo == true) {
                    System.out.println(numero);
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
