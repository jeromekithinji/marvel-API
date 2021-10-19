package com.example.MarvelAPI.repository;

import com.example.MarvelAPI.entity.Character;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICharacterRepository extends JpaRepository<Character, Integer> {
}
