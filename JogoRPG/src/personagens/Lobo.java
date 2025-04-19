package personagens;

import java.util.Random;

public class Lobo extends Personagem {
    public Lobo(String nome) {
        super(nome, 50, 0, 10, 3); // vida, mana, ataque, defesa
    }

    @Override
    public void melhorarHabilidades() {
        this.ataque += 2;
        this.defesa += 1;
        System.out.println(nome + " aprimorou suas habilidades! Ataque e defesa aumentados.");
    }

    @Override
    public void usarHabilidade(int escolha, Personagem alvo) {
        morder(alvo); // só tem um ataque físico
    }

    @Override
    public void mostrarHabilidades() {
        System.out.println("1 - Mordida Selvagem: Ataque físico básico.");
    }

    private void morder(Personagem alvo) {
        Random rand = new Random();
        int dano = ataque - alvo.defesa + rand.nextInt(6); // ataque com variação maior
        dano = Math.max(0, dano);
        alvo.vida -= dano;
        System.out.println(nome + " morde ferozmente e causa " + dano + " de dano!");
    }
}