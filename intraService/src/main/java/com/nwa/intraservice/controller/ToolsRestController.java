package com.nwa.intraservice.controller;

import com.nwa.intraservice.models.Tools;
import com.nwa.intraservice.service.IToolsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tools")
public class ToolsRestController {

    @Autowired
    IToolsService iToolsService;

    @PostMapping("/add/{nameDep}")
    public void addToolsAndAssignToUserAndDepart(@RequestBody Tools tools, @PathVariable("nameDep") String nameDepart) {
        iToolsService.addToolsAndAssignToUserAndToDepartment(tools , nameDepart);
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
    @GetMapping("/counttools")
    public Long countUsers() {
        return iToolsService.countTools();
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
