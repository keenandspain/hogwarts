package edu.tcu.cs.hogwartsartifactsonline.controller;

import edu.tcu.cs.hogwartsartifactsonline.domain.Artifact;
import edu.tcu.cs.hogwartsartifactsonline.domain.Result;
import edu.tcu.cs.hogwartsartifactsonline.service.ArtifactService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artifacts")
public class ArtifactController {
    private ArtifactService artifactService;

    public ArtifactController(ArtifactService artifactService) {
        this.artifactService = artifactService;
    }

    @GetMapping
    public Result findAll(){
        List<Artifact> all = artifactService.findAll();
        Result result = new Result(true, 200, "Find All Success", all);
        return result;
    }

    @GetMapping("/{artifactID}")
    public Result findById(@PathVariable String artifactID){
        return new Result(true, 200, "Find One Success", artifactService.findById(artifactID));
    }

    @PostMapping
    public Result save(@RequestBody Artifact newArtifact){
        artifactService.save(newArtifact);
        return new Result(true, 200, "Save successful");

    }

    @PutMapping("/{artifactID}")
    public Result update(@PathVariable String artifactID, @RequestBody Artifact updatedArtifact){
        artifactService.update(artifactID, updatedArtifact);
        return new Result(true, 200, "Update Success");
    }

    @DeleteMapping("/{artifactID}")
    public Result delete(@PathVariable String artifactID){
        artifactService.delete(artifactID);
        return new Result(true, 200, "Delete Success");

    }
}
