package com.xiongzehua;

import java.util.*;

/**
 * Created by 31339 on 2018/5/19.
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int newCnt = map.get(nums[i]) + 1;
                map.put(nums[i], newCnt);
            } else
                map.put(nums[i], 1);
        }


        HashSet<ThreeInt> threeIntSet = new HashSet<ThreeInt>();
        for (Integer a : map.keySet()) {
            for (Integer b : map.keySet()) {
                int c = 0 - a - b;
                if (map.containsKey(c)) {
                    ThreeInt threeInt = new ThreeInt(a, b, c);
                    if (threeInt.match(map))
                        threeIntSet.add(threeInt);
                } else
                    continue;
            }
        }
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for (ThreeInt threeInt : threeIntSet) {
            list.add(threeInt.toList());
        }
        return list;
    }
}

class ThreeInt {
    int[] array;
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    public int[] getArray() {
        return array;
    }

    public ThreeInt(int a, int b, int c) {
        array = new int[]{a, b, c};
        Arrays.sort(array);

        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                int newCnt = map.get(array[i]) + 1;
                map.put(array[i], newCnt);
            } else
                map.put(array[i], 1);
        }
    }

    public List<Integer> toList() {
        return Arrays.asList(array[0], array[1], array[2]);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ThreeInt threeInt = (ThreeInt) o;
        return Arrays.equals(array, threeInt.getArray());
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

    public boolean match(HashMap<Integer, Integer> map) {
        for (Integer key : this.map.keySet()) {
            if (this.map.get(key) > map.get(key))
                return false;
        }
        return true;
    }
}

