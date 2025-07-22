package socket;

import java.io.ObjectOutputStream;
import java.net.Socket;
import model.Invoice;

public class SocketClient {

    public static void sendPaidInvoice(Invoice invoice) {
        try (Socket socket = new Socket("localhost", 5000); ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())) {

            out.writeObject(invoice);
            out.flush();
        } catch (Exception e) {
            System.err.println("Error sending invoice to server: " + e.getMessage());
        }
    }
}
