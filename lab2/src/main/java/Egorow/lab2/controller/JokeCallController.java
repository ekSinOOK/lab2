package Egorow.lab2.controller;

import Egorow.lab2.model.JokeCall;
import Egorow.lab2.service.CallJokeServise;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/call")
@RequiredArgsConstructor
@Slf4j
public class JokeCallController {

    private final CallJokeServise callJokeServise;

    @PostMapping
    ResponseEntity<Void> addJoke(@RequestBody JokeCall jokeCall){
        callJokeServise.addCallJoke(jokeCall);
        return ResponseEntity.ok().build();

    }
}
