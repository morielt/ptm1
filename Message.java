package test;

import java.util.Date;

public class Message {
    public final byte[] data;
    public final String asText;
    public final double asDouble;
    public final Date date;

    public Message(byte[] data) {
        this.data = data;
        this.asText = data.toString();
        this.asDouble = tryParse(this.asText);
        this.date = new Date();
    }

    public Message(String asText) {
        this(asText.getBytes());
    }

    public Message(double asDouble) {
        this(Double.toString(asDouble));
    }

    private double tryParse(String data){
        try {
            return Double.parseDouble(data);
        } catch (NumberFormatException exception){
            System.out.println(exception.getMessage());
            return Double.NaN;
        }
    }
}
