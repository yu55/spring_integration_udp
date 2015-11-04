package pl.yu55.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.ip.IpHeaders;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

@Component
public class UdpEchoServiceActivator {

    private static final Logger logger = LoggerFactory.getLogger(UdpEchoServiceActivator.class);

    public void processMessage(Message<byte[]> message) {
        logger.info("Received payload={}, message={}", new String(message.getPayload()), message);

        sendReply(message.getHeaders().get(IpHeaders.IP_ADDRESS, String.class),
                message.getHeaders().get(IpHeaders.PORT, Integer.class),
                message.getPayload());
    }

    private void sendReply(String ipAddress, int port, byte[] payload) {
        try {
            InetAddress inetAddress = InetAddress.getByName(ipAddress);

            DatagramPacket sendPacket = new DatagramPacket(payload, payload.length, inetAddress, port);
            DatagramSocket clientSocket = new DatagramSocket();
            clientSocket.send(sendPacket);
            clientSocket.close();

            logger.info("Echo response sent to {}:{}", ipAddress, port);
        } catch (IOException ex) {
            logger.error("Error while sending reply", ex);
        }
    }
}
