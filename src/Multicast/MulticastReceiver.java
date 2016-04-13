package Multicast;
/**
 * Created by aojing on 2016/4/13.
 */
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastReceiver{
    private InetAddress multiAddress;
    private DatagramPacket packet;
    private MulticastSocket multiSocket;
    private byte[] buf = new byte[256];

    MulticastReceiver(String url, int port) {
        try {
            multiAddress = InetAddress.getByName(url);
            packet = new DatagramPacket(buf, buf.length);
            multiSocket = new MulticastSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void connect() {
        try {
            multiSocket.joinGroup(multiAddress);
            receive();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void receive() {
        while(true) {
            try {
                multiSocket.receive(packet);
                System.out.println("已加入以地址" + multiAddress + "为多播IP地址的组");
                System.out.println("从地址：" + packet.getAddress() + ",端口：" + packet.getPort()
                        + "，接收到：" + new String(buf, 0, packet.getLength()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}