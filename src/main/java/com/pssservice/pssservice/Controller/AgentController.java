package com.pssservice.pssservice.Controller;
import com.pssservice.pssservice.Controller.Api.AgentApi;
import com.pssservice.pssservice.Dto.AgentDto;
import com.pssservice.pssservice.Service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin (origins="*")
@RestController
 public class AgentController implements AgentApi {


    private AgentService agentService;


    @Autowired
    public AgentController(
            AgentService agentService
    ) {
        this.agentService = agentService;
    }

    @Override
    public AgentDto createAgent(AgentDto agentDto) {
        return agentService.createAgent(agentDto);
    }

    @Override
    public AgentDto updateAgent(AgentDto agentDto) {
        return agentService.updateAgent(agentDto);
    }

    @Override
    public AgentDto getAgentById(Long aid) {
        return agentService.getAgentById(aid);
    }

    @Override
    public List<AgentDto> getAll() {
        return agentService.getAll();
    }

    @Override
    public Boolean deleteAgent(Long aid) {
        return agentService.deleteAgent(aid);
    }

}

