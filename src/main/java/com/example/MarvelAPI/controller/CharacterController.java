package com.example.MarvelAPI.controller;

import com.example.MarvelAPI.repository.ICharacterRepository;
import com.example.MarvelAPI.services.APIDataRequest;
import com.example.MarvelAPI.entity.Character;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
//@RequestMapping("/characters")
public class CharacterController {

    @Autowired
    ICharacterRepository repository;


    public void getData() throws Exception {
        JSONArray data = new APIDataRequest().getAPI();


        for(Object object : data) {
            Character character = new Character();
            JSONObject record = (JSONObject) object;
//                long id = (long) record.get("id");
            int id = (int) (long) record.get("id");
            character.setId(id);
            String name = (String) record.get("name");
            character.setName(name);
            String description = (String) record.get("description");
            character.setDescription(description);
            String thumbnail = null;
            character.setThumbnail("null");
//                pstmt.setInt(1, (int) id);
//                pstmt.setString(2, name);
//                pstmt.setString(3, description);
//                pstmt.setString(4, thumbnail);
//                pstmt.executeUpdate();
            System.out.println("This is the " + character.getId());
            repository.save(character);
        }
    }



    @GetMapping("/characters")
    public List<Integer> indexCharacters() throws Exception {
        getData();
        List<Character> data = this.repository.findAll();
        List<Integer> characterId = new ArrayList<>();
        for(Character character : data) {
            characterId.add(character.getId());
        }
        return characterId;
    }

    @GetMapping("/characters/{id}")
    public Character showCharacterById(@PathVariable int id) throws Exception {
        getData();
        Character character = this.repository.getById(id);
        return character;
    }

    
}
