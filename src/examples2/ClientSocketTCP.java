package examples2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSocketTCP {

	public static void main(String[] args) {

		try {
			// 1 - Crear un socket de tipo cliente indicando IP y puerto del servidor
			System.out.println("Estableciendo conexión con el servidor");
			Socket cliente = new Socket("192.168.1.137", 49200);

			// 2 - Abrir flujos de lectura y escritura
			InputStream is = cliente.getInputStream();
			OutputStream os = cliente.getOutputStream();

			// 3 - Intercambiar datos con el servidor
			// Envío de mensaje de texto al servidor
			PrintWriter pw = new PrintWriter(os, true);
			pw.println("Soy el cliente. Envío este mensaje al servidor");

			// Leo mensajes que me envía el servidor
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			System.out.println("El servidor me envía el siguiente mensaje: " + br.readLine());

			// 4 - Cerrar flujos de lectura y escritura
			is.close();
			os.close();

			// 5 - Cerrar la conexión
			System.out.println("Se cierra la conexión del cliente");
			cliente.close();
			
		} catch (UnknownHostException e) {
			System.err.println("No se encuentra el host especificado.");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Se ha producido un error en la conexión con el servidor.");
			e.printStackTrace();
		}
	}

}
