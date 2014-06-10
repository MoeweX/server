package brain;

import java.io.File;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import servlets.MyServlet;
import exceptions.NoWebRootPathException;

public class WebServer {
	
	/**
	 * The jetty server serving all requests.
	 */
	private final Server server;

	public WebServer() throws NoWebRootPathException {
		File webDir = new File(Configuration.getWebRootPath());
		if (!webDir.exists()) {
			throw new NoWebRootPathException("The given web root path does not exist: " + webDir.getAbsolutePath());
		}
		int port = Integer.parseInt(Configuration.getServerPort());
		System.out.println("Setting up server at port " + port + " and web root path " + webDir.getAbsolutePath());
		
		server = new Server(port);
		
		// servlet handlers
		ServletContextHandler servletContext = new ServletContextHandler(ServletContextHandler.SESSIONS);
		servletContext.setContextPath("/");
		servletContext.addServlet(new ServletHolder(new MyServlet()), "/myServlet");
		
		// static file handlers
		ResourceHandler resourceHandler = new ResourceHandler();
		resourceHandler.setDirectoriesListed(false);
		resourceHandler.setResourceBase(webDir.getAbsolutePath());
		
		// add handlers to HandlerList
		HandlerList handlers = new HandlerList();
		handlers.addHandler(servletContext);
		handlers.addHandler(resourceHandler);
		
		// add HanderList to server
		server.setHandler(handlers);
	}
	
	public void startServer() {
		try {
			server.start();
			System.out.println("Webserver started successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void stopServer() {
		try {
			server.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
