package Multicast;
/**
 * Created by aojing on 2016/4/13.
 */
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastSender{
    public static void main(String[] args){
        try {
            InetAddress multicastAddress = InetAddress.getByName("239.1.2.3");
            MulticastSocket multiSocket = new MulticastSocket();
            DatagramPacket packet = new DatagramPacket(args[0].getBytes(), args[0].getBytes().length, multicastAddress, 1234);

            multiSocket.send(packet);
            System.out.println("已向目标多播IP地址：" + packet.getAddress() + ",端口：" + packet.getPort()
                    + "，发出：" + args[0]);

            multiSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
