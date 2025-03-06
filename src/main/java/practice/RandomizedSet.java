package practice;

import java.util.*;

public class RandomizedSet {
    Map<Integer, Integer> valueIndex;
    List<Integer> numList;
    Random rand = new Random();
    public RandomizedSet() {
        valueIndex=new HashMap<>();
        numList=new ArrayList<>();
    }

    public boolean insert(int val) {
        if(valueIndex.containsKey(val)){
            return false;
        }
        numList.add(val);
        valueIndex.put(val,numList.size()-1);
        return true;
    }

    public boolean remove(int val) {
        if(!valueIndex.containsKey(val)){
            return false;
        }
        int indexRemove = valueIndex.get(val);
        int last = numList.get(numList.size()-1);

        numList.set(indexRemove, last);
        valueIndex.put(last, indexRemove);
        valueIndex.remove(val);
        numList.remove(numList.size()-1);
        return true;

    }

    public int getRandom() {
        return numList.get(rand.nextInt(numList.size()));
    }
}
