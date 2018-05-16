package hasasiki;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ThreadSocket implements Runnable {
	
	private Socket socket;
	 
	public ThreadSocket(Socket socket) {
		this.socket = socket;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			//获取输入流，读取客户端消息
			String line;
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//由Socket对象得到输入流，并构造相应的BufferedReader对象
			PrintWriter writer = new PrintWriter(socket.getOutputStream());
			//由socket对象得到输出流，并构造PrintWriter对象
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			//由标准输出上打印从客户端读入的字符串
			System.out.println("Client:" + in.readLine());
			//ClientMessage = in.readLine();
			
			line = br.readLine();
			//从标准输入读入一字符串
			
			// -->获取输入流，相应客户端请求
			while(!line.equals("end")) {//如果字符串为“end”，则停止循环
				writer.println(line);//向客户端输出该字符串
				writer.flush();//刷新输入流，使客户端马上收到该字符串
				System.out.println("Server:"+line);//在系统输出上打印读入的字符串
				System.out.println("Client:"+in.readLine());//从Client读入一字符串，并打印到输出
				line = br.readLine();//从系统标准输入读入字符串
				}
			in.close();
			writer.close();
			} catch(Exception e) {
				e.printStackTrace();
				}
	}

}
