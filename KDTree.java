public class KDTree
{
    private Node tree = null;
    private static class Node
    {
        private int  xval, yval, depth;
        private Node left, right;

        public Node(int x, int y, Node left, Node right)
        {
            xval = x;
            yval = y;
            this.left = left;
            this.right = right;
        }

        // This is just a helper method for pretty printing a tree
        private String toString(int indent)
        {
            String indentStr = "        ";
            String ret = "";
            if (left == null)
                ret += indentStr.repeat(indent + 1) + "null" + "\n";
            else
                ret += left.toString(indent + 1);
            ret += indentStr.repeat(indent) + xval + ", " + yval + "\n";
            if (right == null)
                ret += indentStr.repeat(indent + 1) + "null" + "\n";
            else
                ret += right.toString(indent + 1);
            return ret;
        }
    }
    public void insert(int x, int y)
    {
        if (tree == null) {
            tree = new Node(x, y, null, null);
            tree.depth = 0;
            }
        else
            insert(x, y, tree);
    }
    public int currentPlane(Node node){
        return (node.depth % 2);
    }
    private void insert(int x, int y, Node ptr)
    {
        if (currentPlane(ptr) == 0){
            if (x > ptr.xval)
            {
                if (ptr.left == null) {
                    ptr.left = new Node(x, y, null, null);
                    ptr.left.depth = ptr.depth + 1;
                }
                else{
                insert(x, y, ptr.left);
                }
            }
            else if (x < ptr.xval)
            {
                if (ptr.right == null) {
                    ptr.right = new Node(x, y, null, null);
                    ptr.right.depth = ptr.depth + 1;
                    }
                else {
                    insert(x, y, ptr.right);
                    }
            }
            else
                throw new Error("Value already in tree");
        }
        if (currentPlane(ptr) == 1){
            if (y > ptr.yval)
            {
                if (ptr.left == null) {
                    ptr.left = new Node(x, y, null, null);
                    ptr.left.depth = ptr.depth + 1;
                }
                else {
                    insert(x, y, ptr.left);
                }
            }
            else if (y < ptr.yval)
            {
                if (ptr.right == null) {
                    ptr.right = new Node(x, y, null, null);
                    ptr.right.depth = ptr.depth + 1;
                }
                else {
                    insert(x, y, ptr.right);
                }
            }
            else
                throw new Error("Value already in tree");
        }
    }
    public String toString()
    {
        return tree == null ? "Empty" : tree.toString(0);
    }
}
