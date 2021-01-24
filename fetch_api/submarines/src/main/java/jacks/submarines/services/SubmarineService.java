package jacks.submarines.services;

import jacks.submarines.exceptions.NoPictureFoundException;
import jacks.submarines.exceptions.SubmarineNotFoundException;
import jacks.submarines.models.Submarine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class SubmarineService {
    private List<Submarine> submarines;
    private int submarineCount = 5;

    @Autowired
    public SubmarineService() {
        this.submarines = new ArrayList<>();
        this.submarines.add(new Submarine(30, 250, 1));
        this.submarines.add(new Submarine(180, 400, 2));
        this.submarines.add(new Submarine(100, 320, 3));
        this.submarines.add(new Submarine(250, 493, 4));
        this.submarines.add(new Submarine(70, 380, 5));
    }

    public List<Submarine> getAll() {
        return this.submarines;
    }

    public Submarine updateSubmarineToRandomLocation(int submarineId) throws SubmarineNotFoundException, InterruptedException {
        Thread.sleep(3000);
        Submarine submarineToUpdate = this.submarines.stream().filter(submarine -> submarine.id() == submarineId).findFirst().orElseThrow(() -> new SubmarineNotFoundException("Submarine could not be found"));

        submarineToUpdate.x(ThreadLocalRandom.current().nextInt(5, 270 + 1));
        submarineToUpdate.y(ThreadLocalRandom.current().nextInt(200, 500 + 1));

        return submarineToUpdate;
    }

    public int isPictureAvailableForSubmarine(int submarineId) throws NoPictureFoundException {
        if (submarineId % 2 == 0) {
            return ThreadLocalRandom.current().nextInt(1, 6);
        }

        throw new NoPictureFoundException("This submarine does not have any picture available");
    }

}
