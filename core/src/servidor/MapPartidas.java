package servidor;

import utils.Partida;

import java.util.*;

/**
 * Created by davrami on 19/02/17.
 */
public abstract class MapPartidas {
    public static  Map<Float, String> arrPartidas = new HashMap<Float, String>();
    public static  ArrayList<Partida> objPartids = new ArrayList<Partida>();

    public MapPartidas() {
    }

    public static Map<Float, String> getArrPartidas() {
        return arrPartidas;
    }


    public static void setArrPartidas(float points, String level) {
        arrPartidas.put(points, level);
    }

    public static Map sortByValue(Map unsortedMap) {
        Map sortedMap = new TreeMap(new ValueComparator(unsortedMap)) {
        };
        sortedMap.putAll(unsortedMap);
        //System.out.println("unsortedMap: "+arrPartidas);
        System.out.println("sortedMapPuntos: "+sortedMap);
        return sortedMap;
    }

    static class ValueComparator implements Comparator {
        Map map;

        public ValueComparator(Map map) {
            this.map = map;
        }

        public int compare(Object keyA, Object keyB) {

            Comparable valueA = (Comparable) keyA;
            Comparable valueB = (Comparable) keyB;
            //System.out.println(map.get(keyA)+ "map.get(keyA)");
            //System.out.println(map.get(keyB)+ "map.get(keyB)");

            return valueB.compareTo(valueA);
        }
    }

    public static void setArraylistPartidas(Partida obj){
        objPartids.add(obj);
    }

    public static ArrayList<Partida> getObjPartids() {
        return objPartids;
    }


    public static void getSortPoints(){
        //System.out.println("unSortedObjPartida"+objPartids);
        Collections.sort(objPartids);
        System.out.println("\n SortedArraylistObjPartida"+objPartids);
    }



}