package personagens;

import java.util.Random;

public class Elfa extends Personagem {
    public Elfa(String nome) {
        super(nome, 120, 60, 12, 6);
    }
    private int danoHabilidade1;
    private int danoHabilidade2;

    @Override
    public void melhorarHabilidades() {
        danoHabilidade1 += 5; // Aumenta o dano da habilidade 1
        danoHabilidade2 += 7; // Aumenta o dano da habilidade 2
        System.out.println("As habilidades do Mago foram aprimoradas!");
    }

    @Override
    public void usarHabilidade(int escolha, Personagem alvo) {
        Random rand = new Random();
        if (escolha == 1 && mana >= 15) {
            int dano = 18 + rand.nextInt(8) + danoHabilidade1;
            mana -= 15;
            alvo.vida -= dano;
            System.out.println(">>> Flecha Venenosa disparada! Causou " + dano + " de dano em " + alvo.nome);
        } else if (escolha == 2 && mana >= 20) {
            mana -= 20;
            int cura = 20 + rand.nextInt(10) + danoHabilidade2;
            this.vida += cura;
            System.out.println(">>> Cura Natural! " + nome + " recuperou " + cura + " de vida.");
        } else {
            System.out.println("Mana insuficiente ou opção inválida.");
        }
    }

@Override
    public void mostrarHabilidades() {
        System.out.println("1 - Flecha Venenosa (15 de mana): Ataque com veneno (dano: 18 + variação)");
        System.out.println("2 - Cura Natural (20 de mana): Recupera pontos de vida(cura: 20 + variação)");
    }
}
