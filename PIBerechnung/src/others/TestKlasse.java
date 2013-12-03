package others;

import Rmi1.Client;
import Rmi1.Server;

public class TestKlasse {
	public static void main(String arg[]) {
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
				new Server(ip);
			}
		} else {
			Methods.usage();
		}
	}
}
