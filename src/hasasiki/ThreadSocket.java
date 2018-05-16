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
			//��ȡ����������ȡ�ͻ�����Ϣ
			String line;
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//��Socket����õ�����������������Ӧ��BufferedReader����
			PrintWriter writer = new PrintWriter(socket.getOutputStream());
			//��socket����õ��������������PrintWriter����
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			//�ɱ�׼����ϴ�ӡ�ӿͻ��˶�����ַ���
			System.out.println("Client:" + in.readLine());
			//ClientMessage = in.readLine();
			
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
			in.close();
			writer.close();
			} catch(Exception e) {
				e.printStackTrace();
				}
	}

}
