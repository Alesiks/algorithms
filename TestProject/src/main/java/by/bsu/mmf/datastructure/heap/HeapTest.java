package by.bsu.mmf.datastructure.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HeapTest {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Heap heap = new Heap();

        int n = Integer.parseInt(bufferedReader.readLine().trim());
        for(int i = 0; i < n; i++) {
            String line = bufferedReader.readLine().trim();
            String[] input = line.split(" ");
            if(input[0].equals("1")) {
                int value = Integer.valueOf(input[1]);
                heap.add(value);
            } else if(input[0].equals("2")) {
                heap.pop();
            } else if(input[0].equals("3")) {
                int result = heap.getRoot();
                System.out.println(result);
            }
        }

    }
}
