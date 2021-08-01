/*
 * Copyright (c) 2021-2021, Chase Dream All Rights Reserved
 */

package com.chasedream.leetcode.easy;

import com.chasedream.utils.Out;

import java.util.*;

/** @Description 1337. 矩阵中战斗力最弱的 K 行 @Author Zhang DeZhou @Since 2021/8/1 20:39 */
public class KWeakestRows {
  public static void main(String[] args) {
    int[][] mat = {
      {1, 1, 0, 0, 0}, {1, 1, 1, 1, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {1, 1, 1, 1, 1}
    };
    int k = 3;
    int[] res = new KWeakestRows().kWeakestRows1(mat, k);
    for (int re : res) {
      Out.print(re + " ");
    }
  }

  /**
   * @param mat 输入二维数组
   * @param k 输出的前K行
   * @return 返回的前K行下标数组
   * @see <a href="https://leetcode-cn.com/problems/the-k-weakest-rows-in-a-matrix/">1337.
   *     矩阵中战斗力最弱的K 行</a>
   *     <p>解题思路： 解读题目可知：所谓战斗力最弱也就是每行的士兵数量最少，那么我们可以通过如下方法解题 1.遍历每行的士兵总数，将行数和士兵数量建立关联关系，我们用map来做
   *     由于题目中提到士兵总是在平民之前，即1总是在0之前，从而我们遍历行时，遇到0即可停止改行的遍历 2.将map按照value进行排序 3.取出排序后的前K个map的value值
   */
  public int[] kWeakestRows1(int[][] mat, int k) {
    Map<Integer, Integer> powerMap = new HashMap<>();
    int rows = mat.length;
    int cols = mat[0].length;
    for (int i = 0; i < rows; i++) {
      powerMap.put(i, 0);
      for (int j = 0; j < cols; j++) {
        if (mat[i][j] == 0) {
          break;
        }
        powerMap.put(i, powerMap.get(i) + 1);
      }
    }

    List<Map.Entry<Integer, Integer>> list = new ArrayList<>(powerMap.entrySet());
    list.sort(Map.Entry.comparingByValue());

    int[] res = new int[k];
    for (int i = 0; i < k; i++) {
      Map.Entry<Integer, Integer> entry = list.get(i);
      res[i] = entry.getKey();
    }

    return res;
  }
}
