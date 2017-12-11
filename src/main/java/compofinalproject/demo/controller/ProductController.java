package compofinalproject.demo.controller;

import compofinalproject.demo.entity.Product;
import compofinalproject.demo.service.ProductService;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
public class ProductController {

    ProductService productService;
    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product")
    public ResponseEntity<?> getProducts() {
        List<Product> students = productService.getProducts();
        return ResponseEntity.ok(students);
    }

    @GetMapping("product/{id}")
    public ResponseEntity getStudent(@PathVariable("id")long id){
        Product product = productService.findById(id);
        if (product!= null)
            return ResponseEntity.ok(product);
        else
            //http code 204
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }





   @PostMapping("/product")
    public ResponseEntity<?> uploadOnlyProduct(@RequestBody Product product){
        productService.addProduct(product);
        return ResponseEntity.ok(product);
    }






    @Value("${server.imageServerDir}")
    String imageServerDir;
    @GetMapping(
            value = "/images/{fileName:.+}",
            produces = {MediaType.IMAGE_GIF_VALUE, MediaType.IMAGE_JPEG_VALUE,MediaType.IMAGE_PNG_VALUE})
    public @ResponseBody
    ResponseEntity<?> getProductImage(@PathVariable("fileName")String fileName) throws IOException {
        File file = Paths.get(imageServerDir+fileName).toFile();
        if (file.exists()) {
            InputStream in = new FileInputStream(file);
            return ResponseEntity.ok(IOUtils.toByteArray(in));
        }else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }
    @Value("${server.baseUrl}")
    String baseUrl;
    @Value("${server.imageUrl}")
    String imageUrl;
    @PostMapping("/upload")
    public ResponseEntity<?> uploadImage(@RequestParam("file")MultipartFile file){
        if (file.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        try{
            byte[] bytes = file.getBytes();
            String oldFilename = file.getOriginalFilename();
            //String ext = FilenameUtils.getExtension(oldFilename);
            ///String newFilename = Integer.toString(LocalTime.now().hashCode(),16)+Integer.toString(oldFilename.hashCode(),16)+"."+ext;
            Path path = Paths.get(imageServerDir+oldFilename);
            Files.write(path,bytes);
            return ResponseEntity.ok(baseUrl+ imageUrl+oldFilename);
        }catch (IOException e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    };

    @GetMapping("/products")
    public ResponseEntity<?> queryProduct(@RequestParam("search") String query) {
        List<Product> products = productService.queryProduct(query);
        if (products != null)
            return ResponseEntity.ok(products);
        else
            //http code 204
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

}
