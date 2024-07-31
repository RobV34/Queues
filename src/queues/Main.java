package queues;

public class Main {
    public static void main(String[] args) {
        Shelter shelter = new Shelter();

        shelter.enqueue(new Dog("Buddy"));
        shelter.enqueue(new Cat("Whiskers"));
        shelter.enqueue(new Dog("Max"));
        shelter.enqueue(new Cat("Luna"));

        System.out.println("Dequeue Any: " + shelter.dequeueAny().getName()); // Should print "Buddy"
        System.out.println("Dequeue Dog: " + shelter.dequeueDog().getName()); // Should print "Max"
        System.out.println("Dequeue Cat: " + shelter.dequeueCat().getName()); // Should print "Whiskers"
    }
}

