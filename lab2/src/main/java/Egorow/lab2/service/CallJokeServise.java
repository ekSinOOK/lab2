package Egorow.lab2.service;

import Egorow.lab2.model.JokeCall;

import java.util.List;
import java.util.Optional;

public interface CallJokeServise {


    void addCallJoke(JokeCall jokeCall);

    List<JokeCall> getAllCallJokes();

    Optional<JokeCall> getCallJokeById(Long id);

    Optional<JokeCall> putCallJokeById(Long id, JokeCall updatedCallJoke);

    void deleteCallJokeById(Long id);
}
