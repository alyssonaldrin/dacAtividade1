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
public class FactoryDelete {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("my_persistence_unit");
        EntityManager manager = factory.createEntityManager();
        
        manager.getTransaction().begin();
        
        //Deletar Estágio
        Estagio estagio = manager.find(Estagio.class, 1L);
        manager.remove(estagio);
        
        //Deletar Aluno
        Aluno aluno = manager.find(Aluno.class, 1L);
        manager.remove(aluno);
        
        //Deletar Orientador
        Orientador orientador = manager.find(Orientador.class, 1L);
        manager.remove(orientador);
        
        //Deletar Empresa
        Empresa empresa = manager.find(Empresa.class, 1L);
        manager.remove(empresa);
        
        manager.getTransaction().commit();
        manager.close();
        factory.close();
    }
}
