package cn.flyago.leetcode.lcsaf.binarytree;

/**
 * 427. 建立四叉树
 */
public class Construct {

    public static void main(String[] args) {
        int[][] grid = new int[8][];
        grid[0] = new int[]{1, 1, 1, 1, 0, 0, 0, 0};
        grid[1] = new int[]{1,1,1,1,0,0,0,0};
        grid[2] = new int[]{1,1,1,1,1,1,1,1};
        grid[3] = new int[]{1,1,1,1,1,1,1,1};
        grid[4] = new int[]{1,1,1,1,0,0,0,0};
        grid[5] = new int[]{1,1,1,1,0,0,0,0};
        grid[6] = new int[]{1,1,1,1,0,0,0,0};
        grid[7] = new int[]{1,1,1,1,0,0,0,0};
        new Construct().construct(grid);
    }
    public Node construct(int[][] grid) {
        return build(grid, 0, 0, grid.length);
    }

    private Node build(int[][] grid, int x, int y, int len) {
        if (len == 1) {
            return new Node(grid[x][y] == 1, true);
        }
        int k = grid[x][y];
        boolean allEq = true;
        for (int i = x; i < x + len; i++) {
            for (int j = y; j < y + len; j++) {
                if (grid[i][j] != k) {
                    allEq = false;
                    break;
                }
            }
        }
        if (allEq) {
            return new Node(k == 1, true);
        }
        Node topLeft = build(grid, x, y, len / 2);
        Node topRight = build(grid, x, y + len / 2, len / 2);
        Node bottomLeft = build(grid, x + len / 2, y, len / 2);
        Node bottomRight = build(grid, x + len / 2, y + len / 2, len / 2);
        return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
    }

    static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }
}
