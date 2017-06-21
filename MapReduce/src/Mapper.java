import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Mapper {
	
	public List<String> map(String file) throws Exception {
        List<String> palabras = new ArrayList<>();
        
        BufferedReader in = new BufferedReader( new InputStreamReader(new FileInputStream(file), "UTF-8"));
        String line = "";

        while ((line = in.readLine()) != null) {
            int i = 0;
            //leemos una linea del document
            //separamos las palabras de la linea y las añadimos a una lista una por una
            String[] palabra = line.split("[^ç'ñá-úÁ-Úà-ùÀ-Ùa-zA-Z\\d]");       

            while (i < palabra.length) {
            	//este if se asegura de que no añadimos una palabra en blanco
            	if (palabra[i].trim().length() <= 0){
            		i++;
            	}
            	else{
	            palabras.add(palabra[i]);
	            i++;
            	}
            }
        }
        in.close();
        return palabras;

    }

}

