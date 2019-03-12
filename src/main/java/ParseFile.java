import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ParseFile {
    public static PageTree parseFile(String filePath) throws FileNotFoundException {
        Scanner input = new Scanner (new File(filePath));
        int count = 1;
        Map<Integer, List<Integer>> recording = new HashMap<>();
        Map<Integer, PageNode> pages = new HashMap<>();

        while (input.hasNextLine()) {
            String line = input.nextLine();
            String[] parts = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");

            boolean ending = false;
            for (String temp : parts) {
                if (temp.contains("\"")) {
                    PageNode node = new PageNode(count, temp.substring(1, temp.length() - 1), ending);
                    pages.put(count, node);
                }
                else if(temp.contains("ENDING")) {
                    ending = true;
                }
                else {
                    if(recording.containsKey(count)) {
                        recording.get(count).add(Integer.valueOf(temp));
                    } else{
                        recording.put(count, new ArrayList<>(Integer.valueOf(temp)));
                    }
                }
            }
            count++;
        }

        return point(recording, pages);
    }

    private static PageTree point(Map<Integer, List<Integer>> recording, Map<Integer, PageNode> pages) {
        PageTree result = new PageTree(pages.get(1));

        PageNode current = result.getFirst();
        for (int i = 1; i <= recording.size(); i++) {
            for (int j = 0; j < recording.get(i).size() ; j++) {
                current.addChild(pages.get(recording.get(i).get(j)));

            }
            if (result.getNode(i) != null) {
                current = result.getNode(i);
            }
        }

        return null;
    }


}
