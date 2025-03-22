package _22T1020362.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import _22T1020362.models.Nganh;
import _22T1020362.models.SinhVien;
import _22T1020362.service.TextService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/text")
@CrossOrigin(origins = "http://localhost:4200") //angular port
public class TextController {
    private final TextService textService;

    @GetMapping("/sinhvien")
    public List<SinhVien> readSV() {
        return textService.readSV();
    }

    @DeleteMapping("/sinhvien/{msv}")
    public void deleteSV(@PathVariable String msv) {
        textService.deleteSV(msv);
    }

    @GetMapping("/nganh")
    public List<Nganh> readNDT() {
        return textService.readNDT();
    }

    @PostMapping("/nganh")
    public void insertNDT(@RequestBody Nganh nganh) {
    	textService.insertNDT(nganh);
    }
}

