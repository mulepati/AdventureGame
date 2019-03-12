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

    public void playGame() { }

    public void playGame(String option) { }

    public void truncateChoices(int pageNumber) { }
}
