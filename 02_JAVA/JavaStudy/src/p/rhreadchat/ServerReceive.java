package p.rhreadchat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerReceive extends Thread{

	private Socket socket;

	public ServerReceive(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
			//새롱ㄴ 메세지가 도착하면 받아서 출력하는 동작을 무한반복한다
			while(true) {
				String message = br.readLine();
				System.out.println("서버부터 전달받은 메세지 : " + message);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
	}
	
}
