package com.backend.backend.services;

import com.backend.backend.domain.Chamado;
import com.backend.backend.domain.Cliente;
import com.backend.backend.domain.Tecnico;
import com.backend.backend.domain.enums.Perfil;
import com.backend.backend.domain.enums.Prioridade;
import com.backend.backend.domain.enums.Status;
import com.backend.backend.repositories.ChamadoRepository;
import com.backend.backend.repositories.ClienteRepository;
import com.backend.backend.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private TecnicoRepository tecnicoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ChamadoRepository chamadoRepository;

    public void instanciaDB(){
        Tecnico tec1 = new Tecnico(null, "Pedro Gomes", "08426785345", "pedrogomes@gmail.com", "123");
        tec1.addPerfil(Perfil.ADMIN);

        Cliente cli1 = new Cliente(null, "Linus Torvalds", "08426787322", "torvalds@gmail.com", "123");

        Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro Chamado", tec1, cli1);

        tecnicoRepository.saveAll(Arrays.asList(tec1));
        clienteRepository.saveAll(Arrays.asList(cli1));
        chamadoRepository.saveAll(Arrays.asList(c1));
    }

}
