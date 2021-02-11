import java.util.*;
import java.io.*;

package fitxategiak1;

class janariaReg{
	
}

public class Ariketa1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//Fitxategiak irakurtzeko
		File file = new File("fitxategiak/janariak.txt");
		String textline;
		String [] data;
		
		int zenbat = 500;
		
		//Erregistro motako Array bakarra sortu
		janariaReg[] janariak = new janariaREg[];
		
		//Fitxeroa irakurtzeko
		FileReader reader = new FileReader(file);
		BufferedReader buffer = new BufferedReader(reader);
		
		textline = buffer.readLine();
		
		/*Batzutan lehenengo lerroa kendu nahi dugu ez delako erabilgarria
		 *Horretarako:
		 *	if(textline != null){
		 *		textline = buffer.readLine();
		 *}*/
		
		//xd
		System.out.println("XD");
	}

}
