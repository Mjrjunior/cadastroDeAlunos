package repository;

import model.Aluno;
import java.util.List;

public interface iAlunoRepository {
    void adicionar(Aluno aluno);

    void remover(Aluno aluno);

    Aluno buscar(String nome);

    List<Aluno> listar();
}
