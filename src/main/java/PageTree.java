import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PageTree {
    private PageNode root;

    public PageTree() {
        this(null);
    }

    public PageTree(PageNode value) {
        this.root = value;
    }

    public PageNode getNode(int pageNumber) {
        Queue<PageNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            PageNode element = queue.remove();
            if(element.getPageNumber() == pageNumber) {
                return element;
            }

            queue.addAll(element.getChildren());
        }

        return null;

    }

    public PageNode getFirst() {
        return root;
    }

    public List<PageNode> cheat(int desiredEnding) {
        List<PageNode> path = new ArrayList<>();
        return null;

    }

    public void preOrderPrint() {
        preOrderPrintHelper(root);
    }

    private void preOrderPrintHelper(PageNode node) {
        if(node == null) {
            return;
        }
        System.out.println(node);
        for (PageNode child : node.getChildren()) {
            preOrderPrintHelper(child);
        }

    }

}