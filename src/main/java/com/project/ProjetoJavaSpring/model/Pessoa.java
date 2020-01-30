package com.project.ProjetoJavaSpring.model;


import com.project.ProjetoJavaSpring.utils.ValidaCpf;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name="PESSOA")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer Id;

    @Column(name = "CPF")
    private String cpf;

    @Column(name = "nome")
    private String nome;

    @Column(name = "ENDERECO")
    private Endereco endereco;

    @Column(name = "DataNascimento")
    private Date dataNacimento;

    public void setCpf(String cpf) {
        Boolean cpfTeste = ValidaCpf.isCPF(cpf);
        if(cpfTeste){
            this.cpf = cpf;
        }else{
          throw new RuntimeException("CPF invalido!");
        }

    }
}
