package p.rhreadchat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TCPClient {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		BufferedReader br = null;
		PrintWriter pw = null;
		//소프트웨어가 실행중인 본인의 컴퓨터의 ip는
		//127.0.0.1 or localhost라는 대명사로 작성 가능
		try {
			Socket socket = new Socket("192.168.20.22", 3000);
			if(socket != null) {
				System.out.println("연결성공");
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				
				//출력용스트림
		
				pw = new PrintWriter(socket.getOutputStream());
				
				while(true) {
					System.out.println("서버로 보낼 내용 ");
					String sendMessage = sc.nextLine();
					pw.println(sendMessage); //클라이언트로 출력
					pw.flush();//스트림에 있는데이터 전부 내보내기
					String message = br.readLine();
					System.out.println("서버로부터 전달받은 메세지 :"+message);
		
				}
			}
		}catch (UnknownHostException e ) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				sc.close();
				br.close();
				pw.close();
			}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
	}

}
