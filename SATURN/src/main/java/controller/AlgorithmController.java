package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import javafx.util.Pair;

public class AlgorithmController {
    static ArrayList<Integer> capacity = new ArrayList<>();//Capacidad de cada aula
    static ArrayList<Integer> groupSessions = new ArrayList<>();
    static ArrayList<Pair<Integer, Integer>> groups = new ArrayList<>();//capacidad de los grupos a insertar
    static ArrayList<Pair<Integer,Pair<Integer,Pair<Integer, Integer>>>> sessions = new ArrayList<>();//sesiones de grupos, con par(ID,(duracion, (idGrupo, Profesor)))
    static ArrayList<Pair<Integer,Pair<Integer,Pair<Integer,Integer>>>> professor = new ArrayList<>();//disponibilidad de profesores, (ID,(Dia,(inicio,salida)))
    int times = 0;
    static int CLASSROOM;
    
    public AlgorithmController(int times, int type) throws SQLException, ClassNotFoundException {
        DatabaseController d = new DatabaseController();
        this.times = times;
        capacity = d.getClassroomCapacity(type);//saca la capacidad de las aules de tipo x
        groups = d.getGroupCapacity();//saca la capacidad de los grupos 
        sessions = d.getSessionData();
        professor = d.getProfessorData();
        groupSessions = d.getGroupIdBySession();

        CLASSROOM = d.getClassrooms(type);//cantidad de aulas de ese tipo que hay
        
        Random rand = new Random();
        
        
    }
    public boolean start() throws SQLException, ClassNotFoundException{
        DatabaseController d = new DatabaseController();
        
        GeneticAlgorithm solve = new GeneticAlgorithm(groupSessions, capacity, groups, sessions, professor);
        ArrayList<Individual> solution = solve.StartAlgorithm(10, times);

        for(int i = 0;i<solution.size();i++){
            solution.get(i).show_ind();
            System.out.println();
        }
        
        d.insertAlgorithmResult(solution);
        d.insertLeft(solution);
        return true;
    }
}
