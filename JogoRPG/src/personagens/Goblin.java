package personagens;

import java.util.Random;

public class Goblin extends Personagem {
    public Goblin(String nome) {
        super(nome, 40, 10, 8, 2); // vida, mana, ataque, defesa
    }

    @Override
    public void usarHabilidade(int escolha, Personagem alvo) {
        atacar(alvo); // Goblin não tem habilidades especiais
    }

    @Override
    public void mostrarHabilidades() {
        System.out.println("O Goblin não possui habilidades especiais.");
    }

    private void atacar(Personagem alvo) {
        Random rand = new Random();
        int dano = ataque - alvo.defesa + rand.nextInt(4); // ataque simples com variação aleatória
        dano = Math.max(0, dano);
        alvo.vida -= dano;
        System.out.println(nome + " ataca com sua adaga e causa " + dano + " de dano!");
    }

    @Override
    public void melhorarHabilidades() {
        System.out.println(nome + " não pode melhorar habilidades, pois não possui habilidades especiais.");
    }
}