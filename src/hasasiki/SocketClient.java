package hasasiki;

import java.io.*;
import java.net.*;
/*搭建客户器端

a)、创建Socket对象，指明需要连接的服务器的地址和端口。

b)、建立连接后，通过输出流向服务器发送请求信息。

c)、通过输入流获取服务器的响应信息。

d)、关闭响应资源*/

public class SocketClient {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		try {
			//创建客户端socket，指定服务器地址和端口
			Socket socket = new Socket("0.0.0.0",5209);
			System.out.println("client start!");
			
			// -->获取输出流，向服务器端发送信息
			//向本机的5209端口发出客户请求
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			//由系统标准输入设备构造bufferedreader对象
			PrintWriter write = new PrintWriter(socket.getOutputStream());
			//由socket对象得到输出流，并构建pw对象
			
			// --》获得输入流，并读取服务器响应信息
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//由socket对象得到输入流，并构造相应的bufferedReader对象
			String readline;
			readline = br.readLine();//从系统标准输入读入一字符串
			while(!readline.equals("end")) {
				write.println(readline);//从系统标准输入读入的字符串输出到server
				write.flush();//刷新
				System.out.println("Client:"+ readline);
				System.out.println("Server:"+ in.readLine());
				readline = br.readLine();//再从标准输入读入一个字符串哟
			}
			write.close();
			in.close();
			socket.close();
		}catch (Exception e) {
			System.out.println("can not listen to:" + e);
		}
	}

}
