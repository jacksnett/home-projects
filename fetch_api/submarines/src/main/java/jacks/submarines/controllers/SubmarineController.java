package jacks.submarines.controllers;

import jacks.submarines.exceptions.NoPictureFoundException;
import jacks.submarines.exceptions.SubmarineNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import jacks.submarines.models.Submarine;
import jacks.submarines.services.SubmarineService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/submarines")
public class SubmarineController {

    @Autowired
    private SubmarineService submarineService;

    @GetMapping()
    public List<Submarine> getAll() {
        return this.submarineService.getAll();
    }

    @PatchMapping("/{submarineId}/random-location")
    public ResponseEntity<Submarine> updateSubmarineToRandomLocaiton(@PathVariable int submarineId) {
        try {
            Submarine updatedSubmarine = this.submarineService.updateSubmarineToRandomLocation(submarineId);
            return ResponseEntity.ok(updatedSubmarine);
        } catch (SubmarineNotFoundException exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (InterruptedException exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{submarineId}/is-picture-available")
    public ResponseEntity<Integer> isPictureAvailableForSubmarine(@PathVariable int submarineId) {
        try {
            return ResponseEntity.ok(this.submarineService.isPictureAvailableForSubmarine(submarineId));
        } catch (NoPictureFoundException exception) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

    }

    @GetMapping(value = "/pictures/{pictureId}", produces = MediaType.IMAGE_JPEG_VALUE)
    public void getImageAsByteArray(HttpServletResponse response, @PathVariable int pictureId) throws IOException {
        ClassPathResource classPathResource = new ClassPathResource("images/" + pictureId + ".jpg");
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(classPathResource.getInputStream(), response.getOutputStream());
    }

}
