package com.pssservice.pssservice.Service.Impl;
import com.pssservice.pssservice.Dto.AgentDto;
import com.pssservice.pssservice.Exception.ErrorCodes;
import com.pssservice.pssservice.Exception.InvalidEntityException;
import com.pssservice.pssservice.Model.Agent;
import com.pssservice.pssservice.Repository.AgentRepository;
import com.pssservice.pssservice.Service.AgentService;
import com.pssservice.pssservice.Validator.AgentValidator;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import java.util.stream.Collectors;



@Service
@Slf4j
public class AgentServiceImpl implements AgentService {

    @Autowired
    private AgentRepository agentRepository;

    @Autowired
    private ModelMapper modelMapper ;

    @Autowired
    public AgentServiceImpl(AgentRepository agentRepository){

        this.agentRepository = agentRepository;
    }

    @Override
    public AgentDto createAgent(AgentDto agentDto) {
        List<String> errors = AgentValidator.validate(agentDto);
        if (!errors.isEmpty()){
            log.error("Agent n'est pas valide {}",agentDto);
            throw new InvalidEntityException("Agent not valid", ErrorCodes.AGENT_INVALID,errors);
        }

        Agent agent = modelMapper.map(agentDto,Agent.class);
        Agent created=  agentRepository.save(agent);
        return  modelMapper.map(created, AgentDto.class);
    }

    @Override
    public AgentDto updateAgent(AgentDto agentDto) {
        List<String> errors = AgentValidator.validate(agentDto);
        if (!errors.isEmpty()){
            log.error("Agent n'est pas valide {}",agentDto);
            throw new InvalidEntityException("Agent not valid", ErrorCodes.AGENT_INVALID,errors);
        }
        Agent agent = modelMapper.map(agentDto,Agent.class);
        Agent updated=  agentRepository.save(agent);
        return  modelMapper.map(updated, AgentDto.class);
    }

    @Override
    public AgentDto getAgentById(Long aid) {
        if (aid == null) {
            log.error("ID de l'agent est nul");
            return null;
        }

        return modelMapper.map(agentRepository.findById(aid),AgentDto.class);

    }

    @Override
    public List<AgentDto> getAll() {
        return agentRepository.findAll().stream()
                .map(a->modelMapper.map(a,AgentDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Boolean deleteAgent(Long aid) {
        if ( aid == null) {
            log.error("ID de l'agent est nul");
            return false;
        }
        agentRepository.deleteById(aid);
        return true;
    }

}
