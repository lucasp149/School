package classes;

import java.util.ArrayList;

@FunctionalInterface
public interface ISelectTheBestPaid<T> {
    public T getBestPaid(ArrayList<T> array);
}
