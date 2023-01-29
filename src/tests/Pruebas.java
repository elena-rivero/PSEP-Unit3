package tests;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Pruebas {

	public static void main(String[] args) {
		try {
			InetAddress direccion = InetAddress.getByName("www.google.es");
			System.out.println(direccion);
			System.out.println(direccion.getHostAddress());
			System.out.println(direccion.getHostName());
			
			byte[] direccionBytes = direccion.getAddress();
			System.out.println(Arrays.toString(direccionBytes));
			
			InetAddress direccion2 = InetAddress.getByName("142.250.184.3");
			System.out.println(direccion2);
			
			System.out.println(InetAddress.getLocalHost());
			
			int h = 'A';
			
			System.out.println(h);
			
		} catch (UnknownHostException e) {
			System.err.println("Se ha producido un error al intentar acceder al host");
			e.printStackTrace();
		}
	}

}
