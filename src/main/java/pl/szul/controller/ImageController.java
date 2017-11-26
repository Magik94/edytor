package pl.szul.controller;


import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.szul.domain.Action;
import pl.szul.entity.ImageEntity;
import pl.szul.repository.ImageRepository;
import pl.szul.service.ImageService;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by Dawid on 09.05.2017.
 */
@Controller
@RequestMapping
public class ImageController {

    @Autowired
    private ImageService imageService;
    @Autowired
    private ImageRepository imageRepository;


    @RequestMapping("/")
    public String image(Model model){
        model.addAttribute("actions", Action.values());
        return "upload";
    }

    @RequestMapping("/image/{id}")
    public String image(Model model,@PathVariable String id){
        ImageEntity image = imageRepository.findOne(id);
        if(image==null){
            throw new RuntimeException("BRAK OBRAZU!!!");
        }
        model.addAttribute("img",  Base64.encode(image.getImage()));
        model.addAttribute("message", image.getAction());
        model.addAttribute("name", image.getName());
        return "image";
    }

    @GetMapping("/imagesList")
    public String listImage(Model model){
        model.addAttribute("images",imageRepository
                .findAll()
                .stream()
                .map(r->new ImageEntity(r.getId(),r.getName()))
                .collect(Collectors.toList()));
        return "listImages";
    }

    @PostMapping("/upload")
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   @RequestParam(value = "action") Action action,
                                   RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Brak pliku!!!!");
            redirectAttributes.addFlashAttribute("oldImage", null);
            redirectAttributes.addFlashAttribute("newImage", null);

            return "redirect:convertResult";
        }
        try {
            byte[] bytes = file.getBytes();
            redirectAttributes.addFlashAttribute("message",action);
            redirectAttributes.addFlashAttribute("oldImage", Base64.encode(bytes));
            redirectAttributes.addFlashAttribute("newImage", Base64.encode(imageService.convert(bytes,action,file.getOriginalFilename())));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/convertResult";
    }

    @GetMapping("/convertResult")
    public String uploadStatus() { return "convertResult"; }
}
