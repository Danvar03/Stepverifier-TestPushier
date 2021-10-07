package com.sofka.StepVerifier.Services;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class Servicio {
    public Mono<String> buscarUno() {
        return Mono.just("Pedro");
    }

    public Flux<String> buscarTodos() {
        return Flux.just("Pedro", "Maria", "Jesus", "Carmen");
    }

    public Flux<String> buscarTodosLento() {
        return Flux.just("Pedro", "Dani", "Jesus", "Carmen").delaySequence(
                Duration.ofSeconds(20));
    }

    public Flux<String> buscarTodosFiltro() {
        Flux<String> names = Flux.just("John", "Monica", "Mark", "Cloe", "Frank", "Casper", "Olivia", "Emily", "Cate")
                .filter(name -> name.length() == 4)
                .map(String::toUpperCase).doOnNext(elemento -> System.err.println(elemento + "--"));
        names.subscribe();
        return names;
    }

}