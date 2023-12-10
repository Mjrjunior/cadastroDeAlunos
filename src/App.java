import model.Aluno;
import repository.ArrayListAlunoRepository;
import repository.iAlunoRepository;
import exception.AlunoNaoEncontradoException;

import java.util.List;

public class App {
    public static void main(String[] args) {
        try {
            iAlunoRepository repository = new ArrayListAlunoRepository();

            repository.adicionar(new Aluno("João", "1234567890"));
            repository.adicionar(new Aluno("Maria", "0987654321"));
            repository.adicionar(new Aluno("Carlos", "5678901234"));
            repository.adicionar(new Aluno("Ana", "9876543210"));
            repository.adicionar(new Aluno("Pedro", "3456789012"));

            List<Aluno> listaAlunos = repository.listar();
            System.out.println("Lista de Alunos:");
            for (Aluno aluno : listaAlunos) {
                System.out.println("Nome: " + aluno.getNome() + ", Matrícula: " + aluno.getMatricula());
            }

            Aluno alunoBuscado = repository.buscar("Carlos");
            if (alunoBuscado != null) {
                System.out.println("Aluno encontrado: " + alunoBuscado.getNome());
            } else {
                throw new AlunoNaoEncontradoException("Aluno não encontrado");
            }

            repository.remover(alunoBuscado);

            List<Aluno> alunosRestantes = repository.listar();
            System.out.println("\nLista de Alunos após remoção:");
            for (Aluno aluno : alunosRestantes) {
                System.out.println("Nome: " + aluno.getNome() + ", Matrícula: " + aluno.getMatricula());
            }

        } catch (AlunoNaoEncontradoException e) {
            System.err.println(e.getMessage());
        }
    }
}
