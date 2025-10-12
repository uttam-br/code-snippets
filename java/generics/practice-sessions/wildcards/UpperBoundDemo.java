package wildcards;

import java.util.ArrayList;
import java.util.List;

public class UpperBoundDemo {

    public static void feed(List<?> animals) {
        for (Object animal : animals) {
            System.out.println("Feeding " + animal);
        }
    }

    public static void main(String[] args) {

        List<String>[] array = new List<String>[10];

        List<Animal> animalList = new ArrayList<>();
        animalList.add(new Animal("Animal 1"));

        List<Cat> catList = new ArrayList<>();
        catList.add(new Cat("Cat 1", "Cat 1 Type"));

        feed(animalList);
        feed(catList);

    }

    private static class Animal {
        private String name;

        public Animal(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    private static class Cat extends Animal {
        private String type;

        public Cat(String name, String type) {
            super(name);
            this.type = type;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

}
