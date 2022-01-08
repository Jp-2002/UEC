/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package githubtest2;

import java.util.Random;

/**
 *
 * @author joaop
 */
public class Luta {
    //Atributos
    private Lutador desafiado ;
    private Lutador desafiante;
    private int round;
    private boolean aprovada;
    
    //Métodos especiais
    public Lutador getDesafiado() {
        return desafiado;
    }

    public void setDesafiado(Lutador dd) {
        this.desafiado = dd;
    }

    public Lutador getDesafiante() {
        return desafiante;
    }

    public void setDesafiante(Lutador de) {
        this.desafiante = de;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public boolean isAprovada() {
        return aprovada;
    }

    public void setAprovada(boolean aprovada) {
        this.aprovada = aprovada;
    }
    
    //Métodos públicos
    public void marcarLuta(Lutador l1, Lutador l2) {
        if (l1.getCategoria().equals(l2.getCategoria()) && (l1 != l2)) {
            this.setAprovada(true);
            this.setDesafiado(l1);
            this.setDesafiante(l2);
            System.out.println("Luta marcada.");
        } else {
            this.setAprovada(false);
            this.setDesafiado(null);
            this.setDesafiante(null);
            System.out.println("A luta não pode ser marcada.");
        }
    }
    
    public void lutar() {
        if (this.isAprovada()) {
            System.out.println("");
            System.out.println("### DESAFIANTE ###");
            System.out.println("");
            this.desafiante.apresentar();
            System.out.println("### DESAFIADO ###");
            System.out.println("");
            this.desafiado.apresentar();
            
            Random aleatorio = new Random();
            int vencedor = aleatorio.nextInt(3);
            switch(vencedor) {
                case 0 -> {System.out.println("Vitória do " + this.desafiado.getNome());
                    this.desafiado.ganharLuta();
                    this.desafiante.perderLuta();}
                
                case 1 -> {System.out.println("Vitória do " + this.desafiante.getNome());
                    this.desafiado.perderLuta();
                    this.desafiante.ganharLuta();}
                
                case 2 -> {System.out.println("Houve um empate");
                    this.desafiado.empatarLuta();
                    this.desafiante.empatarLuta();}
            }
        } else {
            System.out.println("A luta não pode acontecer");
        }
    }
}
