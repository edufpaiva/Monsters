package edufpaiva.com.br.monsters;

/**
 * Created by pc on 16/10/2016.
 */

public class Monstro {

    private String imgCapa;
    private String nome;
    private boolean imortal;
    private String fraqueza;
    private String forca;

    public Monstro(String imgCapa, String nome, boolean imortal, String fraqueza, String forca) {
        this.imgCapa = imgCapa;
        this.nome = nome;
        this.imortal = imortal;
        this.fraqueza = fraqueza;
        this.forca = forca;
    }

    public String getImgCapa() {
        return imgCapa;
    }

    public void setImgCapa(String imgCapa) {
        this.imgCapa = imgCapa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isImortal() {
        return imortal;
    }

    public void setImortal(boolean imortal) {
        this.imortal = imortal;
    }

    public String getFraqueza() {
        return fraqueza;
    }

    public void setFraqueza(String fraqueza) {
        this.fraqueza = fraqueza;
    }

    public String getForca() {
        return forca;
    }

    public void setForca(String forca) {
        this.forca = forca;
    }


}
