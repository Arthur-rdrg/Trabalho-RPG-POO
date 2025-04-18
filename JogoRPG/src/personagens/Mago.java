package personagens;

import java.util.Random;

public class Mago extends Personagem {
    public Mago(String nome) {
        super(nome, 100, 80, 15, 5);
    }

    @Override
    public void usarHabilidade(int escolha, Personagem alvo) {
        Random rand = new Random();
        if (escolha == 1 && mana >= 20) {
            int dano = 25 + rand.nextInt(10);
            mana -= 20;
            alvo.vida -= dano;
            System.out.println(">>> Bola de Fogo lançada! " + nome + " causou " + dano + " de dano em " + alvo.nome);
        } else if (escolha == 2 && mana >= 15) {
            mana -= 15;
            this.defesa += 5;
            System.out.println(">>> Escudo Arcano ativado! Defesa aumentada.");
        } else {
            System.out.println("Mana insuficiente ou opção inválida.");
        }
    }

@Override
public void mostrarHabilidades() {
    System.out.println("1 - Bola de Fogo (20 de mana): Ataque mágico poderoso");
    System.out.println("2 - Escudo Arcano (15 de mana): Aumenta a defesa temporariamente");
}
}