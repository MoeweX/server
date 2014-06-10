package brain;

import exceptions.NoWebRootPathException;

public class Mastermind {
	public static void main(String[] args) {
		try {
			WebServer server = new WebServer();
			server.startServer();
		} catch (NoWebRootPathException e) {
			e.printStackTrace();
		}
	}
}
