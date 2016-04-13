package Multicast;

/**
 * Created by aojing on 2016/4/13.
 */
public class main {
    public static void main(String[] args) {
        MulticastReceiver receiver = new MulticastReceiver("239.1.2.3", 1234);
        receiver.connect();
    }
}
