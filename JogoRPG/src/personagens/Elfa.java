package personagens;

import java.util.Random;

public class Elfa extends Personagem {
    public Elfa(String nome) {
        super(nome, 120, 60, 12, 6);
    }

    @Override
    public void usarHabilidade(int escolha, Personagem alvo) {
        Random rand = new Random();
        if (escolha == 1 && mana >= 15) {
            int dano = 18 + rand.nextInt(8);
            mana -= 15;
            alvo.vida -= dano;
            System.out.println(">>> Flecha Venenosa disparada! Causou " + dano + " de dano em " + alvo.nome);
        } else if (escolha == 2 && mana >= 20) {
            mana -= 20;
            int cura = 20 + rand.nextInt(10);
            this.vida += cura;
            System.out.println(">>> Cura Natural! " + nome + " recuperou " + cura + " de vida.");
        } else {
            System.out.println("Mana insuficiente ou opção inválida.");
        }
    }
}
