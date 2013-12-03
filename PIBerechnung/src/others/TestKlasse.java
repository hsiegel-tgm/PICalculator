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

			if (arg[0].equals("Balancer")) {
				// new Balancer();
			}
			if (arg[0].equals("Server")) {
				String ip = "";
				for (int i = 0; i < arg.length; i++) {
					if (arg[i].equalsIgnoreCase("-a")) {
						ip = arg[i + 1];
					}
				}
				try {
					new Server(ip);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else {
			try {
				new Server("0.0.0.0");
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//new Client("192.168.175.1", 5);
			// Methods.usage();
		}
	}
}
