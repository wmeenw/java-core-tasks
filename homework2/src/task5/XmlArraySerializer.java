package task5;

import task2.DynamicArray;
import task2.DynamicIntArray;

public class XmlArraySerializer implements ArraySerializer {
    @Override
    public String serialize(DynamicArray array) {
        String res = "<array>";
        for (int i = 0; i < array.size(); ++i){
            res += "<element>" + array.get(i) + "</element>";
        }
        res += "</array>";
        return res;
    }

    @Override
    public DynamicArray deserialize(String data) {
        var array = new DynamicIntArray();
        String[] nums = data.split("</element>");
        for (var el : nums){
            if (!el.isEmpty() && !el.equals("<array>") && !el.equals("</array>")){
                array.add(Integer.parseInt(el));
            }
        }
        return array;
    }
}
