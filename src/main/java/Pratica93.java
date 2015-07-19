
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import utfpr.ct.dainf.if62c.pratica.ExecCmd;


/**
 * UTFPR - Universidade Tecnológica Federal do Paraná
 * DAINF - Departamento Acadêmico de Informática
 * 
 * Template de projeto de programa Java usando Maven.
 * @author Wilson Horstmeyer Bogado <wilson@utfpr.edu.br>
 */

public class Pratica93 {
    public static void main(String[] args){
        Runtime rt = Runtime.getRuntime();
        List<ExecCmd> comandos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String cmd;
        
        while(true){
            System.out.print("comando> ");
            cmd = scanner.next();
            
            if(!cmd.toLowerCase().equals("fim")){
                comandos.add(new ExecCmd(cmd));
                comandos.get(comandos.size()-1).start();
            }
            else{
                int soma = 0;
                char resposta;
                
                for(ExecCmd c: comandos)
                    soma += c.terminado()?0:1;
                
                System.out.print("Há " + soma + 
                        " processos em execução. Deseja terminá-los? <y/n>");
                
                do
                    resposta = scanner.next().charAt(0);
                while(resposta != 'y' && resposta != 'n');
                
                if(resposta == 'y'){
                    for(ExecCmd c: comandos)
                        c.cancela();
                    break;
                }
                
            }
        }
    }
}
