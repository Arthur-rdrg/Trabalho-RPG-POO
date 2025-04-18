import java.util.Scanner;
import personagens.Personagem;
import personagens.Inimigo; 
import personagens.Mago;
import personagens.Elfa;
import java.util.Random;

public class App {

    public static void main(String[] args) {
        Personagem jogador;
        Inimigo inimigo;

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("\n=== O Confronto pelo Artefato ===");
            System.out.println("Há séculos, um artefato mágico capaz de controlar os elementos da natureza está escondido. Agora, um Mago e uma Elfa se enfrentam por seu poder.\n");

            System.out.print("Escolha seu personagem (1 - Mago | 2 - Elfa): ");
            int escolha = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Digite o nome do seu personagem: ");
            String nome = scanner.nextLine();

        if (escolha == 1) {
            jogador = new Mago(nome);
            inimigo = new Inimigo(new Elfa("Elfa Sombra"));
        } else {
            jogador = new Elfa(nome);
            inimigo = new Inimigo(new Mago("Mago Sombrio"));
        }

        Random rand = new Random();

        while (jogador.estaVivo() && inimigo.getPersonagem().estaVivo()) {
            System.out.println("\nSeu status: Vida: " + jogador.vida + ", Mana: " + jogador.mana);
            System.out.println("Inimigo: Vida: " + inimigo.getPersonagem().vida);
            System.out.println("\nEscolha sua ação:");
            System.out.println("1 - Atacar\n2 - Usar Habilidade 1\n3 - Usar Habilidade 2\n4 - Defender\n5 - Mostrar Habilidades\n");
            System.out.print("Digite o número da ação: ");

            int acao = scanner.nextInt();

            switch (acao) {
                case 1:
                    int dano = jogador.ataque - inimigo.getPersonagem().defesa + rand.nextInt(6);
                    dano = Math.max(0, dano);
                    inimigo.getPersonagem().vida -= dano;
                    System.out.println(jogador.nome + " atacou causando " + dano + " de dano!");
                    break;
                case 2:
                case 3:
                    jogador.usarHabilidade(acao - 1, inimigo.getPersonagem());
                    break;
                case 4:
                    jogador.defender();
                    break;
                case 5:
                    jogador.mostrarHabilidades();
                    continue;    
                default:
                    System.out.println("Ação inválida!");
            }

            if (inimigo.getPersonagem().estaVivo()) {
                inimigo.realizarAcao(jogador);
                }
            }
        }

        if (jogador.estaVivo()) {
            System.out.println("\nParabéns, " + jogador.nome + "! Você venceu e conquistou o artefato ancestral!");
        } else {
            System.out.println("\nVocê foi derrotado. O artefato está perdido... por enquanto.");
        }
    }
}
