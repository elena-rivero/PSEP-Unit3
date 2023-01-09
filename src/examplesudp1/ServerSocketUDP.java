package examplesudp1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ServerSocketUDP {

	public static void main(String[] args) {
		DatagramSocket socket = null;
		try {
			// 1 - Crear DatagramSocket y le indicamos el puerto
			System.out.println("(Servidor) Creando socket...");
			socket = new DatagramSocket(49201);

			// 2 - Crear array de bytes que actuará de buffer
			byte[] buffer = new byte[64];

			// 3 - Creación de datagrama con la clase DatagramPacket
			DatagramPacket datagramaEntrada = new DatagramPacket(buffer, buffer.length);

			// 4 - Recepción del datagrama mediante el método receive
			socket.receive(datagramaEntrada);
			System.out.println("(Servidor): Mensaje recibido: " + new String(buffer));

			// 5 - Generación y envío de la respuesta
			System.out.println("(Servidor): Enviando datagrama...");
			byte[] mensajeEnviado = new String("Mensaje enviado desde el servidor").getBytes();
			DatagramPacket packetSalida = new DatagramPacket(mensajeEnviado, mensajeEnviado.length,
					datagramaEntrada.getAddress(), datagramaEntrada.getPort());
			socket.send(packetSalida);

			// 6 - Cierre del socket
			System.out.println("(Servidor): Cerrando la conexión...");
			socket.close();
			System.out.println("(Servidor): Conexión cerrada");
			
		} catch (SocketException e) {
			System.out.println("Error al crear el Socket");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error al recibir el paquete");
			e.printStackTrace();
		} 
	}

}
