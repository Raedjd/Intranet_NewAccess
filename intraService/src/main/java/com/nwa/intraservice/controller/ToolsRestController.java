package com.nwa.intraservice.controller;

import com.nwa.intraservice.models.Department;
import com.nwa.intraservice.models.Tools;
import com.nwa.intraservice.models.User;
import com.nwa.intraservice.service.IToolsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tools")
@Slf4j
public class ToolsRestController {

    @Autowired
    IToolsService iToolsService;

    @PostMapping("/add/{idUser}/{idDepart}")
    public void addToolsAndAssignToUserAndDepart(@RequestBody Tools tools, @PathVariable("idUser") Long idUser,
                                                 @PathVariable("idDepart") Long idDepart) {
        iToolsService.addToolsAndAssignToUserAndToDepartment(tools , idUser ,idDepart);
    }

    @GetMapping("/toolsbydepart/{iddepart}")
    public List<Tools> getToolsByDEpart(@PathVariable("iddepart") Long iddep) {
        return iToolsService.getToolsByDepartement(iddep);
    }

    @GetMapping("/findAll")
    @ResponseBody
    public List<Tools> list() {

        return iToolsService.findAll();
    }

    @PutMapping("/update/{id}")
    @ResponseBody
    public Tools modify(@RequestBody Tools t, @PathVariable("id") Long id) {

        return iToolsService.updateTools(t , id);
    }

    @DeleteMapping("delete/{id}")
    @ResponseBody
    public void delete(@PathVariable("id") Long id) {
        iToolsService.deleteTools(id);

    }

}
