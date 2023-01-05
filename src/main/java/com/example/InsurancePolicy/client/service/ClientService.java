package com.example.InsurancePolicy.client.service;

import com.example.InsurancePolicy.client.dto.ClientDTO;
import com.example.InsurancePolicy.client.entity.Client;
import com.example.InsurancePolicy.client.mapper.ClientMapper;
import com.example.InsurancePolicy.client.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public List<ClientDTO> getAllClients() {
        return clientMapper.toDto(clientRepository.findAll());
    }

    public ClientDTO getClientById(Long id) {
        return clientMapper.toDto(clientRepository.findById(id).orElse(null));
    }

    public Client addClient(ClientDTO client) {
        return clientRepository.save(clientMapper.toEntity(client));
    }

    public Client updateClientById(Long id, ClientDTO clientDTO) {
        Client oldClient = clientRepository.getById(id);
        clientMapper.updateEntity(oldClient, clientDTO);

        return clientRepository.save(oldClient);
    }

    public Long deleteClientById(Long id) {
        clientRepository.deleteById(id);

        return id;
    }
}
