package org.peddi.spring.core.expression.spel.langref.samples;

import java.util.*;

public class Society {

    private String name;

    public static String Advisors = "advisors";
    public static String President = "president";

    private List<Inventor> members = new ArrayList<Inventor>();
    private Map<String, Object> officers = new HashMap<>();

    public  List<Inventor> getMembers() {
        return members;
    }

    public  Map<String, Object> getOfficers() {
        return officers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean isMember(String name) {
    	
        for (Inventor inventor : members) {
            if (inventor.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
