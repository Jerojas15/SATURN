package tec.proyecto.saturn;

import android.util.Pair;
import java.util.ArrayList;
import java.util.List;

public class SessionActivity {

    private static SessionActivity session = new SessionActivity();
    private static  String username;

    private SessionActivity (){}

    public static SessionActivity getSession(){
        if (session == null) {
            session = new SessionActivity();
        }
        return session;
    }

    public void setUsername(String username) {

        this.username = username;
    }

    /*
        SQL: devuelve el nombre del profesor según username
     */
    public String getName() {
        return "Rodrigo";
    }

    /*
        SQL: devuelve usernames y passwords disponibles
     */
    public String [] getUsernames() {
        return new String[]{
                "foo@example.com:hello", "bar@example.com:world", "profe:1234"
        };
    }

    /*
        SQL: devuelve cursos y afinidades
     */
    public List<Pair<String,Integer>> getCourseRates() {
        ArrayList list = new ArrayList<Pair<String, Integer>>();
        list.add(new Pair<>("Introducción a la Programación", 1));
        list.add(new Pair<>("Redes", 1));
        list.add(new Pair<>("Introducción a Sistemas Operativos", 1));
        list.add(new Pair<>("Inteligencia Artificial", 1));
        list.add(new Pair<>("Estructuras de Datos", 1));
        return list;
    }

    /*
        SQL: update afinidad de cursp
     */
    public void updateAffinities(List<Pair<String,Integer>> courseRates){

    }
    /*-------------------------------------------------------------------------------------------*/
    public List<Pair< Pair<Integer,Integer>, Integer>> getAvailabilities() {
        ArrayList list = new ArrayList<Pair<String, Integer>>();
        list.add(new Pair<>(new Pair<> (7, 15), 0));
        list.add(new Pair<>(new Pair<> (7, 12), 1));
        list.add(new Pair<>(new Pair<> (13, 19), 2));
        list.add(new Pair<>(new Pair<> (14, 21), 3));
        list.add(new Pair<>(new Pair<> (15, 20), 4));
        list.add(new Pair<>(new Pair<> (15, 16), 5));
        return list;
    }

    public void updateAvailability(Integer day, Integer start, Integer end) {

    }
}
