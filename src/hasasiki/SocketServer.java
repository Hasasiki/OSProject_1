package hasasiki;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*һ�����������

a)������ServerSocket����󶨼����˿ڡ�

b)��ͨ��accept()���������ͻ��˵�����

c)���������Ӻ�ͨ�������������ȡ�ͻ��˷��͵�������Ϣ��

d)��ͨ���������ͻ��˷���������Ϣ��

e)���ر������Դ��*/
public class SocketServer {
	//global variable to storage the chat info for transfer
	public String ClientMessage;
	public String UserInput;
	private int port = 5209;
	//���������
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		SocketServer socketServer = new SocketServer();
		//����һ����������socket
		socketServer.oneServer();
	}
	public void handle(Socket socket)throws Exception {
		String key = socket.getInetAddress().getHostAddress()+":"+socket.getPort();
		System.out.println("accept a socket:" + key);
		Thread thread = new Thread(new ThreadSocket(socket));
		thread.start();
	}

	public void oneServer() {
		// TODO Auto-generated method stub
		try {
			ServerSocket server = null;
			try {
				server = new ServerSocket(port);
				//ָ���󶨵Ķ˿ڲ������˶˿�
				System.out.println("Server start!");
				//
			}catch(Exception e) {
				System.out.println("hasn't start monitor"+e);//��ӡ������Ϣ
			}
			
			Socket socket = null;
			try {
				while(true) {
					socket = server.accept();
					handle(socket);
				}
				//����accept�����������ȴ��ͻ����ӣ�ʹ��accept���������ȴ��ͻ������пͻ�������ʱ�����һ��socket���󲢼���ִ��
				//���̴߳���һ��ֻ����һ���ͻ��˷���
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
			/*//��ȡ����������ȡ�ͻ�����Ϣ
			String line;
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//��Socket����õ�����������������Ӧ��BufferedReader����
			PrintWriter writer = new PrintWriter(socket.getOutputStream());
			//��socket����õ��������������PrintWriter����
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			//�ɱ�׼����ϴ�ӡ�ӿͻ��˶�����ַ���
			System.out.println("Client:" + in.readLine());
			ClientMessage = in.readLine();
			
			line = br.readLine();
			//�ӱ�׼�������һ�ַ���
			
			// -->��ȡ����������Ӧ�ͻ�������
			while(!line.equals("end")) {//����ַ���Ϊ��end������ֹͣѭ��
				writer.println(line);//��ͻ���������ַ���
				writer.flush();//ˢ����������ʹ�ͻ��������յ����ַ���
				System.out.println("Server:"+line);//��ϵͳ����ϴ�ӡ������ַ���
				System.out.println("Client:"+in.readLine());//��Client����һ�ַ���������ӡ�����
				line = br.readLine();//��ϵͳ��׼��������ַ���
			}
			//�ر���Դ
			writer.close();//�ر�socket�����
			in.close();//�ر�socket������
			socket.close();//�ر�socket
			server.close();//�ر�serverSocket*/
		}catch(Exception e) {
			System.out.println("Error."+e);
		}
	}
	public void MessageTransfer() {
		
	}
}
//course resource copy by https://www.cnblogs.com/zhoudi/p/6025552.html
//https://blog.csdn.net/ppt0501/article/details/30282493