package principal;

import java.util.Random;

public class Monstro {
    
    private String nome;
    private String tipo;
    private int nivel;
    private int atk;
    private int def;
    private int dex;
    private int vit;
    private int[] temBonus;
    private int[] mod;

    public Monstro() {
        this.nivel = 1;
        this.tipo  = " ";
        temBonus = new int[4];
        mod      = new int[4];
        
        this.setTemBonus();
        this.setMod();
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(int[] paramGenes) {
        
        int soma = 0;
        
        for (int i = 0; i < 4; i++) {
           soma = soma + paramGenes[i];
        }
        
        int[] universo = new int[soma];
        int x;
        
        int processados = paramGenes[0];
        for(x = 0; x< processados; x++) {
            universo[x] = 1;
        }
        processados = processados+paramGenes[1];
        
        for(x = paramGenes[0]; x< processados; x++) {
            universo[x] = 2;
        }
        processados = processados+paramGenes[2];
        
        for(x = paramGenes[0]+paramGenes[1]; x< processados; x++) {
            universo[x] = 3;
        }
        processados = processados+paramGenes[3];
        for(x = paramGenes[0]+paramGenes[1]+paramGenes[2]; x< processados; x++) {
            universo[x] = 4;
        }
        
        Random randNum = new Random();
        int sorteado = randNum.nextInt(universo.length);
        
        switch (universo[sorteado]) {
            case 1: this.tipo = "Vermelho"; break;
            case 2: this.tipo = "Verde"; break;
            case 3: this.tipo = "Azul"; break;
            case 4: this.tipo = "Amarelo"; break;
            default: this.tipo = "";
        }
    }
    
    public int getNivel() {
        return nivel;
    }

    public void setNivel(int[] paramGenes) {
        for (int i = 0; i < 5; i++) {
            nivel = nivel + paramGenes[i];
        }
        nivel = (int) (nivel/100);     
        
       if (nivel == 0) { 
           nivel = 1;
       } 
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getDex() {
        return dex;
    }

    public void setDex(int dex) {
        this.dex = dex;
    }

    public int getVit() {
        return vit;
    }

    public void setVit(int vit) {
        this.vit = vit;
    }

    public int[] getTemBonus() {
        return temBonus;
    }

    private void setTemBonus() {
        for (int i = 0; i < 4; i++) {
            this.temBonus[i] = 0;
        }
    }

    public int[] getMod() {
        return mod;
    }

    private void setMod() {
        for (int i = 0; i < 4; i++) {
            this.mod[i] = 4-i;
        }
    }
    
    public void sortearBonus(){
        
        Random randNum = new Random();        
        int sorteado = randNum.nextInt(4);
        
        this.temBonus[sorteado]  = 1; 
    }
        
    public void gerarMonstro(int[] paramGenes) {
        
        this.sortearBonus();
        
        this.setTipo(paramGenes);
        
        this.setNivel(paramGenes);
        
        this.atk =  ((paramGenes[0]*mod[0])+(this.temBonus[0]*paramGenes[4])) +
                    ((paramGenes[1]*mod[1])) +
                    ((paramGenes[2]*mod[2])) +
                    ((paramGenes[3]*mod[3]));           
        
        this.def =  ((paramGenes[0]*mod[3])) +
                    ((paramGenes[1]*mod[0])+(this.temBonus[1]*paramGenes[4])) +
                    ((paramGenes[2]*mod[1])) +
                    ((paramGenes[3]*mod[2]));
        
        this.dex =  ((paramGenes[0]*mod[2])) +
                    ((paramGenes[1]*mod[3])) +
                    ((paramGenes[2]*mod[0])+(this.temBonus[2]*paramGenes[4])) +
                    ((paramGenes[3]*mod[1]));
        
        this.vit =  ((paramGenes[0]*mod[1])) +
                    ((paramGenes[1]*mod[2])) +
                    ((paramGenes[2]*mod[3])) +
                    ((paramGenes[3]*mod[0])+(this.temBonus[3]*paramGenes[4]));
    }
    
    public void printMonstro(){
        System.out.println(" ");
        System.out.println("Monstro criado.");
        System.out.println("Nome.... " + this.getNome());
        System.out.println("Tipo.... " + this.getTipo());
        System.out.println("Nivel... " + this.getNivel());
        System.out.println("ATK..... " + this.getAtk());
        System.out.println("DEF..... " + this.getDef());
        System.out.println("DEX..... " + this.getDex());
        System.out.println("VIT..... " + this.getVit());
        System.out.println(" ");
    }
    
    public void printMonstro(int[] paramGenes){
        System.out.println(" ");
        System.out.println("Monstro criado.");
        System.out.println("Nome.... " + this.getNome() );
        System.out.println("Tipo.... " + this.getTipo());
        System.out.println("Nivel... " + this.getNivel());
        System.out.println("ATK..... " + this.getAtk()+"("+ paramGenes[0] +")");
        System.out.println("DEF..... " + this.getDef()+"("+ paramGenes[1] +")");
        System.out.println("DEX..... " + this.getDex()+"("+ paramGenes[2] +")");
        System.out.println("VIT..... " + this.getVit()+"("+ paramGenes[3] +")");
        System.out.println(" ");
    }
    
    
}
