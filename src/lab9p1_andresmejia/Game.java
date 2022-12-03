// Constructor
package lab9p1_andresmejia;

import java.util.ArrayList;

public class Game {
    
    public int[][] board;
    public int[][]next=new int[10][10];
    public int rondas;
    ArrayList<String> coordenadas=new ArrayList();

    public Game(){
        
    }
    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    public int[][] getNext() {
        return next;
    }

    public void setNext(int[][] next) {
        this.next = next;
    }

    public int getRondas() {
        return rondas;
    }

    public void setRondas(int rondas) {
        this.rondas = rondas;
    }

    public ArrayList<String> getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(ArrayList<String> coordenadas) {
        this.coordenadas = coordenadas;
    }
    
    public void print(ArrayList<String> coordenadas){
        int [][]temporal=new int[10][10];
        System.out.println(coordenadas);
        for(int i=0; i<coordenadas.size(); i++){
            String[] coords=coordenadas.get(i).split(":");
            temporal[Integer.parseInt(coords[0])][Integer.parseInt(coords[1])]=1;
        }
        for(int j=0; j<10; j++){
            for(int k=0; k<10; k++){
                System.out.print("["+temporal[j][k]+"]");
            }
            System.out.println("");
        }
        
    } //Fin del print
    
    public void nextgen(){
        coordenadas.clear();
        int contador=0;
        for(int i=1; i<9; i++){
            for(int j=1; j<9; j++){
                contador =0;
                if(i==0|| j==0|| i==board.length-1|| j==board[0].length-1){
                    next[i][j]=0;
                }
                else if(board[i][j]==1){
                    
                    for(int x=-1; x<=1; x++){
                        for(int y=-1; y<=1; y++){
                            if(board[x+i][y+j]==1){
                                contador++;
                            }
                        }
                    }
                    contador--;
                   // System.out.println(i+" "+j+" "+contador);
                    
                    if(contador<2){
                        next[i][j]=0;
                    }
                    if(contador>3){
                        next[i][j]=0;
                    }
                    if(contador==2||contador==3){
                        next[i][j]=1;
                    }
                    
                }
                
                else if(board[i][j]==0){
                    for(int x=i-1; x<=i+1; x++){
                        for(int y=j-1; y<=j+1; y++){
                            if(board[x][y]==1){
                                contador++;
                            }
                        }
                    }
                    if(contador==3){
                        next[i][j]=1;
                    }
                    else{
                        next[i][j]=0;
                    }
                }
                if(next[i][j]==1){
                    coordenadas.add(i+":"+j);
                }
                               
            }
        }
        int[][]temp=board;
        board=next;
        next=temp;
    }
    
    public void jugar(){
        for(int i=0; i<rondas; i++){
            nextgen();
            System.out.println("Ronda "+(i+1));
            System.out.println("Coordenadas de celdas vivas: ");
            print(coordenadas);
            System.out.println("");
        }
        
        
    }
        
}
