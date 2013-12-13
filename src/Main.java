
public class Main {
    public static void main(String[] args) {
        Tree t = new Tree();

        Branch tree = t.generateTree();
        TreeDrawer td = new TreeDrawer(tree);
        td.draw();
    }
}
