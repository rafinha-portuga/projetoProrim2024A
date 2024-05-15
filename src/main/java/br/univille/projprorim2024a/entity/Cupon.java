package br.univille.projprorim2024a.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Cupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 1000, nullable = false)
    @NotBlank(message = "Campo não pode ser em branco")
    private String nome;
    private long idEmpresa;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataExpiracao;
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public long getIdEmpresa() {
        return idEmpresa;
    }
    public void setIdEmpresa(long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
    public Date getDataExpiracao() {
        return dataExpiracao;
    }
    public void setDataExpiracao(Date dataExpiracao) {
        this.dataExpiracao = dataExpiracao;
    }

    
}
