package OOP.HW3.pharmacy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import OOP.HW3.components.Component;

public class Pharmacy implements Iterator<Component>, Comparable<Pharmacy>{
    private String name;
    private List<Component> components;
    private int idx;

    public Pharmacy (String name){
        this.components = new ArrayList<>();
        this.idx = 0;
    }

    public Pharmacy addComponent(Component item){
        components.add(item);
        return this;
    }
    public static int allPowers(Pharmacy pharmacy) {
        int result = 0;
        for (Component c : pharmacy.components) {
            result += c.getPower();
        }
        return result;
    }

    @Override
    public boolean hasNext() {
        return idx < components.size();
    }

    @Override
    public Component next() {
        return components.get(idx++);
    }

    @Override
    public int compareTo(Pharmacy p) {
        return Integer.compare(allPowers(this), allPowers(p));
    }

    @Override
    public String toString() {
        return String.format("Name: %s, components: %d", this.name, allPowers(this));
    }
}
