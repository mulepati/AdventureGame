import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PageTree {
    private PageNode root;

    public PageNode getFirst() { return root; }

    public PageNode getNode(int data) {
        Queue<PageNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            PageNode element = queue.remove();
            if (element.getPageNumber() == data) {
                return element;
            }
            queue.addAll(element.getChildren());

        }
        return null;
    }

    public List<PageNode> cheat(int desiredEnding) {
        List<PageNode> cheatList = new ArrayList<>();
        return null; }

    public PageTree() {
        root = null;

    }

    public PageTree(PageNode val) {
        root = val;
    }

    public void to() {
        preOrderPrint(root);
    }
    
    public static void preOrderPrint(PageNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node);
        for (PageNode child : node.getChildren()) {
            preOrderPrint(child);
        }
    }
}