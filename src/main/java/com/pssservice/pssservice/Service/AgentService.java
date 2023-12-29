package com.pssservice.pssservice.Service;

import com.pssservice.pssservice.Dto.AgentDto;

import java.util.List;

public interface AgentService {

    AgentDto createAgent(AgentDto agentDto);
    AgentDto updateAgent(AgentDto agentDto);

    AgentDto getAgentById(Long aid);

    List<AgentDto> getAll();

    Boolean deleteAgent( Long aid);


}
