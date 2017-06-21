import java.util.HashMap;
import java.util.List;

public class Reducer {
		
	public HashMap<String, Integer> reduce(List<String> listaPalabras){
		
		int value = 0;  
		String palabra = "";
        HashMap<String, Integer> listaRepeticiones = new HashMap<String, Integer>();
        
        for (int i= 0; i< listaPalabras.size(); i++){
        	palabra = listaPalabras.get(i);
        	//si la palabra esta, aumentamos el value, si no, la añadimos con value 1
        	if(listaRepeticiones.containsKey(palabra)){
        		value = listaRepeticiones.get(palabra);
        		value += 1;
        		listaRepeticiones.put(palabra, value);
        	}
        	else{
        		listaRepeticiones.put(palabra, 1);
        	}
        }
        
        return listaRepeticiones;
	}

}
