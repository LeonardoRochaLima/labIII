import java.util.*;
import java.io.*;
/**
 * Escreva a descrição da classe Agenda aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Contato

{
    public static void main(String args[]){
       String nome = "";
       String telefone = "";
       File currentDirFile = new File("");
       Scanner scanner = new Scanner(System.in);
       int opcao = 9;
        do {
        System.out.println("                  |     1 - Cadastrar Novo Contato         |");
        System.out.println("                  |     2 - Buscar Contato                 |");
        System.out.println("                  |     3 - Listar Todos os Contatos       |");
        System.out.println("                  |     0 - Sair                           |");
        opcao = scanner.nextInt();
        System.out.print("\n");
        switch (opcao) {
           case 1:
                Scanner input = new Scanner(System.in);
                //CADASTRAR CONTATO
                System.out.print("Escreva o nome do contato: ");
                nome = input.nextLine();
                System.out.print("Escreva o telefone do contato: ");
                telefone = input.nextLine();
                try{
                    salvar(nome, telefone);
                }catch(Exception E){
                    System.out.println("Caiu nessa merda aqui");
                }   
            
                break;
           case 2:
                //BUSCAR CONTATO    
                break;
           case 3:
                //LISTAR TODOS OS CONTATOS
                break;
           case 0:
                try{
                    salvarOrdenado();
                }catch(Exception E){
                    System.out.println("Caiu nessa merda aqui3");
                } 
                
                //SAIR
                break;
           default:
                System.out.println("Opção Inválida!");
                break;
             }
       } while (opcao != 0);
    }
    
    public static void salvar(String nome, String telefone) throws IOException{
       File currentDirFile = new File("");
       String helper = currentDirFile.getAbsolutePath();
       File file = new File(helper+"\\agenda.txt");

       FileWriter fw = new FileWriter(file, true);
       PrintWriter pw = new PrintWriter(fw);
       BufferedWriter bw = new BufferedWriter(pw);
        if(!file.exists()){
        file.createNewFile();
        System.out.println("Arquivo criado com sucesso");
       }else{
        System.out.println("Arquivo ja existe");
       }
       
       bw.write(nome+", "+telefone);
       bw.newLine();
       bw.close();
    }
    
    public static void salvarOrdenado() throws IOException{
        File currentDirFile = new File("");
        BufferedReader arquivo = null;
        String linha = "";
        String limitador = ", ";
        String listaDeContatos = currentDirFile.getAbsolutePath()+"\\agenda.txt";
        try{
           Map<String, String> mapaAgenda = new HashMap<String, String>();
           arquivo = new BufferedReader(new FileReader(listaDeContatos));
            while((linha = arquivo.readLine()) != null){
            String aux[] = linha.split(limitador);
            mapaAgenda.put(aux[0], aux[1]);
           }
           String helper = currentDirFile.getAbsolutePath();
           File file = new File(helper+"\\agenda2.txt");

           FileWriter fw = new FileWriter(file, true);
           PrintWriter pw = new PrintWriter(fw);
           BufferedWriter bw = new BufferedWriter(pw);
           if(!file.exists()){
               file.createNewFile();
               System.out.println("Arquivo criado com sucesso");
            }else{
                file.delete();
                System.out.println("Arquivo ja existe");
            }
            Map<String, String> mapaAgendaOrdenado = new TreeMap<String, String>(mapaAgenda);
            for(Map.Entry<String, String> i : mapaAgendaOrdenado.entrySet()){
                bw.write(i.getKey()+", "+i.getValue());
                bw.newLine();
            }
            bw.close();
        }catch(Exception E){
            System.out.println("Caiu nessa merda aqui2");
        }     
    }
}
