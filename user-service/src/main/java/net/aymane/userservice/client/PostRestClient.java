//package net.aymane.userservice.client;
//
//import net.aymane.userservice.external.Pub;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//@RestController
//@FeignClient(name = "POST-SERVICE")
//public interface PostRestClient {
//    @PostMapping("/pub")
//    Pub createPub(String img,String content,Long id);
//
//    @GetMapping("/post/{id}")
//    Pub getPostById(@PathVariable Long id);
//@GetMapping("/allPubs")
//    List<Pub> allPub();
//
//}
