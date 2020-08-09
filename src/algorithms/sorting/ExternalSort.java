package algorithms.sorting;

import java.io.*;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by tareqmy on 9/8/20.
 */
public class ExternalSort {


    public static void externalSort(String fileName) {
        String tempFile = "temp-file-";
        int[] buffer = new int[Math.min(M, N)];

        try {
            int slices = (int) Math.ceil((double) N / M);
            int i, j;

            try (FileReader fr = new FileReader(fileName);
                 BufferedReader br = new BufferedReader(fr)) {

                // Iterate through the elements in the file
                for (i = 0; i < slices; i++) {
                    // Read M-element chunk at a time from the file
                    for (j = 0; j < (Math.min(M, N)); j++) {
                        String t = br.readLine();
                        if (t != null)
                            buffer[j] = Integer.parseInt(t);
                        else
                            break;
                    }
                    // Sort M elements
                    Arrays.sort(buffer);

                    try (FileWriter fw = new FileWriter(tempFile + i + ".txt");
                         PrintWriter pw = new PrintWriter(fw)) {
                        // Write the sorted numbers to temp file
                        for (int k = 0; k < j; k++)
                            pw.println(buffer[k]);
                    }
                }
            }

            // Now open each file and merge them, then write back to disk
            int[] topNums = new int[slices];
            BufferedReader[] brs = new BufferedReader[slices];

            try {
                for (i = 0; i < slices; i++) {
                    //create one bufferedreader per each sorted temp file
                    brs[i] = new BufferedReader(new FileReader(tempFile + i + ".txt"));
                    String t = brs[i].readLine(); //read the first element and put in toparray
                    if (t != null)
                        topNums[i] = Integer.parseInt(t);
                    else
                        topNums[i] = Integer.MAX_VALUE;
                }
                System.out.println(Arrays.toString(topNums));

                try (FileWriter fw = new FileWriter("external-sorted.txt");
                     PrintWriter pw = new PrintWriter(fw)) {

                    for (i = 0; i < N; i++) { //write the full file.. that is the whole array of size N
                        int minFile = 0;
                        int min = topNums[minFile];

                        //find the minValue and index in the topNums
                        for (j = 0; j < slices; j++) {
                            if (min > topNums[j]) {
                                minFile = j;
                                min = topNums[minFile];
                            }
                        }

                        pw.println(min);
                        //read the next line from the mean value temp file
                        String t = brs[minFile].readLine();
                        if (t != null)
                            topNums[minFile] = Integer.parseInt(t); //replace old one if found
                        else
                            topNums[minFile] = Integer.MAX_VALUE; //replace with maxvalue when not found

                    }

                    //at the end all of them should be MAX_VALUE
//                    System.out.println(Arrays.toString(topNums));
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                //close temp files bufferedreaders
                for (i = 0; i < slices; i++)
                    brs[i].close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static String generateInput(int n) {
        String fileName = "external-sort.txt";
        Random rand = new Random();

        try (PrintWriter pw = new PrintWriter(new FileWriter(fileName))) {
            for (int i = 0; i < n; i++)
                pw.println(rand.nextInt(101));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileName;
    }

    static int N = 100; // size of the file in disk
    static int M = 5; // max items the memory buffer can hold

    public static void main(String[] args) {
        String fileName = generateInput(N);
        externalSort(fileName);
    }
}
