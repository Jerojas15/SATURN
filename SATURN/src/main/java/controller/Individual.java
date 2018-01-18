package controller;

import java.util.ArrayList;
import java.util.Random;
import javafx.util.Pair;

public class Individual {
    private final static int CLASSROOM =5;//Aulas disponibles
    private final static int PERIODS = 30;//Periodos de media hora disponibles
    private final static int DAYS = 6;//Dias de la semana disponibles
    
    int[][][] ind = new int[DAYS][CLASSROOM][PERIODS];//Individuo, el valor es el grupo correspondiente
    
    private ArrayList<Integer> capacity;//Capacidad de cada aula
    
    private ArrayList<Pair<Integer,Integer>> groups;//capacidad de los grupos a insertar
    
    private ArrayList<Pair<Integer,Pair<Integer,Pair<Integer, Integer>>>> sessions;//sesiones de grupos, con par(ID, (duracion, (idGrupo, idProfesor)))
    
    private ArrayList<Pair<Integer,Pair<Integer,Pair<Integer, Integer>>>> left_sessions;//sesiones que no caben para ser asignadas
    
    private ArrayList<Pair<Integer,Pair<Integer,Pair<Integer,Integer>>>> professor;//disponibilidad del profesor
    
    public int value(){
        return sessions.size();
    }
    
    private boolean canBeSet(int i, int j, int k, int remaining_time){
        if(k+remaining_time<PERIODS){
            for(;remaining_time>0;k++,remaining_time--){
                if(ind[i][j][k] != 0){
                    return false;
                }
            }
        }else{
            return false;
        }
        return true;
    }
    //(ID,(Dia,(inicio,salida)))
    private boolean hasDisponibility(int day, int entry, int exit, int prof){
        for(int i = 0;i < professor.size ();i++){
            if(professor.get(i).getKey()==prof){
                if(professor.get(i).getValue().getKey() == day){
                    if(professor.get(i).getValue().getValue().getKey()<=entry){
                        if(professor.get(i).getValue().getValue().getValue()>=exit){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    
    public ArrayList<Pair<Integer,Pair<Integer,Pair<Integer, Integer>>>> getLeftSession(){
        return sessions;
    }
    
    public int getGroupCapacity(int actual_session){
        for(int i = 0;i<groups.size();i++){
            if(groups.get(i).getValue() == sessions.get(actual_session).getValue().getValue().getKey()){
                return groups.get(i).getKey();
            }
        }
        return 0;
    }
    
    private void setIndividual(){
        boolean assigned = true;
        Random rand = new Random();
        int actual_session, remaining_time;
        while(sessions.size()>0){
            assigned = false;
            actual_session = rand.nextInt(sessions.size());//grupo random a insertar
            for (int i= 0; i<DAYS;i++){//DIAS
                for (int j= 0; j<CLASSROOM;j++){//AULAS
                    for (int k=0; k<PERIODS;k++){//PERIODOS - llena los individuos
                        if(ind[i][j][k]==0){//si no le ha asignado valor
                            System.out.println(sessions.get(actual_session).getValue().getValue().getKey());
                            if(getGroupCapacity(actual_session)<=capacity.get(j)){//si cabe en el aula
                                remaining_time = sessions.get(actual_session).getValue().getKey() * 2;
                                if(canBeSet(i,j,k, remaining_time)){//si queda campo durante el dia
                                    
                                    if(hasDisponibility(i,k,k+remaining_time,sessions.get(actual_session).getValue().getValue().getValue())){//(ID, (duracion, (idGrupo, idProfesor)))
                                        while(remaining_time>0){
                                            ind[i][j][k] = sessions.get(actual_session).getKey();
                                            remaining_time--;
                                            k++;
                                        }
                                        k--;
                                        sessions.remove(actual_session);
                                        assigned = true;
                                    }
                                } 
                            }else{
                                break;
                            }
                        }
                        if(assigned){break;}
                    }
                    if(assigned){break;}
                }
                if(assigned){break;}
            }
            if(!assigned){
                left_sessions.add(sessions.get(actual_session));
                sessions.remove(actual_session);
            }
        }
        for(int i = 0;i<left_sessions.size();i++){
            sessions.add(left_sessions.get(i));
            left_sessions.remove(i);
        }
    }
    
    public Individual(ArrayList<Pair<Integer,Pair<Integer,Pair<Integer,Integer>>>> professor,ArrayList<Integer> capacity, ArrayList<Pair<Integer,Integer>> groups, ArrayList<Pair<Integer,Pair<Integer,Pair<Integer, Integer>>>> sessions) {
        this.capacity = capacity;
        this.groups = groups;
        this.sessions = sessions;
        this.professor = professor;
        left_sessions = new ArrayList<>();
        setIndividual();
        
    }
    
    public void show_ind(){
        for (int i= 0; i<ind.length;i++){
            for (int j= 0; j<ind[i].length ;j++){
                for (int k=0; k<ind[i][j].length;k++){
                    System.out.print(ind[i][j][k]+" ");
                }
                System.out.print("           ");
            }
            System.out.println();

        }
    }

    public int[][][] getIndividual(){
        return ind;
    }
}
