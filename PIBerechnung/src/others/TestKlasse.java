package others;

import java.rmi.RemoteException;

import client.Client;
import server.Server;

public class TestKlasse {

	public static void main(String arg[]) {
		String policy = "grant{permission java.security.AllPermission;};";
		System.setProperty("java.security.policy", policy.toString());
		if (Methods.checkArguments(arg)) {
			if (arg[0].equals("Client")) {
				String ip = "";
				int number = 0;
				for (int i = 0; i < arg.length; i++) {
					if (arg[i].equalsIgnoreCase("-a")) {
						ip = arg[i + 1];
					}
					if (arg[i].equalsIgnoreCase("-n")) {
						number = Integer.parseInt(arg[i + 1]);

					}
				}
				new Client(ip, number);
			}

			else if (arg[0].equals("Balancer")) {
				// new Balancer();
			}
			else if (arg[0].equals("Server")) {
				System.out.println("Server...");
				String ip = "";
				for (int i = 0; i < arg.length; i++) {
					if (arg[i].equalsIgnoreCase("-a")) {
						ip = arg[i + 1];
					}
				}
				try {
					new Server(ip);
					Methods.debug("welcome 123");

				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else {
			Methods.debug("printing usagen");

		 Methods.usage();
		}
	}
}
