package com.excilys.tondeuse.cli;

import java.util.HashMap;
import java.util.Map;

public enum Menu {
    FICHIER_PATH(1),DATA(2),FICHIER_DEFAULT(3),STOP_PROGRAMME(4),RIEN(5);

    private static Map<Integer,Menu> map = new HashMap<>();

    private int order;

    Menu(int order){
        this.order = order;
    }

    static {
        for (Menu menu : Menu.values()){
            map.put(menu.order, menu);
        }
    }

    public static Menu valueOf(int order){
        return map.get(order);
    }

    public int getOrder(){
        return order;
    }
}
