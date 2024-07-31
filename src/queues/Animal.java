package queues;

import java.util.LinkedList;
import java.util.Queue;

abstract class Animal {
    private String name;
    private int order;

    public Animal(String name) {
        this.name = name;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getOrder() {
        return this.order;
    }

    public String getName() {
        return this.name;
    }

    public boolean isOlderThan(Animal other) {
        return this.order < other.getOrder();
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
}

class Shelter {
    private Queue<Dog> dogs;
    private Queue<Cat> cats;
    private int order; // Acts as a timestamp

    public Shelter() {
        dogs = new LinkedList<>();
        cats = new LinkedList<>();
        order = 0;
    }

    public void enqueue(Animal animal) {
        animal.setOrder(order);
        order++;

        if (animal instanceof Dog) {
            dogs.add((Dog) animal);
        } else if (animal instanceof Cat) {
            cats.add((Cat) animal);
        }
    }

    public Animal dequeueAny() {
        if (dogs.isEmpty()) {
            return dequeueCat();
        } else if (cats.isEmpty()) {
            return dequeueDog();
        }

        Dog dog = dogs.peek();
        Cat cat = cats.peek();

        if (dog.isOlderThan(cat)) {
            return dequeueDog();
        } else {
            return dequeueCat();
        }
    }

    public Dog dequeueDog() {
        if (!dogs.isEmpty()) {
            return dogs.poll();
        } else {
            return null;
        }
    }

    public Cat dequeueCat() {
        if (!cats.isEmpty()) {
            return cats.poll();
        } else {
            return null;
        }
    }

    public boolean isEmpty() {
        return dogs.isEmpty() && cats.isEmpty();
    }
}

