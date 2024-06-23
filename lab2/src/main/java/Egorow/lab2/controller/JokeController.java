package Egorow.lab2.controller;

import Egorow.lab2.model.JokeModel;
import Egorow.lab2.service.JokeModelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/joke")
@RequiredArgsConstructor
@Slf4j
public class JokeController {

    private final JokeModelService jokeModelService;

    @PostMapping
    ResponseEntity<Void> addJoke(@RequestBody JokeModel jokeModel){
        jokeModelService.addJoke(jokeModel);
        return ResponseEntity.ok().build();

    }

    @GetMapping
    ResponseEntity<Page<JokeModel>> getAllJoke(Pageable pageable){
        return ResponseEntity.ok(jokeModelService.getAllJokes(pageable));

    }

    @GetMapping("/{id}")
    ResponseEntity<JokeModel> getJokeById(@PathVariable Long id){
        Optional<JokeModel> jokeOptional = jokeModelService.getJokeById(id);
        return jokeOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    ResponseEntity<JokeModel> updateJokeById(@PathVariable Long id, @RequestBody JokeModel updatedJoke) {
        Optional<JokeModel> updatedJokeOptional = jokeModelService.putJokeById(id, updatedJoke);
        return updatedJokeOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteJokeById(@PathVariable Long id){
        jokeModelService.deleteJokeById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/top5")
    ResponseEntity<Page<JokeModel>> getTop5Jokes(Pageable pageable) {
        return  ResponseEntity.ok(jokeModelService.getTop5Jokes(pageable));
    }

}
