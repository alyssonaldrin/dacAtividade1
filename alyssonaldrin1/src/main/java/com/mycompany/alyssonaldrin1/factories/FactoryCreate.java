/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.alyssonaldrin1.factories;

import com.mycompany.alyssonaldrin1.entities.Aluno;
import com.mycompany.alyssonaldrin1.entities.Empresa;
import com.mycompany.alyssonaldrin1.entities.Estagio;
import com.mycompany.alyssonaldrin1.entities.Orientador;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author cfontes
 */
public class FactoryCreate {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("my_persistence_unit");
        EntityManager manager = factory.createEntityManager();
        
        manager.getTransaction().begin();
        
        //Criando Aluno
        Aluno aluno = new Aluno("Alysson", "123456", "ADS");
        
        manager.persist(aluno);
        
        //Criando Orientador
        Orientador orientador = new Orientador("Cristiano", "Informatica");
        
        manager.persist(orientador);
        
        //Criando Empresa
        Empresa empresa = new Empresa("IFPB", "Rua Teste", "123456789");
        
        manager.persist(empresa);
        
        //Criando Estágio
        Date inicioEstagio = new Date();
        Date fimEstagio = new Date();
        inicioEstagio.setYear(fimEstagio.getYear() - 1);
        
        Estagio estagio = new Estagio(inicioEstagio, fimEstagio, 20, "Finalizado", aluno, empresa, orientador);

        manager.persist(estagio);
        
        // Populando Banco
        for (int i = 2; i <= 6; i++) {
            Aluno a = new Aluno("Aluno " + i, "123456" + i, "Curso " + i);
            manager.persist(a);
            
            Orientador o = new Orientador("Orientador " + i, "Área " + i);
            manager.persist(o);
            
            Empresa e = new Empresa("Empresa " + i, "Rua Teste " + i, "123456789" + i);
            manager.persist(e);

            Date inicioE = new Date();
            Date fimE = new Date();
            fimE.setYear(fimEstagio.getYear() + 1);

            Estagio es = new Estagio(inicioE, fimE, 20, "Em andamento", a, e, o);
            manager.persist(es);
        }
        
        manager.getTransaction().commit();
        manager.close();
        factory.close();
    }
}
