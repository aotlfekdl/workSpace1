package p.rhreadchat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPServer {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = null;
		PrintWriter pw = null;
		
		int port = 3000;
		
		try {
			ServerSocket soc = new ServerSocket(port);
			
			
			System.out.println("클라이언트 요청");
			
			Socket socket =  soc.accept();
			
			System.out.println(socket.getInetAddress().getHostAddress()+"가 요청함");
			
			
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter(socket.getOutputStream());
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				br.close();
				pw.close();
				sc.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
