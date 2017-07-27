package by.bsu.mmf.algo.sort;

import java.util.Comparator;

/**
 * Created by Ales on 23.06.17.
 */
public interface Sort {

    <T> void sort(T[] arrayToSort, Comparator<T> comparator);

    <T extends Comparable> void sort(T[] arrayToSort);

}
