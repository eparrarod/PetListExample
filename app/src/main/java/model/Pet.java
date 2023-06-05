package model;

import androidx.annotation.NonNull;

public class Pet {

    private String name;
    private String breed;
    private int age;

    public Pet(String name, String breed, int age) {
        this.name = name;
        this.breed = breed;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    @NonNull
    @Override
    public String toString() {
        return name + " (" + breed + "): " + age;
    }
}
