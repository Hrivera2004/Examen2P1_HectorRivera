//fila 1 silla 1
//12341097 Hector Rolando Rivera Varela
package ex2p1_hectorrivera;
import java.util.Scanner;
public class Ex2P1_HectorRivera {
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        int choose = 0;

        System.out.println("------------------Menu-----------------");
        System.out.println("1.||- - - -Kingdom Heart Recoded- - - -||");
        System.out.println("2.Exit");
        int opc = sc.nextInt();
        while (opc!=2){
            switch(opc){
                case 1:
                    
                    Personaje Characters = new Personaje();
                    Items Objetos = new Items();
                    Characters.start();
                    Objetos.start();
                    for (int i = 1; i <= 20; i++) {
                        System.out.println("Cuarto "+i);
                        Characters.Play();
                    }
                    
                    break;
                default:
                    System.out.println("Ingrese opcion valida");
            }
            System.out.println("------------------Menu-----------------");
            System.out.println("1.||- - - -Kingdom Heart Recoded- - - -||");
            System.out.println("2.Exit");
            opc = sc.nextInt();
        }
    }
    

}
