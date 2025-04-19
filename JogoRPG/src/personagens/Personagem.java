package personagens;

public abstract class Personagem {
    public String nome;
    public int nivel;
    public int vida;
    public int mana;
    public int maxVida;
    public int maxMana;
    public int ataque;
    public int defesa;

    public Personagem(String nome, int vida, int mana, int ataque, int defesa) {
        this.nome = nome;
        this.vida = vida;
        this.mana = mana;
        this.maxVida = vida; // Initialize maxVida with the initial vida
        this.maxMana = mana; // Initialize maxMana with the initial mana
        this.vida = vida;
        this.mana = mana;
        this.ataque = ataque;
        this.defesa = defesa;
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public abstract void usarHabilidade(int escolha, Personagem alvo);

    public void defender() {
        this.defesa += 3;
        System.out.println(nome + " está se defendendo, defesa aumentada temporariamente!");
    }

    public void subirDeNivel() {
        nivel++; // Incrementa o nível
        maxVida += 10; // Aumenta o máximo de vida
        maxMana += 5; // Aumenta o máximo de mana
        ataque += 2; // Aumenta o ataque base
        vida = maxVida; // Restaura a vida ao máximo
        mana = maxMana; // Restaura a mana ao máximo

        // Aumenta o dano das habilidades (se houver habilidades específicas)
        melhorarHabilidades();

        System.out.println(nome + " subiu para o nível " + nivel + "!");
        System.out.println("Vida máxima: " + maxVida + ", Mana máxima: " + maxMana + ", Ataque: " + ataque);
    }

   

// Define the method to improve skills
public abstract void melhorarHabilidades();

public abstract void mostrarHabilidades();
}
