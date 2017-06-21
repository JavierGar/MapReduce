import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class ThreadLectura extends Thread {
	
	private String nombreArchivo;
	private BufferedWriter writer;
	
	public ThreadLectura(String nombreArchivo,BufferedWriter writer){
		this.nombreArchivo = nombreArchivo;
		this.writer = writer;
	} //Cierre del constructor
	
	@Override
	public void run() {
		Mapper mapeado = new Mapper();
		List<String> listaPalabras = null;
		try {
			listaPalabras = mapeado.map(nombreArchivo);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
        Reducer reductor = new Reducer();
        HashMap<String, Integer> listaReducida = reductor.reduce(listaPalabras);
		try{	
			//construimos el string con el nombre del documento y las palabras
			StringBuilder texto = new StringBuilder();
			texto.append(nombreArchivo);
			texto.append(":");
			texto.append(System.getProperty("line.separator"));
			String lista = listaReducida.toString();
			lista = lista.replace(",", "");  //remove the commas
		    lista = lista.replace("{", "");  //remove the right bracket
		    lista = lista.replace("}", "");  //remove the left bracket
		    lista = lista.replace(" ", "=");  //remove the left bracket
		    String[] palabras = lista.split("=");
		    for (int x = 0; x < palabras.length; x+=2){ //invierte la key y value de posicion
			    	texto.append(palabras[x+1]);
					texto.append(" ");
			    	texto.append(palabras[x]);
					texto.append(System.getProperty("line.separator"));
		    }
			String texto2 = texto.toString();
			writer.write(texto2);
			writer.newLine();		        
        }catch (IOException e) {
        	   System.out.println("Error al escribir en el archivo");
        }
	}
	

}
