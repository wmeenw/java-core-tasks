package task5;

import task2.DynamicArray;
import task2.DynamicIntArray;

import java.util.Base64;

public class BinaryArraySerializer implements ArraySerializer {
    @Override
    public String serialize(DynamicArray array) {
        byte[] bytes = new byte[array.size() * 4];
        for (int i = 0; i < array.size(); ++i){
            int value = array.get(i);
            bytes[i*4] = (byte)(value >> 24);
            bytes[i*4+1] = (byte)(value >> 16);
            bytes[i*4+2] = (byte)(value >> 8);
            bytes[i*4+3] = (byte)value;
        }
        return Base64.getEncoder().encodeToString(bytes);
    }

    @Override
    public DynamicArray deserialize(String data) {
        byte[] bytes = Base64.getDecoder().decode(data);
        var array = new DynamicIntArray();

        for (int i = 0; i < bytes.length; i += 4){
            int val = ((bytes[i] & 0xFF) << 24) | ((bytes[i+1] & 0xFF) << 16) | ((bytes[i+2] & 0xFF) << 8) | (bytes[i+3] & 0xFF);
            array.add(val);
        }
        return array;
    }
    
}
