package chavevalor;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

public class ChaveValorClient {

	public static void main(String[] args) {
		try {
			TTransport transport;
			transport = new TSocket("localhost",9090);
			TProtocol protocol = new TBinaryProtocol(transport);
			ChaveValor.Client client = new ChaveValor.Client(protocol);
			
			client.setKV(10, "valor para a chave 10");
			System.out.println("Valor = "+ client.getKV(10));
			System.out.println("Apagando valor ...");
			client.delKV(10);
			System.out.println("Valor : "+ client.getKV(10));
			
			transport.close();
		} catch (TException x) {
			x.printStackTrace();
		}

	}

}
