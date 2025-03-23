package _22T1020362.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<SinhVien>> readSV() {
    	try {
            List<SinhVien> sv = mongoDBService.readSV();
            return new ResponseEntity<>(sv, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/sinhvien/delete/{msv}")
    public ResponseEntity<?> deleteSV(@PathVariable("msv") String msv) {
    	try {
            mongoDBService.deleteSV(msv);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/nganh")
    public ResponseEntity<List<Nganh>> readNDT() {
    	try{
            List<Nganh> ndt = mongoDBService.readNDT();
            return new ResponseEntity<>(ndt, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("/nganh/add")
    public ResponseEntity<Nganh> insertNDT(@RequestBody Nganh nganh) {
    	try {
            mongoDBService.insertNDT(nganh);
            return new ResponseEntity<>(nganh, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
