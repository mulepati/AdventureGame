import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ParseFile {
    public static PageTree parseFile(String filePath) throws FileNotFoundException {
        Scanner input = new Scanner(new File(filePath));
        int count = 1;
        String[] parts;
        Map<Integer, List<Integer>> recording = new HashMap<>();
        Map<Integer, PageNode> pages = new HashMap<>();

        while (input.hasNextLine()) {
            String line = input.nextLine();
            parts = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
            boolean ending = false;
            for (String lineSplit : parts) {
                if (lineSplit.contains("\"")) {
                    PageNode node = new PageNode(count,lineSplit.substring(1, lineSplit.length() - 1), ending);
                    pages.put(count, node);
                }else if (lineSplit.contains("ENDING")) {
                    ending = true;
                } else {
                    if (recording.containsKey(count)) {
                        recording.get(count).add(Integer.valueOf(lineSplit));
                    } else {
                        recording.put(count, new ArrayList<>());
                        recording.get(count).add(Integer.valueOf(lineSplit));
                    }
                }
            }
            count++;
        }



        return points(recording, pages);

    }

    private static PageTree points(Map<Integer, List<Integer>> recording, Map<Integer, PageNode> pages){
        PageTree tree = new PageTree(pages.get(1));
        PageNode current = tree.getFirst();
        for (int i = 1; i <= recording.size(); i++) {
            for (int j = 0; j < recording.get(i).size(); j++) {
                current.addChild(pages.get(recording.get(i).get(j)));
            }
            if (tree.getNode(i + 1) != null) {
                current = tree.getNode(i + 1);
            }
        }

        return tree;

    }


}
