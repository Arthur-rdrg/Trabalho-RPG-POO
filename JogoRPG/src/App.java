import java.util.Scanner;
import personagens.Personagem;
import personagens.Inimigo;
import personagens.Lobo;
import personagens.Mago;
import personagens.Elfa;
import personagens.Goblin;

import java.util.Random;

public class App {

    public static void main(String[] args) {
        Personagem jogador;
        Inimigo inimigo;

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("\n=== O Confronto pelo Artefato ===");
            System.out.println("Há muitos séculos, escondido nas profundezas da Floresta Eterna, foi criado um artefato capaz de controlar os quatro elementos da natureza: fogo, água, terra e ar.");
            System.out.println("Esse objeto místico, conhecido como Coração dos Elementos, foi selado por antigos guardiões, não apenas por seu imenso poder, mas por carregar uma maldição esquecida: aquele que tentar dominá-lo corre o risco de perder sua alma.\n");
            System.out.println("Agora, o selo está prestes a se romper, e duas figuras poderosas surgem para disputar sua posse: Elfa Sombria, a elfa guardiã da floresta, e Mago Negro, o mago que dedicou sua vida aos mistérios arcanos.\n");
            System.out.println("Ambos acreditam ser os únicos dignos de controlar o Coração dos Elementos. Aeryn deseja selá-lo novamente e proteger o equilíbrio da natureza. Thalion busca despertar seu verdadeiro potencial e conquistar a sabedoria absoluta para moldar o mundo com as próprias mãos.\n");
            System.out.println("Mas nenhum deles sabe o que realmente aguarda aquele que tocar o artefato.\nA batalha é inevitável. Escolha seu lado. O destino do mundo – e da sua alma – está em jogo.\n");

 
            System.out.print("Escolha seu personagem (1 - Mago | 2 - Elfa): ");
            int escolha = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Digite o nome do seu personagem: ");
            String nome = scanner.nextLine();

        if (escolha == 1) {
            jogador = new Mago(nome);
            inimigo = new Inimigo(new Elfa("Elfa Sombria"));
        } else {
            jogador = new Elfa(nome);
            inimigo = new Inimigo(new Mago("Mago Negro"));
        }

                // Inimigos intermediários (Goblin e Lobo)
                Inimigo goblin = new Inimigo(new Goblin("Goblin assassino"));
                Inimigo lobo = new Inimigo(new Lobo("Lobo selvagem"));
        
                // Início da jornada
                System.out.println("\nVocê começa sua jornada enfrentando inimigos menores para ganhar força...\n");
        
                // Combate contra Goblin
                if (!combater(jogador, goblin, "Goblin")) return;
        
                // Combate contra Lobo
                if (!combater(jogador, lobo, "Lobo")) return;
        
                // Combate final com o inimigo escolhido
                combater(jogador, inimigo, "Chefe Final");
            }
        }

        // Método que gerencia o combate entre o jogador e um inimigo
        private static boolean combater(Personagem jogador, Inimigo inimigo, String tipoDeInimigo) {
            Scanner scanner = new Scanner(System.in);
            Random rand = new Random();

        System.out.println("\n--- Começo do combate contra " + inimigo.getPersonagem().nome + " ---");

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
                    continue; // Pula para o próximo loop
            }

            // Verifica se o inimigo foi derrotado
            if (!inimigo.getPersonagem().estaVivo()) {
                if (tipoDeInimigo.equals("Goblin")) {
                    System.out.println("\nVocê derrotou o Goblin! A floresta ficou mais segura, mas sua jornada ainda está longe de terminar.");
                } else if (tipoDeInimigo.equals("Lobo")) {
                    System.out.println("\nVocê derrotou o Lobo Selvagem! Um perigo a menos na floresta, mas o maior desafio ainda está por vir.");
                } else {
                    System.out.println("\nParabéns, " + jogador.nome + "! Você venceu o " + inimigo.getPersonagem().nome + " e conquistou o artefato ancestral!");
                }
                jogador.subirDeNivel(); // Aumenta o nível após cada combate
                System.out.println("Você subiu para o nível " + jogador.nivel + "!");
                return true; // Indica vitória
            }

            // Turno do inimigo
            if (inimigo.getPersonagem().estaVivo()) {
                int danoInimigo = inimigo.getPersonagem().ataque - jogador.defesa + rand.nextInt(6);
                danoInimigo = Math.max(0, danoInimigo);
                jogador.vida -= danoInimigo;
                System.out.println(inimigo.getPersonagem().nome + " atacou causando " + danoInimigo + " de dano!");
            }
        }

        // Se o jogador não estiver mais vivo, exibe a mensagem de derrota
        if (!jogador.estaVivo()) {
            System.out.println("\nVocê foi derrotado por " + inimigo.getPersonagem().nome + ". O jogo acabou.");
            return false; // Indica derrota
        }
        
        return true; // Indica vitória
    
    }
}


