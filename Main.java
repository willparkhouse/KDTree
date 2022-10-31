public class Main {
    public static void main(String[] args) {
        KDTree tree = new KDTree();
        tree.insert(40, 45);
        tree.insert(15, 70);
        tree.insert(70, 10);
        tree.insert(69, 50);
        tree.insert(66, 85);
        tree.insert(85, 90);
        System.out.println(tree);
    }
}