package task5;

import task2.DynamicArray;

public interface ArraySerializer {
    String serialize(DynamicArray array);
    DynamicArray deserialize(String data);
}
