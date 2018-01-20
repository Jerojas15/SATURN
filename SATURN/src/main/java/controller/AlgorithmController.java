package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import javafx.util.Pair;

public class AlgorithmController {
    static ArrayList<Integer> capacity = new ArrayList<>();//Capacidad de cada aula
    static ArrayList<Pair<Integer, Integer>> groups = new ArrayList<>();//capacidad de los grupos a insertar
    static ArrayList<Pair<Integer,Pair<Integer,Pair<Integer, Integer>>>> sessions = new ArrayList<>();//sesiones de grupos, con par(ID,(duracion, (idGrupo, Profesor)))
    static ArrayList<Pair<Integer,Pair<Integer,Pair<Integer,Integer>>>> professor = new ArrayList<>();//disponibilidad de profesores, (ID,(Dia,(inicio,salida)))
    int times = 0;
    
    
    public AlgorithmController(int times) throws SQLException, ClassNotFoundException {
        DatabaseController d = new DatabaseController();
        this.times = times;
        capacity = d.getClassroomCapacity();
        groups = d.getGroupCapacity();
        sessions = d.getSessionData();
        professor = d.getProfessorData();
        /*
        for(int i = 0;i<a.capacity.size();i++){
            System.out.println(a.capacity.get(i));
        }
        System.out.println();
        for(int i = 0;i<a.groups.size();i++){
            System.out.println(a.groups.get(i));
        }
        System.out.println();
        for(int i = 0;i<a.sessions.size();i++){
            System.out.println(a.sessions.get(i));
        }
        System.out.println();
        for(int i = 0;i<a.professor.size();i++){
            System.out.println(a.professor.get(i));
        }*/
        
        int CLASSROOM = 19;
        
        Random rand = new Random();
        
        /*
        for(int i = 0;i<CLASSROOM;i++){//llena temporal la capacidad de las aulas con random de 10-25
            a.capacity.add(rand.nextInt(16)+20);
        }
        for(int i = 0;i<300;i++){//llena temporal el tamano de los grupos
            a.groups.add(rand.nextInt(16)+10);
        }
        int prof;
        for(int i = 0;i<600;i++){//llena temporal el tiempo de cada sesion por grupo, 2 sesiones
            prof = rand.nextInt(51);
            a.sessions.add(new Pair(i,new Pair(rand.nextInt(3)+1,new Pair((int)Math.floor(i/2),prof))));
        }
        
        int day,entry,exit,temp;
        boolean more;
        for(int i = 0;i<50;i++){//50 profesores
            for(int j = 0;j<6;j++){
                more = rand.nextBoolean();//calcula si el profe puede ir ese dia
                if(more){
                    entry = rand.nextInt(10);
                    temp = rand.nextInt(20)+entry+3;
                    exit = temp>29?29:temp;//calcula tiempo de entrada y salida del profesor
                    a.professor.add(new Pair(i,new Pair(j,new Pair(entry, exit))));
                }
            }      
        }
        
        
        */
        
    }
    public boolean start() throws SQLException, ClassNotFoundException{
        DatabaseController d = new DatabaseController();
        GeneticAlgorithm solve = new GeneticAlgorithm(capacity, groups, sessions, professor);
        ArrayList<Individual> solution = solve.StartAlgorithm(50, times);
        
        for(int i = 0;i<solution.size();i++){
            solution.get(i).show_ind();
            System.out.println();
        }
        
        d.insertAlgorithmResult(solution);
        return true;
    }
}
