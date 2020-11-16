package chavevalor;

import org.apache.thrift.TException;
import java.util.HashMap;
import chavevalor.*;

public class ChaveValorHandler implements ChaveValor.Iface {
   private HashMap<Integer,String> kv = new HashMap<>();
   @Override
   public String getKV(int key) throws TException {
       if(kv.containsKey(key))
          return kv.get(key);
       else
          throw new KeyNotFound();
   }
   @Override
   public boolean setKV(int key, String valor) throws TException {
	   if(kv.containsKey(key)) {
		   System.out.println("Chave já preenchida com o valor : "+ kv.get(key));
		   return false;
	   }else {
		   kv.put(key,valor);
	       return true;
	   }
   }
   @Override
   public void delKV(int key) throws TException {
       kv.remove(key);
   }    
}