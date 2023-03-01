package gaia.school.matricula.aluno;

import gaia.school.matricula.endereco.Endereco;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "alunos") 
@Entity(name = "Aluno")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Aluno {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    private String nome ;
    private String email ;
    private String idade ;
    private String telefone ;

    @Enumerated(EnumType.STRING)
    private Curso curso ;
    
    @Embedded
    private Endereco endereco ;



    public Aluno(DadosCadastroAlunos dados) {
  
        this.nome = dados.nome();
        this.email = dados.email();
        this.idade = dados.idade();
        this.telefone = dados.telefone();
        this.curso = dados.curso();
        this.endereco = new Endereco(dados.endereco());
    }


    public void atualizarInformacoes(DadosAtualizacaoAlunos dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.email() != null) {
            this.email = dados.email();
        }
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
        if (dados.curso() != null) {
            this.curso = dados.curso();
        }
        if (dados.endereco() != null) {
            this.endereco.atualizarInformacoes(dados.endereco());
        }

    }

}
