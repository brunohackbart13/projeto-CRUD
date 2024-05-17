package br.com.alura.project_01.domain.pecas;

import br.com.alura.project_01.controller.Pecas.DadosAlteraPecas;
import jakarta.persistence.*;

@Entity
@Table (name = "pecas")
public class Pecas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String equipamento;
    private String peso;
    private String valor;

    public Pecas(DadosCadastroPecas dados){
        this.nome = dados.nome();
        this.equipamento = dados.equipamento();
        this.peso = dados.peso();
        this.valor = dados.valor();
    }
    public Pecas() {
    }

    public void atualizaDados(DadosAlteraPecas dados) {
        this.nome = dados.nome();
        this.equipamento = dados.equipamento() ;
        this.peso = dados.peso();
        this.valor = dados.valor();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEquipamento() {
        return equipamento;
    }

    public String getPeso() {
        return peso;
    }

    public String getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Peças{" +
                "nome='" + nome + '\'' +
                ", equipamento='" + equipamento + '\'' +
                ", peso='" + peso + '\'' +
                ", valor='" + valor + '\'' +
                '}';
    }
}

