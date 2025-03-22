package _22T1020362.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import _22T1020362.models.Nganh;
import _22T1020362.models.SinhVien;
import _22T1020362.service.MongoDBService;
import lombok.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/mongodb")
@CrossOrigin(origins = "http://localhost:4200") //angular port
public class MongoDBController {
    private final MongoDBService mongoDBService;

    @GetMapping("/sinhvien")
    public List<SinhVien> readSV() {
        return mongoDBService.readSV();
    }

    @DeleteMapping("/sinhvien/{msv}")
    public void deleteSV(@PathVariable String msv) {
        mongoDBService.deleteSV(msv);
    }

    @GetMapping("/nganh")
    public List<Nganh> readNDT() {
        return mongoDBService.readNDT();
    }

    @PostMapping("/nganh")
    public void insertNDT(@RequestBody Nganh nganh) {
    	mongoDBService.insertNDT(nganh);
    }
}
