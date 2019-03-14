import java.util.*;

public class Playthrough {
    private LinkedList<PageNode> choices = new LinkedList<>();
    private PageTree book;

    public Playthrough(PageTree book) {
        this.book = book;
    }

    public LinkedList<PageNode> getChoices() {
        return choices;
    }

    public void playGame() {
        Scanner sc = new Scanner(System.in);
        PageNode current = book.getFirst();
        choices.add(current);
        while(!current.getIsEnding()) {
            System.out.println(current);
            StringBuilder choose = new StringBuilder("Choose an option : ");
            List<Integer> legalPage = new ArrayList<>();

            for (PageNode child : current.getChildren()) {
                choose.append(child.getPageNumber() + " ");
                legalPage.add(child.getPageNumber());
            }

            System.out.println(choose.toString());
            int choice = sc.nextInt();
            if(book.getNode(choice) != null && legalPage.contains(choice)) {
                current = book.getNode(choice);
                choices.add(current);
            }

        }
        System.out.println(current);

    }

    public void playGame(int option) {
        if(book.getFirst().getPageNumber() == option) {
            playGame();
        }
    }

    public void truncateChoices(int pageNumber) {
        book.truncateList(pageNumber);
    }
}
