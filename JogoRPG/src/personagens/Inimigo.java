package personagens;

import java.util.Random;

public class Inimigo {
    private Personagem personagem;
    private Random rand = new Random();
    private String estrategia; // "agressivo", "defensivo", "curandeiro"

    public Inimigo(Personagem personagem) {
        this.personagem = personagem;
        this.estrategia = escolherEstrategia();
    }

    private String escolherEstrategia() {
        String[] estrategias = {"agressivo", "defensivo", "curandeiro"};
        return estrategias[rand.nextInt(estrategias.length)];
    }

    public Personagem getPersonagem() {
        return personagem;
    }

    public void realizarAcao(Personagem alvo) {
        switch (estrategia) {
            case "agressivo":
                if (rand.nextBoolean()) {
                    personagem.usarHabilidade(1, alvo);
                } else {
                    atacar(alvo);
                }
                break;
            case "defensivo":
                if (rand.nextInt(100) < 50) {
                    personagem.defender();
                } else {
                    atacar(alvo);
                }
                break;
            case "curandeiro":
                if (personagem.vida < 50 && personagem.mana >= 20) {
                    personagem.usarHabilidade(2, personagem);
                } else {
                    atacar(alvo);
                }
                break;
            default:
                atacar(alvo);
        }
    }

    private void atacar(Personagem alvo) {
        int dano = personagem.ataque - alvo.defesa + rand.nextInt(6);
        dano = Math.max(0, dano);
        alvo.vida -= dano;
        System.out.println(personagem.nome + " atacou causando " + dano + " de dano!");
    }
}