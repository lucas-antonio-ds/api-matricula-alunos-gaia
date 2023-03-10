package gaia.school.matricula.aluno;

import gaia.school.matricula.endereco.DadosEndereco;

public record DadosCadastroAlunos(
    String nome,
    String email,
    String idade,
    String telefone,
    Curso curso,
    DadosEndereco endereco) {
}
