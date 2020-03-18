
import java.io.*;
/**
 * Escreva a descrição da classe Main aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class SimplyCharacterCopy

{
    public static void main(String args[]) throws IOException{
       long tempoInicio = System.currentTimeMillis();
       FileReader in = null;
       FileWriter out = null;
       try{
           in = new FileReader("arquivomedio.txt");
           out = new FileWriter("arquivopequeno.txt");
           int c;
           while ((c = in.read()) != -1){
               out.write(c);
            }
        } finally{
            if(in != null){
                in.close();
            }
            if(out != null){
                out.close();
            }
        }
        System.out.println("Tempo Total: "+(System.currentTimeMillis()-tempoInicio));
    }
}
