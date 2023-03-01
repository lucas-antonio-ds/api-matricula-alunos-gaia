package gaia.school.matricula.aluno;

// record que criará a listagem de alunos ao ser feita a requisição get
public record DadosListagemAluno(Long id, String nome, String email, String idade, Curso curso) {

    public DadosListagemAluno(Aluno aluno) {
        this(aluno.getId(), aluno.getNome(), aluno.getEmail(), aluno.getIdade(), aluno.getCurso());
    }
    
}
