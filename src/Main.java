import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            List<Map.Entry<String, Integer>> sortedWords = getEntries();
            sortedWords.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

            for (Map.Entry<String, Integer> entry : sortedWords) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

            String maxWord = sortedWords.get(0).getKey();
            int maxCount = sortedWords.get(0).getValue();
            System.out.println("Слово с максимальным количеством повторений: " + maxWord + " (" + maxCount + " раз)");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Map.Entry<String, Integer>> getEntries() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        String line;
        Map<String, Integer> wordCount = new HashMap<>();
        while ((line = reader.readLine()) != null) {
            String[] words = line.split(" ");
            for (String word : words) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }
        reader.close();

        List<Map.Entry<String, Integer>> sortedWords = new ArrayList<>(wordCount.entrySet());
        return sortedWords;
    }
}


