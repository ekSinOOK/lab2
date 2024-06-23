package Egorow.lab2.service;

import Egorow.lab2.model.JokeModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface JokeModelService {

    Page<JokeModel> getTop5Jokes(Pageable pageable);  // Вызов топ 5 шуток
    Page<JokeModel> getAllJokes(Pageable pageable); // Вызов всех шуток

    void addJoke(JokeModel jokeModel); // Добавить шутку

    Optional<JokeModel> getJokeById(Long id); // Вызвать шутку по id

    Optional<JokeModel> putJokeById(Long id, JokeModel updatedJoke); // Изменить шутку

    void deleteJokeById(Long id); // Удалить шутку

    JokeModel getRandomJoke(); // Выдать случайную шутку
}
