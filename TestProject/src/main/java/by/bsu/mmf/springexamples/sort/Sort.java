package by.bsu.mmf.springexamples.sort;

import java.util.Comparator;

/**
 * Created by Ales on 23.06.17.
 */
public interface Sort {

    <T> T[] sort(T[] arrayToSort, Comparator<T> comparator);

    <T extends Comparable> T[] sort(T[] arrayToSort);

}
