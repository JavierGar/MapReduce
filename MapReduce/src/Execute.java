/**
 * @author Javier García Cantero 1332973
 */


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class Execute {
	
	
	public static void main(String args[]) throws Exception{
		
		int numArchivos = args.length;
		File archivo = new File("palabras_repetidas.txt");
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(archivo),"UTF-8"));
		
        if(archivo.exists()==true){//si el archivo ya existe, borramos el existente y creamos uno nuevo
            System.out.println("archivo palabras_repetidas creado");
            archivo.delete();
            archivo.createNewFile();
        }
        
		ThreadLectura[] threads = new ThreadLectura[numArchivos];
		for(int j = 0; j < numArchivos; j++){
			//abrimos un thread por cada documento
			threads[j]  = new ThreadLectura(args[j], writer);
			threads[j].start();
		}
		for(int j=0; j< numArchivos; j++) {
			threads[j].join(); // Esperamos a que acaben todos los threads
		}
		writer.close();
        System.out.println("Terminado");    

	}

	
		
}

