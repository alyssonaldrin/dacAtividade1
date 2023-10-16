/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.alyssonaldrin1.factories;

import com.mycompany.alyssonaldrin1.entities.Aluno;
import com.mycompany.alyssonaldrin1.entities.Empresa;
import com.mycompany.alyssonaldrin1.entities.Estagio;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author cfontes
 */
public class FactoryRead {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("my_persistence_unit");
        EntityManager manager = factory.createEntityManager();
        
        manager.getTransaction().begin();
        
        //Listar Todos Alunos
        System.out.println("Listar Todos Alunos");
        System.out.println();
        Query query = manager.createQuery("SELECT a FROM Aluno a");
        
        List<Aluno> alunos = query.getResultList();
        
        for(Aluno aluno : alunos){
            System.out.println("Nome: " + aluno.getNome());
            System.out.println("Matricula: " + aluno.getMatricula());
            System.out.println("Curso: " + aluno.getCurso());
            System.out.println("Orientador: " + aluno.getOrientador().getNome());
            System.out.println("Empresa: " + aluno.getEmpresa().getNome());
            System.out.println();
        }
        
        //Listar Aluno Por Id
        System.out.println("Listar Aluno Por Id");
        System.out.println();
        Long alunoId = 1L;
        Query query2 = manager.createQuery("SELECT a FROM Aluno a WHERE a.id = :alunoId");
        query2.setParameter("alunoId", alunoId);
        
        Aluno aluno2 = (Aluno) query2.getSingleResult();
        
        System.out.println("Nome: " + aluno2.getNome());
        System.out.println("Matricula: " + aluno2.getMatricula());
        System.out.println("Curso: " + aluno2.getCurso());
        System.out.println("Orientador: " + aluno2.getOrientador().getNome());
        System.out.println("Empresa: " + aluno2.getEmpresa().getNome());
        System.out.println();
        
        //Listar Aluno Por Matricula
        System.out.println("Listar Aluno Por Matricula");
        System.out.println();
        String matricula = "123456";
        Query query3 = manager.createQuery("SELECT a FROM Aluno a WHERE a.matricula = :matricula");
        query3.setParameter("matricula", matricula);
        
        Aluno aluno3 = (Aluno) query3.getSingleResult();
        
        System.out.println("Nome: " + aluno3.getNome());
        System.out.println("Matricula: " + aluno3.getMatricula());
        System.out.println("Curso: " + aluno3.getCurso());
        System.out.println("Orientador: " + aluno3.getOrientador().getNome());
        System.out.println("Empresa: " + aluno3.getEmpresa().getNome());
        System.out.println();
        
        //Listar Estagios Em Andamento
        System.out.println("Listar Estagios Em Andamento");
        System.out.println();
        Query query4 = manager.createQuery("SELECT e FROM Estagio e WHERE e.status = 'Em andamento'");
        
        List<Estagio> estagios = query4.getResultList();
        
        for(Estagio estagio : estagios){
            System.out.println("Id: " + estagio.getId());
            System.out.println("Aluno: " + estagio.getAluno().getNome());
            System.out.println("Orientador: " + estagio.getOrientador().getNome());
            System.out.println("Empresa: " + estagio.getEmpresa().getNome());
            System.out.println("Carga Horaria: " + estagio.getCargaHoraria());
            System.out.println("Inicio estagio: " + estagio.getInicioEstagio());
            System.out.println("Fim estagio: " + estagio.getFimEstagio());
            System.out.println();
        }
        
        //Listar Empresas Por Substring
        System.out.println("Listar Empresas Por Substring");
        System.out.println();
        String parteNome = "Empresa";
        Query query5 = manager.createQuery("SELECT e FROM Empresa e WHERE e.nome LIKE :parteNome", Empresa.class);
        query5.setParameter("parteNome", "%" + parteNome + "%");
        
        List<Empresa> empresas = query5.getResultList();
        
        for(Empresa empresa : empresas){
            System.out.println("Nome: " + empresa.getNome());
            System.out.println("CNPJ: " + empresa.getCnpj());
            System.out.println("Endereco: " + empresa.getEndereco());
            for(Aluno aluno : empresa.getAlunos()){
                System.out.println("Aluno: " + aluno.getNome());
            }
            System.out.println();
        }
        
        //Listar Nome dos Orientadores Em Ordem Alfabética
        System.out.println("Listar Nome dos Orientadores Em Ordem Alfabética");
        System.out.println();
        Query query6 = manager.createQuery("SELECT o.nome FROM Orientador o ORDER BY o.nome");
        
        List<String> nomes = query6.getResultList();
        
        for(String nome : nomes){
            System.out.println(nome);
        }
        
        //Consultar Numero Total de Alunos
        System.out.println("Consultar Numero Total de Alunos");
        System.out.println();
        Query query7 = manager.createQuery("SELECT COUNT(a) FROM Aluno a");
        
        Long count = (Long) query7.getSingleResult();
                
        System.out.println("Número de alunos: " + count);
        
        //Listar Alunos Que Cursam Determinado Curso
        System.out.println("Listar Alunos Que Cursam Determinado Curso");
        System.out.println();
        String curso = "ADS";  
        Query query8 = manager.createQuery("SELECT a FROM Aluno a WHERE a.curso = :curso");
        query8.setParameter("curso", curso);
        
        List<Aluno> alunosAds = query8.getResultList();

        for (Aluno aluno : alunosAds) {
            System.out.println("Nome: " + aluno.getNome() + ", Curso: " + aluno.getCurso());
        }
        
        //Encontrar Estágio do Aluno pelo Id do mesmo
        System.out.println("Encontrar Estágio do Aluno pelo Id do mesmo");
        System.out.println();
        Long id = 1L;
        Query query9 = manager.createQuery("SELECT e FROM Estagio e WHERE e.aluno.id = :id");
        query9.setParameter("id", id);
        
        Estagio estagioAluno = (Estagio) query9.getSingleResult();

        System.out.println("ID Estágio: " + estagioAluno.getId() + ", Status: " + estagioAluno.getStatus());
        
        
        //Listar Alunos por Orientador
        String nomeOrientador = "Orientador 3";
        Query query10 = manager.createQuery("SELECT a FROM Aluno a WHERE a.orientador.nome = :nomeOrientador");
        query10.setParameter("nomeOrientador", nomeOrientador);

        List<Aluno> alunosDoOrientador = query10.getResultList();

        for (Aluno aluno : alunosDoOrientador) {
            System.out.println("Nome do Aluno: " + aluno.getNome() + ", Matrícula: " + aluno.getMatricula());
        }
        
        manager.close();
        factory.close();
    }
}
