package classes;

import java.util.ArrayList;
import java.util.Random;

// this class generates a random ID for new instances of Employees
public final class IdGeneration {

    private static ArrayList<Integer> employeesIds = new ArrayList<>();

    // methods
    public int generateId() {

        Random r = new Random();
        int temp = r.nextInt(1000);

        while(employeesIds.contains(temp))
        {
            r = new Random();
            temp = r.nextInt(1000);
        }

        return temp;
    }

    public void reportUsedId (int id) {
        employeesIds.add(id);
    }
}

