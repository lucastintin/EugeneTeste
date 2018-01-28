package principal;

import java.util.Random;

public class Combate {
    
    private Monstro[] monstros;
    private int dado;
    
    public Combate(Monstro[] monstros) {
        this.monstros = monstros;
    }
    
    public int rolarDado(int pFaces) {
        Random randNum = new Random();        
        return randNum.nextInt(pFaces);
    }
    
    public int iniciativa(){
        int inicP1 = this.monstros[0].getDex() + rolarDado(20);
        int inicP2 = this.monstros[1].getDex() + rolarDado(20);
        Log log    = new Log();
        
        if (inicP1 > inicP2) {
            System.out.println(this.monstros[0].getNome()+" tem a iniciativa do combate");
            log.gravarArena(this.monstros[0].getNome()+" tem a iniciativa do combate");
            return 0;
        } else {
            System.out.println(this.monstros[1].getNome()+" tem a iniciativa do combate");
            log.gravarArena(this.monstros[1].getNome()+" tem a iniciativa do combate");
            return 1;
        }
    }
   
    public void lutar(int pVez){
        int ataque = this.monstros[pVez].getAtk() + rolarDado(20);
        int defesa = 0;
        Log log    = new Log();
        
        if (pVez == 1){
            defesa = this.monstros[0].getDef()+ rolarDado(20);
        } else {
            defesa = this.monstros[1].getDef()+ rolarDado(20);
        }
                
        if (ataque > defesa) {
            int dano = ataque - defesa;
            System.out.println("Monstro "+ (pVez+1) +" causou "+ dano +" de dano." );
            log.gravarArena("Monstro "+ (pVez+1) +" causou "+ dano +" de dano.");
            
            if (pVez == 1){
                this.monstros[0].setVit(this.monstros[0].getVit()-dano);
            } else {
                this.monstros[1].setVit(this.monstros[1].getVit()-dano);
            }
        } else {
            System.out.println("Bloqueado");
            log.gravarArena("Bloqueado");
        }
        System.out.println("Vida do Monstro 1 = "+ this.monstros[0].getVit());
        System.out.println("Vida do Monstro 2 = "+ this.monstros[1].getVit());
        log.gravarArena("Vida do Monstro 1 = "+ this.monstros[0].getVit());
        log.gravarArena("Vida do Monstro 2 = "+ this.monstros[1].getVit());
    }
    
}
