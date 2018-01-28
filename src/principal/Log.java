package principal;

import java.io.FileWriter;
import java.io.PrintWriter;

public class Log {

    public Log() {
    }
    
    public static void gravar(String pNome, Monstro pMonstro){
        try{
            String executionPath = System.getProperty("user.dir");
            executionPath = executionPath+"/log/";
            
            //Colocar as coisas de gravar o CSV
            FileWriter arquivo = new FileWriter(executionPath+pNome, true);
            PrintWriter gravarArquivo = new PrintWriter(arquivo);
            
            gravarArquivo.println(pMonstro.getAtk()+","+pMonstro.getDef()+","+pMonstro.getDex()+","+pMonstro.getVit());
            
            arquivo.close();
            //System.out.print("Executing at =>"+executionPath.replace("\\", "/"));
        } catch (Exception e){
            System.out.println("Exception caught ="+e.getMessage());
        }
    }
    
    public static void gravarMonstro(String pNome, Monstro pMonstro, int[] paramGenes){
        try{
            String executionPath = System.getProperty("user.dir");
            executionPath = executionPath+"/log/";
            
            //Colocar as coisas de gravar o CSV
            FileWriter arquivo = new FileWriter(executionPath+pNome, true);
            PrintWriter gravarArquivo = new PrintWriter(arquivo);
            
            gravarArquivo.println("Nome.... " + pMonstro.getNome() );
            gravarArquivo.println("Tipo.... " + pMonstro.getTipo());
            gravarArquivo.println("Nivel... " + pMonstro.getNivel());
            gravarArquivo.println("ATK..... " + pMonstro.getAtk()+"("+ paramGenes[0] +")");
            gravarArquivo.println("DEF..... " + pMonstro.getDef()+"("+ paramGenes[1] +")");
            gravarArquivo.println("DEX..... " + pMonstro.getDex()+"("+ paramGenes[2] +")");
            gravarArquivo.println("VIT..... " + pMonstro.getVit()+"("+ paramGenes[3] +")");
            
            arquivo.close();
            //System.out.print("Executing at =>"+executionPath.replace("\\", "/"));
        } catch (Exception e){
            System.out.println("Exception caught ="+e.getMessage());
        }
    }
    
    public static void gravarArena(String pMensagem){
        try{
            String executionPath = System.getProperty("user.dir");
            executionPath = executionPath+"/log/";
            
            //Colocar as coisas de gravar o CSV
            FileWriter arquivo = new FileWriter(executionPath+"arena.txt", true);
            PrintWriter gravarArquivo = new PrintWriter(arquivo);
            
            gravarArquivo.println(pMensagem);
            
            arquivo.close();
            //System.out.print("Executing at =>"+executionPath.replace("\\", "/"));
        } catch (Exception e){
            System.out.println("Exception caught ="+e.getMessage());
        }
    }
    
}
