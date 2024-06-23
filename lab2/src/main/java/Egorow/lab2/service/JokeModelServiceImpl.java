package Egorow.lab2.service;

import Egorow.lab2.model.JokeCall;
import Egorow.lab2.model.JokeModel;
import Egorow.lab2.repository.JokeCallRepository;
import Egorow.lab2.repository.JokeModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JokeModelServiceImpl implements JokeModelService {

    private final JokeModelRepository jokeModelRepository;
    private final JokeCallRepository jokeCallRepository;

    @Override
    public void addJoke(JokeModel jokeModel) {

        JokeCall jokeCall = jokeModel.getJokeCall();
        if (jokeCall != null && jokeCall.getCallId() != null){
            jokeCall = jokeCallRepository.findById(jokeCall.getCallId()).orElse(null);
        }

        jokeModel.setJokeCall(jokeCall);
        jokeModelRepository.save(jokeModel);
    }

    @Override
    public Page<JokeModel> getAllJokes(Pageable pageable) {
        return jokeModelRepository.findAll(pageable);
    }

    @Override
    public Page<JokeModel> getTop5Jokes(Pageable pageable) {
        return jokeModelRepository.findTop5ByOrderByJokeCallDesc(pageable);
    }

    @Override
    public Optional<JokeModel> getJokeById(Long id) {
        return jokeModelRepository.findById(id);
    }

    @Override
    public Optional<JokeModel> putJokeById(Long id, JokeModel updatedJoke) {
        Optional<JokeModel> existingJoke = jokeModelRepository.findById(id);
        if (existingJoke.isPresent()) {
            JokeModel jokeToUpdate = existingJoke.get();
            jokeToUpdate.setTextJoke(updatedJoke.getTextJoke());
            jokeModelRepository.save(jokeToUpdate);
        }
        return existingJoke;
    }

    @Override
    public void deleteJokeById(Long id) {
        jokeModelRepository.deleteById(id);
    }

    public JokeModel getRandomJoke() {
        return jokeModelRepository.findRandomJoke();
    }
}
