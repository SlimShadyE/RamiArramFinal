public class Ride {
    private String From, To;
    private int Price, Time;

    public String getFrom() {
        return From;
    }

    public void setFrom(String from) {
        From = from;
    }

    public String getTo() {
        return To;
    }

    public void setTo(String to) {
        To = to;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public int getTime() {
        return Time;
    }

    public void setTime(int time) {
        Time = time;
    }

    public Ride(String from, String to, int price, int time) {

        From = from;
        To = to;
        Price = price;
        Time = time;
    }
}
