package gaia.school.matricula.controller;

import gaia.school.matricula.aluno.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gaia.school.matricula.aluno.AlunoRepository;
import gaia.school.matricula.aluno.DadosAtualizacaoAlunos;
import gaia.school.matricula.aluno.DadosCadastroAlunos;
import gaia.school.matricula.aluno.DadosListagemAluno;
import jakarta.transaction.Transactional;


@RestController
@RequestMapping("/matricula")
public class MatriculaController {

    @Autowired
    private AlunoRepository repository;

    /**
     * void indica que a classe cadastrar não retorna dados
     * os dados a serem postados foram criados no record DadosCadastroAluno e retorna o parametro "dados"
     * o repository.save salva o construtor da classe Aluno com os parametros "dados"
     */
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroAlunos dados){
        repository.save(new Aluno(dados));
    }

    /**
     * o list é importado do Java Util (o List foi substituido por Page)
     * o GET de listar tem como ordenação de pagina o default retornar 10 linhas por pagina e ordenar pelo nome
     * o Page e Pageable deve ser importado de Spring.data 
     * o map retorna para o reposity.findall o construtor da classe Dados ListagemAluno
     */
    @GetMapping
    public Page<DadosListagemAluno> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemAluno::new); // o find all vira findAllAtivoTrue para apenas retornar alunos ativos
    }

    /**
     * através do ID, atualizamos elementos na entidade aluno
     * criamos o DTO record para fazer a atualização
     * o repository.getReferenceById puxa o ID do DTO e fazer a atualização a partir dele
     * o metodo atualizar informações é criado dentro do DTO de novo cadastro (post)
     */
    @PutMapping
    @Transactional
    public void atualizar(@RequestBody DadosAtualizacaoAlunos dados){
        var aluno = repository.getReferenceById(dados.id());
        aluno.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
