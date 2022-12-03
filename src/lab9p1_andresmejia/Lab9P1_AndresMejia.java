// Andres Mejia
package lab9p1_andresmejia;
import java.util.Scanner;
import java.security.SecureRandom;
import java.util.ArrayList;


public class Lab9P1_AndresMejia {
    static Scanner read=new Scanner(System.in);
    static SecureRandom random=new SecureRandom();
    static Game g= new Game();
    
    
    public static void main(String[] args) {
        int opcion;
        
        do{
            System.out.println("Opcion 1: Game of Life");
            System.out.println("Opcion 2: Salir");
            System.out.println("Ingrese la opcion: ");
            opcion=read.nextInt();
            
            switch(opcion){
                case 1:{
                    int [][] matriz=new int[10][10];
                    
                    int [][]next=new int [10][10];
                    
                    ArrayList<String> coordenadas=new ArrayList();
                    
                    matriz=llenado(matriz, next, coordenadas);
                    g.setBoard(matriz);
                    
                    System.out.println("Ingrese cuantas rondas quiere jugar: ");
                    int rondas=read.nextInt();
                    g.setRondas(rondas);
                    
                    System.out.println("Coordenadas de tablero inicial: ");
                    g.print(coordenadas);
                    System.out.println("");
                    
                    g.jugar();
                    System.out.println("");
                    break;
                }
                
            }
            
        }while(opcion!=2);
    } //Fin del main
    
    
    public static int [][] llenado(int [][]matriz, int [][]next, ArrayList<String> coordenadas){
        
        for(int i=0; i<matriz.length; i++){
            for(int j=0; j<matriz[0].length; j++){
                if(i==0 || j==0 || i==matriz.length-1|| j==matriz[0].length-1){
                    matriz[i][j]=0;
                }
                else{
                    matriz[i][j]=random.nextInt(2);
                }
                next[i][j]=0;
                if(matriz[i][j]==1){
                    coordenadas.add(i+":"+j);
                }
                //coordenadas.clear();
            }
        }
   //     g.setCoordenadas(coordenadas);
        return matriz;
    }
    
    
    
    
    
    
}
