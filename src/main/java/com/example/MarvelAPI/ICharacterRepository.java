package com.example.MarvelAPI;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ICharacterRepository extends JpaRepository<Character, Integer> {
}
