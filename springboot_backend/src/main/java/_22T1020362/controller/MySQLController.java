package _22T1020362.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import _22T1020362.models.Nganh;
import _22T1020362.models.SinhVien;
import _22T1020362.service.MySQLService;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/mysql")
@CrossOrigin(origins = "https://22t1020362-abstractfactorywebsite.netlify.app") //angular port
public class MySQLController {
    private final MySQLService mySQLService;

    @GetMapping("/sinhvien")
    public ResponseEntity<List<SinhVien>> readSV() {
    	try {
            List<SinhVien> sv = mySQLService.readSV();
            return new ResponseEntity<>(sv, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/sinhvien/delete/{msv}")
    public ResponseEntity<?> deleteSV(@PathVariable("msv") String msv) {
    	try {
            mySQLService.deleteSV(msv);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/nganh")
    public ResponseEntity<List<Nganh>> readNDT() {
    	try{
            List<Nganh> ndt = mySQLService.readNDT();
            return new ResponseEntity<>(ndt, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("/nganh/add")
    public ResponseEntity<Nganh> insertNDT(@RequestBody Nganh nganh) {
    	try {
            mySQLService.insertNDT(nganh);
            return new ResponseEntity<>(nganh, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}

