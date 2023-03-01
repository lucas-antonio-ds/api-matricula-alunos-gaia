package gaia.school.matricula.aluno;

import gaia.school.matricula.endereco.DadosEndereco;

public record DadosAtualizacaoAlunos(
    long id,
    String nome,
    String email,
    String telefone,
    Curso curso,
    DadosEndereco endereco) {
    
}
