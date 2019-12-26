package com.percyvega.java8.interfacemultipleinheritance;

public class CousinCoworker implements Relative, Employee {

    @Override
    public String getName() {
        return "Percy Vega";
    }

    // if not present, "inherits unrelated defaults" compiler error
    @Override
    public String getRole() {
        return Relative.super.getRole() + "/" + Employee.super.getRole();
    }

    @Override
    public String getSalute(String addressee) {
        return Employee.super.getSalute(addressee);
    }

}