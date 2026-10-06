package task5;

public class SerializerFactory {
    public static ArraySerializer forFormat(String format) {
        int indexOfDot = format.lastIndexOf(".");
        String resFormat = format.substring(indexOfDot + 1);

        if (resFormat.equals("json")){
            return new JsonArraySerializer();
        } else if (resFormat.equals("xml")){
            return new XmlArraySerializer();
        } else if (resFormat.equals("csv")){
            return new CsvArraySerializer();
        } else if (resFormat.equals("bin")){
            return new BinaryArraySerializer();
        } else{
            throw new IllegalArgumentException("Unknown format: " + resFormat);
        }
    }
}
