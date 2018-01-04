package controller;

import java.util.ArrayList;
import java.util.Random;
import javafx.util.Pair;

public class AlgorithmController {
    ArrayList<Integer> capacity = new ArrayList<>();//Capacidad de cada aula
    ArrayList<Integer> groups = new ArrayList<>();//capacidad de los grupos a insertar
    ArrayList<Pair<Integer,Pair<Integer,Pair<Integer, Integer>>>> sessions = new ArrayList<>();//sesiones de grupos, con par(ID,(duracion, (idGrupo, Profesor)))
    ArrayList<Pair<Integer,Pair<Integer,Pair<Integer,Integer>>>> professor = new ArrayList<>();//disponibilidad de profesores, (ID,(Dia,(inicio,salida)))
    
    
    public static void main(String[] args) {
        AlgorithmController a = new AlgorithmController(); 
        ArrayList<Individual> generation = new ArrayList<>();
        
        int CLASSROOM = 19;
        
        Random rand = new Random();
        
        
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
        
        
        
        GeneticAlgorithm solve = new GeneticAlgorithm(a.capacity, a.groups, a.sessions, a.professor);
        ArrayList<Individual> solution = solve.StartAlgorithm(10, 5);
        
        for(int i = 0;i<solution.size();i++){
            solution.get(i).show_ind();
            System.out.println();
        }
       
    }
}
