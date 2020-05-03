package edu.tcu.cs.hogwartsartifactsonline.service;

import edu.tcu.cs.hogwartsartifactsonline.dao.ArtifactDao;
import edu.tcu.cs.hogwartsartifactsonline.domain.Artifact;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ArtifactService {
    private ArtifactDao artifactDao;
    private IdWorker idWorker;

    public ArtifactService(ArtifactDao artifactDao, IdWorker idWorker) {
        this.artifactDao = artifactDao;
        this.idWorker = idWorker;
    }

    public List<Artifact> findAll(){
        return artifactDao.findAll();
    }

    public Artifact findById(String artifactID) {
        return artifactDao.findById(artifactID).get();
    }

    public void save(Artifact newArtifact){
        newArtifact.setId(idWorker.nextId() + "");
        artifactDao.save(newArtifact);
    }

    public void update(String artifactID, Artifact updatedArtifact) {
        updatedArtifact.setId(artifactID);
        artifactDao.save(updatedArtifact);
    }

    public void delete(String artifactID) {
        artifactDao.deleteById(artifactID);
    }
}
