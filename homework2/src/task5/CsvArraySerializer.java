package task5;

import task2.DynamicArray;
import task2.DynamicIntArray;

public class CsvArraySerializer implements ArraySerializer {
    @Override
    public String serialize(DynamicArray array) {
         String res = "";
         for (int i = 0; i < array.size(); ++i){
             res += array.get(i);
             if (i < array.size() - 1) res += ",";
         }
         return res;
    }

    @Override
    public DynamicArray deserialize(String data) {
        var array = new DynamicIntArray();
        if (data.trim().isEmpty()) return array;

        String[] nums = data.split(",");
        for (var el : nums){
            array.add(Integer.parseInt(el.trim()));
        }
        return array;
    }
}
