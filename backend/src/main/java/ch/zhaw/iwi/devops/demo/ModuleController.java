package ch.zhaw.iwi.devops.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class ModuleController {

    private List<Module> modules = new ArrayList<>();

    public ModuleController() {
        modules.add(new Module(1,"DevOps","CI/CD"));
        modules.add(new Module(2,"Cloud","AWS Basics"));
    }

    @GetMapping("/services/modules")
    public List<Module> getModules(){
        return modules;
    }

    @GetMapping("/services/module/{id}")
    public Module getModule(@PathVariable long id){
        return modules.stream()
                .filter(m -> m.id == id)
                .findFirst()
                .orElse(null);
    }

    @PostMapping("/services/module")
    public Module addModule(@RequestBody Module module){
        modules.add(module);
        return module;
    }

    @DeleteMapping("/services/module/{id}")
    public String deleteModule(@PathVariable long id){
        modules.removeIf(m -> m.id == id);
        return "deleted";
    }

    @PutMapping("/modules/{id}")
public Module updateModule(@PathVariable long id, @RequestBody Module updatedModule) {

    for (int i = 0; i < modules.size(); i++) {

        if (modules.get(i).id == id) {

            modules.set(i, updatedModule);

            return updatedModule;
        }

    }

    return null;
}
}