/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.alyssonaldrin1.factories;

import com.mycompany.alyssonaldrin1.entities.Aluno;
import com.mycompany.alyssonaldrin1.entities.Empresa;
import com.mycompany.alyssonaldrin1.entities.Estagio;
import com.mycompany.alyssonaldrin1.entities.Orientador;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author cfontes
 */
public class FactoryUpdate {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("my_persistence_unit");
        EntityManager manager = factory.createEntityManager();
        
        manager.getTransaction().begin();
        
        //Atualizar Aluno
        Aluno aluno = manager.find(Aluno.class, 1L);
        aluno.setNome("Alysson Aldrin");
        
        manager.persist(aluno);
        
        //Atualizar Orientador
        Orientador orientador = manager.find(Orientador.class, 1L);
        orientador.setNome("Cristiano Fontes");
        
        manager.persist(orientador);
        
        //Atualizar Empresa
        Empresa empresa = manager.find(Empresa.class, 1L);
        empresa.setCnpj("111111111");
        
        manager.persist(empresa);
        
        //Atualizar Estágio
        Estagio estagio = manager.find(Estagio.class, 1L);
        estagio.setCargaHoraria(30);
        
        manager.persist(estagio);
        manager.getTransaction().commit();
        manager.close();
        factory.close();
    }
}
