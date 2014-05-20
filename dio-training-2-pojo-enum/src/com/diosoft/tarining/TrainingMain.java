package com.diosoft.tarining;

import java.util.Arrays;

public class TrainingMain {

    public static void main(String[] args) {
        Person student = new Person();
        student.setFirstName("Petro");
        student.setLastName("Poroshenko");
        student.setAge(54);
        Person adult = new Person("Julia","Timoshenko",18,Profession.STUDENT);
        Person adult2 = new Person("Julia","Timoshenko",18,Profession.STUDENT);

        Person[] persons = {student, adult};

        switch (adult.getProfession().getStatus()){
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;

        }
        switch (adult.getProfession()){

            case STUDENT:
                break;
            case ENGINEER:
                break;
            case WORKER:
                break;
        }
//        for (Profession prof : Profession.values()){
//            System.out.println("prof = " + prof);
//        }
//        System.out.println(" student =  " + student.toString());
        System.out.println(" adult =  " + adult);
//
//        System.out.println("is link : " + (adult==adult2));
//        System.out.println("is equals : " + adult.equals(adult2));
//        System.out.println(Profession.STUDENT.name());

    }
}
