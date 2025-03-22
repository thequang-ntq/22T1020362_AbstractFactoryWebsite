package _22T1020362.controller;

import org.springframework.web.bind.annotation.*;

import _22T1020362.models.Nganh;
import _22T1020362.models.SinhVien;
import _22T1020362.service.MySQLService;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/mysql")
@CrossOrigin(origins = "http://localhost:4200") //angular port
public class MySQLController {
    private final MySQLService mySQLService;

    @GetMapping("/sinhvien")
    public List<SinhVien> readSV() {
        return mySQLService.readSV();
    }

    @DeleteMapping("/sinhvien/{msv}")
    public void deleteSV(@PathVariable String msv) {
        mySQLService.deleteSV(msv);
    }

    @GetMapping("/nganh")
    public List<Nganh> readNDT() {
        return mySQLService.readNDT();
    }

    @PostMapping("/nganh")
    public void insertNDT(@RequestBody Nganh nganh) {
    	mySQLService.insertNDT(nganh);
    }
}

