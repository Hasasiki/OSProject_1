package hasasiki;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*一、搭建服务器端

a)、创建ServerSocket对象绑定监听端口。

b)、通过accept()方法监听客户端的请求。

c)、建立连接后，通过输入输出流读取客户端发送的请求信息。

d)、通过输出流向客户端发送请求信息。

e)、关闭相关资源。*/
public class SocketServer {
	//global variable to storage the chat info for transfer
	public String ClientMessage;
	public String UserInput;
	//搭建服务器端
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		SocketServer socketServer = new SocketServer();
		//创建一个服务器端socket
		socketServer.oneServer();
	}

	public void oneServer() {
		// TODO Auto-generated method stub
		try {
			ServerSocket server = null;
			try {
				server = new ServerSocket(5209);
				//指定绑定的端口并监听此端口
				System.out.println("Server start!");
				//
			}catch(Exception e) {
				System.out.println("hasn't start monitor"+e);//打印错误信息
			}
			
			Socket socket = null;
			try {
				socket = server.accept();
				//调用accept方法监听，等待客户链接，使用accept方法阻塞等待客户请求，有客户请求到来时则产生一个socket对象并继续执行
				//单线程处理，一次只允许一个客户端访问
				//THERE NEED A Supporting Multiple Clients!
				/*
				 while (true) {
    					accept a connection;
    					create a thread to deal with the client;
				 }
				 */
				}catch(Exception e) {
					System.out.println("Error."+e);//show error message
				}
			//获取输入流，读取客户端消息
			String line;
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//由Socket对象得到输入流，并构造相应的BufferedReader对象
			PrintWriter writer = new PrintWriter(socket.getOutputStream());
			//由socket对象得到输出流，并构造PrintWriter对象
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			//由标准输出上打印从客户端读入的字符串
			System.out.println("Client:" + in.readLine());
			ClientMessage = in.readLine();
			
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
			//关闭资源
			writer.close();//关闭socket输出流
			in.close();//关闭socket输入流
			socket.close();//关闭socket
			server.close();//关闭serverSocket
		}catch(Exception e) {
			System.out.println("Error."+e);
		}
	}
	public void MessageTransfer() {
		
	}
}
//course resource copy by https://www.cnblogs.com/zhoudi/p/6025552.html