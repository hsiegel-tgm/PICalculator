package others;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Methods {
	public static void debug(String x) {

		System.out.println(x);
	}

	public static boolean checkArguments(String arg[]) {
		if (arg[0].equals("Balancer") && arg.length == 1) {
			return true;
		} else if (arg[0].equals("Client") && arg.length == 5) {
			for (int i = 0; i < arg.length; i++) {
				if (arg[i].equalsIgnoreCase("-a")) {
					String IPADDRESS_PATTERN = "(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";
					if (!(arg[i + 1].matches(IPADDRESS_PATTERN))) {
						return false;
					}
					i++;
				}
				if (arg[i].equalsIgnoreCase("-n")) {
					try {
						Integer.parseInt(arg[i + 1]);
					} catch (NumberFormatException e) {
						return false;
					}
					i++;
				}
			}
			return true;

		} else if (arg[0].equals("Server") && arg.length == 3) {
			return false;
		} else {
			return false;
		}

	}

	public static void usage() {
		System.out.println("Server -a <ip adress>");
		System.out.println("");
		System.out.println("Client -a <ip adress> -n <number of digits>");
	}

}