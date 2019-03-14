import java.util.*;
import java.util.stream.Collectors;

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

        while (!queue.isEmpty()) {
            PageNode element = queue.remove();
            if (element.getPageNumber() == pageNumber) {
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
        return cheatHelper(root, path, desiredEnding);
    }

    private List<PageNode> cheatHelper(PageNode node, List<PageNode> listNode, int desiredEnding) {
        List<PageNode> track = new ArrayList<>(listNode);
        if (node.getPageNumber() == desiredEnding) {
            track.add(node);
            return track;
        }
        track.add(node);
        for (PageNode child : node.getChildren()) {
            List<PageNode> path = cheatHelper(child, track, desiredEnding);
            String paths = path.stream().map(page -> String.valueOf(page.getPageNumber())).collect(Collectors.joining("->"));
            if (paths.contains(String.valueOf(desiredEnding))) {
                return path;
            }
        }
        if (node.getIsEnding()) {
            track.remove(node);
        }
        return track;
    }

    public void preOrderPrint() {
        preOrderPrintHelper(root);
    }

    public void truncateList(int value){
        if (root.getChildren() != null && root.getPageNumber() != value) {
            for (PageNode page : root.getChildren()) {
                if (page.getPageNumber() == value) {
                    root = page;
                    break;
                }
            }
        }
    }

    private void preOrderPrintHelper(PageNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node);
        for (PageNode child : node.getChildren()) {
            preOrderPrintHelper(child);
        }

    }

}