package personagens;

public abstract class Personagem {
    public String nome;
    int nivel;
    public int vida;
    public int mana;
    public int ataque;
    public int defesa;

    public Personagem(String nome, int vida, int mana, int ataque, int defesa) {
        this.nome = nome;
        this.nivel = 1;
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


public abstract void mostrarHabilidades();
}
