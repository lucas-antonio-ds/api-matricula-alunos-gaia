package gaia.school.matricula.aluno;

public record DadosCadastroAlunos(String nome,
                                  String email,
                                  String idade,
                                  String telefone,
                                  Curso curso,
                                  DadosEndereco endereco) {
}
