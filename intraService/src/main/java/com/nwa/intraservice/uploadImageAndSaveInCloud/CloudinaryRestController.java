package com.nwa.intraservice.uploadImageAndSaveInCloud;

import com.nwa.intraservice.models.Image;
import com.nwa.intraservice.models.User;
import com.nwa.intraservice.repository.ImageRepository;
import com.nwa.intraservice.repository.UserRepository;
import com.nwa.intraservice.uploadImageAndSaveInCloud.CloudinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/cloudinary")
@CrossOrigin
public class CloudinaryRestController {

    @Autowired
    CloudinaryService cloudinaryService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    ImageRepository imageRepository;

    @PatchMapping("/upload/{idUser}")
    public ResponseEntity<Map> upload(@RequestParam MultipartFile multipartFile,@PathVariable("idUser") Long id) throws IOException {
        BufferedImage bi = ImageIO.read(multipartFile.getInputStream());
        if(bi== null){
            return  new ResponseEntity("invalid image",HttpStatus.BAD_REQUEST);
        }

     Map result = cloudinaryService.upload(multipartFile);
        Image image = new Image((String)result.get("original_filename"),
                (String)result.get("url"),
                (String)result.get("public_id"));
        User user= userRepository.findById(id).orElse(null);
        user.setImage(image);
        userRepository.save(user);
        imageRepository.save(image);
     return new ResponseEntity("Image changed for user" , HttpStatus.ACCEPTED);
    }



}
