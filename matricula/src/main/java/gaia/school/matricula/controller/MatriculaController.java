package gaia.school.matricula.controller;

import gaia.school.matricula.aluno.DadosCadastroAlunos;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/matricula")
public class MatriculaController {

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroAlunos dado){
        System.out.println(dado);
    };
}
