package classes;

import java.util.Random;

// this class generates a random ID for new instances of Employees
public final class IdGeneration {
    // methods
    public int generateId() {
        Random r = new Random();
        return r.nextInt(1000);
    }
}

