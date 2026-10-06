package task5;

import task2.DynamicArray;
import task2.DynamicIntArray;

public class JsonArraySerializer implements ArraySerializer {
    @Override
    public String serialize(DynamicArray array) {
        String result = "[";
        for (int i = 0; i < array.size(); ++i){
            result += array.get(i);
            if (i < array.size() - 1) result += ",";
        }
        result += "]";
        return result;
    }

    @Override
    public DynamicArray deserialize(String data) {
        var array = new DynamicIntArray();
        String onlyNumbersAndCommas = data.substring(1, data.length() - 1);
        if (onlyNumbersAndCommas.isEmpty()) return array;

        String[] numbers = onlyNumbersAndCommas.split(",");
        for (var num : numbers){
            array.add(Integer.parseInt(num));
        }
        return array;
    }
}
