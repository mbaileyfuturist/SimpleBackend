
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class Driver {
	
	private static final int NUMBER_OF_THREADS = 4; // 8?
	
	public static void main(String[] args) throws IOException {
		
		server();
		
	}
	
	public static void server() throws IOException {
		
		HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
		
		server.createContext("/profile", new ProfileHanlder());
		server.createContext("/settings", new SettingsHanlder());
		server.createContext("/friends", new FriendsHanlder());
		server.createContext("/messages", new MessagesHanlder());

		
		//Setup an executor service to schedule a thread to handle every incoming HTTP request 
		Executor executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
				
		server.setExecutor(executor);

		server.start();
		
	}
	
	public static class ProfileHanlder  implements HttpHandler{

		@Override
		public void handle(HttpExchange httpExchange) throws IOException {
			
			String message = "You are visiting the profile page.";
			
			//Generate an Http response.
			//First convert it to a byte array.
			byte[] response = message.getBytes(); //Transforms string into byte array.
			
			//Setup the http response.
			httpExchange.sendResponseHeaders(201, response.length);
			
			//Transform it into an output Stream.
			OutputStream outputStream = httpExchange.getResponseBody();
			
			//Write the response into the output stream.
			outputStream.write(response);
			
			//Close the stream.
			outputStream.close();
			
		}
		
	}
	
	public static class SettingsHanlder  implements HttpHandler{

		@Override
		public void handle(HttpExchange httpExchange) throws IOException {
			
			String message = "You are visiting the settings page.";
			
			//Generate an Http response.
			//First convert it to a byte array.
			byte[] response = message.getBytes(); //Transforms string into byte array.
			
			//Setup the http response.
			httpExchange.sendResponseHeaders(201, response.length);
			
			//Transform it into an output Stream.
			OutputStream outputStream = httpExchange.getResponseBody();
			
			//Write the response into the output stream.
			outputStream.write(response);
			
			//Close the stream.
			outputStream.close();
			
		}
		
	}
	
	public static class FriendsHanlder  implements HttpHandler{

		@Override
		public void handle(HttpExchange httpExchange) throws IOException {
			
			String message = "You are visiting the friends page.";
			
			//Generate an Http response.
			//First convert it to a byte array.
			byte[] response = message.getBytes(); //Transforms string into byte array.
			
			//Setup the http response.
			httpExchange.sendResponseHeaders(201, response.length);
			
			//Transform it into an output Stream.
			OutputStream outputStream = httpExchange.getResponseBody();
			
			//Write the response into the output stream.
			outputStream.write(response);
			
			//Close the stream.
			outputStream.close();
			
		}
		
	}
	
	public static class MessagesHanlder  implements HttpHandler{

		@Override
		public void handle(HttpExchange httpExchange) throws IOException {
			
			String message = "You are visiting the messages page.";
			
			//Generate an Http response.
			//First convert it to a byte array.
			byte[] response = message.getBytes(); //Transforms string into byte array.
			
			//Setup the http response.
			httpExchange.sendResponseHeaders(201, response.length);
			
			//Transform it into an output Stream.
			OutputStream outputStream = httpExchange.getResponseBody();
			
			//Write the response into the output stream.
			outputStream.write(response);
			
			//Close the stream.
			outputStream.close();
			
		}
		
	}

}
