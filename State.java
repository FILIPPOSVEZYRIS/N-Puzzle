import java.util.*;
public class State{
    int[] puzzle;//arxikos pinakas poy bazoume san input
    int emptyPos;//to - ston pinaka

    double g,h;

    State parent;
        

    State(int[] puzzle, double g,double h, State parent){
        this.puzzle = puzzle;
        this.g = g;
        this.h = h;
        this.parent = parent;
        
        for(int i=0;i<puzzle.length;i++) if(puzzle[i] == 0) this.emptyPos = i;// to emptyIndex exei tin thesi tou 0
            
    }
            
    public boolean equals(Object o){//prepei na ginei overide gia na leitoyrgei gia Hashmap
        return Arrays.equals(this.puzzle,((State) o).puzzle);
    }

    double getF(){
        return g + h;
    }
            
    public int hashCode(){
        return Arrays.hashCode(puzzle);
    }
}