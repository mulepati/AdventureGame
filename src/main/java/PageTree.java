import java.util.*;

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
        Stack<PageNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.empty()) {
            PageNode current = stack.pop();
            path.add(current);
            if(current.getPageNumber() == desiredEnding) {
                break;
            } else if (current.getIsEnding()) {
                path.remove(current);
            }
            for (PageNode child: current.getChildren()) {
                stack.push(child);
            }

        }
        return path;

    }

    public void preOrderPrint() {
        preOrderPrintHelper(root);
    }

    public void truncateList(int value){
        if(root.getChildren() != null && root.getPageNumber() != value) {
            for (PageNode page : root.getChildren()) {
                if (page.getPageNumber() == value) {
                    root = page;
                    break;
                }
            }
        }
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