package cn.flyago.leetcode.lcsaf.binarytree;

/**
 * LCP 51. 烹饪料理
 *
 * 子集回溯
 */
public class PerfectMenu {
    int limit, x, y, res;
    int[] materials;
    int[][] cookbooks, attribute;
    public int perfectMenu(int[] materials, int[][] cookbooks, int[][] attribute, int limit) {
        this.materials = materials;
        this.cookbooks = cookbooks;
        this.attribute = attribute;
        this.limit = limit;
        dfs(0);
        return res;
    }

    private void dfs(int i) {
        if (i == cookbooks.length) {
            if (y >= limit) res = Math.max(res, x);
            return;
        }
        // 烹饪 cookbooks[i] 料理，然后做下一道菜
        if (enough(i)) {
            for (int j = 0; j < cookbooks[i].length; j++) {
                materials[j] -= cookbooks[i][j];
            }
            x += attribute[i][0];
            y += attribute[i][1];
            dfs(i + 1); // 做下一道菜
            // 恢复食材、饱腹度、满意度
            for (int j = 0; j < cookbooks[i].length; j++) {
                materials[j] += cookbooks[i][j];
            }
            x -= attribute[i][0];
            y -= attribute[i][1];
        }
        // 不烹饪 cookbooks[i] 料理，直接做下一道菜
        dfs(i + 1);
    }

    private boolean enough(int i) {
        for (int j = 0; j < cookbooks[i].length; j++) {
            if (cookbooks[i][j] > materials[j]) return false;
        }
        return true;
    }
}
