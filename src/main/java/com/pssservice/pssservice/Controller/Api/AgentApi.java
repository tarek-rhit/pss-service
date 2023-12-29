package com.pssservice.pssservice.Controller.Api;
import com.pssservice.pssservice.Dto.AgentDto;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static com.pssservice.pssservice.Utils.Constants.APP_ROOT;


@CrossOrigin (origins="http://localhost:4200")
public interface AgentApi {

    @PostMapping(value = APP_ROOT + "/agent/creer")
    AgentDto createAgent(@RequestBody AgentDto agentDto);
    @PutMapping(value = APP_ROOT + "/agent/modifier")
    AgentDto updateAgent(@RequestBody AgentDto agentDto);

    @GetMapping(value = APP_ROOT + "/agent/{aid}")
    AgentDto getAgentById(@PathVariable Long aid);

    @GetMapping(value = APP_ROOT + "/agent/all")
    List<AgentDto> getAll();

    @DeleteMapping(value = APP_ROOT + "/agent/supprimer/{aid}")
    Boolean deleteAgent( @PathVariable Long aid);

}
