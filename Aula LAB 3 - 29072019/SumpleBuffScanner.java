import java.io.*;
import java.util.*;
/**
 * Escreva a descrição da classe Main aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class SumpleBuffScanner

{
    public static void main(String args[]) throws IOException{
       long tempoInicio = System.currentTimeMillis();
       BufferedWriter out = null;
       Scanner scanner = null;
       try{
           scanner = new Scanner(new BufferedReader(new FileReader("arquivogrande.txt")));
           out = new BufferedWriter(new FileWriter("arquivopequeno.txt"));
           while (scanner.hasNext()){
               out.write(scanner.next());
               out.write("\n");
            }
        } finally{
            if(scanner != null){
                scanner.close();
            }
            if(scanner != null){
                out.close();
            }
        }
        System.out.println("Tempo Total: "+(System.currentTimeMillis()-tempoInicio));
    }
}
