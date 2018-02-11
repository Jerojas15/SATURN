package controller;

import static controller.AlgorithmController.capacity;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import javafx.util.Pair;

public class GeneticAlgorithm {
    private static int CLASSROOM;//Aulas disponibles
    private final static int PERIODS = 30;//Periodos de media hora disponibles
    private final static int DAYS = 6;//Dias de la semana disponibles
    
    ArrayList<Integer> groupSessions;
    ArrayList<Integer> capacity = new ArrayList<>();//Capacidad de cada aula
    ArrayList<Pair<Integer,Integer>> groups = new ArrayList<>();//capacidad de los grupos a insertar
    ArrayList<Pair<Integer,Pair<Integer,Pair<Integer, Integer>>>> sessions = new ArrayList<>();//sesiones de grupos, con par(ID,(duracion, (idGrupo, Profesor)))
    ArrayList<Pair<Integer,Pair<Integer,Pair<Integer,Integer>>>> professor = new ArrayList<>();//disponibilidad de profesores, (ID,(Dia,(inicio,salida)))
    
    public GeneticAlgorithm(ArrayList<Integer> groupSessions,
                            ArrayList<Integer> capacity, ArrayList<Pair<Integer,Integer>>groups, 
                            ArrayList<Pair<Integer,Pair<Integer,Pair<Integer, Integer>>>> sessions, 
                            ArrayList<Pair<Integer,Pair<Integer,Pair<Integer,Integer>>>> professor){
        this.groupSessions = groupSessions;
        this.capacity = capacity;
        this.groups = groups;
        this.sessions = sessions;
        this.professor = professor;
        CLASSROOM = AlgorithmController.CLASSROOM;
    }
    
    public Individual getBestIndividual(ArrayList<Individual>generation){
        Individual best = generation.get(0);
        int bestPosition = 0;
        for(int i = 1;i<generation.size();i++){
            if(best.value()>generation.get(i).value()){
                best=generation.get(i);
                bestPosition = i;
            }
        }
        return best;
    }
    
    private Pair<Integer,Pair<Integer,Pair<Integer, Integer>>> findSession(int session){
        for(int i = 0;i<sessions.size();i++){
            if(sessions.get(i).getKey() == session){
                return sessions.get(i);
            }
        }
        return null;
    }
    
    private ArrayList<Individual> cross(ArrayList<Individual> parents) throws SQLException, ClassNotFoundException{
        Random rand = new Random();
        
        ArrayList<Individual> newGeneration = new ArrayList<>();//generacion resultante
        
        int first, second;//random para saber los padres
        boolean choice;//random para saber el horario de que padre escogio
        Individual firstParent, secondParent;//padres
        int[][][] selected, notSelected;//hijos nuevos
        
        while(parents.size()>1){//mientras queden padres
            
            ArrayList<Pair<Integer,Pair<Integer,Pair<Integer, Integer>>>> newSessions = new ArrayList<>();//lista nueva para generar los hijos nuevos
            ArrayList<Pair<Integer,Pair<Integer,Pair<Integer, Integer>>>> newSecondSessions = new ArrayList<>();//lista nueva para generar los hijos nuevos
            first = rand.nextInt(parents.size());//saca padre 1
            firstParent = parents.get(first);
            parents.remove(first);
            
            second = rand.nextInt(parents.size());//saca padre 2
            secondParent = parents.get(second);
            parents.remove(second);
            
            ArrayList<Integer> firstSon = new ArrayList<>();
            ArrayList<Integer> secondSon = new ArrayList<>();
            int firstLast = -1, secondLast = -1;
            for (int i= 0; i<DAYS;i++){//DIAS  Saca lista de sesiones que tiene cada padre
                for (int j= 0; j<CLASSROOM;j++){//AULAS
                    for (int k=0; k<PERIODS;k++){//PERIODOS
                        if(firstParent.getIndividual()[i][j][k] != 0 && firstParent.getIndividual()[i][j][k] != firstLast){
                            firstLast = firstParent.getIndividual()[i][j][k];
                            firstSon.add(firstLast);
                        }
                        if(secondParent.getIndividual()[i][j][k] != 0 && secondParent.getIndividual()[i][j][k] != secondLast){
                            secondLast = secondParent.getIndividual()[i][j][k];
                            secondSon.add(secondLast);
                        }
                    }
                }
            }
            for(int i = 0;i<Math.max(firstSon.size(), secondSon.size());i++){//llena las sesiones de los nuevos hijos
                choice = rand.nextBoolean();
                if(choice){
                    if(i<firstSon.size()){newSessions.add(findSession(firstSon.get(i)));}
                    if(i<secondSon.size()){newSecondSessions.add(findSession(secondSon.get(i)));}
                }else{
                    if(i<secondSon.size()){newSessions.add(findSession(secondSon.get(i)));}
                    if(i<firstSon.size()){newSecondSessions.add(findSession(firstSon.get(i)));}
                }
            }
            ArrayList<Pair<Integer,Pair<Integer,Pair<Integer, Integer>>>> leftSessions = firstParent.getLeftSession();//lista nueva para generar los hijos nuevos
            ArrayList<Pair<Integer,Pair<Integer,Pair<Integer, Integer>>>> leftSecondSessions = secondParent.getLeftSession();//lista nueva para generar los hijos nuevos
            
            
            for(int i = 0;i<Math.max(leftSessions.size(), leftSecondSessions.size());i++){//llena las sesiones que no se asignaron de los nuevos hijos
                choice = rand.nextBoolean();
                if(choice){
                    if(i<leftSessions.size()){newSessions.add(leftSessions.get(i));}
                    if(i<leftSecondSessions.size()){newSecondSessions.add(leftSecondSessions.get(i));}
                }else{
                    if(i<leftSecondSessions.size()){newSessions.add(leftSecondSessions.get(i));}
                    if(i<leftSessions.size()){newSecondSessions.add(leftSessions.get(i));}
                }
            }
            
            Individual newSon = new Individual(groupSessions, professor, capacity, groups, new ArrayList<>(newSessions));//crea los nuevos hijos
            newSon.setLeft_sessions(leftSessions);
            Individual newSecondSon = new Individual(groupSessions, professor, capacity, groups, new ArrayList<>(newSecondSessions));
            newSon.setLeft_sessions(leftSecondSessions);
            newGeneration.add(newSon);
            newGeneration.add(newSecondSon);
        }
        
        return newGeneration;
    }
    
    
    public ArrayList<Individual> StartAlgorithm(int size, int need) throws SQLException, ClassNotFoundException{
        ArrayList<Individual> generation = new ArrayList<>();
        ArrayList<Individual> newGeneration = new ArrayList<>(); 
        ArrayList<Individual> result = new ArrayList<>(); 
        for(int  i = 0;i<size;i++){//crea la primera poblacion
            generation.add(new Individual(groupSessions, professor, capacity, groups, new ArrayList<>(sessions)));
        }
        
        for(int i = 0;i<2;i++){
              newGeneration = cross(generation);
              generation = newGeneration;
        }
        for(int i = 0;i<need;i++){
            result.add(newGeneration.get(i));
        }
        return result;
    }
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException{
        DatabaseController d = new DatabaseController();
        ArrayList<Integer> groups = new ArrayList<>();
        groups = d.getGroupIdBySession();
        GeneticAlgorithm solve = new GeneticAlgorithm(groups, d.getClassroomCapacity(), d.getGroupCapacity(), d.getSessionData(), d.getProfessorData());
        ArrayList<Individual> solution = solve.StartAlgorithm(10, 4);
        System.out.println("HOOOLAAAAA");
        for(int i = 0;i<solution.size();i++){
            solution.get(i).show_ind();
            System.out.println();
        }
    }
    
}
