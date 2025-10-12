package wildcards;

import java.util.ArrayList;
import java.util.List;

// producer extends, consumer super

public class LowerBoundDemo {

    public static void addCats(List<? super Cat> catList) {
        catList.add(new Cat("Cat 2", "Cat Type 2"));

        // catList.add(new Animal("Animal 2"));
        // such inserts are not valid, because at the time of reading this might give Dog object or some other objects
        // that's extending Animal.

    }

    public static void main(String[] args) {

        List<Animal> animalList = new ArrayList<>();
        animalList.add(new Animal("Animal 1"));

        List<Cat> catList = new ArrayList<>();
        catList.add(new Cat("Cat 1", "Cat 1 Type"));

        addCats(catList);

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
