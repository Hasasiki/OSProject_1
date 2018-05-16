package hasasiki;

import java.io.*;
import java.net.*;
/*��ͻ�����

a)������Socket����ָ����Ҫ���ӵķ������ĵ�ַ�Ͷ˿ڡ�

b)���������Ӻ�ͨ������������������������Ϣ��

c)��ͨ����������ȡ����������Ӧ��Ϣ��

d)���ر���Ӧ��Դ*/

public class SocketClient {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		try {
			//�����ͻ���socket��ָ����������ַ�Ͷ˿�
			Socket socket = new Socket("0.0.0.0",5209);
			System.out.println("client start!");
			
			// -->��ȡ���������������˷�����Ϣ
			//�򱾻���5209�˿ڷ����ͻ�����
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			//��ϵͳ��׼�����豸����bufferedreader����
			PrintWriter write = new PrintWriter(socket.getOutputStream());
			//��socket����õ��������������pw����
			
			// --�����������������ȡ��������Ӧ��Ϣ
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//��socket����õ�����������������Ӧ��bufferedReader����
			String readline;
			readline = br.readLine();//��ϵͳ��׼�������һ�ַ���
			while(!readline.equals("end")) {
				write.println(readline);//��ϵͳ��׼���������ַ��������server
				write.flush();//ˢ��
				System.out.println("Client:"+ readline);
				System.out.println("Server:"+ in.readLine());
				readline = br.readLine();//�ٴӱ�׼�������һ���ַ���Ӵ
			}
			write.close();
			in.close();
			socket.close();
		}catch (Exception e) {
			System.out.println("can not listen to:" + e);
		}
	}

}
