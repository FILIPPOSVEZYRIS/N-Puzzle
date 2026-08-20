import java.util.*;

public class PuzzleSolver{
    static final int[] goalState = {1,2,3,6,5,4,7,0,8};
    
    
    
    public static void solve(int[] unsolvedPuzzle, boolean useA){
        int extensions = 0;

        PriorityQueue<State> unvisited = new PriorityQueue<>(Comparator.comparingDouble(State::getF));
        Set<State> visited = new HashSet<>();//aytes poy episkeftikame kai den prepei na ksanapame

        double startH = useA ? heuristic(unsolvedPuzzle) : 0;//an useA = true xrisimopoiw to heuristic gia to startH alliws 0 

        unvisited.add(new State(unsolvedPuzzle,0,startH,null));//states poy den exoyme episkeftei

        while(!unvisited.isEmpty()){
            State currentState = unvisited.poll();

            if(Arrays.equals(currentState.puzzle, goalState)){
                printSolution(currentState,extensions);
                return;
            }
            
            if(visited.contains(currentState)) continue;//elegxos an to currentState einai sta visited an oxi to bazoyme
            visited.add(currentState);
            extensions++;

            for(Action action : validActions(currentState.emptyPos)){
                int[] nextBoard = currentState.puzzle.clone();
                int targetPos = action.targetPos;
                int emptyPos = currentState.emptyPos;

                //antallagh toy adeioy koytioy me to katallhlo koyti
                nextBoard[emptyPos] = nextBoard[targetPos];
                nextBoard[targetPos] = 0;

                double moveCost = action.cost;
                double nextH = useA ? heuristic(nextBoard) : 0;

                unvisited.add(new State(nextBoard, currentState.g + moveCost, nextH, currentState));
            }
        }
    }

    //method poy deixnei tis egkyres kiniseis apo mia thesi k einai grammeno gia na xrhsimopoihthei apo to emptyPos
    static List<Action> validActions(int pos){
        List<Action> actions = new ArrayList<>();
        int row = pos/3;
        int col = pos%3;

        int[][] directions = {{-1,0}, {1,0},{0,-1},{0,1}};
        for(int[] d : directions){
            int newRow = row + d[0];
            int newCol = col + d[1];
            if(newRow >= 0 && newRow < 3 && newCol >= 0 && newCol < 3){
                int newpos = newRow*3 + newCol;
                actions.add(new Action(newpos, 1.0));
            }
        }
        //kiniseis apo akro grammis h stilis
        if(col == 0) actions.add(new Action((row*3 + 2), 1.0));
        if(col == 2) actions.add(new Action((row*3 + 0), 1.0));
        if(row == 0) actions.add(new Action((6 + col), 1.0));
        if(row == 2) actions.add(new Action((0 + col), 1.0));

        //telepo0rtation

        if(pos == 0) actions.add(new Action(8,0.5));
        if(pos == 8) actions.add(new Action(0,0.5));

        return actions;
    }

    //method gia na breis thn heuristic synartisi h
    public static double heuristic(int[] puzzle){
        int misplaced = 0;
        for(int i=0;i<9;i++){
            if(puzzle[i] != 0 && puzzle[i] != goalState[i]) misplaced++;
        }
        return misplaced * 0.5;//to elaxisto kostos einai 0.5 logo toy teleport
    }

    //edw ginetai to teliko print
    public static void printSolution(State s, int ext){
        List<State> path = new ArrayList<>();
        State temp = s;
        while(temp != null){
            path.add(0,temp);//mpainei sth prwth thesi kathe fora to temp
            temp = temp.parent;
        }
        for(int i=0;i<path.size();i++){
            State state = path.get(i);
            for(int j = 0;j<state.puzzle.length;j++){
                System.out.print("" + state.puzzle[j]);
            }
            System.out.println("");
        }
        System.out.println("Synoliko Kostos: " + s.g);
        System.out.println("SYnolikes Extensions: " + ext);
    }



}