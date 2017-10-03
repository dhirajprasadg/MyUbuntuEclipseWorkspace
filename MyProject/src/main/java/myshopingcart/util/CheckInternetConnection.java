package myshopingcart.util;

import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;

public class CheckInternetConnection {

	public static void main(String[] args) {

		try {
			URL ur = new URL("http://www.google.com");
			URLConnection con = ur.openConnection();
			con.connect();
			System.out.println("Connectoed" );

		} catch (Exception e1) {

			e1.printStackTrace();
		}

		Enumeration<NetworkInterface> interfaces = null;

		try {

			interfaces = NetworkInterface.getNetworkInterfaces();

		} catch (SocketException e) {
			e.printStackTrace();
		}

		while (interfaces.hasMoreElements()) {

			NetworkInterface nic = interfaces.nextElement();

			System.out.print("Interface Name : [" + nic.getDisplayName() + "]");

			try {

				System.out.println(", is connected : [" + nic.isUp() + "]");

			} catch (SocketException e) {
				e.printStackTrace();
			}

		}

	}
}