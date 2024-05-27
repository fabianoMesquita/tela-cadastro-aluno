package aula5;

public class Aluno {

    private String nome;
    private String status;
    private String curso;
    private String turno;
    private Double n1;
    private Double n2;
    private Double media;
    private int idade;


    public Aluno(){} // construtor

    //construtor de parametros
    public Aluno(String nome, Double n1, Double n2, String curso,String turno, int idade) {
        super();
        this.nome = nome;
        this.n1 = n1;
        this.n2 = n2;
        this.curso = curso;
        this.turno = turno;
        this.idade = idade;
        calcMedia();
    }

    void calcMedia() {
        media = (n1+n2)/2;
        if(media >= 6)
            status = "Aprovado";
        else if (media >= 4)
            status = "Em recuperação";
        else
            status = "Reprovado";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getN1() {
        return n1;
    }

    public void setN1(Double n1) {
        this.n1 = n1;
    }

    public Double getN2() {
        return n2;
    }

    public void setN2(Double n2) {
        this.n2 = n2;
    }

    public Double getMedia() {
        return media;
    }

    public void setMedia(Double media) {
        this.media = media;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String curso) {
        this.curso = turno;
    }
    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

}