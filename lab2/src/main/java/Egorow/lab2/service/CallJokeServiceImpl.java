package Egorow.lab2.service;

import Egorow.lab2.model.JokeCall;
import Egorow.lab2.repository.JokeCallRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CallJokeServiceImpl implements CallJokeServise{

    private final JokeCallRepository jokeCallRepository;

    @Override
    public void addCallJoke(JokeCall jokeCall) {
        jokeCallRepository.save(jokeCall);
    }

    @Override
    public List<JokeCall> getAllCallJokes() {
        return null;
    }

    @Override
    public Optional<JokeCall> getCallJokeById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<JokeCall> putCallJokeById(Long id, JokeCall updatedCallJoke) {
        return Optional.empty();
    }

    @Override
    public void deleteCallJokeById(Long id) {

    }
}
