package principal;

import java.util.Scanner;

public class Eugene {
    
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        int opcao = 0;
        int sair  = 1;
        
        System.out.println("Me chamo Eugene, seja bem-vindo ao meu laboratorio!");
        while (sair == 1) {
            System.out.println("Escolha a opcao que voce deseja");
            System.out.println("1 - LAB, 2 - Arena");
            opcao = teclado.nextInt();
            
            switch(opcao){
                case 1: laboratorio(); break;
                case 2: arena(); break;
            }
            
            System.out.println("Deseja continuar no jogo?");
            System.out.println("1- Sim, 2- Nao"); 
            sair = teclado.nextInt();
        }    
    }
    
    public static void laboratorio() {
        Scanner teclado = new Scanner(System.in);
        int genes[] = new int[5];    
        int sair    = 1;
        int gravar  = 2;
        Log log     = new Log();
        
        System.out.println("==LAB==");
        
        while (sair == 1) {    
            System.out.println("==Vamos criar um monstro ?==");
            System.out.println("Por favor insira quantidade de Genes para criar teu monstro");
            System.out.print("Quantos Genes Vermelhos? ");
            genes[0] = teclado.nextInt();
            System.out.print("Quantos Genes Verdes?    ");
            genes[1] = teclado.nextInt();
            System.out.print("Quantos Genes Azuis?     ");
            genes[2] = teclado.nextInt();
            System.out.print("Quantos Genes Amarelos?  ");
            genes[3] = teclado.nextInt();
            System.out.print("Quantos Genes Pretos?    ");
            genes[4] = teclado.nextInt();
            System.out.println("Aguarde a maquina criar o monstro.");
        
            Monstro monstro1 = new Monstro();
            monstro1.setNome("Ornitoptero");
            monstro1.gerarMonstro(genes);     
            monstro1.printMonstro();
            
            System.out.println("Deseja gravar esse monstro ?");
            System.out.println("1- Sim, 2- Nao");   
            gravar = teclado.nextInt();
            
            if (gravar == 1){
                log.gravar("monstros.csv", monstro1);
            }
            
            System.out.println("Deseja criar outro monstro ?");
            System.out.println("1- Sim, 2- Nao");   
            sair = teclado.nextInt();
        }
    }
    
    public static void arena() {
        Scanner teclado = new Scanner(System.in);
        int genes[] = new int[5];    
        int sair    = 1;
        int player  = 0;
        int fim     = 0;
        Log log     = new Log();
        
        Monstro[] monstros = new Monstro[2];
        
        for (int i = 0; i < 2; i++) {
            System.out.println("Por favor insira quantidade de Genes para criar teu monstro");
            System.out.print("Quantos Genes Vermelhos? ");
            genes[0] = teclado.nextInt();
            System.out.print("Quantos Genes Verdes?    ");
            genes[1] = teclado.nextInt();
            System.out.print("Quantos Genes Azuis?     ");
            genes[2] = teclado.nextInt();
            System.out.print("Quantos Genes Amarelos?  ");
            genes[3] = teclado.nextInt();
            System.out.print("Quantos Genes Pretos?    ");
            genes[4] = teclado.nextInt();
        
            monstros[i] = new Monstro();
            monstros[i].setNome("Monstro "+(i+1));
            monstros[i].gerarMonstro(genes);
            monstros[i].printMonstro();
            log.gravarMonstro("arena.txt", monstros[i], genes);
        }
        
        Combate ufc = new Combate(monstros);
        
        player = ufc.iniciativa();
        
        do {
           ufc.lutar(player);
           
           //Trocando o Turno - deve ter um maneira menos imbecil
           if (player == 1) {
               player = 0;
           } else {
               player = 1;
           }
           
           //While com OR tava dando erro, ae coloquei essa parada.
           if (monstros[0].getVit() <= 0 ) {
               fim  = 1;
           }
           
           if (monstros[1].getVit() <= 0 ) {
               fim  = 1;
           }
           //Fim da condicao de vitoria
        } while (fim == 0);
        
        if (monstros[0].getVit() > monstros[1].getVit()) {
            System.out.println(monstros[0].getNome() +" venceu!");
            log.gravarArena(monstros[0].getNome() +" venceu!");
        } else {
            System.out.println(monstros[1].getNome() +" venceu!");
            log.gravarArena(monstros[1].getNome() +" venceu!");
        }
        
    }
    
    
       
}
