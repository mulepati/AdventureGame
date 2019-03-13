import java.util.HashSet;
import java.util.Set;

public class PageNode {
    private int pageNumber;
    private String text;
    private boolean isEnding;
    private Set<PageNode> children;

    public PageNode() {
        this(-1, null, false);
    }

    public PageNode(int pageNumber, String text, boolean isEnding) {
        this.pageNumber = pageNumber;
        this.text = text;
        this.isEnding = isEnding;
        children = new HashSet<>();
    }

    public void addChild(PageNode child) {
        if(child != null) {
            children.add(child);

        }


    }

    public boolean getIsEnding() {
        return isEnding;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public Set<PageNode> getChildren() {
        return children;
    }

    public String toString() {
        return text;
    }


}
