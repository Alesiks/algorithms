package by.bsu.mmf.algo.strings;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Map;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class SearchMultipleStringsInTextTest {

    private SearchMultipleStringsInText multipleStringsSearch = new SearchMultipleStringsInText();

    @Test
    public void test1() {
        Map<String, Integer> result = multipleStringsSearch.findOccurrences(
                asList("abc", "dfe", "xxx"),
                "abcabxcabddffexxxxabdfae");
        assertEquals(Integer.valueOf(1), result.get("abc"));
        assertEquals(Integer.valueOf(0), result.get("dfe"));
        assertEquals(Integer.valueOf(2), result.get("xxx"));
    }

    @Test
    public void test2() {
        Map<String, Integer> result = multipleStringsSearch.findOccurrences(
                asList("dabce", "abc", "bc"),
                "dabc"
        );
        assertEquals(Integer.valueOf(0), result.get("dabce"));
        assertEquals(Integer.valueOf(1), result.get("abc"));
        assertEquals(Integer.valueOf(1), result.get("bc"));
    }

    @Test
    public void test3() {
        Map<String, Integer> result = multipleStringsSearch.findOccurrences(
                asList("bb", "ea"),
                "bccdbbdecebcbeaccbdebbcdacddcebeeaccbcbadcabdaeabceeadcaaceaeaedadadddabdadbaecdbdadceeecdebadecebac"
        );
        assertEquals(Integer.valueOf(2), result.get("bb"));
        assertEquals(Integer.valueOf(6), result.get("ea"));
    }

}
